package test;

import org.junit.Assert;
import org.junit.Test;

import entity.Contestant;
import entity.Problem;
import entity.Submission;

public class AddSubmissionTest extends ProjectBaseTest{
	
	public AddSubmissionTest() {
		super();
	}

	@Test
	public void test() {
		entity.TestCase testCase = new entity.TestCase(1);
		Problem problem = new Problem(testCase, 1);
		Contestant contestant = new Contestant(testCase, 1);
		Submission submission = new Submission(testCase, contestant, problem, 1, "C");
		this.getRepository().addSubmission(submission);
		Assert.assertTrue("Error adding submission", this.getRepository().getSubmissions(testCase).size() == 1);
	}

}
