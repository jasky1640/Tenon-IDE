package debugCommand.constant;

public class TenonCommandString {

	/**
	 * 调式命令
	 */
	public static final String TVMSTART = "tvm -i task0.asm";

	public static final String TENON = "tenon -m base";

	public static final String TVMTASK = "tenonc -g -m base";

	public static final String BREAKPOINT = "breakpoint";

	public static final String NEXT = "next";

	public static final String STEP = "step";

	public static final String STEPI = "stepi";

	public static final String HELP = "help";

	public static final String HISTORY = "history";

	public static final String RUN = "run";

	public static final String BACKTRACE = "backtrace";

	public static final String CONTINUE = "continue";

	public static final String DELETE = "delete";

	public static final String DISABLE = "disable";

	public static final String ENABLE = "enable";

	public static final String SHOW = "show";

	public static final String TVMQUIT = "quit";

	/**
	 * 是与否
	 */
	public static final String YES = "y";

	public static final String NO = "n";

	/**
	 * 后台终端打开位置
	 */
	public static final String FILE = "/tmp";

	/**
	 * 文件后缀名
	 */
	public static final String SUFFIX = "t";

}
