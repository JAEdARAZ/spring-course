package com.springdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private ArrayList<String> fortunesList = new ArrayList<String>();
	private Random rand = new Random();
	
	@Override
	public String getFortune() {
		return fortunesList.get(rand.nextInt(fortunesList.size()));
	}
	
	@PostConstruct
	public void fillFortuneArray() {
		
		Path path = Paths.get("src/fortunes.txt");
		try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> fortunesList.add(s));
        } catch (IOException ex) {
        	System.out.println(ex.getMessage());
        }
		
	}

}
