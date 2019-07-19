package debugCommand;

import debugCommand.Utils.PutCommand;
import debugCommand.Utils.TakeCommand;
import debugCommand.constant.ConstantString;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * @ClassName: BreakpointT
 * @Description: 向后台Tvm模式中传入breakpoint命令按钮
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class BreakpointT extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Thread breakpoinThread = new Thread(new PutCommand(ConstantString.BREAKPOINT+" main"));
		Thread takeCommandThread = new Thread(new TakeCommand());

		breakpoinThread.start();
		takeCommandThread.start();

		return null;
	}
}