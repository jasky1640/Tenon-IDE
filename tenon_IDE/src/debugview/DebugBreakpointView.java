package debugview;

import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.*;

public class DebugBreakpointView extends ViewPart{
	private Label label;
	public DebugBreakpointView() {
		super();
	}
	public void setFocus() {
		label.setFocus();
	}
	public void createPartControl (Composite parent) {
		label = new Label(parent, 0);
		label.setText("Fine");
	}
}
