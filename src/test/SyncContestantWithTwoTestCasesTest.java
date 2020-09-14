package test;


import org.junit.Assert;
import org.junit.Test;

import entity.Contestant;

public class SyncContestantWithTwoTestCasesTest extends ProjectBaseTest{
	
	public SyncContestantWithTwoTestCasesTest() {
		super();
	}

	@Test
	public void test() {
		entity.TestCase testCase1 = new entity.TestCase(1);
		entity.TestCase testCase2 = new entity.TestCase(2);
		Contestant contestant = new Contestant(testCase1, 1);
		this.getRepository().syncContestant(contestant);
		Assert.assertTrue("SyncContestant does not add correctly", this.getRepository().getContestants(testCase1).size() == 1);
		Assert.assertTrue("SyncContestant add contestant in TestCase out of scope", this.getRepository().getContestants(testCase2).size() == 0);
	}

}
