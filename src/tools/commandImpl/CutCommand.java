package tools.commandImpl;

import java.util.Arrays;

import tools.baseCommand.BaseCommand;

public class CutCommand implements BaseCommand {
	
	
	

	public CutCommand(String[] args) {
		System.out.println("in cut constructor");
		
	}

	@Override
	public void performAction(String[] args) {
		
		System.out.println(Arrays.toString(args));
		
	}

}
