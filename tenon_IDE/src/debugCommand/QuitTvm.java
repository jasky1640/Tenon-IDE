package debugCommand;

import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;
import debugview.breakpointview.DebugBreakpointList;
import debugview.constant.ViewConstant;
import debugview.utils.ViewUtils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;

/**
 * @ClassName: QuitTvm
 * @Description: 退出Tvm
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class QuitTvm extends AbstractHandler {

	@SuppressWarnings("static-access")
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommandUtils.executeCommand(TenonCommandString.TVMQUIT);

		try {
			ViewUtils.closeOropenView(ViewConstant.DEBUGVARIABLEVIEW, false);
			ViewUtils.closeOropenView(ViewConstant.DEBUGBREAKPOINTVIEW, false);
			OpenTvmMode.getTvmThread().tvmThreadPocess = null;
			DebugBreakpointList.clearBreakpointCounts();
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void quitTvmUI() {
		CommandUtils.executeCommand(TenonCommandString.TVMQUIT);

		try {
			ViewUtils.closeOropenView(ViewConstant.DEBUGVARIABLEVIEW, false);
			ViewUtils.closeOropenView(ViewConstant.DEBUGBREAKPOINTVIEW, false);
			OpenTvmMode.getTvmThread().tvmThreadPocess = null;
			DebugBreakpointList.clearBreakpointCounts();
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}