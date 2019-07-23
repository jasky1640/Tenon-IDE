package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.PutCommand;
import debugCommand.Utils.TakeCommand;
import debugCommand.constant.ConstantString;


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

		Thread stepiThread = new Thread(new PutCommand(ConstantString.STEPI));
		Thread takeCommandThread = new Thread(new TakeCommand());

		stepiThread.start();
		takeCommandThread.start();

		return null;
	}

	public static void stepiUI() {
		Thread stepiThread = new Thread(new PutCommand(ConstantString.STEPI));
		Thread takeCommandThread = new Thread(new TakeCommand());

		stepiThread.start();
		takeCommandThread.start();
	}

}
