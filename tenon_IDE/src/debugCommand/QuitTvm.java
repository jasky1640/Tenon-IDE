package debugCommand;

import debugCommand.Utils.Consumer;
import debugCommand.Utils.Producer;
import debugCommand.constant.ConstantString;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * @ClassName: QuitTvm
 * @Description: 退出Tvm
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class QuitTvm extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Thread quitThread = new Thread(new Producer(ConstantString.TVMQUIT));
		Thread consumerThread = new Thread(new Consumer());

		quitThread.start();
		consumerThread.start();

		return null;
	}
}