package tools.commandImpl;


import java.util.ArrayList;
import java.util.List;

import tools.baseCommand.BaseCommand;
import tools.enums.LineNumberMode;
import tools.utils.Constants;
import tools.utils.Helper;

public class CatCommand implements BaseCommand {
	
	
	private LineNumberMode lineNumberMode;
	
	private Integer lineNumbers;
	
	 private final List<String> fileNames = new ArrayList<>();
	
	
	
	
	public LineNumberMode getLineNumberMode() {
		return lineNumberMode;
	}


	public void setLineNumberMode(LineNumberMode lineNumberMode) {
		this.lineNumberMode = lineNumberMode;
	}
	
	
	public Integer getLineNumbers() {
		return lineNumbers;
	}


	public void setLineNumbers(Integer lineNumbers) {
		this.lineNumbers = lineNumbers;
	}


	public List<String> getFileNames() {
		return fileNames;
	}


		


	@Override
	public String toString() {
		return "CatCommand [lineNumberMode=" + this.lineNumberMode + ", lineNumbers=" + this.lineNumbers + ", fileNames="
				+ this.fileNames + "]";
	}


	public CatCommand(String[] args) {
		
	//	System.out.println(Arrays.toString(args));
		
		for(int i=1;i<args.length;i++) {
			
			parseArgument(args[i]);
	
		}
		
	}
	
	void parseArgument(String value) {
		
		
		if(value.trim().isBlank()) {
			return;
		}
				
		
		if (value.startsWith(Constants.LINE_MODE_HYPEN_N)) {
		       
			 applyMode(LineNumberMode.N, value);
		     
			 String suffix = value.substring(Constants.LINE_MODE_HYPEN_N.length());
		     
			 if (!suffix.isBlank()) {
		     
				 try {
					 
		          setLineNumbers(Integer.parseInt(suffix));
		         
				 } catch (NumberFormatException e) {
		             throw new RuntimeException("Invalid number in argument: " + value);
		         }
		        
			 }
		     
			 return;
		  }
		 
		 
		if(value.startsWith(Constants.LINE_MODE_HYPEN_B)) {
			
			applyMode(LineNumberMode.B, value);
	        return;
			
		}
		
		if(value.startsWith(Constants.LINE_MODE_HYPEN)) {
			
			 applyMode(LineNumberMode.NONE, value);
		     return;
		}
		
		
		
		if(Helper.isValidFile(value)) {
			
			fileNames.add(value);
					
		}
		
		
		
	}


	@Override
	public void performAction(String[] args) {
		
		if (lineNumberMode == null) {
            throw new IllegalStateException("No line number mode specified.");
        }
	
		switch(lineNumberMode) {
			case N:
			case NONE:
				performActionForHypenN();
				break;
			case B:
				performActionForHypenB();
				break;
		}
		
	}

	
	void performActionForHypenN() {
		
	}
	
	
	void performActionForHypenB() {
		
	}
	
	
	
	 void applyMode(LineNumberMode mode, String originalValue) {
	    if (lineNumberMode != null) {
	        throw new RuntimeException(String.format("Invalid argument %s: mode %s already set", originalValue, lineNumberMode));
	    }
	    setLineNumberMode(mode);
	}

}
