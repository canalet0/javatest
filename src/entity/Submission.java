package entity;

import enumeration.SubmissionStatus;

public class Submission {
	
	private Integer testCaseId;
	private Integer contestantId;
	private Integer problemId;
	private Integer elapsedTime;
	private SubmissionStatus status;
	
	public Submission(TestCase testCase,Contestant contestant, Problem problem, Integer elapsedTime, String status) {
		this.testCaseId = testCase.getId();
		this.contestantId = contestant.getId();
		this.problemId = problem.getId();
		this.elapsedTime = elapsedTime;
		this.setStatus(status);
	}

	public Integer getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(Integer testCaseId) {
		this.testCaseId = testCaseId;
	}

	public Integer getContestantId() {
		return contestantId;
	}

	public void setContestantId(Integer contestantId) {
		this.contestantId = contestantId;
	}

	public Integer getProblemId() {
		return problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public Integer getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Integer elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public SubmissionStatus getStatus() {
		return status;
	}

	public void setStatus(SubmissionStatus status) {
		this.status = status;
	}
	
	private void setStatus(String status) {
		this.status = SubmissionStatus.UNDEFINED;
		
		for(SubmissionStatus statusEnum : SubmissionStatus.values()) {
			if(statusEnum.toString().equals(status)) {
				this.status = statusEnum;
			}
		}
	}
	
}
