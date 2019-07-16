package debugCommand;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.eclipse.ui.console.MessageConsoleStream;

import console.ConsoleFactory1;
import debugCommand.constant.ConstantString;

/**
 * @ClassName: OpenTvmMode
 * @Description: 向后台传输tvm开启命令
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class OpenTvmMode implements Runnable {

	public static Process tvmThreadPocess = null;

	private static OpenTvmMode openTvmMode = null;

	public static OpenTvmMode getTvmThread() {
		synchronized (OpenTvmMode.class) {
			if (openTvmMode == null) {
				openTvmMode = new OpenTvmMode();
			}
		}
		return openTvmMode;
	}

	@Override
	public void run() {

		MessageConsoleStream printer = ConsoleFactory1.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);

		File dir = new File(ConstantString.FILE);
		String command = ConstantString.TVMSTART;
		ProcessBuilder pb = new ProcessBuilder();
		pb.redirectErrorStream(true);

		try {
			pb.directory(dir);
			pb.command(command.split(" "));
			tvmThreadPocess = pb.start();

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(tvmThreadPocess.getOutputStream()));

			bw.flush();

			InputStream is = tvmThreadPocess.getInputStream();
			InputStreamReader isr = null;
			isr = new InputStreamReader(is, "UTF-8");
			BufferedReader in = new BufferedReader(isr);
			String line = null;
			while ((line = in.readLine()) != null) {
				printer.println(line + "\n");
			}

			InputStream isE = tvmThreadPocess.getErrorStream();
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