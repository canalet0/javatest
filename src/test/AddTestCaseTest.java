package test;

import org.junit.Assert;
import org.junit.Test;

public class AddTestCaseTest extends ProjectBaseTest {

	public AddTestCaseTest(){
		super();
	}
	
	@Test
	public void test() {
		entity.TestCase testCase = new entity.TestCase(1);
		this.getRepository().addTestCase(testCase);
		Assert.assertTrue("Error adding testCase", this.getRepository().getTestCases().size() == 1);
	}
}
