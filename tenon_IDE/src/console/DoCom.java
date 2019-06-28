package console;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.MessageConsoleStream;

public class DoCom implements IWorkbenchWindowActionDelegate {

	@Override
	public void run(IAction action) {
        String filePath = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getToolTipText();
        
    	String cmd = "tenon -m base " + filePath;
		String result;
		result = Shell.execCmd(cmd, null);
        ConsoleFactory1 con = new ConsoleFactory1();
        MessageConsoleStream printer = con.getConsole().newMessageStream();
        printer.setActivateOnWrite(true);
        printer.println(cmd);
        printer.println(result);

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}

}
