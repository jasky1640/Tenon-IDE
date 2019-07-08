package debugview;

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * This class provides the content for the debug variable table
 */
public class DebugVariableContentProvider implements IStructuredContentProvider{
	
	/**
	* Gets the elements for the table in the form of Object array
	* @param obj The DebugVariableList that contains all pairs of debugging variable and value
	* @return Object[] All pairs of debugging variable and value as Object array
	*/	
	public Object[] getElements (Object obj) {
		//return all pairs of debugging variable and value as Object array
		return ((DebugVariableList)obj).getDebugVariables().toArray();
	}
}
