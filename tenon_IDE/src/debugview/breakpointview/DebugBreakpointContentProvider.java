package debugview.breakpointview;

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * This class provides the content for the debug breakpoint table
 */
public class DebugBreakpointContentProvider implements IStructuredContentProvider {

	/**
	* Gets the elements for the table in the form of Object array
	* @param inputElement The DebugBreakpointList that contains all debugging breakpoint
	* @return Object[] All debugging breakpoints as Object array
	*/		
	@Override
	public Object[] getElements(Object inputElement) {
		//return all debugging breakpoints as Object array
		return ((DebugBreakpointList)inputElement).getDebugBreakpoints().toArray();
	}

}
