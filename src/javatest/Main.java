package javatest;

import useCases.InputController;
import useCases.ReportController;
import useCases.ScoreBoardController;

public class Main {

	public static void main(String[] args){
		try {
			InputController inputController = new InputController();
			inputController.loadDataFromInput("data/data.txt");
			
			ScoreBoardController scoreBoardController = new ScoreBoardController();
			scoreBoardController.calculateScoreBoard();
			
			ReportController reportController = new ReportController();
			reportController.printReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
