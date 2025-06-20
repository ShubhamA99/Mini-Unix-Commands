package tools.utils;

import java.io.File;

import tools.contract.BaseCommand;

public class Helper {
	
	public static boolean validInput(String[] input) {
		
		if(input.length == 0) {
			return false;
		}
		
		return true;
	}
	
	
	public static boolean isValidFile(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return false;
        }

        File file = new File(filename);

        // Checks:
        // 1. File exists
        // 2. It is a file (not a directory)
        // 3. It can be read
        return file.exists() && file.isFile() && file.canRead();
    }

	
	public static boolean isInteger(String value) {
		
		if (value == null) return false;
	    try {
	        Integer.parseInt(value);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	    
	}
	

}
