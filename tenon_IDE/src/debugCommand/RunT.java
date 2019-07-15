package debugCommand;

import debugCommand.Utils.Consumer;
import debugCommand.Utils.Producer;
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

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Thread runThread = new Thread(new Producer(ConstantString.RUN));
		Thread consumerThread = new Thread(new Consumer());

		runThread.start();
		consumerThread.start();

		return null;
	}
}