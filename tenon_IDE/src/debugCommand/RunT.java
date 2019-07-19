package debugCommand;

import debugCommand.Utils.PutCommand;
import debugCommand.Utils.TakeCommand;
import debugCommand.constant.ConstantString;

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
	
	//Will be removed, keep for test purpose
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Thread runThread = new Thread(new PutCommand(ConstantString.RUN));
		Thread takeCommandThread = new Thread(new TakeCommand());

		runThread.start();
		takeCommandThread.start();

		return null;
	}
	
	public static void run() {
		Thread runThread = new Thread(new PutCommand(ConstantString.RUN));
		Thread takeCommandThread = new Thread(new TakeCommand());

		runThread.start();
		takeCommandThread.start();
	}
}