package tool;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

/**
 * @ClassName: ToolUtilsTest
 * @Description: 公共方法单元测试
 * @author weijian
 * @date 2019-08-21 10:18:05
 */
@DisplayName("公共方法单元测试")
public class ToolUtilsTest {

	/**
	 * @Title: setUpBeforeClass
	 * @Description: 测试前执行，只执行一次
	 * @throws java.lang.Exception
	 * @author weijian
	 * @date 2019-08-21 10:18:05
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @Title: setUp
	 * @Description: 每个测试方法运行前都执行一次
	 * @throws java.lang.Exception
	 * @author weijian
	 * @date 2019-08-21 10:18:05
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @Title: tearDown
	 * @Description: 每个测试方法运行后都执行一次
	 * @throws java.lang.Exception
	 * @author weijian
	 * @date 2019-08-21 10:18:05
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link tool.ToolUtils#fileIfT(java.lang.String)}.
	 */
	@Test
	@DisplayName("判断文件后缀是否为*.t")
	void testFileIfT() {
		Boolean isTExpect = true;
		Boolean isTResult = ToolUtils.fileIfT("hello.t");
		
		Boolean notTExpect = false;
		Boolean notTResult = ToolUtils.fileIfT("hello.java");
		
		Boolean expect = true;
		Boolean result = false;
		if (isTExpect == isTResult && notTExpect == notTResult) {
			result = true;
		}
		assertEquals(expect, result);
	}

	/**
	 * Test method for {@link tool.ToolUtils#getFilePath()}.
	 */
	@Test
	@Disabled
	@DisplayName("获取文件绝对路径")
	void testGetFilePath() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link tool.ToolUtils#getFileName(java.lang.String)}.
	 */
	@Test
	@DisplayName("根据绝对路径获取文件名")
	void testGetFileName() {
		String expect = "hello.t";
		String result = ToolUtils.getFileName("/home/weijian/hello.t");
		assertEquals(expect, result);
	}

}
