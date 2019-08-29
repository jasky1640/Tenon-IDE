package debugview.utils;

import java.util.Locale;

import org.eclipse.osgi.util.NLS;

/*
 * This class is designed for I18N
 */
public class DebugViewMessages extends NLS {
	
	private static final String BUNDLE_NAME_CN = "debugview.utils.debugviewmessages_cn"; //Chinese language package name 
	private static final String BUNDLE_NAME_EN = "debugview.utils.debugviewmessages_en"; //English language package name
	
	private static final String ISO3_SIMPLIFIED_CHINESE = "zho";  //ISO639-2 code for simplified Chinese
	private static final String ISO3_TRADITIONAL_CHINESE = "chi"; //ISO639-2 code for traditional Chinese
	
	//Strings in DebugBreakpointView class
	public static String DebugBreakpointView_Next;          
	public static String DebugBreakpointView_Quit_Tvm_Mode; 
	public static String DebugBreakpointView_Run;
	public static String DebugBreakpointView_Backtrace;
	public static String DebugBreakpointView_Continue;
	public static String DebugBreakpointView_Step;
	public static String DebugBreakpointView_Stepi;
	public static String DebugBreakpointView_EnableSelected;
	public static String DebugBreakpointView_EnableAll;
	public static String DebugBreakpointView_DisableSelected;
	public static String DebugBreakpointView_DisableAll;
	public static String DebugBreakpointView_DeleteAll;
	public static String DebugBreakpointView_DeleteSelected;
	public static String DebugBreakpointView_Start_Tvm_Mode;
	
	//Strings in DebugVariableView class
	public static String DebugVariableView_Variable;
	public static String DebugVariableView_Value;
	
	private static String BUNDLE_NAME; //name of selected language package based on OS setting
	
	// initialize resource bundle
	static {
		String ISO3Language = Locale.getDefault().getISO3Language();
		
		if (ISO3Language.equals(DebugViewMessages.ISO3_SIMPLIFIED_CHINESE)) {
			BUNDLE_NAME = DebugViewMessages.BUNDLE_NAME_CN;
		}
		
		else if (ISO3Language.equals(DebugViewMessages.ISO3_TRADITIONAL_CHINESE)) {
			BUNDLE_NAME = DebugViewMessages.BUNDLE_NAME_CN;
		}

		else {
			BUNDLE_NAME = DebugViewMessages.BUNDLE_NAME_EN;
		}
			
		NLS.initializeMessages(BUNDLE_NAME, DebugViewMessages.class);
	}

	private DebugViewMessages() {
	}
}
