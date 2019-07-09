package debugview.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class RunAction extends Action implements IWorkbenchAction{
    
    public RunAction(){
    }
    
    public void run() {
    	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    	String dialogBoxTitle = "Run";
    	String message = "You clicked run button!";
    	MessageDialog.openInformation(shell, dialogBoxTitle, message);
    }
    
    @Override
    public void dispose() {
    	// TODO Auto-generated method stub  	
    }
}