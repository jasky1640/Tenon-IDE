package debugCommand;

import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * @ClassName: RunT
 * @Description: 向后台Tvm模式中传入run命令按钮
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class RunT extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.executeCommand(TenonCommandString.RUN);
		return null;
	}

	/**
	 * @Title: runUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 12:59:28
	 */
	public static void runUI() {
		CommandUtils.executeCommand(TenonCommandString.RUN);
	}
}