package tool;

import org.eclipse.ui.PlatformUI;

import debugCommand.constant.TenonCommandString;

/**
 * @ClassName: ToolUtils
 * @Description: 公共方法
 * @author weijian
 * @date 2019-08-21 11:50:10
 */
public class ToolUtils {

	/**
	 * @Title: fileIfT
	 * @Description: 判断是否为*.t文件
	 * @param fileName
	 * @return
	 * @author weijian
	 * @date 2019-08-21 05:41:17
	 */
	public static boolean fileIfT(String fileName) {
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (suffix.equals(TenonCommandString.SUFFIX)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Title: getFilePath
	 * @Description: 获取文件绝对路径
	 * @return
	 * @author weijian
	 * @date 2019-08-21 11:58:30
	 */
	public static String getFilePath() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput()
				.getToolTipText();
	}

	/**
	 * @Title: getFileName
	 * @Description: 根据文件路径获取文件名
	 * @param filePath
	 * @return
	 * @author weijian
	 * @date 2019-08-21 12:15:16
	 */
	public static String getFileName(String filePath) {
		return filePath.substring(filePath.lastIndexOf("/") + 1);
	}
}
