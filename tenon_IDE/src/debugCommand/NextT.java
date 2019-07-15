package debugCommand;

import debugCommand.Utils.Consumer;
import debugCommand.Utils.Producer;
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
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Thread nextThread = new Thread(new Producer(ConstantString.NEXT));
		Thread consumerThread = new Thread(new Consumer());

		nextThread.start();
		consumerThread.start();

		return null;
	}
}