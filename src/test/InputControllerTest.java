package test;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import entity.TestCase;
import useCases.InputController;

public class InputControllerTest extends ProjectBaseTest{
		
	public InputControllerTest() {
		super();
	}
	
	@Test(expected = Exception.class)
	public void testInvalidPath() throws Exception {
		InputController inputController = new InputController(getRepository());
		inputController.loadDataFromInput("");
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testInvalidFilePath() throws Exception {
		InputController inputController = new InputController(getRepository());
		inputController.loadDataFromInput("blablabla");
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testInvalidFile() throws Exception {
		InputController inputController = new InputController(getRepository());
		inputController.loadDataFromInput("data");
	}
	
	@Test
	public void inputTest1() throws Exception{
		InputController inputController = new InputController(getRepository());
		inputController.loadDataFromInput("data/testCase1.txt");
		
		Assert.assertTrue("Can't load testCase's correctly", this.getRepository().getTestCases().size() == 1);
		
		TestCase testCase = this.getRepository().getTestCases().get(0);
		Assert.assertTrue("Can't load Submission's correctly", this.getRepository().getSubmissions(testCase).size() == 5);
		Assert.assertTrue("Can't load Contestant's correctly", this.getRepository().getContestants(testCase).size() == 2);
		Assert.assertTrue("Can't load Problem's correctly", this.getRepository().getProblems(testCase).size() == 2);
		
	}
	
	@Test
	public void inputTest2() throws Exception{
		InputController inputController = new InputController(getRepository());
		inputController.loadDataFromInput("data/testCase2.txt");
		
		Integer submissions = 0;
		Integer contestants = 0;
		Integer problems = 0;
		
		Assert.assertTrue("Can't load testCase's correctly", this.getRepository().getTestCases().size() == 5);
		
		for (TestCase testCase : this.getRepository().getTestCases()) {
			submissions = submissions + this.getRepository().getSubmissions(testCase).size();
			contestants = contestants + this.getRepository().getContestants(testCase).size();
			problems = problems + this.getRepository().getProblems(testCase).size();
		}
		
		Assert.assertTrue("Can't load Submission's correctly", submissions == 18);
		Assert.assertTrue("Can't load Contestant's correctly", contestants == 11);
		Assert.assertTrue("Can't load Problem's correctly", problems == 11);
	}

}