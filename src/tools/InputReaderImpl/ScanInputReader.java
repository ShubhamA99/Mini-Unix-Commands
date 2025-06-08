package tools.InputReaderImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tools.contract.InputReader;

public class ScanInputReader implements InputReader  {

	@Override
	public List<String> readInput() {
		 Scanner scanner = new Scanner(System.in);
	        List<String> lines = new ArrayList<>();

	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            lines.add(line);
	        }

	        return lines;
	}

}
