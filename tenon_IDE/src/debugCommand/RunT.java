package debugCommand;

import console.ConsoleFactory1;
import org.eclipse.core.commands.AbstractHandlerWithState;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.State;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.MessageConsoleStream;

public class RunT extends AbstractHandlerWithState {
	public void handleStateChange(State state, Object oldValue) {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		String filePath = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorInput().getToolTipText();

		MessageConsoleStream printer = ConsoleFactory1.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);

		Utils utils = new Utils();
		utils.createTask0asm(filePath);

		CreateRun createRun = new CreateRun();
		createRun.start();
		try {
			createRun.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printer.println("createRun");

		return null;
	}
}