package debugCommand.Utils;

import console.ConsoleFactory;
import debugCommand.DoDebug;
import debugCommand.OpenTvmMode;
import debugCommand.constant.TenonCommandString;
import debugview.breakpointview.DebugBreakpoint;
import debugview.breakpointview.DebugBreakpointList;
import debugview.utils.ViewUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * @ClassName: CommandUtils
 * @Description: 调试命令常用方法
 * @author weijian
 * @date 2019-07-31 09:33:10
 */
public class CommandUtils {

	/**
	 * @Title: execCmd
	 * @Description: 供右键菜单“Tenon编译”使用
	 * @param cmd
	 * @param dir
	 * @return
	 * @author weijian
	 * @date 2019-08-21 12:04:59
	 */
	public static String execCmd(String cmd, File dir) {
		StringBuilder result = new StringBuilder();

		if (cmd == null || cmd.length() <= 0) {
			return result.toString();
		}

		Process process = null;
		BufferedReader bufrIn = null;
		BufferedReader bufrError = null;

		try {
			// 执行命令, 返回一个子进程对象（命令在子进程中执行）
			process = Runtime.getRuntime().exec(cmd, null, dir);

			// process = Runtime.getRuntime().exec(cmd);
			// 方法阻塞, 等待命令执行完成（成功会返回0）
			process.waitFor();

			// 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
			bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
			bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

			// 读取输出
			String line = null;
			while ((line = bufrIn.readLine()) != null) {
				result.append(line).append('\n');
			}
			while ((line = bufrError.readLine()) != null) {
				result.append(line).append('\n');
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStream(bufrIn);
			closeStream(bufrError);

			// 销毁子进程
			if (process != null) {
				process.destroy();
			}
		}

		// 返回执行结果
		return result.toString();
	}

	/**
	 * @Title: closeStream
	 * @Description: 关闭流
	 * @param stream
	 * @author weijian
	 * @date 2019-08-21 12:06:20
	 */
	public static void closeStream(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (Exception e) {
				// nothing
			}
		}
	}

	/**
	 * @Title: excutCommand
	 * @Description: 执行命令
	 * @param command
	 * @author weijian
	 * @date 2019-08-21 11:38:25
	 */
	public static void executeCommand(String command) {
		Thread putCommandThread = new Thread(new PutCommand(command));
		Thread takeCommandThread = new Thread(new TakeCommand());

		putCommandThread.start();
		takeCommandThread.start();
	}

	/**
	 * @Title: createTask0asm
	 * @Description: 生成task0.asm
	 * @param @param filePath
	 * @return void
	 * @author weijain
	 * @date 2019年7月13日
	 */
	public static void createTask0asm(String filePath) {

		File dir = new File(TenonCommandString.FILE);
		String cmdString = null;

		cmdString = TenonCommandString.TVMTASK + " " + filePath;
		CommandUtils.execCmd(cmdString, dir);
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
	public static String callbackCommand(Process tvm, String command) {

		MessageConsoleStream printer = ConsoleFactory.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);
		printer.println(command);
		StringBuilder result = new StringBuilder();
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
				result.append(line).append('\n');
			}
			InputStream isE = tvm.getErrorStream();
			InputStreamReader isrE = null;
			isrE = new InputStreamReader(isE, "UTF-8");
			BufferedReader err = new BufferedReader(isrE);
			String lineE = null;
			while ((lineE = err.readLine()) != null) {
				printer.println(lineE + "\n");
				result.append(line).append('\n');
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result.toString();
	}

	/**
	 * @Title: judgeTvmWhetherOpen
	 * @Description: 判断Tvm模式是否开启
	 * @return
	 * @author weijian
	 * @date 2019-08-20 09:21:24
	 */
	@SuppressWarnings("static-access")
	public static boolean judgeTvmWhetherOpen() {
		if (OpenTvmMode.getTvmThread().tvmThreadPocess == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @Title: ableSelected
	 * @Description: 将选中断点开启或关闭
	 * @param breakpointCountsList
	 * @param disableOREnable
	 * @author weijian
	 * @date 2019-08-21 06:57:08
	 */
	public static void ableSelected(ArrayList<Integer> breakpointCountsList, Boolean disableOREnable) {
		for (int num = breakpointCountsList.size() - 1; num >= 0; num--) {
			ableOne(breakpointCountsList.get(num), disableOREnable);
			try {
				Thread.currentThread();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @Title: deleteSelected
	 * @Description: 删除所选断点
	 * @param breakpointCountsList
	 * @author weijian
	 * @date 2019-08-21 03:53:06
	 */
	public static void deleteSelected(ArrayList<Integer> breakpointCountsList) {
		Collections.sort(breakpointCountsList);
		for (int num = breakpointCountsList.size() - 1; num >= 0; num--) {
			CommandUtils.deleteOne(breakpointCountsList.get(num));
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @Title: deleteAll
	 * @Description: 删除所有断点
	 * @author weijian
	 * @date 2019-08-08 11:09:54
	 */
	public static void deleteAll() {
		MessageConsoleStream printer = ConsoleFactory.getConsole().newMessageStream();
		printer.setActivateOnWrite(true);
		DebugBreakpointList bpList = ViewUtils.getBreakpointList();
		int length = bpList.getDebugBreakpoints().size();
		printer.println("A total of " + String.valueOf(length) + " breakpoints need to be deleted.");
		for (int count = length - 1; count >= 0; count--) {
			printer.println("The serial number of the breakpoint to be deleted is: " + count);
			deleteOne(count);
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @Title: ableOne
	 * @Description: 关闭或开启某断点
	 * @param count
	 * @param disableOREnable
	 * @author weijian
	 * @date 2019-08-21 06:53:06
	 */
	public static void ableOne(int count, Boolean disableOREnable) {
		if (disableOREnable) {
			executeCommand(TenonCommandString.ENABLE + " " + count);
		} else {
			executeCommand(TenonCommandString.DISABLE + " " + count);
		}
	}

	/**
	 * @Title: deleteOne
	 * @Description: 删除某个断点
	 * @param count
	 * @author weijian
	 * @date 2019-08-10 06:08:47
	 */
	public static void deleteOne(int count) {
		executeCommand(TenonCommandString.DELETE + " " + count);
	}

	/**
	 * @Title: setBreakpointContions
	 * @Description: 设置断点
	 * @param fileName
	 * @param lineNum
	 * @author weijian
	 * @date 2019-08-14 09:15:03
	 */
	public static void setBreakpoint(String fileName, int lineNum) {
		String breakpointCommand = TenonCommandString.BREAKPOINT + " " + DoDebug.fileName + ":" + lineNum;
		CommandUtils.executeCommand(breakpointCommand);
	}

	/**
	 * @Title: judgeAlreadyBreakpoint
	 * @Description: 判断该处是否已有断点
	 * @param fileName
	 * @param lineNum
	 * @return
	 * @author weijian
	 * @date 2019-08-21 12:36:53
	 */
	public static Boolean judgeAlreadyBreakpoint(String fileName, int lineNum) {
		if (fileWhetherDebugFile(fileName) && (!judgeLineWhetherExists(lineNum)) && judgeTvmWhetherOpen()) {
			return false;
		}
		return true;
	}

	/**
	 * @Title: doubleClickSetBreakpoint
	 * @Description: 双击设置断点，如果已存在则删除
	 * @param fileName
	 * @param lineNum
	 * @author weijian
	 * @date 2019-08-18 10:09:16
	 */
	public static void doubleClickSetBreakpoint(String fileName, int lineNum) {

		if (judgeLineWhetherExists(lineNum)) {
			DebugBreakpointList bpList = ViewUtils.getBreakpointList();
			DebugBreakpointList bpListTemp = new DebugBreakpointList();
			DebugBreakpointList.reduceBreakpointCounts();
			for (DebugBreakpoint bp : bpList.getDebugBreakpoints()) {
				if (bp.getLineNumber() == lineNum) {
					int count = bp.getCounts();
					deleteOne(count);
				} else {
					bpListTemp.add(bp);
				}
			}

			int breakpontSize = bpListTemp.getDebugBreakpoints().size();
			int tempCount = 0;
			for (DebugBreakpoint bp : bpListTemp.getDebugBreakpoints()) {
				if (tempCount < breakpontSize) {
					bp.setCounts(tempCount);
					tempCount++;
				}
			}
			DebugBreakpointList.setBreakpointCounts(tempCount);
			ViewUtils.updateBreakpointListView(bpListTemp);
		} else if (!judgeLineWhetherExists(lineNum)) {
			String breakpointCommand = TenonCommandString.BREAKPOINT + " " + DoDebug.fileName + ":" + lineNum;
			CommandUtils.executeCommand(breakpointCommand);
			CommandUtils.makeBreakpointShowView(lineNum);
		}

	}

	/**
	 * @Title: judgeLineWhetherExists
	 * @Description: 判断该行是否已设置断点
	 * @param @param lineNumber
	 * @return boolean
	 * @author weijain
	 * @date 2019年7月30日
	 */
	public static boolean judgeLineWhetherExists(int lineNumber) {
		DebugBreakpointList bpList = ViewUtils.getBreakpointList();
		for (DebugBreakpoint bp : bpList.getDebugBreakpoints()) {
			if (lineNumber == bp.getLineNumber())
				return true;
		}
		return false;
	}

	/**
	 * @Title: fileWhetherDebugFile
	 * @Description: 判断当前文件是否为开启tvm模式的文件
	 * @param fileName
	 * @return
	 * @author weijian
	 * @date 2019-08-14 09:04:55
	 */
	public static boolean fileWhetherDebugFile(String fileName) {
		if (fileName.equals(DoDebug.fileName)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Title: makeBreakpointShowView
	 * @Description: 將信息传入到breakpoint视图中显示
	 * @param @param breakpointString
	 * @return void
	 * @author weijain
	 * @date 2019年7月26日
	 */
	public static void makeBreakpointShowView(int breakpointLine) {
		DebugBreakpoint dBreakpoint = new DebugBreakpoint();
		dBreakpoint.setLineNumber(breakpointLine);
		dBreakpoint.setCounts(DebugBreakpointList.getBreakpointCounts());
		DebugBreakpointList bpList = ViewUtils.getBreakpointList();
		bpList.add(dBreakpoint);
		ViewUtils.updateBreakpointListView(bpList);
	}

	/**
	 * @Title: getLine
	 * @Description: 获取光标所在行的行号;获取选中文本的结束行号
	 * @param event
	 * @return 行号
	 * @author weijain
	 * @date 2019年7月27日
	 */
	public static int getLine(ExecutionEvent event) {
		int line = 0;
		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
		if (editorPart instanceof ITextEditor) {
			ITextEditor tesEditor = (ITextEditor) editorPart;
			org.eclipse.jface.text.TextSelection selection = (TextSelection) tesEditor.getSelectionProvider()
					.getSelection();
			line = selection.getEndLine() + 1;
		}
		return line;
	}

	/**
	 * @Title: returnCounts
	 * @Description: 返回选中断点的计数
	 * @param element
	 * @return
	 * @author weijian
	 * @date 2019-08-21 06:29:55
	 */
	public static int returnCounts(Object element) {
		DebugBreakpoint bp = (DebugBreakpoint) element;
		return bp.getCounts();
	}

}