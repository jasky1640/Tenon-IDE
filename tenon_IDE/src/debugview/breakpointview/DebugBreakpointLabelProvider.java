package debugview.breakpointview;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import debugview.utils.Activator;

/**
 * This class provides the labels for the debug breakpoint table
 */
public class DebugBreakpointLabelProvider implements ITableLabelProvider {

	private static final int COLUMN_BREAKPOINT = 0;
	/**
	* Returns the column text
	* @param element the input DebugBreakpoint for this column
	* @param columnIndex the column index. Column 0 is COLUMN_BREAKPOINT
	* @return String the column text: breakpoint information
	*/	
	@Override
	public String getColumnText(Object element, int columnIndex) {
		DebugBreakpoint debugBreakpoint = (DebugBreakpoint) element;
		if (columnIndex == COLUMN_BREAKPOINT) {
			return debugBreakpoint.getInfo();
		}
		return null;
	}
	
	/**
	* Returns the image that describes the column
	* @param element the input DebugBreakpoint for this column
	* @param columnIndex the column index. Column 0 is COLUMN_BREAKPOINT
	* @return Image the image that describes the column
	*/	
	@Override
	public Image getColumnImage(Object element, int columnIndex) {	
		if (columnIndex == COLUMN_BREAKPOINT) {
			return Activator.getImageDescriptor("icons/coffeebreak.png").createImage();
		}
		return null;	
	}
	
	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
	}
}
