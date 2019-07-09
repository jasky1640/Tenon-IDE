package debugview.variableview;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a list of pairs of variable and value for debugging
 */
public class DebugVariableList {
	private List<DebugVariable> debugVariables;
	
	public DebugVariableList() {
		debugVariables = new ArrayList<DebugVariable>();
	}
	
	public void add(DebugVariable debugVar) {
		debugVariables.add(debugVar);
	}
	
	public List<DebugVariable> getDebugVariables() {
	    return Collections.unmodifiableList(debugVariables);
	}
}
