package debugview.breakpointview;

import org.eclipse.ui.part.ViewPart;

import debugview.actions.NextAction;
import debugview.actions.RunAction;
import debugview.actions.TerminatedAction;
import debugview.utils.Activator;
import debugview.utils.DebugViewMessages;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;

//Reserved for Click listener
//import org.eclipse.jface.viewers.ICheckStateListener;
//import org.eclipse.jface.viewers.CheckStateChangedEvent;

public class DebugBreakpointView extends ViewPart{

	private CheckboxTableViewer viewer;

	public DebugBreakpointView() {
		super();
	}

	/**
	* Creates the main window's contents
	* @param parent The main window
	*/
	public void createPartControl (Composite parent) {
		//Create viewer
		GridData gridData = new GridData (SWT.FILL, SWT.FILL, true, true, 1, 1);		
		viewer = CheckboxTableViewer.newCheckList(parent, SWT.BORDER | SWT.CHECK | SWT.MULTI | SWT.FULL_SELECTION);
		viewer.getTable().setLayoutData(gridData);
		viewer.setContentProvider(new DebugBreakpointContentProvider());
		viewer.setLabelProvider(new DebugBreakpointLabelProvider());

		//Add run button
		RunAction runAction = new RunAction();
		runAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Run);
		runAction.setImageDescriptor(Activator.getImageDescriptor("icons/run.png")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(runAction);
		
		//Add next button
		NextAction nextAction = new NextAction();
		nextAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Next);
		nextAction.setImageDescriptor(Activator.getImageDescriptor("icons/next.png")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(nextAction);
		
		//Add terminated button to quit Tvm mode
		TerminatedAction terminatedAction = new TerminatedAction();
		terminatedAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Quit_Tvm_Mode);
		terminatedAction.setImageDescriptor(Activator.getImageDescriptor("icons/quit.png")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(terminatedAction);
		
		/*
		viewer.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
			}

		});
		*/
		
		//Fill in the table, For test purpose
		DebugBreakpointList testList = new DebugBreakpointList();
		DebugBreakpoint test1 = new DebugBreakpoint("[Line 5] - main"); //$NON-NLS-1$
		DebugBreakpoint test2 = new DebugBreakpoint("[Line 11] - main"); //$NON-NLS-1$
		testList.add(test1);
		testList.add(test2);
		
		this.update(testList);
		
		//Pack the columns
		Table table = viewer.getTable();
	    for (int i = 0, n = table.getColumnCount(); i < n; i++) {
	        table.getColumn(i).pack();
	    }
	}

	/**
	* Updates the application with the input debugVariableList
	* @param debugVariableList The input DebugVariableList instance containing DebugVariable list
	*/
	public void update(DebugBreakpointList debugBreakpointList) {
		viewer.setInput(debugBreakpointList);
		viewer.refresh();
	}
	
	public CheckboxTableViewer getViewer() {
		return this.viewer;
	}
	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}
}