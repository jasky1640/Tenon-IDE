package debugCommand;

import java.util.ArrayList;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.CommandUtils;
import debugview.breakpointview.DebugBreakpointList;
import debugview.utils.ViewUtils;

/**
 * @ClassName: DeleteT
 * @Description: 向后台Tvm模式中传入delete命令按钮
 * @author weijian
 * @date 2019-08-08 11:12:23
 */
public class DeleteT extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.deleteAll();

		ViewUtils.clearDBList();

		return null;
	}

	/**
	 * @Title: deleteUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 01:58:33
	 */
	public static void deleteUI() {
		CommandUtils.deleteAll();

		ViewUtils.clearDBList();
	}

	/**
	 * @Title: deleteSelected
	 * @Description: 使通过按钮选中的断点删除
	 * @param breakpointCountsList
	 * @author weijian
	 * @date 2019-08-21 01:58:52
	 */
	public static void deleteSelectedUI(ArrayList<Integer> breakpointCountsList) {
		CommandUtils.deleteSelected(breakpointCountsList);

		DebugBreakpointList dpList = ViewUtils.deleteSelectedUI(breakpointCountsList);
		ViewUtils.updateBreakpointListView(dpList);
	}

}
