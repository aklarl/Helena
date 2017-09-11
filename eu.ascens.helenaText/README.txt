README - Helena Workbench
#########################

The Helena workbench provides tool support for the development of ensemble-based 
systems with Helena relying on Eclipse. A custom editor in Eclipse allows to define
ensemble specifications using the domain-specific language HelenaText . The editor
provides syntax highlighting, content assist as well as validation of the 
specification. Furthermore, two generators take the HelenaText specification as 
input to generate an semantically equivalent Promela verification model for 
model-checking with Spin and to generate Java code which can be executed relying on 
the jHelena framework. 

User-Guide for Developing the Helena Workbench
-----------------------------------------------

1) Setting up an Xtext Project in Eclipse
-----------------------------------------
Initially, an Xtext project must be set up to develop the Helena workbench. The 
following steps were necessary (tested with Eclipse Mars.2):
- install Xtext plug-in in the Eclipse installation (Xtext Complete SDK version 2.10.0 from Eclipse Marketplace)
- install ATL plug-in in the Eclipse installation (ATL/EMFVM version 3.7.0 from Eclipse Marketplace)
- create new Xtext project and finish with the default settings 
	-> four projects are created (language, sdk, tests, ui)
In the generated .xtext-file, the Xtext grammar for HelenaText is defined. To 
generate the HelenaText editor as an Eclipse plug-in, this grammar needs to be run
such that the plug-in code is generated. To initiate the generation, right-click on 
the .xtext-file and select `Run As' -> `Generate Xtext Artifacts'. Whenever changes 
in the grammar are made, the generation of Xtext artifacts has to be initiated again
(for more information see the tutorial on 
http://www.eclipse.org/Xtext/documentation.html#FirstFiveMinutes).

Afterwards the plug-in can be used either by exporting the plug-in (see later on) 
or by launching a new Eclipse instance. To do the latter, right-click on the 
language-project and select `Run As' -> Eclipse Application. A new Eclipse instance 
is launched which contains the HelenaText plug-in. The usage of the Helena 
workbench and its HelenaText editor is explained later on.

2) Projects and Packages of the Helena Workbench
------------------------------------------------
The Helena workbench consists of three projects:
- The project eu.ascens.helenaText contains the definition of the grammar of the 
  domain-specific language \HelenaText, formatting and validation for the generated 
  HelenaText editor, and both generators to Promela and to jHelena.
	- The package eu.ascens contains the grammar file HelenaText.xtext for
	  HelenaText and the workflow GenerateHelenaText.mwe2 to create the Eclipse 
	  editor.
	- The package eu.ascens.validation contains validation rules which check
	  conformance of the \HelenaText specification with the formal Helena 
	  definition. Validation checks are executed while typing in the HelenaText 
	  editor.
	- The package eu.ascens.scoping defines the scoping context of certain entities 
	  of the HelenaText grammar, e.g., all variables in the scope of a role behavior.
	- The package eu.ascens.formatting contains rules for formatting a HelenaText 
	  specification automatically. Formatting is triggered in the HelenaText editor 
	  by pressing CTRL+SHIFT+F.
	- The package eu.ascens.generator contains all generation rules for the 
	  translation from HelenaText to Promela and to jHelena. Generation is triggered
	  in the HelenaText editor whenever a file is saved.
- The project eu.ascens.helenaText.tests is a project where unit tests for testing 
  the parser, validator etc. can be defined.
- The project eu.ascens.helenaText.ui provides the implementation of the HelenaText 
  editor. It is mostly generated and can be adapted to make customize the HelenaText
  editor, e.g., to add quickfixes, to change the appearance of the outline, or to 
  provide code proposals.

3) Exporting the \Helena Workbench as \Eclipse Plug-in
------------------------------------------------------
To make the Helena workbench available to users (instead of just launching an 
internal Eclipse instance), it must be exported as an Eclipse plug-in. The export 
creates several jar-archives. To use the Helena workbench, the user has to install 
the plug-in into his Eclipse installation by copying the jar files into the 
plugins folder of his Eclipse installation.

The Helena workbench is exported as an Eclipse plug-in by using the Eclipse export 
functionality which can only be used if the Eclipse Plug-in Development Environment 
is installed in the running Eclipse installation. The following steps are necessary 
to export the Helena workbench:
- click `File' -> `Export'
- choose `Plug-in Development' -> `Deployable plug-ins and fragments'
- select the projects eu.ascens.helenaText and eu.ascens.helenaText.ui
- set the target directory for the resulting jar files
- click `Finish'


User-Guide for Using the \Helena Workbench
------------------------------------------
To use the HelenaText editor, a running Eclipse installation is needed. The 
installation was tested with Eclipse Mars 4.5.1 with the plug-ins for Xtext 
version 2.8.4 installed from software updates and ATL/EMFTVM version 3.6 installed 
from marketplace (any previous version of ATL might have to be uninstalled before). 
To add the Helena workbench to this \Eclipse installation, two approaches are 
possible: Either import the jar-archives of the Helena plug-in to the plugins-folder 
of the current Eclipse installation. Or launch a new internal Eclipse instance with 
the Helena workbench running. 

In the Eclipse installation with the Helena plug-in, the HelenaText editor can be 
used. For that, create a new Java project in the new Eclipse instance and create a 
file in the src-folder of the new project with the extension of the defined language,
i.e., .helena. A window will pop-up which asks whether the Xtext nature should be
added to the new project. By confirming this pop-up, the HelenaText editor can be 
used for the new project.

With that, the Java project is ready to be used for the specification of an 
ensemble-based system with HelenaText. The specification has to be written in a 
.helena-file. Such a file is supported by a custom HelenaText editor which provides 
syntax highlighting, content assist and validation. On save, a valid HelenaText file
is furthermore automatically translated to Promela and Java. The generated Promela 
file resides in the folder promela-gen and has the same name as the .helena, but 
with the extension .pml. This file can be used for verification with Spin. The 
generated Java code resides in the folders src-gen and src-user. To be able to run 
the generated Java code, several steps are necessary. Firstly, the two folders have 
to be added to the build-path. Secondly, the jHelena framework has to be added to 
the build-path (either as a jar-archive or a project). Thirdly, the missing code in 
the implementation classes of the folder src-user has to be implemented.


Adaptations in the HelenaLanguage Xtext Project
--------------------------------------------
- Install test-util plugin from https://code.google.com/a/eclipselabs.org/p/xtext-utils/ (which provides useful Classes and functions for unit-testing)
  and add a dependency to plugin org.eclipselabs.xtext.utils.unittesting in MANIFEST.MF (in the test project)
- Added testfiles folder to build-path of the test project