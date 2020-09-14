package repository;

public class CompetitonRepositoryFactory {
	private static final CompetitionRepository INSTANCE = new CompetitionRepository();
	
	public static CompetitionRepository getInstance() {
		return INSTANCE;
	}
}
