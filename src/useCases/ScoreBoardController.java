package useCases;

import entity.Contestant;
import entity.Problem;
import entity.Submission;
import entity.TestCase;
import enumeration.SubmissionStatus;
import repository.ICompetitionRepository;

public class ScoreBoardController {
	
	private ICompetitionRepository _repository;

	public ScoreBoardController(ICompetitionRepository repository) {
		this._repository = repository;
	}
	
	public void calculateScoreBoard() {
		for (TestCase testCase : this._repository.getTestCases()) {
			this.updateProblemStatus(testCase);
			this.calculateContestantScore(testCase);
		}
	}
	
	private void updateProblemStatus(TestCase testCase) {		
		for (Problem problem: this._repository.getProblems(testCase)) {
			for (Submission submission : this._repository.getSubmissions(testCase)) {
				if(submission.getProblemId().intValue() == problem.getId().intValue()
				&& SubmissionStatus.CORRECT.equals(submission.getStatus()))
					problem.flagAsResolved();
			}
		}
	}
	
	private void calculateContestantScore(TestCase testCase) {
		for (Contestant contestant: this._repository.getContestants(testCase)) {
			contestant.setPenaltyTime(this.calculateContestantPenaltyTime(testCase,contestant));
			contestant.setSolvedProblems(this.calculateContestantSolvedProblems(contestant));
		}
	}
	
	private Integer calculateContestantPenaltyTime(TestCase testCase,Contestant contestant) {
		Integer penaltyTime = 0;
		
		for (Submission submission : this._repository.getContestantSubmissions(contestant)) {
			if(SubmissionStatus.CORRECT.equals(submission.getStatus()))
				penaltyTime = penaltyTime + submission.getElapsedTime();
			
			if(SubmissionStatus.INCORRECT.equals(submission.getStatus())) {
				for (Problem problem : this._repository.getSolvedProblems(testCase)) {
					if(problem.getId().intValue() == submission.getProblemId().intValue()) {
						penaltyTime = penaltyTime + 20;
					}
				}
			}
		}
		
		return penaltyTime;
	}
	
	private Integer calculateContestantSolvedProblems(Contestant contestant) {
		Integer correctAnswers = 0;
		for (Submission submission : this._repository.getContestantSubmissions(contestant)) {
			if(SubmissionStatus.CORRECT.equals(submission.getStatus()))
				correctAnswers++;
		}
		
		return correctAnswers;
	}
}
