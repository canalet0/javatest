package test;

import org.junit.Assert;
import org.junit.Test;

import entity.Contestant;
import entity.Problem;
import entity.Submission;
import entity.TestCase;
import enumeration.SubmissionStatus;
import useCases.ScoreBoardController;

public class ScoreBoardControllerTest extends ProjectBaseTest{
		
	public ScoreBoardControllerTest() {
		super();
	}
	
	private void calculateScoreBoard() {
		ScoreBoardController scoreBoardController = new ScoreBoardController(getRepository());
		scoreBoardController.calculateScoreBoard();
	}
			
	@Test
	public void testSolvedProblems() {
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		Contestant contestant2 = new Contestant(testCase, 2);
		
		Problem problem1 = new Problem(testCase, 1);
		Problem problem2 = new Problem(testCase, 2);
		this.getRepository().addTestCase(testCase);
		
		this.getRepository().syncContestant(contestant1);
		this.getRepository().syncContestant(contestant2);
		
		this.getRepository().syncProblem(problem1);
		this.getRepository().syncProblem(problem2);
		
		Submission submission1 = new Submission(testCase, contestant1, problem1, 1, SubmissionStatus.CORRECT.toString());
		Submission submission2 = new Submission(testCase, contestant2, problem1, 1, SubmissionStatus.INCORRECT.toString());
		
		this.getRepository().addSubmission(submission1);
		this.getRepository().addSubmission(submission2);
		this.calculateScoreBoard();
		Assert.assertTrue("ScoreBoard calculate solved problem's incorrectly", this.getRepository().getSolvedProblems(testCase).size() == 1);
	}
	
	@Test
	public void testPenaltyTime1() {
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		Contestant contestant2 = new Contestant(testCase, 2);
		
		Problem problem1 = new Problem(testCase, 1);
		Problem problem2 = new Problem(testCase, 2);
		this.getRepository().addTestCase(testCase);
		
		this.getRepository().syncContestant(contestant1);
		this.getRepository().syncContestant(contestant2);
		
		this.getRepository().syncProblem(problem1);
		this.getRepository().syncProblem(problem2);
		
		Submission submission1 = new Submission(testCase, contestant1, problem1, 1, SubmissionStatus.CORRECT.toString());
		Submission submission2 = new Submission(testCase, contestant2, problem1, 1, SubmissionStatus.INCORRECT.toString());
		Submission submission3 = new Submission(testCase, contestant2, problem1, 1, SubmissionStatus.CORRECT.toString());
		
		this.getRepository().addSubmission(submission1);
		this.getRepository().addSubmission(submission2);
		this.getRepository().addSubmission(submission3);
		this.calculateScoreBoard();
			
		for (Contestant contestant : this.getRepository().getContestants(testCase)) {
			if(contestant.getId().intValue() == 2) {
				Assert.assertTrue("ScoreBoard calculate penalty time Incorrectly",contestant.getPenaltyTime().intValue() == 21);
			}
		}
	}
	
	@Test
	public void testPenaltyTime2() {
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		Contestant contestant2 = new Contestant(testCase, 2);
		
		Problem problem1 = new Problem(testCase, 1);
		Problem problem2 = new Problem(testCase, 2);
		this.getRepository().addTestCase(testCase);
		
		this.getRepository().syncContestant(contestant1);
		this.getRepository().syncContestant(contestant2);
		
		this.getRepository().syncProblem(problem1);
		this.getRepository().syncProblem(problem2);
		
		Submission submission1 = new Submission(testCase, contestant1, problem1, 1, SubmissionStatus.CORRECT.toString());
		Submission submission2 = new Submission(testCase, contestant2, problem1, 1, SubmissionStatus.INCORRECT.toString());
		Submission submission3 = new Submission(testCase, contestant2, problem1, 1, SubmissionStatus.CLARIFICATION_REQUEST.toString());
		Submission submission4 = new Submission(testCase, contestant2, problem1, 1, SubmissionStatus.UNJUDGED.toString());
		Submission submission5 = new Submission(testCase, contestant2, problem1, 1, SubmissionStatus.ERRONEOUS.toString());
		Submission submission6 = new Submission(testCase, contestant2, problem1, 1, SubmissionStatus.CORRECT.toString());
		
		this.getRepository().addSubmission(submission1);
		this.getRepository().addSubmission(submission2);
		this.getRepository().addSubmission(submission3);
		this.getRepository().addSubmission(submission4);
		this.getRepository().addSubmission(submission5);
		this.getRepository().addSubmission(submission6);
		this.calculateScoreBoard();
			
		for (Contestant contestant : this.getRepository().getContestants(testCase)) {
			if(contestant.getId().intValue() == 2) {
				Assert.assertTrue("ScoreBoard calculate penalty time Incorrectly",contestant.getPenaltyTime().intValue() == 21);
			}
		}
	}
	
	@Test
	public void testContestSolvedProblems() {
		TestCase testCase = new TestCase(1);
		this.getRepository().addTestCase(testCase);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		Contestant contestant2 = new Contestant(testCase, 2);
		this.getRepository().syncContestant(contestant1);
		this.getRepository().syncContestant(contestant2);
		
		Problem problem1 = new Problem(testCase, 1);
		Problem problem2 = new Problem(testCase, 2);
		
		this.getRepository().syncProblem(problem1);
		this.getRepository().syncProblem(problem2);
		
		Submission submission1 = new Submission(testCase, contestant1, problem1, 1, SubmissionStatus.CORRECT.toString());
		Submission submission2 = new Submission(testCase, contestant2, problem1, 1, SubmissionStatus.CORRECT.toString());
		Submission submission3 = new Submission(testCase, contestant2, problem2, 1, SubmissionStatus.CORRECT.toString());
		
		this.getRepository().addSubmission(submission1);
		this.getRepository().addSubmission(submission2);
		this.getRepository().addSubmission(submission3);
		this.calculateScoreBoard();
		
		Assert.assertTrue("ScoreBoard calculate Contestand solved problem's incorrectly", 
				this.getRepository().getContestants(testCase).get(0).getSolvedProblems() == 1
				&& this.getRepository().getContestants(testCase).get(1).getSolvedProblems() == 2);
	}

}
