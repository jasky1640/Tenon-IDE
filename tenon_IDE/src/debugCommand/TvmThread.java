package debugCommand;

import console.ConsoleFactory1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.eclipse.ui.console.MessageConsoleStream;

public class TvmThread {
	public static Process tvmThreadPocess = null;

	private static TvmThread tvmThread = null;

	public static TvmThread getTvmThread() {
		synchronized (TvmThread.class) {
			if (tvmThread == null) {
				tvmThread = new TvmThread();
			}
		}

		return tvmThread;
	}

	public static void execTvm() {
		File dir = new File("/tmp");
		String command = "tvm -i task0.asm";
		new StringBuilder();
		ProcessBuilder pb = new ProcessBuilder(new String[0]);
		pb.redirectErrorStream(true);

		MessageConsoleStream printer = ConsoleFactory1.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);
		try {
			pb.directory(dir);
			pb.command(command.split(" "));
			tvmThreadPocess = pb.start();


			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(tvmThreadPocess.getOutputStream()));

			bw.write("help \n");

			bw.flush();

			InputStream is = tvmThreadPocess.getInputStream();
			InputStreamReader isr = null;
			isr = new InputStreamReader(is, "UTF-8");
			BufferedReader in = new BufferedReader(isr);
			String line = null;
			while ((line = in.readLine()) != null) {
				printer.println(line + "\n");
			}

			tvmThreadPocess.getErrorStream();
			InputStreamReader isrE = null;
			isrE = new InputStreamReader(is, "UTF-8");
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