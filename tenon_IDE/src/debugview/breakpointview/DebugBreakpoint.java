package debugview.breakpointview;

/**
 * This class represents a breakpoint for debugger
 */
public class DebugBreakpoint {

	private String info;
	private boolean enabled;

	public DebugBreakpoint(String info) {
		super();
		this.info = info;
		this.enabled = true;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
