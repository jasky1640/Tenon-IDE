package debugview;

import org.eclipse.ui.PlatformUI;
import debugCommand.OpenTvmMode;
import debugCommand.Utils.Utils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;

public class DoDebugView extends AbstractHandler {

	public static Thread openTvmModeThread = new Thread();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("debugVariableView");
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("debugBreakpointView");
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String filePath = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorInput().getToolTipText();

		Utils utils = new Utils();
		utils.createTask0asm(filePath);

		openTvmModeThread = new Thread(OpenTvmMode.getTvmThread());
		openTvmModeThread.start();

		return null;
	}
}
