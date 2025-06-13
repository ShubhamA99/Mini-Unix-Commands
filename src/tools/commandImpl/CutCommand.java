package tools.commandImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tools.InputReaderImpl.FileInputReader;
import tools.InputReaderImpl.ScanInputReader;
import tools.contract.BaseCommand;
import tools.contract.InputReader;
import tools.utils.Constants;
import tools.utils.Helper;

public class CutCommand implements BaseCommand {
	
	
	private List<Integer> columns;
	
	private InputReader inputReader;

	private String delimiter = "	";
	
	private final List<String> fileNames = new ArrayList<>();
	
	
	
	public CutCommand(String[] args) {

		this.columns = new ArrayList<Integer>();
		
		for(int i=1;i<args.length;i++) {
			
			String arg = args[i];
			
			if (arg.isBlank()) continue;
			
			parseArgument(arg);
		}
		
		if(fileNames.isEmpty()) {
			this.inputReader = new ScanInputReader();
		}else {
			this.inputReader = new FileInputReader(fileNames);
		}
		
	}
	
	
	void parseArgument(String value) {
		
		if(value.startsWith(Constants.LINE_MODE_HYPHEN_F)) {
			populatecolumneRange(value);
		}
		
		if(value.startsWith(Constants.LINE_MODE_HYPEN_D)) {
			extractDelimiter(value);
		}
		
		if (Helper.isValidFile(value)) {

			fileNames.add(value);

		}

	}
	
	
	void populatecolumneRange(String value) {
		
		String[] splittedArgument = value.split("");
		for(String alphabet : splittedArgument) {
			
			if(columns.size() < 2 && Helper.isInteger(alphabet)) {
				columns.add(Integer.parseInt(alphabet));
			}
		}
	}

	
	
	List<String> parseData(List<String> lines){
		
		List<String> response = new ArrayList<String>();
		
		for(String line : lines) {
			List<String> parsedValue = new ArrayList<String>();
			String[] splittedLine = line.split(delimiter);
			if(splittedLine.length > 0) {
				for(int index : columns) {
					String value = getValueforColumnIndex(splittedLine, index);
					parsedValue.add(value);
				}
			String joinedValue =	String.join(delimiter, parsedValue);
			response.add(joinedValue);
			}
		}
		
		return response;
	}
	
	
	String getValueforColumnIndex(String[]splittedLine , int index ) {
		if(index > splittedLine.length) {
			return "";
		}
		
		int arrayIndex =  index-1;
		
		return splittedLine[arrayIndex];
		
	}
	
	void extractDelimiter(String value){
		String[] splittedValue = value.split("");
		if(splittedValue.length<3) {
			this.delimiter = "";
			return;
		}
		
		this.delimiter = splittedValue[2];
		
		
	}
	
	@Override
	public List<String> performAction(String[] args) {
		
		System.out.println(Arrays.toString(args));
		List<String> output = new ArrayList<>();
		List<String> lines = inputReader.readInput();
		output = parseData(lines);
							
		return output;
		
	}

}
