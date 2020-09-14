package test;

import org.junit.Assert;
import org.junit.Test;

import entity.Contestant;
import entity.Problem;
import entity.Submission;

public  class GetContestantSubmissionTest extends ProjectBaseTest{
	
	public GetContestantSubmissionTest() {
		super();
	}

	@Test
	public void test() {
		entity.TestCase testCase = new entity.TestCase(1);
		Problem problem = new Problem(testCase, 1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		Submission submission1 = new Submission(testCase, contestant1, problem, 1, "C");
		Submission submission2 = new Submission(testCase, contestant1, problem, 1, "C");
		
		Contestant contestant2 = new Contestant(testCase, 2);		
		Submission submission3 = new Submission(testCase, contestant2, problem, 1, "C");
		
		this.getRepository().addSubmission(submission1);
		this.getRepository().addSubmission(submission2);
		this.getRepository().addSubmission(submission3);
		
		Assert.assertTrue("Error on getContestantSubmissions for contestant1", this.getRepository().getContestantSubmissions(contestant1).size() == 2);
		Assert.assertTrue("Error on getContestantSubmissions for contestant2", this.getRepository().getContestantSubmissions(contestant2).size() == 1);
		Assert.assertTrue("Error on getSubmissions", this.getRepository().getSubmissions(testCase).size() == 3);
	}

}
