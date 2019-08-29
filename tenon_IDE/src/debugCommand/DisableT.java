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
 * @ClassName: DisableT
 * @Description: 向后台Tvm模式中传入disable命令按钮
 * @author weijian
 * @date 2019年7月18日
 * 
 */
public class DisableT extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.executeCommand(TenonCommandString.DISABLE);

		DebugBreakpointList bpList = ViewUtils.getBreakpointList();
		DebugBreakpointList bpListRefresh = ViewUtils.ableALL(bpList, false);
		ViewUtils.updateBreakpointListView(bpListRefresh);

		return null;
	}

	/**
	 * @Title: disableUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 01:24:31
	 */
	public static void disableUI() {
		CommandUtils.executeCommand(TenonCommandString.DISABLE);

		DebugBreakpointList bpList = ViewUtils.getBreakpointList();
		DebugBreakpointList bpListRefresh = ViewUtils.ableALL(bpList, false);
		ViewUtils.updateBreakpointListView(bpListRefresh);
	}

	/**
	 * @Title: disableSelected
	 * @Description: 使通过按钮选中的断点失效
	 * @param element
	 * @author weijian
	 * @date 2019-08-01 08:22:33
	 */
	public static void disableSelectedUI(ArrayList<Integer> breakpointCountsList) {
		CommandUtils.ableSelected(breakpointCountsList, false);

		DebugBreakpointList dpList=ViewUtils.ableSelectedUI(breakpointCountsList, false);
		ViewUtils.updateBreakpointListView(dpList);
	}

}
