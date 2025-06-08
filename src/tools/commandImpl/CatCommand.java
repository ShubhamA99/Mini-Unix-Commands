package tools.commandImpl;


import java.util.ArrayList;
import java.util.List;

import tools.InputReaderImpl.FileInputReader;
import tools.InputReaderImpl.ScanInputReader;
import tools.contract.BaseCommand;
import tools.contract.InputReader;
import tools.enums.LineNumberMode;
import tools.utils.Constants;
import tools.utils.Helper;

public class CatCommand implements BaseCommand {
	
	
	private LineNumberMode lineNumberMode;
	
	private InputReader inputReader;
	
	private final List<String> fileNames = new ArrayList<>();
	
	
	
	
	public LineNumberMode getLineNumberMode() {
		return lineNumberMode;
	}


	public void setLineNumberMode(LineNumberMode lineNumberMode) {
		this.lineNumberMode = lineNumberMode;
	}
	
	
	


	public List<String> getFileNames() {
		return fileNames;
	}


	
	public CatCommand(String[] args) {
		
	//	System.out.println(Arrays.toString(args));
		
		for(int i=1;i<args.length;i++) {
			
			if (args[i].isBlank()) continue;
						
			parseArgument(args[i]);
	
		}
		
		if(fileNames.isEmpty()) {
			this.inputReader = new ScanInputReader();
		}else {
			this.inputReader = new FileInputReader(fileNames);
		}
		
	}
	
	void parseArgument(String value) {
		
			
		
		if (value.startsWith(Constants.LINE_MODE_HYPEN_N)) {
		       
			 applyMode(LineNumberMode.N, value);		     
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
	public List<String> performAction(String[] args) {
		
		if (lineNumberMode == null) {
            lineNumberMode = LineNumberMode.NONE; // default mode if none provided
        }
				
		return printOutput();
		
		
	}

	
	
	List<String> printOutput() {
		List<String> lines = inputReader.readInput();
		List<String> output = new ArrayList<>();

		int count = 1;
		for (String line : lines) {
			switch (lineNumberMode) {
			case N:
				output.add(String.format("%6d  %s", count++, line));
				break;
			case B:
				if (!line.trim().isEmpty()) {
					output.add(String.format("%6d  %s", count++, line));
				} else {
					output.add("");
				}
				break;
			case NONE:
			default:
				output.add(line);
			}
		}
		return output;
	}
	
	
	
	
	void applyMode(LineNumberMode mode, String originalValue) {
		if (lineNumberMode != null) {
			throw new RuntimeException(
					String.format("Invalid argument %s: mode %s already set", originalValue, lineNumberMode));
		}
		setLineNumberMode(mode);
	}
	
	


}
