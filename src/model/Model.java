package model;

import java.util.ArrayList;
import java.util.List;

import entity.Contestant;
import entity.Problem;

public class Model {

	private List<Contestant> contestantList;
	private List<Problem> problemList;
	
	public Model() {
		super();
		this.contestantList = new ArrayList<>();
		this.problemList = new ArrayList<>();
	}
	
	public List<Contestant> getContestantList() {
		return contestantList;
	}

	public List<Problem> getProblemList() {
		return problemList;
	}
	
	public Contestant getContestant(Integer id) {
		for (Contestant contestant : this.contestantList) {
			if(contestant.id.equals(id)) {
				return contestant;
			}
		}
		
		return new Contestant(id);
	}
	
	public Problem getProblem(Integer id) {
		for (Problem problem : this.problemList) {
			if(problem.id.equals(id)) {
				return problem;
			}
		}
		
		return new Problem(id);
	}
	
	public void syncProblem(Problem problem) {
		for (Problem _problem : this.problemList) {
			if(_problem.id.equals(problem.id)) {
				this.problemList.remove(_problem);
				break;
			}
		}
		
		this.problemList.add(problem);
	}
	
	public void syncContestant(Contestant contestant) {
		for (Contestant _contestant : this.contestantList) {
			if(_contestant.id.equals(contestant.id)) {
				this.contestantList.remove(_contestant);
				break;
			}
		}
		
		this.contestantList.add(contestant);
	}
	
	
	
}
