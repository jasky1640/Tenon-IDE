package debugview.variableview;

import org.eclipse.ui.part.ViewPart;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;

public class DebugVariableView extends ViewPart{
	
	private TableViewer viewer;
	
	public DebugVariableView() {
		super();
	}

	/**
	* Creates the main window's contents
	* @param parent The main window
	*/
	public void createPartControl (Composite parent) {
		//Create viewer
		viewer = new TableViewer(parent);
		viewer.setContentProvider(new DebugVariableContentProvider());
		viewer.setLabelProvider(new DebugVariableLabelProvider());
		
		//Setup the table
		Table table = viewer.getTable();	
		table.setLayoutData(new GridData (SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		//Add the variable column
		TableColumn column = new TableColumn(table,SWT.LEFT);
		column.setText("Variable");
		
		//Add the value column
		column = new TableColumn(table,SWT.LEFT);
		column.setText("Value");
		
		//Fill in the table, For test purpose
		DebugVariableList testList = new DebugVariableList();
		DebugVariable test1 = new DebugVariable("a","1");
		DebugVariable test2 = new DebugVariable("b","2");
		DebugVariable test3 = new DebugVariable("c","hello");
		DebugVariable test4 = new DebugVariable("d","hi");
		testList.add(test1);
		testList.add(test2);
		testList.add(test3);
		testList.add(test4);		

		this.update(testList);
		//Fill in the table, For test purpose
		
		//Pack the columns
	    for (int i = 0, n = table.getColumnCount(); i < n; i++) {
	        table.getColumn(i).pack();
	    }
	    
	    //Turn on the header
	    table.setHeaderVisible(true);
	    table.setHeaderBackground(new Color(Display.getCurrent(), new RGB(200, 200, 200)));
	}
	
	/**
	* Updates the application with the input debugVariableList
	* @param debugVariableList The input DebugVariableList instance containing DebugVariable list
	*/
	public void update(DebugVariableList debugVariableList) {
		viewer.setInput(debugVariableList);
		viewer.refresh();
	}
	
	public TableViewer getViewer() {
		return this.viewer;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}
}
