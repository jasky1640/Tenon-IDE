package debugview.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import debugview.breakpointview.DebugBreakpoint;
import debugview.breakpointview.DebugBreakpointList;

/**
 * @ClassName: ViewUtilsTest
 * @Description: 视图常用方法单元测试
 * @author weijian
 * @date 2019-08-21 10:17:37
 */
@DisplayName("视图常用方法单元测试")
class ViewUtilsTest {

	/**
	 * @Title: setUpBeforeClass
	 * @Description: 测试前执行，只执行一次
	 * @throws java.lang.Exception
	 * @author weijian
	 * @date 2019-08-21 10:17:37
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @Title: setUp
	 * @Description: 每个测试方法运行前都执行一次
	 * @throws java.lang.Exception
	 * @author weijian
	 * @date 2019-08-21 10:17:37
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @Title: tearDown
	 * @Description: 每个测试方法运行后都执行一次
	 * @throws java.lang.Exception
	 * @author weijian
	 * @date 2019-08-21 10:17:37
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link debugview.utils.ViewUtils#ableALL(debugview.breakpointview.DebugBreakpointList, boolean)}.
	 */
	@Test
	@DisplayName("使所有断点开启或者关闭")
	void testAbleALL() {
		DebugBreakpointList bpList = new DebugBreakpointList();
		for (int i = 0; i < 4; i++) {
			DebugBreakpoint dBreakpoint = new DebugBreakpoint();
			dBreakpoint.setLineNumber(i + 1);
			dBreakpoint.setCounts(i);
			bpList.add(dBreakpoint);
		}
		bpList = ViewUtils.ableALL(bpList, false);
		Boolean setFalseresult = true;
		Boolean setFslseexpect = false;
		for (DebugBreakpoint dp : bpList.getDebugBreakpoints()) {
			if (dp.isEnabled()) {
				setFalseresult = true;
				break;
			} else {
				setFalseresult = false;
			}
		}

		bpList = ViewUtils.ableALL(bpList, true);
		Boolean setTrueresult = false;
		Boolean setTrueexpect = true;
		for (DebugBreakpoint dp : bpList.getDebugBreakpoints()) {
			if (!dp.isEnabled()) {
				setTrueresult = false;
				break;
			} else {
				setTrueresult = true;
			}
		}
		Boolean expect = false;
		Boolean result = true;
		if (setFalseresult == setFslseexpect && setTrueresult == setTrueexpect) {
			expect = true;
		}
		assertEquals(expect, result);

	}

	/**
	 * Test method for
	 * {@link debugview.utils.ViewUtils#ableSelectedUI(java.util.ArrayList, java.lang.Boolean)}.
	 */
	@Test
	@Disabled
	void testAbleSelectedUI() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugview.utils.ViewUtils#deleteSelectedUI(java.util.ArrayList)}.
	 */
	@Test
	@Disabled
	void testDeleteSelectedUI() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link debugview.utils.ViewUtils#clearDBList()}.
	 */
	@Test
	@Disabled
	void testClearDBList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link debugview.utils.ViewUtils#getBreakpointList()}.
	 */
	@Test
	@Disabled
	void testGetBreakpointList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugview.utils.ViewUtils#makeBreakpointShowView(int)}.
	 */
	@Test
	@Disabled
	void testMakeBreakpointShowView() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugview.utils.ViewUtils#updateBreakpointListView(debugview.breakpointview.DebugBreakpointList)}.
	 */
	@Test
	@Disabled
	void testUpdateBreakpointListView() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link debugview.utils.ViewUtils#closeOropenView(java.lang.String, boolean)}.
	 */
	@Test
	@Disabled
	void testCloseOropenView() {
		fail("Not yet implemented");
	}

}
