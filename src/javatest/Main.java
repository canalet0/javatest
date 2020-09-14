package javatest;

import repository.CompetitonRepositoryFactory;
import repository.ICompetitionRepository;
import useCases.InputController;
import useCases.ReportController;
import useCases.ScoreBoardController;

public class Main {

	public static void main(String[] args){
		try {
			ICompetitionRepository repository = CompetitonRepositoryFactory.getInstance();
			
			InputController inputController = new InputController(repository);
			inputController.loadDataFromInput("data/input.txt");
			
			System.out.println(repository.getTestCases().size());
			
			ScoreBoardController scoreBoardController = new ScoreBoardController(repository);
			scoreBoardController.calculateScoreBoard();
			
			ReportController reportController = new ReportController(repository);
			reportController.printReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
