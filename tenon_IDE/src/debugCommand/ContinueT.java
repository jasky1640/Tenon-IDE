package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;

/**
 * @ClassName: ContinueT
 * @Description: 向后台Tvm模式中传入continue命令按钮
 * @author weijian
 * @date 2019年7月16日
 * 
 */
public class ContinueT extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.executeCommand(TenonCommandString.CONTINUE);
		return null;
	}

	/**
	 * @Title: continueUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 12:51:56
	 */
	public static void continueUI() {
		CommandUtils.executeCommand(TenonCommandString.CONTINUE);
	}

}
