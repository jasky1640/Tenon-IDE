package debugview.variableview;

/**
 * This class represents a pair of variable and value for debugging
 */
public class DebugVariable {

	private String variable;
	private String value;
	
	public DebugVariable(String variable, String value) {
		this.setVariable(variable);
		this.setValue(value);
	}
	
	public String getVariable() {
		return this.variable;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setVariable(String variable) {
		this.variable = variable;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
