package useCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import entity.Contestant;
import entity.Problem;
import entity.Submission;
import entity.TestCase;
import repository.CompetitionRepository;

public class InputController {
	
	private File inputFile;
	private Scanner fileReader;
	private CompetitionRepository _repository;

	public InputController() {
		this._repository = CompetitionRepository.getInstance();
	}
	
	public void loadDataFromInput(String filePath) throws Exception {
		if(filePath.isEmpty())
			throw new Exception("Caminho do arquivo de dados invalido!");
		
		this.loadFile(filePath);
		this.processDataFromFile();
		this.closeFile();
	}
	
	public void loadFile(String filePath) throws FileNotFoundException{
		this.inputFile = new File(filePath);
		
		if(!inputFile.exists()
		|| !inputFile.isFile()
		|| !inputFile.canRead())
			throw new FileNotFoundException("teste do canal!");
		
		this.fileReader = new Scanner(this.inputFile);
	}
	

	public void processDataFromFile() {
		String line;
		String[] splittedData;
		TestCase testCase = new TestCase(0);
		Contestant contestant;
		Problem problem; 
		Integer elapsedTime;
		String submissionStatus;
		
		while (this.fileReader.hasNextLine()) {
			line = this.fileReader.nextLine();
			
			if(line.isEmpty())
				continue;
			
			splittedData = line.split(" ");
			
			switch (splittedData.length) {
			case 1:
				testCase = createTestCase(splittedData);
				break;
			case 4:
				contestant = createContestant(testCase,splittedData[0]);
				problem = createProblem(testCase,splittedData[1]);
				elapsedTime = Integer.parseInt(splittedData[2]);
				submissionStatus = splittedData[3];
				createSubmission(testCase,contestant,problem,elapsedTime,submissionStatus);
				break;
			default:
				break;
			}	
		}
		
	}
	
	public void closeFile() {
		this.fileReader.close();
	}
	
	private TestCase createTestCase(String[] testCaseLine) {
		TestCase testCase = new TestCase(Integer.parseInt(testCaseLine[0]));
		this._repository.addTestCase(testCase);
		return testCase;
	}
	
	private Contestant createContestant(TestCase testCase,String id) {
		Contestant contestant = new Contestant(testCase, Integer.parseInt(id));
		this._repository.syncContestant(contestant);
		return contestant;
	}
	
	private Problem createProblem(TestCase testCase,String id) {
		Problem problem = new Problem(testCase, Integer.parseInt(id));
		this._repository.syncProblem(problem);
		return problem;
	}
	
	private Submission createSubmission(TestCase testCase,Contestant contestant,Problem problem,Integer elapsedTime,String status) {
		Submission submission = new Submission(testCase, contestant, problem, elapsedTime, status);
		this._repository.addSubmission(submission);
		return submission;
	}

}
