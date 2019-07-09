package debugview.breakpointview;

/**
 * This class represents a breakpoint for debugger
 */
public class DebugBreakpoint {

	private String info;

	public DebugBreakpoint(String info) {
		super();
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
