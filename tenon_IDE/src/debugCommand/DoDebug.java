package debugCommand;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;

import debugCommand.Utils.Utils;

/**
 * @ClassName: DoDebug
 * @Description: 开启Tvm模式按钮
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class DoDebug extends AbstractHandler {

	public static Thread openTvmModeThread = new Thread();

	public Object execute(ExecutionEvent event) throws ExecutionException {

		String filePath = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorInput().getToolTipText();

		Utils utils = new Utils();
		utils.createTask0asm(filePath);

		openTvmModeThread = new Thread(OpenTvmMode.getTvmThread());
		openTvmModeThread.start();

		return null;
	}
}