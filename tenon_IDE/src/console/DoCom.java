package console;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.console.MessageConsoleStream;

import debugCommand.Utils.CommandUtils;
import debugCommand.constant.TenonCommandString;
import tool.ToolUtils;

/**
 * @ClassName: DoCom
 * @Description: 工具栏菜单"Tenon编译"
 * @author weijian
 * @date 2019-08-21 12:07:50
 */
public class DoCom implements IWorkbenchWindowActionDelegate {

	@SuppressWarnings("static-access")
	@Override
	public void run(IAction action) {
		String filePath = ToolUtils.getFilePath();
		String cmd = TenonCommandString.TENON + " " + filePath;

		String result = CommandUtils.execCmd(cmd, null);
		ConsoleFactory con = new ConsoleFactory();
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
