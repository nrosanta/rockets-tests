package com.testingfly.file.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCsvReader {

	public static void main(String[] args) {
		try {
			readCsv("src/test/resources/test.csv");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void readCsv(String fileName) throws IllegalStateException, FileNotFoundException {
		List<TestInput> beans = new CsvToBeanBuilder<TestInput>(new FileReader(fileName))
				.withType(TestInput.class).build().parse();
		Iterator<TestInput> itr = beans.iterator();
		Map<String, TestInput> dataMap = new HashMap<>();
		
		while(itr.hasNext()) {
			TestInput data = itr.next();
			dataMap.put(data.getEnvironment(), data);
		}
		
		System.out.println("Test Input:\n"+dataMap.get("DEV"));
	}

}
