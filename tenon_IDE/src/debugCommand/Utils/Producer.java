package debugCommand.Utils;

/**
 * @ClassName: Producer
 * @Description: 将调试命令放入表中
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class Producer implements Runnable {

	private final String command;

	public Producer(String commandString) {

		this.command = commandString;

	}

	@SuppressWarnings("unchecked")
	@Override

	public void run() {

		try {
			ShareQueue.sharedQueue.put(command);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
