package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.PutCommand;
import debugCommand.Utils.TakeCommand;
import debugCommand.constant.ConstantString;

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
		Thread disableThread = new Thread(new PutCommand(ConstantString.DISABLE));
		Thread takeCommandThread = new Thread(new TakeCommand());

		disableThread.start();
		takeCommandThread.start();
		return null;
	}

	public static void disableUI() {
		Thread disableThread = new Thread(new PutCommand(ConstantString.DISABLE));
		Thread takeCommandThread = new Thread(new TakeCommand());

		disableThread.start();
		takeCommandThread.start();
	}

}
