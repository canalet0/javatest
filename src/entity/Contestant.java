package entity;

import java.util.ArrayList;
import java.util.List;

public class Contestant {
	public Integer id;
	public List<Submission> submissions;
	public Integer solvedProblems;
	public Integer penaltyTime;
	
	public Contestant(Integer id){
		this.id = id;
		this.submissions = new ArrayList<>();
		this.solvedProblems = 0;
		this.penaltyTime = 0;
	}
}
