package comparator;

import java.util.Comparator;

import entity.Contestant;

public class RankComparator implements Comparator<Contestant> {
		 
    @Override
    public int compare(Contestant contestant1, Contestant contestant2) {
    	switch (contestant1.getSolvedProblems().compareTo(contestant2.getSolvedProblems())) {
		case 1:
			return -1;
		case -1:
			return 1;
		default:
			break;
		}
    	
    	switch (contestant1.getPenaltyTime().compareTo(contestant2.getPenaltyTime())) {
		case 1:
			return 1;
		case -1:
			return -1;
		default:
			break;
		}
    	
    	return contestant1.getId() - contestant2.getId();
    }
}
