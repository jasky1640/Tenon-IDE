package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;

/**
 * @ClassName: BacktraceT
 * @Description: 向后台Tvm模式中传入backtrace命令按钮
 * @author weijian
 * @date 2019年7月16日
 * 
 */
public class BacktraceT extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.executeCommand(TenonCommandString.BACKTRACE);
		return null;
	}

	/**
	 * @Title: backtraceUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 11:40:42
	 */
	public static void backtraceUI() {
		CommandUtils.executeCommand(TenonCommandString.BACKTRACE);
	}

}
