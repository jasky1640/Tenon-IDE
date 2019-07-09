package debugview.variableview;

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * This class provides the content for the debug variable table
 */
public class DebugVariableContentProvider implements IStructuredContentProvider{
	
	/**
	* Gets the elements for the table in the form of Object array
	* @param inputElement The DebugVariableList that contains all pairs of debugging variable and value
	* @return Object[] All pairs of debugging variable and value as Object array
	*/	
	public Object[] getElements (Object inputElement) {
		//return all pairs of debugging variable and value as Object array
		return ((DebugVariableList)inputElement).getDebugVariables().toArray();
	}
}
