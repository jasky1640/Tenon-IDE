package debug.togglebreakpoints;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.ui.texteditor.AbstractRulerActionDelegate;
import org.eclipse.ui.texteditor.ITextEditor;

import debugCommand.Utils.MyMouseListener;

//implements IEditorActionDelegate
public class ManageBreakpointRulerActionDelegate extends AbstractRulerActionDelegate {

	private IVerticalRulerInfo frulerInfo = null;
	private ITextEditor feditor = null;

	@Override
	public void run(IAction action) {

	}

	@Override
	protected IAction createAction(ITextEditor editor, IVerticalRulerInfo rulerInfo) {

		this.feditor = editor;
		this.frulerInfo = rulerInfo;

		return null;
	}

	@Override
	public void menuAboutToShow(IMenuManager manager) {
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		int line = frulerInfo.getLineOfLastMouseButtonActivity() + 1;
		String fileName = feditor.getTitle();
		MyMouseListener myMouseListener = new MyMouseListener(fileName, line);
		myMouseListener.mouseClicked(e);

	}

	@Override
	public void mouseDown(MouseEvent e) {
	}

	@Override
	public void mouseUp(MouseEvent e) {
	}

}
