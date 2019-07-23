package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.PutCommand;
import debugCommand.Utils.TakeCommand;
import debugCommand.constant.ConstantString;

/**
 * @ClassName: ShowT
 * @Description: 向后台Tvm模式中传入show breakpoint命令按钮
 * @author weijian
 * @date 2019年7月18日
 * 
 */
public class ShowT extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Thread showThread = new Thread(new PutCommand(ConstantString.SHOW + " breakpoint"));
		Thread takeCommandThread = new Thread(new TakeCommand());

		showThread.start();
		takeCommandThread.start();
		return null;
	}

	public static void showUI() {
		Thread showThread = new Thread(new PutCommand(ConstantString.SHOW + " breakpoint"));
		Thread takeCommandThread = new Thread(new TakeCommand());

		showThread.start();
		takeCommandThread.start();
	}
}
