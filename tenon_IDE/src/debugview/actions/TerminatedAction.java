package debugview.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class TerminatedAction extends Action implements IWorkbenchAction{
    
    public TerminatedAction(){
    }
    
    public void run() {
    	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    	String dialogBoxTitle = "Terminated";
    	String message = "You clicked terminated button!";
    	MessageDialog.openInformation(shell, dialogBoxTitle, message);
    }
    
    @Override
    public void dispose() {
    	// TODO Auto-generated method stub  	
    }
}