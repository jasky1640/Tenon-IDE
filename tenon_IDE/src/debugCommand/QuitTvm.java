package debugCommand;

import console.ConsoleFactory1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.console.MessageConsoleStream;

public class QuitTvm extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		MessageConsoleStream printer = ConsoleFactory1.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(OpenTvmMode.tvmThreadPocess.getOutputStream()));

			bw.write("quit \n");

			bw.flush();

			InputStream is = OpenTvmMode.tvmThreadPocess.getInputStream();
			InputStreamReader isr = null;
			isr = new InputStreamReader(is, "UTF-8");
			BufferedReader in = new BufferedReader(isr);
			String line = null;
			while ((line = in.readLine()) != null) {
				printer.println(line + "\n");
			}

			OpenTvmMode.tvmThreadPocess.getErrorStream();
			InputStreamReader isrE = null;
			isrE = new InputStreamReader(is, "UTF-8");
			BufferedReader err = new BufferedReader(isrE);

			String lineE = null;

			while ((lineE = err.readLine()) != null) {
				printer.println(lineE + "\n");
			}

			OpenTvmMode.tvmThreadPocess.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}