package debugview.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class NextAction extends Action implements IWorkbenchAction{
    
    public NextAction(){
    }
    
    public void run() {
    	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    	String dialogBoxTitle = "Next";
    	String message = "You clicked next button!";
    	MessageDialog.openInformation(shell, dialogBoxTitle, message);
    }
    
    @Override
    public void dispose() {
    	// TODO Auto-generated method stub  	
    }
}