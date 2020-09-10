package entity;

import enumeration.SubmissionStatus;

public class Submission {
	
	public Integer contestant;
	public Integer problem;
	public Integer timeLapse;
	public Enum<SubmissionStatus> status;
	
	public Submission(Integer contestant, Integer problem, Integer timeLapse, SubmissionStatus status) {
		this.contestant = contestant;
		this.problem = problem;
		this.timeLapse = timeLapse;
		this.status = status;
	}
	
}
