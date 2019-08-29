package debugCommand;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;
import debugview.breakpointview.DebugBreakpointList;
import debugview.utils.ViewUtils;

/**
 * @ClassName: EnableT
 * @Description: 向后台Tvm模式中传入enable命令按钮
 * @author weijian
 * @date 2019年7月20日
 * 
 */
public class EnableT extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.executeCommand(TenonCommandString.ENABLE);

		DebugBreakpointList bpList = ViewUtils.getBreakpointList();
		DebugBreakpointList bpListRefresh = ViewUtils.ableALL(bpList, true);
		ViewUtils.updateBreakpointListView(bpListRefresh);

		return null;
	}

	/**
	 * @Title: enableUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 01:43:53
	 */
	public static void enableUI() {
		CommandUtils.executeCommand(TenonCommandString.ENABLE);

		DebugBreakpointList bpList = ViewUtils.getBreakpointList();
		DebugBreakpointList bpListRefresh = ViewUtils.ableALL(bpList, true);
		ViewUtils.updateBreakpointListView(bpListRefresh);
	}

	/**
	 * @Title: enableSelected
	 * @Description: 使通过按钮选中的断点有效
	 * @param breakpointCountsList
	 * @author weijian
	 * @date 2019-08-01 08:26:24
	 */
	public static void enableSelected(ArrayList<Integer> breakpointCountsList) {
		CommandUtils.ableSelected(breakpointCountsList, true);

		DebugBreakpointList dpList = ViewUtils.ableSelectedUI(breakpointCountsList, true);
		ViewUtils.updateBreakpointListView(dpList);
	}

}
