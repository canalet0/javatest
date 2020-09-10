package controller;

import entity.Contestant;
import entity.Problem;
import entity.Submission;
import enumeration.ProblemStatus;
import enumeration.SubmissionStatus;
import model.Model;

public class SubmissionController {
	
	private Model model;
	
	public SubmissionController(Model model) {
		this.model = model;
	}
	
	public void processSubmission(Submission submission) {
		Problem problem = this.model.getProblem(submission.problem);
		Contestant contestant = this.model.getContestant(submission.contestant);
		
		contestant.submissions.add(submission);
		
		if(submission.status.equals(SubmissionStatus.CORRECT))
			problem.status = ProblemStatus.SOLVED;
		
		model.syncProblem(problem);
		model.syncContestant(contestant);
	}

}
