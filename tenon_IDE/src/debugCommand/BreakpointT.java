package debugCommand;

import console.ConsoleFactory1;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.MessageConsoleStream;

public class BreakpointT extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String filePath = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorInput().getToolTipText();

		MessageConsoleStream printer = ConsoleFactory1.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);

		Utils utils = new Utils();
		utils.createTask0asm(filePath);

		CreateBreakpoint createBreakpoint = new CreateBreakpoint();
		createBreakpoint.start();
		try {
			createBreakpoint.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printer.println("createBreakpoint");
		return null;
	}
}