package console;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import console.Shell;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.MessageConsoleStream;

public class DoCompile extends AbstractHandler {
	public DoCompile() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
        String filePath = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getToolTipText();
        File dir = new File("/tmp");
    	String cmd = "tenon -m base " + filePath;
		String result;
		result = Shell.execCmd(cmd, dir);
        ConsoleFactory1 con = new ConsoleFactory1();
        MessageConsoleStream printer = con.getConsole().newMessageStream();
        printer.setActivateOnWrite(true);
        printer.println(cmd);
        printer.println(result);

        
		return null;
	}
}