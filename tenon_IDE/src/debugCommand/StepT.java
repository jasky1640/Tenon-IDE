package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.PutCommand;
import debugCommand.Utils.TakeCommand;
import debugCommand.constant.ConstantString;

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

		Thread stepThread = new Thread(new PutCommand(ConstantString.STEP));
		Thread takeCommandThread = new Thread(new TakeCommand());

		stepThread.start();
		takeCommandThread.start();

		return null;
	}

	public static void stepUI() {
		Thread stepThread = new Thread(new PutCommand(ConstantString.STEP));
		Thread takeCommandThread = new Thread(new TakeCommand());

		stepThread.start();
		takeCommandThread.start();
	}

}
