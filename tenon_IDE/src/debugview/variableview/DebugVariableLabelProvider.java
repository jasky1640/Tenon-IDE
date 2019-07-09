package debugview.variableview;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * This class provides the labels for the debug variable table
 */
public class DebugVariableLabelProvider implements ITableLabelProvider{
	
	/**
	* Returns the column text
	* @param element the input DebugVariable for this column
	* @param columnIndex the column index. Column 0 is COLUMN_VARIABLE, Column 1 is COLUMN_VALUE
	* @return String the column text: variable or value
	*/	
	@Override
	public String getColumnText(Object element, int columnIndex) {
		DebugVariable debugVar = (DebugVariable) element;
		switch (columnIndex) {
			case DebugVariableConst.COLUMN_VARIABLE:
				return debugVar.getVariable();
			case DebugVariableConst.COLUMN_VALUE:
				return debugVar.getValue();
		}
		return null;
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

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}
}
