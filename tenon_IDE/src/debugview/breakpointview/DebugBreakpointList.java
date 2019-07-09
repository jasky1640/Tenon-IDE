package debugview.breakpointview;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a list debugger breakpoint information
 */
public class DebugBreakpointList {
	private List<DebugBreakpoint> debugBreakpoints;
	
	public DebugBreakpointList() {
		debugBreakpoints = new ArrayList<DebugBreakpoint>();
	}
	
	public void add(DebugBreakpoint debugBreakpoint) {
		debugBreakpoints.add(debugBreakpoint);
	}

	public List<DebugBreakpoint> getDebugBreakpoints() {
		return Collections.unmodifiableList(debugBreakpoints);
	}
}
