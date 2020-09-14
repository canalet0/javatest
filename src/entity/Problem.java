package entity;

import enumeration.ProblemStatus;

public class Problem {
	
	private Integer testCaseId;
	private Integer id;
	private ProblemStatus status;
	
	public Problem(TestCase testCase,Integer id) {
		this.testCaseId = testCase.getId();
		this.id = id;
		this.status = ProblemStatus.UNSOLVED;
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

	public ProblemStatus getStatus() {
		return status;
	}

	public void setStatus(ProblemStatus status) {
		this.status = status;
	}
	
	public void flagAsResolved(){
		this.status = ProblemStatus.SOLVED;
	}
}
