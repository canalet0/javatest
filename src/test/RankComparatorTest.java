package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import comparator.RankComparator;
import entity.Contestant;
import entity.TestCase;

public class RankComparatorTest extends ProjectBaseTest{
	
	private void debug(List<Contestant> contestants) {
		for (Contestant contestant : contestants) {
			System.out.println("Id: " + contestant.getId() + " problems: " + contestant.getSolvedProblems() + " time: " + contestant.getPenaltyTime());
		}
	}
	
	@Test
	public void sortByTimePenalty1() {
		List<Contestant> contestants = new ArrayList<>();
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		contestant1.setPenaltyTime(10);
		
		Contestant contestant2 = new Contestant(testCase, 2);
		contestant2.setPenaltyTime(20);
		
		Contestant contestant3 = new Contestant(testCase, 3);
		contestant3.setPenaltyTime(30);
		
		contestants.add(contestant1);
		contestants.add(contestant2);
		contestants.add(contestant3);
		
		contestants.sort(new RankComparator());
		
		Assert.assertTrue("Comparator has sorted incorrectly!", contestants.get(0).getId().intValue() == 1);
	}
	
	@Test
	public void sortByTimePenalty2() {
		List<Contestant> contestants = new ArrayList<>();
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		contestant1.setPenaltyTime(10);
		
		Contestant contestant2 = new Contestant(testCase, 2);
		contestant2.setPenaltyTime(20);
		
		Contestant contestant3 = new Contestant(testCase, 3);
		contestant3.setPenaltyTime(30);
		
		contestants.add(contestant2);
		contestants.add(contestant1);
		contestants.add(contestant3);
		
		contestants.sort(new RankComparator());
		
		Assert.assertTrue("Comparator has sorted incorrectly!", contestants.get(0).getId().intValue() == 1);
	}
	
	@Test
	public void sortByTimePenalty3() {
		List<Contestant> contestants = new ArrayList<>();
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		contestant1.setPenaltyTime(30);
		
		Contestant contestant2 = new Contestant(testCase, 2);
		contestant2.setPenaltyTime(10);
		
		Contestant contestant3 = new Contestant(testCase, 3);
		contestant3.setPenaltyTime(20);
		
		contestants.add(contestant3);
		contestants.add(contestant2);
		contestants.add(contestant1);
		
		contestants.sort(new RankComparator());
		
		Assert.assertTrue("Comparator has sorted incorrectly!", contestants.get(0).getId().intValue() == 2);
	}
	
	@Test
	public void sortByProblemsSolved1() {
		List<Contestant> contestants = new ArrayList<>();
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		contestant1.setSolvedProblems(10);
		
		Contestant contestant2 = new Contestant(testCase, 2);
		contestant2.setSolvedProblems(20);
		
		Contestant contestant3 = new Contestant(testCase, 3);
		contestant3.setSolvedProblems(30);
		
		contestants.add(contestant1);
		contestants.add(contestant2);
		contestants.add(contestant3);
		
		contestants.sort(new RankComparator());
		
		Assert.assertTrue("Comparator has sorted incorrectly!", contestants.get(0).getId().intValue() == 3);
	}
	
	@Test
	public void sortByProblemsSolved2() {
		List<Contestant> contestants = new ArrayList<>();
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		contestant1.setSolvedProblems(10);
		
		Contestant contestant2 = new Contestant(testCase, 2);
		contestant2.setSolvedProblems(20);
		
		Contestant contestant3 = new Contestant(testCase, 3);
		contestant3.setSolvedProblems(30);
		
		contestants.add(contestant2);
		contestants.add(contestant1);
		contestants.add(contestant3);
		
		contestants.sort(new RankComparator());
		
		Assert.assertTrue("Comparator has sorted incorrectly!", contestants.get(0).getId().intValue() == 3);
	}
	
	@Test
	public void sortByProblemsSolved3() {
		List<Contestant> contestants = new ArrayList<>();
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		contestant1.setSolvedProblems(30);
		
		Contestant contestant2 = new Contestant(testCase, 2);
		contestant2.setSolvedProblems(10);
		
		Contestant contestant3 = new Contestant(testCase, 3);
		contestant3.setSolvedProblems(20);
		
		contestants.add(contestant3);
		contestants.add(contestant2);
		contestants.add(contestant1);
		
		contestants.sort(new RankComparator());
	
		Assert.assertTrue("Comparator has sorted incorrectly!", contestants.get(0).getId().intValue() == 1);
	}
	
	@Test
	public void sortByFullRank1() {
		List<Contestant> contestants = new ArrayList<>();
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		contestant1.setSolvedProblems(1);
		contestant1.setPenaltyTime(10);
		
		Contestant contestant2 = new Contestant(testCase, 2);
		contestant2.setSolvedProblems(1);
		contestant2.setPenaltyTime(11);
		
		Contestant contestant3 = new Contestant(testCase, 3);
		contestant3.setSolvedProblems(0);
		contestant3.setPenaltyTime(9);
		
		contestants.add(contestant1);
		contestants.add(contestant2);
		contestants.add(contestant3);
		
		contestants.sort(new RankComparator());
	
		Assert.assertTrue("Comparator has sorted incorrectly!", contestants.get(0).getId().intValue() == 1);
	}
	
	@Test
	public void sortByFullRank2() {
		List<Contestant> contestants = new ArrayList<>();
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		contestant1.setSolvedProblems(1);
		contestant1.setPenaltyTime(10);
		
		Contestant contestant2 = new Contestant(testCase, 2);
		contestant2.setSolvedProblems(2);
		contestant2.setPenaltyTime(11);
		
		Contestant contestant3 = new Contestant(testCase, 3);
		contestant3.setSolvedProblems(0);
		contestant3.setPenaltyTime(9);
		
		contestants.add(contestant3);
		contestants.add(contestant2);
		contestants.add(contestant1);
		
		contestants.sort(new RankComparator());
		
		Assert.assertTrue("Comparator has sorted incorrectly!", contestants.get(0).getId().intValue() == 2);
	}
	
	@Test
	public void sortByFullRank3() {
		List<Contestant> contestants = new ArrayList<>();
		TestCase testCase = new TestCase(1);
		
		Contestant contestant1 = new Contestant(testCase, 1);
		contestant1.setSolvedProblems(1);
		contestant1.setPenaltyTime(10);
		
		Contestant contestant2 = new Contestant(testCase, 2);
		contestant2.setSolvedProblems(0);
		contestant2.setPenaltyTime(9);
		
		Contestant contestant3 = new Contestant(testCase, 3);
		contestant3.setSolvedProblems(1);
		contestant3.setPenaltyTime(10);
		
		contestants.add(contestant1);
		contestants.add(contestant2);
		contestants.add(contestant3);
		
		contestants.sort(new RankComparator());
		
		this.debug(contestants);
		
		Assert.assertTrue("Comparator has sorted incorrectly!", contestants.get(0).getId().intValue() == 1);
	}

	
}
