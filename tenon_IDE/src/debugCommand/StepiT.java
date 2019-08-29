package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;

/**
 * @ClassName: StepiT
 * @Description: 向后台Tvm模式中传入stepi命令按钮
 * @author weijian
 * @date 2019年7月20日
 * 
 */
public class StepiT extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.executeCommand(TenonCommandString.STEPI);
		return null;
	}

	/**
	 * @Title: stepiUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 12:56:48
	 */
	public static void stepiUI() {
		CommandUtils.executeCommand(TenonCommandString.STEPI);
	}

}
