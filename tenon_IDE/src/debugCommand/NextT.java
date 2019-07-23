package debugCommand;

import debugCommand.Utils.PutCommand;
import debugCommand.Utils.TakeCommand;
import debugCommand.constant.ConstantString;

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

	// Will be removed, keep for test purpose
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Thread nextThread = new Thread(new PutCommand(ConstantString.NEXT));
		Thread takeCommandThread = new Thread(new TakeCommand());

		nextThread.start();
		takeCommandThread.start();

		return null;
	}

	public static void nextUI() {
		Thread nextThread = new Thread(new PutCommand(ConstantString.NEXT));
		Thread takeCommandThread = new Thread(new TakeCommand());

		nextThread.start();
		takeCommandThread.start();
	}

}