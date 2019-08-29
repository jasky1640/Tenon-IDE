package debugview.utils;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import debugview.breakpointview.DebugBreakpoint;
import debugview.breakpointview.DebugBreakpointList;
import debugview.breakpointview.DebugBreakpointView;

/**
 * @ClassName: ViewUtils
 * @Description: 视图常用方法
 * @author weijian
 * @date 2019-08-01 10:02:12
 */
public class ViewUtils {

	/**
	 * @Title: ableALL
	 * @Description: 將所有断点设置为可用或不可用
	 * @param bpDisOrEnable
	 * @author weijian
	 * @date 2019-07-31 09:31:03
	 */
	public static DebugBreakpointList ableALL(DebugBreakpointList bpList, boolean bpsDisOREnable) {

		for (DebugBreakpoint bp : bpList.getDebugBreakpoints()) {
			bp.setEnabled(bpsDisOREnable);
		}
		return bpList;
	}

	/**
	 * @Title: ableSelectedUI
	 * @Description: 在视图中关闭或开启选中断点
	 * @param breakpointCountsList
	 * @param disableOREnable
	 * @return
	 * @author weijian
	 * @date 2019-08-21 07:14:11
	 */
	public static DebugBreakpointList ableSelectedUI(ArrayList<Integer> breakpointCountsList, Boolean disableOREnable) {
		DebugBreakpointList bpList = getBreakpointList();
		for (DebugBreakpoint bp : bpList.getDebugBreakpoints()) {
			if (breakpointCountsList.contains(bp.getCounts())) {
				bp.setEnabled(disableOREnable);
				continue;
			}
		}
		return bpList;
	}

	/**
	 * @Title: deleteSelected
	 * @Description: 在视图中删除选中断点
	 * @param breakpointCountsList
	 * @author weijian
	 * @date 2019-08-10 06:06:03
	 */
	public static DebugBreakpointList deleteSelectedUI(ArrayList<Integer> breakpointCountsList) {
		Collections.sort(breakpointCountsList);
		DebugBreakpointList bpList = getBreakpointList();
		DebugBreakpointList bpListTemp = new DebugBreakpointList();
		for (DebugBreakpoint bp : bpList.getDebugBreakpoints()) {
			if (breakpointCountsList.contains(bp.getCounts())) {
				DebugBreakpointList.reduceBreakpointCounts();
				continue;
			} else {
				bpListTemp.add(bp);
			}
		}
		int breakpontSize = bpListTemp.getDebugBreakpoints().size();
		int tempCount = 0;
		for (DebugBreakpoint bp : bpListTemp.getDebugBreakpoints()) {
			if (tempCount < breakpontSize) {
				bp.setCounts(tempCount);
				tempCount++;
			}
		}
		DebugBreakpointList.setBreakpointCounts(tempCount);
		return bpListTemp;
	}

	/**
	 * @Title: clearDBList
	 * @Description: 删除断点视图中所有的断点
	 * @author weijian
	 * @date 2019-08-21 01:55:58
	 */
	public static void clearDBList() {
		updateBreakpointListView(new DebugBreakpointList());
		DebugBreakpointList.clearBreakpointCounts();
	}

	/**
	 * @Title: getBreakpointList
	 * @Description: 获取当前断点视图中的全部断点
	 * @return
	 * @author weijian
	 * @date 2019-08-21 12:24:08
	 */
	public static DebugBreakpointList getBreakpointList() {
		return (DebugBreakpointList) DebugBreakpointView.getViewer().getInput();

	}

	/**
	 * @Title: makeBreakpointShowView
	 * @Description: 在断点视图中增加设置的断点
	 * @param breakpointLine
	 * @return
	 * @author weijian
	 * @date 2019-08-21 01:34:11
	 */
	public static DebugBreakpointList makeBreakpointShowView(int breakpointLine) {
		DebugBreakpoint dBreakpoint = new DebugBreakpoint();
		dBreakpoint.setLineNumber(breakpointLine);
		dBreakpoint.setCounts(DebugBreakpointList.getBreakpointCounts());
		DebugBreakpointList bpList = getBreakpointList();
		bpList.add(dBreakpoint);
		return bpList;
	}

	/**
	 * @Title: updateBreakpointListView
	 * @Description: 更新断点视图中显示的断点
	 * @param bpList
	 * @author weijian
	 * @date 2019-08-21 01:32:48
	 */
	public static void updateBreakpointListView(DebugBreakpointList bpList) {
		DebugBreakpointView.update(bpList);
	}

	/**
	 * @Title: closeOropenView
	 * @Description: 开启或关闭视图
	 * @param id
	 * @param viewOpenOrClose
	 * @throws PartInitException
	 * @author weijian
	 * @date 2019-08-01 10:32:30
	 */
	public static void closeOropenView(String id, boolean viewOpenORClose) throws PartInitException {
		if (viewOpenORClose == true) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(id);
		} else {
			IViewPart viewpart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(id);
			if (viewpart != null) {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(viewpart);
			}
		}
	}

}
