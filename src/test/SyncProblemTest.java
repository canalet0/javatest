package test;

import org.junit.Assert;
import org.junit.Test;
import entity.Problem;

public class SyncProblemTest extends ProjectBaseTest{
	
	public SyncProblemTest() {
		super();
	}

	@Test
	public void test() {
		entity.TestCase testCase = new entity.TestCase(1);
		Problem problem = new Problem(testCase, 1);
		this.getRepository().syncProblem(problem);
		this.getRepository().syncProblem(problem);
		Assert.assertTrue("SyncProblem generate duplicated values", this.getRepository().getProblems(testCase).size() == 1);
	}

}
