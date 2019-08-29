package debugCommand;

import debugCommand.Utils.CommandUtils;
import debugview.utils.ViewUtils;
import tool.ToolUtils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * @ClassName: BreakpointT
 * @Description: 设置断点
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class BreakpointT extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String filePath = ToolUtils.getFilePath();
		String fileName = ToolUtils.getFileName(filePath);
		int line = CommandUtils.getLine(event);

		if (!CommandUtils.judgeAlreadyBreakpoint(fileName, line)) {
			CommandUtils.setBreakpoint(fileName, line);
			ViewUtils.updateBreakpointListView(ViewUtils.makeBreakpointShowView(line));
		}
		return null;
	}
}