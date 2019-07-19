package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.PutCommand;
import debugCommand.Utils.TakeCommand;
import debugCommand.constant.ConstantString;

/**
 * @ClassName: ContinueT
 * @Description: 向后台Tvm模式中传入continue命令按钮
 * @author weijian
 * @date 2019年7月16日
 * 
 */
public class ContinueT extends AbstractHandler {

	//Will be removed, keep for test purpose
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Thread continueThread = new Thread(new PutCommand(ConstantString.NEXT));
		Thread takeCommandThread = new Thread(new TakeCommand());

		continueThread.start();
		takeCommandThread.start();
		return null;
	}

	public static void continueT() {
		Thread continueThread = new Thread(new PutCommand(ConstantString.NEXT));
		Thread takeCommandThread = new Thread(new TakeCommand());

		continueThread.start();
		takeCommandThread.start();
	}
}
