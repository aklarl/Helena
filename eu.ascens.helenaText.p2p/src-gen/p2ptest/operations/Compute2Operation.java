
package p2ptest.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import eu.ascens.helena.dev.Operation;
import eu.ascens.helena.dev.Variable;

public class Compute2Operation extends Operation {

	public Compute2Operation(Variable<Integer> input, Variable<Boolean> input2) {
		super(toList(input, input2));
	}

	private static List<Variable<?>> toList(Variable<?>... objects) {
		return Arrays.asList(objects);
	}
}
