package debugCommand;

import console.ConsoleFactory1;
import console.Shell;
import java.io.File;
import org.eclipse.ui.console.MessageConsoleStream;

public class Utils {
	public void createTask0asm(String filePath) {
		MessageConsoleStream printer = ConsoleFactory1.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);

		File dir = new File("/tmp");
		String cmdString = null;

		cmdString = "tenonc -g " + filePath;
		Shell.execCmd(cmdString, dir);
	}
}