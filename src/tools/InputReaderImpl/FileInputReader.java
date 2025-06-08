package tools.InputReaderImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tools.contract.InputReader;

public class FileInputReader implements InputReader {
	
	
	private List<String> fileNames;
	
	
	
	public List<String> getFileNames() {
		return fileNames;
	}

	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}

	public FileInputReader(List<String> fileNames) {
		this.fileNames = fileNames;
	}

	@Override
	public List<String> readInput() {
		
		List<String> allLines = new ArrayList<>();

        for (String fileName : fileNames) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    allLines.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to read file: " + fileName, e);
            }
        }

        return allLines;
	}

}
