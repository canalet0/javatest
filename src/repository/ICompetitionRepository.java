package repository;

import java.util.List;

import entity.Contestant;
import entity.Problem;
import entity.Submission;
import entity.TestCase;

public interface ICompetitionRepository{
	public List<TestCase> getTestCases();
	public List<Contestant> getContestants(TestCase testCase);
	public List<Problem> getProblems(TestCase testCase);
	public List<Problem> getSolvedProblems(TestCase testCase);
	public List<Submission> getSubmissions(TestCase testCase);
	public List<Submission> getContestantSubmissions(Contestant contestant);
	public void addTestCase(TestCase newTestCase);
	public void addSubmission(Submission submission);
	public void syncContestant(Contestant contestant);
	public void syncProblem(Problem problem);
}
