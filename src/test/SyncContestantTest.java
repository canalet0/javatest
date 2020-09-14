package test;

import org.junit.Assert;
import org.junit.Test;
import entity.Contestant;

public class SyncContestantTest extends ProjectBaseTest {
	
	public SyncContestantTest() {
		super();
	}

	@Test
	public void test() {
		entity.TestCase testCase = new entity.TestCase(1);
		Contestant contestant = new Contestant(testCase, 1);
		this.getRepository().syncContestant(contestant);
		this.getRepository().syncContestant(contestant);
		Assert.assertTrue("SyncContestant generate duplicated values", this.getRepository().getContestants(testCase).size() == 1);
	}

}
