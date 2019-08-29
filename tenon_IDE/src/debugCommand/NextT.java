package debugCommand;

import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * @ClassName: NextT
 * @Description: 向后台Tvm模式中传入next命令按钮
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class NextT extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.executeCommand(TenonCommandString.NEXT);
		return null;
	}

	/**
	 * @Title: nextUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 12:54:12
	 */
	public static void nextUI() {
		CommandUtils.executeCommand(TenonCommandString.NEXT);
	}

}