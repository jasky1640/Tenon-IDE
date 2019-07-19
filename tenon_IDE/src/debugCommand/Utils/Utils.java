package debugCommand.Utils;

import console.ConsoleFactory1;
import console.Shell;
import debugCommand.constant.ConstantString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.eclipse.ui.console.MessageConsoleStream;

public class Utils {

	/**
	 * @Title: createTask0asm
	 * @Description: 生成task0.asm
	 * @param @param filePath
	 * @return void
	 * @throws @author weijain
	 * @date 2019年7月13日
	 */
	public void createTask0asm(String filePath) {
		MessageConsoleStream printer = ConsoleFactory1.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);

		File dir = new File(ConstantString.FILE);
		String cmdString = null;

		cmdString = "tenonc -g " + filePath;
		Shell.execCmd(cmdString, dir);
	}

	/**
	 * @Title: callBackCommand
	 * @Description: 將调试命令放入tvm模式中，并输出调试结果
	 * @param @param tvm
	 * @param @param command
	 * @return void
	 * @throws @author weijain
	 * @date 2019年7月13日
	 */
	public void callBackCommand(Process tvm, String command) {

		MessageConsoleStream printer = ConsoleFactory1.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);
		printer.println(command);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(tvm.getOutputStream()));

		try {
			bw.flush();
			bw.write(command + " \n");
			bw.flush();
			InputStream is = tvm.getInputStream();
			InputStreamReader isr = null;
			isr = new InputStreamReader(is, "UTF-8");
			BufferedReader in = new BufferedReader(isr);
			String line = null;
			while ((line = in.readLine()) != null) {
				printer.println(line + "\n");
			}
			InputStream isE = tvm.getErrorStream();
			InputStreamReader isrE = null;
			isrE = new InputStreamReader(isE, "UTF-8");
			BufferedReader err = new BufferedReader(isrE);
			String lineE = null;
			while ((lineE = err.readLine()) != null) {
				printer.println(lineE + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}