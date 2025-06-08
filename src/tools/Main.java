package tools;

import java.util.List;

import tools.commandImpl.CatCommand;
import tools.commandImpl.CutCommand;
import tools.contract.BaseCommand;
import tools.utils.Helper;

public class Main {

	public static void main(String[] args) {
		
	 boolean value = Helper.validInput(args);
	 
	 if(!value) {
		 System.out.println(" Invalid Arguments");
	 }
	 
	 
	 BaseCommand command = commandFactoryPattern(args);
	 if(command == null) {
		 System.out.println("Invalid Command");
	 }
	 
	
	 
	 List<String> lines = command.performAction(args);
	 for(var line : lines ) {
		 System.out.println(line);
	 }
	 
	 
	}
	
	public static  BaseCommand commandFactoryPattern(String[] args) {
		String command = args[0];
		
		if(command.trim().isBlank()) {
			return null;
		}
		
		switch(command) {
		case "cat":
			return new CatCommand(args);
		case "cut":
			return new CutCommand(args);
		default:
			return null;
		}
	}

}
