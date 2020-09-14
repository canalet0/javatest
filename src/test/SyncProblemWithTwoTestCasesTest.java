package test;

import org.junit.Assert;
import org.junit.Test;
import entity.Problem;

public class SyncProblemWithTwoTestCasesTest extends ProjectBaseTest{
	
	public SyncProblemWithTwoTestCasesTest() {
		super();
	}

	@Test
	public void test() {
		entity.TestCase testCase1 = new entity.TestCase(1);
		entity.TestCase testCase2 = new entity.TestCase(2);
		Problem problem = new Problem(testCase1, 1);
		this.getRepository().syncProblem(problem);
		Assert.assertTrue("SyncContestant does not add correctly", this.getRepository().getProblems(testCase1).size() == 1);
		Assert.assertTrue("SyncContestant add contestant in TestCase out of scope", this.getRepository().getProblems(testCase2).size() == 0);
	}

}
