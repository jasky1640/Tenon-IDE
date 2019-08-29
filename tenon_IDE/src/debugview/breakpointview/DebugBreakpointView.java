package debugview.breakpointview;

import java.util.ArrayList;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.part.ViewPart;

import debugCommand.*;
import debugCommand.Utils.CommandUtils;
import debugview.utils.*;

public class DebugBreakpointView extends ViewPart {

	public static CheckboxTableViewer viewer;

	public DebugBreakpointView() {
		super();
	}

	// Nested class for OpenTvm Action
	private class StartAction extends Action implements IWorkbenchAction {

		private StartAction() {
		}

		public void run() {
			DoDebug.DoDebugUI();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Backtrace Action
	private class BacktraceAction extends Action implements IWorkbenchAction {

		private BacktraceAction() {
		}

		public void run() {
			BacktraceT.backtraceUI();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Continue Action
	private class ContinueAction extends Action implements IWorkbenchAction {

		private ContinueAction() {
		}

		public void run() {
			ContinueT.continueUI();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Step Action
	private class StepAction extends Action implements IWorkbenchAction {

		private StepAction() {
		}

		public void run() {
			StepT.stepUI();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Stepi Action
	private class StepiAction extends Action implements IWorkbenchAction {

		private StepiAction() {
		}

		public void run() {
			StepiT.stepiUI();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Next Action
	private class NextAction extends Action implements IWorkbenchAction {

		private NextAction() {
		}

		public void run() {
			NextT.nextUI();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Run Action
	private class RunAction extends Action implements IWorkbenchAction {

		private RunAction() {
		}

		public void run() {
			RunT.runUI();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Enable Selected Breakpoint Action
	private class EnableSelectedAction extends Action implements IWorkbenchAction {

		private EnableSelectedAction() {
		}

		public void run() {
			ArrayList<Integer> breakpointCountsList = new ArrayList<Integer>();
			for (Object element : getViewer().getCheckedElements()) {
				breakpointCountsList.add(CommandUtils.returnCounts(element));
			}
			EnableT.enableSelected(breakpointCountsList);
			DebugBreakpointList bpList = ViewUtils.getBreakpointList();
			ViewUtils.updateBreakpointListView(bpList);
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Enable All Breakpoint Action
	private class EnableAllAction extends Action implements IWorkbenchAction {

		private EnableAllAction() {
		}

		public void run() {
			EnableT.enableUI();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Disable Selected Breakpoint Action
	private class DisableSelectedAction extends Action implements IWorkbenchAction {

		private DisableSelectedAction() {
		}

		public void run() {
			ArrayList<Integer> breakpointCountsList = new ArrayList<Integer>();
			for (Object element : getViewer().getCheckedElements()) {
				breakpointCountsList.add(CommandUtils.returnCounts(element));

			}
			DisableT.disableSelectedUI(breakpointCountsList);
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Disable All Breakpoint Action
	private class DisableAllAction extends Action implements IWorkbenchAction {

		private DisableAllAction() {
		}

		public void run() {
			DisableT.disableUI();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Delete Selected Breakpoint Action
	private class DeleteSelectedAction extends Action implements IWorkbenchAction {

		private DeleteSelectedAction() {
		}

		public void run() {
			ArrayList<Integer> breakpointCountsList = new ArrayList<Integer>();
			for (Object element : getViewer().getCheckedElements()) {
				breakpointCountsList.add(CommandUtils.returnCounts(element));
			}
			DeleteT.deleteSelectedUI(breakpointCountsList);
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for Delete All Breakpoint Action
	private class DeleteAllAction extends Action implements IWorkbenchAction {

		private DeleteAllAction() {
		}

		public void run() {
			DeleteT.deleteUI();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	// Nested class for QuitTvm Action
	private class TerminatedAction extends Action implements IWorkbenchAction {

		private TerminatedAction() {
		}

		public void run() {
			QuitTvm.quitTvmUI();
			ViewUtils.clearDBList();
			DebugBreakpointList.clearBreakpointCounts();

		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	/**
	 * Creates the main window's contents
	 * 
	 * @param parent The main window
	 */
	public void createPartControl(Composite parent) {
		// Create viewer
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		viewer = CheckboxTableViewer.newCheckList(parent, SWT.BORDER | SWT.CHECK | SWT.MULTI | SWT.FULL_SELECTION);
		viewer.getTable().setLayoutData(gridData);
		viewer.setContentProvider(new DebugBreakpointContentProvider());
		viewer.setLabelProvider(new DebugBreakpointLabelProvider());

		// Create buttons
		this.createButtons();

		// Pack the columns
		Table table = viewer.getTable();
		for (int i = 0, n = table.getColumnCount(); i < n; i++) {
			table.getColumn(i).pack();
		}
	}

	/**
	 * Create buttons for initialization
	 */
	public void createButtons() {
		// Add start button to open Tvm mode
		StartAction startAction = new StartAction();
		startAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Start_Tvm_Mode);
		startAction.setImageDescriptor(Activator.getImageDescriptor("icons/start.png")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(startAction);

		// Add run button
		RunAction runAction = new RunAction();
		runAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Run);
		runAction.setImageDescriptor(Activator.getImageDescriptor("icons/run.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(runAction);

		// Add next button
		NextAction nextAction = new NextAction();
		nextAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Next);
		nextAction.setImageDescriptor(Activator.getImageDescriptor("icons/next.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(nextAction);

		// Add Step button
		StepAction stepAction = new StepAction();
		stepAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Step);
		stepAction.setImageDescriptor(Activator.getImageDescriptor("icons/step.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(stepAction);

		// Add Stepi button
		StepiAction stepiAction = new StepiAction();
		stepiAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Stepi);
		stepiAction.setImageDescriptor(Activator.getImageDescriptor("icons/stepi.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(stepiAction);

		// Add continue button
		ContinueAction continueAction = new ContinueAction();
		continueAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Continue);
		continueAction.setImageDescriptor(Activator.getImageDescriptor("icons/continue.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(continueAction);

		// Add backtrace button
		BacktraceAction backtraceAction = new BacktraceAction();
		backtraceAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Backtrace);
		backtraceAction.setImageDescriptor(Activator.getImageDescriptor("icons/backtrace.png")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(backtraceAction);

		// Add disableselected button
		DisableSelectedAction disableSelectedAction = new DisableSelectedAction();
		disableSelectedAction.setToolTipText(DebugViewMessages.DebugBreakpointView_DisableSelected);
		disableSelectedAction.setImageDescriptor(Activator.getImageDescriptor("icons/disableselected.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(disableSelectedAction);

		// Add disableAll button
		DisableAllAction disableAllAction = new DisableAllAction();
		disableAllAction.setToolTipText(DebugViewMessages.DebugBreakpointView_DisableAll);
		disableAllAction.setImageDescriptor(Activator.getImageDescriptor("icons/disableall.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(disableAllAction);

		// Add enableselected button
		EnableSelectedAction enableSelectedAction = new EnableSelectedAction();
		enableSelectedAction.setToolTipText(DebugViewMessages.DebugBreakpointView_EnableSelected);
		enableSelectedAction.setImageDescriptor(Activator.getImageDescriptor("icons/enableselected.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(enableSelectedAction);

		// Add enableAll button
		EnableAllAction enableAllAction = new EnableAllAction();
		enableAllAction.setToolTipText(DebugViewMessages.DebugBreakpointView_EnableAll);
		enableAllAction.setImageDescriptor(Activator.getImageDescriptor("icons/enableall.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(enableAllAction);

		// Add deleteselected button
		DeleteSelectedAction deleteSelectedAction = new DeleteSelectedAction();
		deleteSelectedAction.setToolTipText(DebugViewMessages.DebugBreakpointView_DeleteSelected);
		deleteSelectedAction.setImageDescriptor(Activator.getImageDescriptor("icons/deleteselected.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(deleteSelectedAction);

		// Add deleteAll button
		DeleteAllAction deleteAllAction = new DeleteAllAction();
		deleteAllAction.setToolTipText(DebugViewMessages.DebugBreakpointView_DeleteAll);
		deleteAllAction.setImageDescriptor(Activator.getImageDescriptor("icons/deleteall.gif")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(deleteAllAction);

		// Add terminated button to quit Tvm mode
		TerminatedAction terminatedAction = new TerminatedAction();
		terminatedAction.setToolTipText(DebugViewMessages.DebugBreakpointView_Quit_Tvm_Mode);
		terminatedAction.setImageDescriptor(Activator.getImageDescriptor("icons/quit.png")); //$NON-NLS-1$
		getViewSite().getActionBars().getToolBarManager().add(terminatedAction);
	}

	/**
	 * Updates the application with the input debugVariableList
	 * 
	 * @param debugVariableList The input DebugVariableList instance containing
	 *                          DebugVariable list
	 */
	public static void update(DebugBreakpointList debugBreakpointList) {
		viewer.setInput(debugBreakpointList);
		viewer.refresh();
	}

	public static CheckboxTableViewer getViewer() {
		return viewer;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}
}