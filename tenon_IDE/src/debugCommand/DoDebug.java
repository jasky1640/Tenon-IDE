package debugCommand;

import console.ConsoleFactory1;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class DoDebug extends AbstractHandler {
	public static Object openTvmObject = new Object();

	public Object execute(ExecutionEvent event) throws ExecutionException {
		String filePath = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorInput().getToolTipText();

		MessageConsoleStream printer = ConsoleFactory1.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);

		Utils utils = new Utils();
		utils.createTask0asm(filePath);

		openTvmObject = OpenTvmMode.getTvmThread();
		((Thread) openTvmObject).start();
		try {
			openTvmObject.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printer.println("Dodebug");
		return null;
	}
}