package enumeration;

public enum ProblemStatus {
	SOLVED("S"),
	UNSOLVED("U");
	
	private final String status;
	
	ProblemStatus(final String status){
		this.status = status;
	}
	
	public String toString() { return status; }
}
