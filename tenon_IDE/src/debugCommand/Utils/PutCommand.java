package debugCommand.Utils;

/**
 * @ClassName: TakeCommand
 * @Description: 放入调试命令
 * @author weijian
 * @date 2019年7月14日
 * 
 */
public class PutCommand implements Runnable {

	private final String command;

	public PutCommand(String commandString) {

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
