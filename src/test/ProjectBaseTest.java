package test;

import repository.CompetitionRepository;

public class ProjectBaseTest {
	private CompetitionRepository repository;
	public ProjectBaseTest() {
		this.repository = new CompetitionRepository();
	}
	
	public CompetitionRepository getRepository() {
		return this.repository;
	}
}
