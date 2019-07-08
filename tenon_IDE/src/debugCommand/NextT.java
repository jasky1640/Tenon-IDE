package debugCommand;

import console.ConsoleFactory1;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.MessageConsoleStream;

public class NextT extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String filePath = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorInput().getToolTipText();

		MessageConsoleStream printer = ConsoleFactory1.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);

		Utils utils = new Utils();
		utils.createTask0asm(filePath);

		CreateNext createNext = new CreateNext();
		createNext.start();
		try {
			createNext.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printer.println("createNext");

		return null;
	}
}