package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;

/**
 * @ClassName: StepT
 * @Description: 向后台Tvm模式中传入step命令按钮
 * @author weijian
 * @date 2019年7月20日
 * 
 */
public class StepT extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.executeCommand(TenonCommandString.STEP);
		return null;
	}

	/**
	 * @Title: stepUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 12:56:13
	 */
	public static void stepUI() {
		CommandUtils.executeCommand(TenonCommandString.STEP);
	}

}
