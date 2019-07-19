package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.PutCommand;
import debugCommand.Utils.TakeCommand;
import debugCommand.constant.ConstantString;

/**
 * @ClassName: BacktraceT
 * @Description: 向后台Tvm模式中传入backtrace命令按钮
 * @author weijian
 * @date 2019年7月16日
 * 
 */
public class BacktraceT extends AbstractHandler {

	//Will be removed, keep for test purpose
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Thread backtraceThread = new Thread(new PutCommand(ConstantString.BACKTRACE));
		Thread takeCommandThread = new Thread(new TakeCommand());

		backtraceThread.start();
		takeCommandThread.start();
		return null;
	}

	public static void backtrace() {
		Thread backtraceThread = new Thread(new PutCommand(ConstantString.BACKTRACE));
		Thread takeCommandThread = new Thread(new TakeCommand());

		backtraceThread.start();
		takeCommandThread.start();
	}
}
