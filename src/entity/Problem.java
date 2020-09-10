package entity;

import enumeration.ProblemStatus;

public class Problem {
	
	public Integer id;
	public ProblemStatus status;
	
	public Problem(Integer id) {
		this.id = id;
		this.status = ProblemStatus.UNSOLVED;
	}
}
