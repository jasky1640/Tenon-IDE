package debugCommand.Utils;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.ui.console.MessageConsoleStream;

import console.ConsoleFactory;

/**
 * @ClassName: MyMouseListener
 * @Description: 判断是否为双击事件
 * @author weijian
 * @date 2019-08-19 09:19:52
 */
public class MyMouseListener extends java.awt.event.MouseAdapter {
	public MyMouseListener(String fileName, int lineNum) {
		super();
		this.fileName = fileName;
		this.lineNum = lineNum;
	}

	// 用来判断是否已经执行双击事件
	private static boolean flag = false;
	// 用来判断是否该执行双击事件
	private static int clickNum = 0;
	private String fileName;
	private int lineNum;

	public void mouseClicked(MouseEvent e) {

		final MouseEvent me = e;
		// 每次点击鼠标初始化双击事件执行标志为false
		this.flag = false;

		// 定义定时器
		java.util.Timer timer = new java.util.Timer();

		// 定时器开始执行,延时1.0秒后确定是否执行单击事件
		timer.schedule(new java.util.TimerTask() {
			// 记录定时器执行次数
			private int n = 0;

			public void run() {
				// 如果双击事件已经执行,那么直接取消单击执行
				if (MyMouseListener.flag) {
					n = 0;
					MyMouseListener.clickNum = 0;
					this.cancel();
					return;
				}
				// 定时器等待1.0秒后,双击事件仍未发生,执行单击事件
				if (n == 1) {
					// 执行单击事件
					mouseSingleClicked(me);
					MyMouseListener.flag = true;
					MyMouseListener.clickNum = 0;
					n = 0;
					this.cancel();
				}
				clickNum++;
				n++;
			}
		}, new java.util.Date(), 1000);

		// 当clickNum==1时执行双击事件
		if (this.clickNum == 1) {
			// 执行双击事件
			this.mouseDoubleClicked();
			// 初始化双击事件执行标志为0
			this.clickNum = 0;
			// 双击事件已执行,事件标志为true
			this.flag = true;
		}
	}

	/**
	 * @Title: mouseSingleClicked
	 * @Description: 鼠标单击事件
	 * @param e
	 * @author weijian
	 * @date 2019-08-19 09:20:46
	 */
	public void mouseSingleClicked(MouseEvent e) {
	}

	/**
	 * @Title: mouseDoubleClicked
	 * @Description: 鼠标双击事件
	 * @param e
	 * @author weijian
	 * @date 2019-08-19 09:21:02
	 */
	public void mouseDoubleClicked() {
		MessageConsoleStream printer = ConsoleFactory.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);
		if (CommandUtils.fileWhetherDebugFile(fileName) && CommandUtils.judgeTvmWhetherOpen()) {
			printer.println("The line number at which you double click is: " + lineNum);
			CommandUtils.doubleClickSetBreakpoint(fileName, lineNum);
		}
	}
}