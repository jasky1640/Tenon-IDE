package debugview.breakpointview;

import debugCommand.DoDebug;

/**
 * This class represents a breakpoint for debugger
 */
public class DebugBreakpoint {

	private boolean enabled;
	private int lineNumber;
	private int counts;

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public void reduceCount() {
		this.counts = this.counts - 1;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public DebugBreakpoint() {
		super();
		this.enabled = true;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getBreakpointInfo() {
		return "Breakpoint " + this.getCounts() + ",  " + DoDebug.fileName + ": " + this.lineNumber;
	}
}
