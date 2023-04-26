package com.csv_to_json;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.json.CDL;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.JSONTokener;

//@SpringBootApplication
public class CsvToJsonApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CsvToJsonApplication.class, args);

		 InputStream inputStream = CsvToJsonApplication.class.getClassLoader().getResourceAsStream("G://input1.csv");
//	        String csvAsString = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
		 	String csvAsString = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
		 	String json = CDL.toJSONArray(csvAsString).toString();
	        try {
	            Files.write(Path.of("src/main/resources/output.json"), json.getBytes(StandardCharsets.UTF_8));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
