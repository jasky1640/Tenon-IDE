package console;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import java.io.File;
import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;
import tool.ToolUtils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.ui.console.MessageConsoleStream;

/**
 * @ClassName: DoCompile
 * @Description: 右键菜单"Tenon编译"
 * @author weijian
 * @date 2019-08-21 12:09:37
 */
public class DoCompile extends AbstractHandler {
	public DoCompile() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("static-access")
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Get the absolute path of the file.
		String filePath = ToolUtils.getFilePath();
		// Terminal open position.
		File dir = new File(TenonCommandString.FILE);
		// Set command "tenon -m base *.t"
		String cmd = TenonCommandString.TENON + " " + filePath;
		String result = CommandUtils.execCmd(cmd, dir);
		ConsoleFactory con = new ConsoleFactory();
		MessageConsoleStream printer = con.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);
		printer.println(cmd);
		printer.println(result);

		return null;
	}
}