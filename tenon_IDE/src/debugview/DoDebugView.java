package debugview;

import debugCommand.DoDebug;
import debugCommand.Utils.CommandUtils;
import debugview.constant.ViewConstant;
import debugview.utils.ViewUtils;
import tool.ToolUtils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;

public class DoDebugView extends AbstractHandler {

	public static Thread openTvmModeThread = new Thread();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			String filePath = ToolUtils.getFilePath();
			CommandUtils.createTask0asm(filePath);
			DoDebug.fileName = ToolUtils.getFileName(filePath);

			ViewUtils.closeOropenView(ViewConstant.DEBUGVARIABLEVIEW, true);
			ViewUtils.closeOropenView(ViewConstant.DEBUGBREAKPOINTVIEW, true);

			ViewUtils.clearDBList();

		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
