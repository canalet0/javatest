package controller;

import java.util.ArrayList;
import java.util.List;

import entity.Contestant;
import entity.Problem;
import entity.Submission;
import enumeration.ProblemStatus;
import enumeration.SubmissionStatus;

public class ScoreBoardController {
	
	public List<Contestant> getScoreBoard(List<Contestant> contestants,List<Problem> problems){
		List<Contestant> scoreBoard = new ArrayList<>();
		
		this.calculateContestantScore(contestants,problems);
		scoreBoard = this.calculateScoreBoard(contestants);
		
		return scoreBoard;
	}
	
	public List<Contestant> calculateScoreBoard(List<Contestant> contestants){
		List<Contestant> scoreBoard = new ArrayList<>();
		
		return contestants;
	}

	public void calculateContestantScore(List<Contestant> contestants,List<Problem> problems) {
		for (Contestant contestant: contestants) {
			contestant.penaltyTime = this.calculateContestantPenaltyTime(contestant,problems);
			contestant.solvedProblems = this.calculateContestantSolvedProblems(contestant);
		}
	}
	
	public Integer calculateContestantPenaltyTime(Contestant contestant,List<Problem> problems) {
		Integer penaltyTime = 0;
		
		for (Submission submission : contestant.submissions) {
			
			if(submission.status.equals(SubmissionStatus.CORRECT))
				penaltyTime = penaltyTime + submission.timeLapse;
			
			if(submission.status.equals(SubmissionStatus.INCORRECT)) {
				for (Problem problem : problems) {
					if(problem.id.equals(submission.problem)
					&& problem.status.equals(ProblemStatus.SOLVED)) {
						penaltyTime = penaltyTime + 20;
					}
				}
			}
		}
		
		return penaltyTime;
	}
	
	public Integer calculateContestantSolvedProblems(Contestant contestant) {
		Integer correctAnswers = 0;
		
		for (Submission submission : contestant.submissions) {
			if(submission.status.equals(SubmissionStatus.CORRECT))
				correctAnswers++;
		}
		
		return correctAnswers;
	}

}
