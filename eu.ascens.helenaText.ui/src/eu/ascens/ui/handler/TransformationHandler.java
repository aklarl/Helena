package eu.ascens.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

import eu.ascens.serializer.AtlEmftvmModelTransformationLauncher;

public class TransformationHandler extends AbstractHandler implements IHandler {

	@Inject
	private IGenerator generator;

	@Inject
	private Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;

	@Inject
	private AtlEmftvmModelTransformationLauncher transformer;

	@Inject
	IResourceDescriptions resourceDescriptions;

	@Inject
	IResourceSetProvider resourceSetProvider;

	@Override
	public Object execute(ExecutionEvent event) {

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IFile) {
				IFile file = (IFile) firstElement;
				IProject project = file.getProject();
				IFolder modelFolder = project.getFolder("model");
				if (!modelFolder.exists()) {
					try {
						modelFolder.create(true, true,
								new NullProgressMonitor());
					}
					catch (CoreException e) {
						return null;
					}
				}

				// Get filesystem access (needed for the generator)
				// final EclipseResourceFileSystemAccess2 fsa =
				// fileAccessProvider.get();
				// fsa.setOutputPath(srcGenFolder.getFullPath().toString());
				// fsa.setMonitor(new NullProgressMonitor());
				// fsa.setProject(project);

				URI uri = URI.createPlatformResourceURI(
						file.getFullPath().toString(), true);
				ResourceSet rs = this.resourceSetProvider.get(project);
				Resource r = rs.getResource(uri, true);

				try {
					// generator.doGenerate(r, fsa);
					this.transformer.launchTransformation(r);
				}
				catch (Exception e) {
					// If this error occurs there's probably an error in the ATL
					// transformation
					Shell activeShell = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell();
					MessageDialog.openError(activeShell, "Error",
							"An error occured. Model transformation failed."
									+ e.getMessage());
					e.printStackTrace();

				}

			}
		}

		return null;
	}

}