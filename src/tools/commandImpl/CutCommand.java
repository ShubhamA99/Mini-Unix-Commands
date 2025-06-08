package tools.commandImpl;

import java.util.Arrays;
import java.util.List;

import tools.contract.BaseCommand;

public class CutCommand implements BaseCommand {
	
	
	

	public CutCommand(String[] args) {
		System.out.println("in cut constructor");
		
	}

	@Override
	public List<String> performAction(String[] args) {
		
		System.out.println(Arrays.toString(args));
		return null;
		
	}

}
