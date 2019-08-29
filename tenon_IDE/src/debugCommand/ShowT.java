package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;

/**
 * @ClassName: ShowT
 * @Description: 向后台Tvm模式中传入show breakpoint命令按钮
 * @author weijian
 * @date 2019年7月18日
 * 
 */
public class ShowT extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.executeCommand(TenonCommandString.SHOW + " " + "breakpoint");
		return null;
	}

	/**
	 * @Title: showUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 12:58:28
	 */
	public static void showUI() {
		CommandUtils.executeCommand(TenonCommandString.SHOW + " " + "breakpoint");
	}
}
