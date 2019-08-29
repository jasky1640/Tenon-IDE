package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import debugCommand.Utils.CommandUtils;
import debugview.breakpointview.DebugBreakpointList;
import tool.ToolUtils;

/**
 * @ClassName: DoDebug
 * @Description: 开启Tvm模式按钮
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class DoDebug extends AbstractHandler {

	public static Thread openTvmModeThread = new Thread();

	public static String fileName;

	public Object execute(ExecutionEvent event) throws ExecutionException {

		String filePath = ToolUtils.getFilePath();
		CommandUtils.createTask0asm(filePath);

		DebugBreakpointList.clearBreakpointCounts();

		openTvmModeThread = new Thread(OpenTvmMode.getTvmThread());
		openTvmModeThread.start();

		return null;
	}
	
	/**  
	 * @Title: DoDebugUI
	 * @Description: 供断点视图图标使用
	 * @author weijian
	 * @date 2019-08-21 05:34:19 
	 */ 
	public static void DoDebugUI() {
		String filePath = ToolUtils.getFilePath();
		CommandUtils.createTask0asm(filePath);

		DebugBreakpointList.clearBreakpointCounts();

		openTvmModeThread = new Thread(OpenTvmMode.getTvmThread());
		openTvmModeThread.start();
	}
}