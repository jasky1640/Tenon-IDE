package debugCommand.Utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: ShareQueue
 * @Description: 存放调试命令
 * @author weijian
 * @date 2019年7月13日
 * 
 */
public class ShareQueue {
	@SuppressWarnings("rawtypes")
	public static BlockingQueue sharedQueue = new LinkedBlockingQueue();

}
