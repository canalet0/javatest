package javatest1;

import java.util.ArrayList;
import java.util.List;

import controller.ScoreBoardController;
import controller.SubmissionController;
import entity.Contestant;
import entity.Submission;
import enumeration.SubmissionStatus;
import model.Model;

public class Core {

	private static Model model;
	
	public static void main(String[] args) {
		model = new Model();
		List<Submission> submissions = new ArrayList<Submission>();
		List<Contestant> scoreBoard = new ArrayList<Contestant>();
		
		
		submissions.add(new Submission(1,2,10,SubmissionStatus.INCORRECT));
		submissions.add(new Submission(3,1,11,SubmissionStatus.CORRECT));
		submissions.add(new Submission(1,2,19,SubmissionStatus.CLARIFICATION_REQUEST));
		submissions.add(new Submission(1,2,21,SubmissionStatus.CORRECT));
		submissions.add(new Submission(1,1,25,SubmissionStatus.CORRECT));
		
		processSubmissions(submissions);
		scoreBoard = calculateScoreBoard();
		report(scoreBoard);
	}
	
	public static void processSubmissions(List<Submission> submissions) {
		SubmissionController submissionController = new SubmissionController(model);
		for (Submission submission : submissions) {
			submissionController.processSubmission(submission);
		}
	}
	
	public static List<Contestant> calculateScoreBoard() {
		ScoreBoardController scoreBoardController = new ScoreBoardController();
		return scoreBoardController.getScoreBoard(model.getContestantList(), model.getProblemList());
	}
	
	public static void report(List<Contestant> scoreBoard) {
		for (Contestant rankedContestant : scoreBoard) {
			System.out.println(rankedContestant.id.toString() + " " 
					+ rankedContestant.solvedProblems.toString() + " " 
					+ rankedContestant.penaltyTime.toString());
		}
		
	}
}
