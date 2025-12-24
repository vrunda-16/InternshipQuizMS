package com.app.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.app.model.Question;

public class QuestionFileParser {
	
	public static List<Question> parse(File file) throws Exception{
		List<Question> questionList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line , question = null , optionA = null , optionB = null , optionC = null , optionD = null ;
		char answer = 0 ;
		
		while (((line = br.readLine()) != null)) {
			line = line.trim();
			if(question == null && line.isEmpty() == false) {
				question = line;
			}
			else if(line.matches("[A-D][).].*")){
				char ch = line.charAt(0);
				String value = line.substring(2).trim();
				if(ch == 'A')
					optionA = value;
				if(ch == 'B')
					optionB = value;
				if(ch == 'C')
					optionC = value;
				if(ch == 'D')
					optionD = value;
			}
			else if(line.startsWith("Answer:")) {
				answer = line.charAt(7);
			}
			else if(line.isEmpty() || (line = br.readLine()) == null ) {
				if(question != null) {
					questionList.add(new Question(0 ,question, optionA, optionB, optionC, optionD, answer));
				}
				question=optionA=optionB=optionC=optionD = null ;
				answer = 0 ;
				continue;
			}
		}
		br.close();
		return questionList;
	}
}
