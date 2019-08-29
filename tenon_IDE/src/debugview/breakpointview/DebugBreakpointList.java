package debugview.breakpointview;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a list debugger breakpoint information
 */
public class DebugBreakpointList {
	private List<DebugBreakpoint> debugBreakpoints;

	private static int breakpointCounts = 0; // 断点数

	public static int getBreakpointCounts() {
		return breakpointCounts;
	}

	public static void setBreakpointCounts(int breakpointCounts) {
		DebugBreakpointList.breakpointCounts = breakpointCounts;
	}

	public static int addBreakpointCounts() {
		return breakpointCounts++;
	}

	public static int reduceBreakpointCounts() {
		return breakpointCounts--;
	}

	public DebugBreakpointList() {
		debugBreakpoints = new ArrayList<DebugBreakpoint>();
	}

	// 添加断点
	public void add(DebugBreakpoint debugBreakpoint) {
		debugBreakpoints.add(debugBreakpoint);
		addBreakpointCounts();
	}

	// 获取当前所有断点
	public List<DebugBreakpoint> getDebugBreakpoints() {
		return Collections.unmodifiableList(debugBreakpoints);
	}

	// 删除某断点
	public void delete(int breakpointCount) {
		debugBreakpoints.remove(breakpointCount);
		reduceBreakpointCounts();
		for (DebugBreakpoint bp : debugBreakpoints) {
			if (bp.getCounts() == breakpointCount) {
				debugBreakpoints.remove(bp);
			}
			if (bp.getCounts() > breakpointCount) {
				bp.reduceCount();
			}
		}
	}

	// 删除所有断点
	public void delete() {
		debugBreakpoints.clear();
		clearBreakpointCounts();

	}

	// 断点数清零
	public static void clearBreakpointCounts() {
		breakpointCounts = 0;
	}
}
