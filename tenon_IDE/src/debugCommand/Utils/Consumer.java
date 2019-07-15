package debugCommand.Utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import debugCommand.OpenTvmMode;

/**
 * @ClassName: Consumer
 * @Description: 从表中取出调试命令，并调用 Utils.callBackCommand方法
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class Consumer implements Runnable {

	public Process callbackProcess = null;

	@SuppressWarnings("static-access")
	public Consumer() {
		this.callbackProcess = OpenTvmMode.getTvmThread().tvmThreadPocess;
	}

	@Override
	public void run() {
		while (true) {

			try {

				String commString = (String) ShareQueue.sharedQueue.take();
				ShareQueue.sharedQueue.clear();

				Utils utils2 = new Utils();
				utils2.callBackCommand(callbackProcess, commString);

			} catch (InterruptedException ex) {

				Logger.getLogger(OpenTvmMode.class.getName()).log(Level.SEVERE, null, ex);

			}
		}
	}
}
