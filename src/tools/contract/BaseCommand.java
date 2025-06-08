package tools.contract;

import java.util.List;

public interface BaseCommand {
	
	List<String> performAction(String[] args);

}
