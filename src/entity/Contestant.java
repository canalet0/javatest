package entity;

public class Contestant {
	private Integer testCaseId;
	private Integer id;
	private Integer solvedProblems;
	private Integer penaltyTime;
	
	public Contestant(TestCase testCase,Integer id){
		this.testCaseId = testCase.getId();
		this.id = id;
		this.solvedProblems = 0;
		this.penaltyTime = 0;
	}

	public Integer getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(Integer testCaseId) {
		this.testCaseId = testCaseId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSolvedProblems() {
		return solvedProblems;
	}

	public void setSolvedProblems(Integer solvedProblems) {
		this.solvedProblems = solvedProblems;
	}

	public Integer getPenaltyTime() {
		return penaltyTime;
	}

	public void setPenaltyTime(Integer penaltyTime) {
		this.penaltyTime = penaltyTime;
	}
}
