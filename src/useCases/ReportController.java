package useCases;

import java.util.List;

import comparator.RankComparator;
import entity.Contestant;
import entity.TestCase;
import repository.ICompetitionRepository;

public class ReportController {
	
	private ICompetitionRepository _repository;

	public ReportController(ICompetitionRepository repository) {
		this._repository = repository;
	}
	
	public void printReport() {
		for (TestCase testCase : _repository.getTestCases()) {
			for (Contestant rankedContestant : this.getRankedList(testCase)) {
				System.out.println(rankedContestant.getId().toString() + " " 
						+ rankedContestant.getSolvedProblems().toString() + " " 
						+ rankedContestant.getPenaltyTime().toString());
			}
			System.out.println();
		}
	}
		
	private List<Contestant> getRankedList(TestCase testCase) {
		List<Contestant> rankedContestantsList;
		rankedContestantsList = _repository.getContestants(testCase);
		rankedContestantsList.sort(new RankComparator());
		return rankedContestantsList;
	}
}


