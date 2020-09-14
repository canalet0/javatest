package enumeration;

public enum SubmissionStatus {
	CORRECT("C"),
	INCORRECT("I"),
	CLARIFICATION_REQUEST("R"),
	UNJUDGED("U"),
	ERRONEOUS("E"),
	UNDEFINED("");
	
	private final String value;
	
	SubmissionStatus(final String value){
		this.value = value;
	}
	
	public String toString() { return value; }
}
