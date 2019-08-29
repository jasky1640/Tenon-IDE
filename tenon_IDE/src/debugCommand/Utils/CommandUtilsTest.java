package debugCommand.Utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import debugCommand.DoDebug;
import debugCommand.OpenTvmMode;
import debugview.breakpointview.DebugBreakpoint;

/**
 * @ClassName: CommandUtilsTest
 * @Description: 调试命令常用方法单元测试
 * @author weijian
 * @date 2019-08-21 10:11:13
 */
@DisplayName("调试命令常用方法单元测试")
class CommandUtilsTest {

	File dir;

	/**
	 * @Title: setUpBeforeClass
	 * @Description: 测试前执行，只执行一次
	 * @throws java.lang.Exception
	 * @author weijian
	 * @date 2019-08-21 10:11:13
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @Title: setUp
	 * @Description: 每个测试方法运行前都执行一次
	 * @throws java.lang.Exception
	 * @author weijian
	 * @date 2019-08-21 10:11:13
	 */
	@BeforeEach
	void setUp() throws Exception {
		dir = new File("/tmp");
	}

	/**
	 * @Title: tearDown
	 * @Description: 每个测试方法运行后都执行一次
	 * @throws java.lang.Exception
	 * @author weijian
	 * @date 2019-08-21 10:11:13
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#execCmd(java.lang.String, java.io.File)}.
	 */
	@Test
	@DisplayName("向终端传入命令")
	void testExecCmd() {
		String isnullResultString = CommandUtils.execCmd(null, null);
		Boolean isnullResultBoolean = false;
		Boolean nullExpect = true;
		if (isnullResultString == null || isnullResultString.length() <= 0) {
			isnullResultBoolean = true;
		}

		String notnullResultString = CommandUtils.execCmd("echo hello", null);
		String notnullExpectString = "hello\n";
		Boolean notnullResultBoolean = false;
		Boolean notnullExpect = true;
		if (notnullResultString.equals(notnullExpectString)) {
			notnullResultBoolean = true;
		}
		Boolean result = false;
		Boolean expect = true;
		if (isnullResultBoolean == nullExpect && notnullResultBoolean == notnullExpect) {
			result = true;
		}
		assertEquals(expect, result);
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#closeStream(java.io.Closeable)}.
	 * Note:Need to place a hello.t in /tmp
	 */
	@Test
	@DisplayName("关闭流")
	void testCloseStream() {
		// Actual value:The initial value is false.If the target is active before the
		// function being tested, the value is true.
		Boolean closeBeforeResult = false;
		// Actual value:The initial value is true.If the target is active after the
		// function being tested, the value is false.
		Boolean closeAfterResult = true;

		File file = new File("/tmp/helloWorld.t");
		// Create if the target file does not exist.
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Actual value:If the target is active before the function being tested, the
				// value is true.
				closeBeforeResult = fos.getFD().valid();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CommandUtils.closeStream(fos);
			try {
				// Actual value:If the target is active after the function being tested, the
				// value is false.
				closeAfterResult = fos.getFD().valid();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Expected value:The target should be open before executing the function being
		// tested.
		Boolean closeBeforeExpect = true;
		// Expected value:The target should be closed after executing the function being
		// tested.
		Boolean closeAfterExpect = false;

		// The value is true if (closeBeforeExpect == closeBeforeResult &&
		// closeAfterExpect == closeAfterResult),otherwise the value is false.
		Boolean result = false;
		// result should be true.((closeBeforeExpect == closeBeforeResult &&
		// closeAfterExpect == closeAfterResult)=true.)
		Boolean expect = true;
		if (closeBeforeExpect == closeBeforeResult && closeAfterExpect == closeAfterResult) {
			result = true;
		}
		assertEquals(expect, result);
	}

	/**
	 * Test put command.
	 */
	@Test
	@DisplayName("放入命令")
	void testPutCommand() {
		Thread putCommandThread = new Thread(new PutCommand("Test put and take command"));
		putCommandThread.start();
		String commString = null;
		try {
			commString = (String) ShareQueue.sharedQueue.take();
			ShareQueue.sharedQueue.clear();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = false;
		if (commString.equals("Test put and take command")) {
			result = true;
		}
		Boolean expect = true;
		assertEquals(expect, result);
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#createTask0asm(java.lang.String)}.
	 * Note:Need to place a hello.t in /tmp
	 */
	@Test
//	@Disabled
	void testCreateTask0asm() {
		CommandUtils.execCmd("rm task0.asm", dir);

		CommandUtils.createTask0asm("/tmp/hello.t");
		String resultString = CommandUtils.execCmd("ls", dir);

		Boolean result = false;
		Boolean expect = true;
		if (resultString.indexOf("task0.asm") != -1) {
			result = true;
		}
		assertEquals(expect, result);
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#callbackCommand(java.lang.Process, java.lang.String)}.
	 */
	@Test
	@Disabled
	void testCallBackCommand() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#judgeTvmWhetherOpen()}.
	 */
	@Test
	@DisplayName("判断tvm模式是否开启")
	void testJudgeTvmWhetherOpen() {
		Boolean isNullResult = CommandUtils.judgeTvmWhetherOpen();
		Boolean isNullExpect = false;

		ProcessBuilder pb = new ProcessBuilder();
		String command = "ls";
		pb.directory(dir);
		pb.command(command.split(" "));
		try {
			OpenTvmMode.tvmThreadPocess = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean notNullResult = CommandUtils.judgeTvmWhetherOpen();
		Boolean notNullExpect = true;

		Boolean result = false;
		Boolean expect = true;
		if (isNullExpect == isNullResult && notNullExpect == notNullResult) {
			result = true;
		}
		assertEquals(expect, result);
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#ableSelected(java.util.ArrayList, java.lang.Boolean)}.
	 */
	@Test
	@Disabled
	void testAbleSelected() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#deleteSelected(java.util.ArrayList)}.
	 */
	@Test
	@Disabled
	void testDeleteSelected() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link debugCommand.Utils.CommandUtils#deleteAll()}.
	 */
	@Test
	@Disabled
	void testDeleteAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#ableOne(int, java.lang.Boolean)}.
	 */
	@Test
	@Disabled
	void testAbleOne() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link debugCommand.Utils.CommandUtils#deleteOne(int)}.
	 */
	@Test
	@Disabled
	void testDeleteOne() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#setBreakpoint(java.lang.String, int)}.
	 */
	@Test
	@Disabled
	void testSetBreakpoint() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#judgeAlreadyBreakpoint(java.lang.String, int)}.
	 */
	@Test
	@Disabled
	void testJudgeAlreadyBreakpoint() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#doubleClickSetBreakpoint(java.lang.String, int)}.
	 */
	@Test
	@Disabled
	void testDoubleClickSetBreakpoint() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#judgeLineWhetherExists(int)}.
	 */
	@Test
	@Disabled
	void testJudgeLineWhetherExists() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#fileWhetherDebugFile(java.lang.String)}.
	 */
	@Test
	@DisplayName("判断文件是否为开启tvm模式的文件")
	void testFileWhetherDebugFile() {
		DoDebug.fileName = "hello.t";
		Boolean isResult = CommandUtils.fileWhetherDebugFile("hello.t");
		Boolean isExpect = true;

		Boolean notResult = CommandUtils.fileWhetherDebugFile("helloWorld.t");
		Boolean notExpect = false;

		Boolean result = false;
		Boolean expect = true;
		if (isExpect == isResult && notExpect == notResult) {
			result = true;
		}
		assertEquals(expect, result);
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#makeBreakpointShowView(int)}.
	 */
	@Test
	@Disabled
	void testMakeBreakpointShowView() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#getLine(org.eclipse.core.commands.ExecutionEvent)}.
	 */
	@Test
	@Disabled
	void testGetLine() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugCommand.Utils.CommandUtils#returnCounts(java.lang.Object)}.
	 */
	@Test
	@DisplayName("获取某断点的计数")
	void testReturnCounts() {
		DebugBreakpoint bp = new DebugBreakpoint();
		bp.setCounts(1);
		int result = CommandUtils.returnCounts(bp);
		int expect = 1;
		assertEquals(expect, result);
	}

}
