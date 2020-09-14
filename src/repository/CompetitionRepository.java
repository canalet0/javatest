package repository;

import java.util.ArrayList;
import java.util.List;

import entity.Contestant;
import entity.Problem;
import entity.Submission;
import entity.TestCase;
import enumeration.ProblemStatus;

public class CompetitionRepository implements ICompetitionRepository{
	
	private List<TestCase> testCases;
	private List<Contestant> contestants;
	private List<Problem> problems;
	private List<Submission> submissions;
	
	public CompetitionRepository() {
		testCases = new ArrayList<>();
		contestants = new ArrayList<>();
		problems = new ArrayList<>();
		submissions = new ArrayList<>();
	}
	
	public List<TestCase> getTestCases() {
		return testCases;
	}

	public List<Contestant> getContestants(TestCase testCase) {
		List<Contestant> _contestants = new ArrayList<>();
		
		for (Contestant contestant : this.contestants) {
			if(contestant.getTestCaseId().intValue() == testCase.getId().intValue())
				_contestants.add(contestant);
		}
		return _contestants;
	}

	public List<Problem> getProblems(TestCase testCase) {
		List<Problem> _problems = new ArrayList<>();
		
		for (Problem problem : this.problems) {
			if(problem.getTestCaseId().intValue() == testCase.getId().intValue())
				_problems.add(problem);
		}
		return _problems;
	}
	
	
	public List<Problem> getSolvedProblems(TestCase testCase) {
		List<Problem> _problems = new ArrayList<>();
		
		for (Problem problem : this.problems) {
			if(problem.getTestCaseId().intValue() == testCase.getId().intValue()
			&& ProblemStatus.SOLVED.equals(problem.getStatus()))
				_problems.add(problem);
		}
		return _problems;
	}
	public List<Submission> getSubmissions(TestCase testCase) {
		List<Submission> _submissions = new ArrayList<>();
		
		for (Submission submission : this.submissions) {
			if(submission.getTestCaseId().intValue() == testCase.getId().intValue())
				_submissions.add(submission);
		}
		
		return _submissions;
	}

	public List<Submission> getContestantSubmissions(Contestant contestant) {
		List<Submission> _submissions = new ArrayList<>();
		
		for (Submission submission : this.submissions) {
			if(submission.getTestCaseId().intValue() == contestant.getTestCaseId().intValue()
			&& submission.getContestantId().intValue() == contestant.getId().intValue())
				_submissions.add(submission);
		}
		
		return _submissions;
	}
	
	public void addTestCase(TestCase newTestCase) {
		testCases.add(newTestCase);
	}
	
	public void addSubmission(Submission submission) {
		submissions.add(submission);
	}
	
	public void syncContestant(Contestant contestant) {
		Boolean hasRegister = false;
		for (Contestant _contestant : contestants) {
			if(_contestant.getTestCaseId().intValue() == contestant.getTestCaseId().intValue()
			&& _contestant.getId().intValue() == contestant.getId().intValue()) {
				hasRegister = true;
				contestant = _contestant;
				break;
			}
		}
		
		if(hasRegister)
			return;
			
		
		contestants.add(contestant);
	}
	
	public void syncProblem(Problem problem) {
		Boolean hasRegister = false;
		for (Problem _problem : problems) {
			if(_problem.getTestCaseId().intValue() == problem.getTestCaseId().intValue()
			&& _problem.getId().intValue() == problem.getId().intValue()) {
				hasRegister = true;
				problem = _problem;
				break;
			}
		}
		
		if(hasRegister)
			return;
			
		
		problems.add(problem);
	}
}
