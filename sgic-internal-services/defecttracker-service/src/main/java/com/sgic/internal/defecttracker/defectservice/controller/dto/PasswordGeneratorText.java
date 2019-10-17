package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.Arrays;
import java.util.List;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Service;

@Service
public class PasswordGeneratorText {
	
	public String generateRandomPassword() {

		List<CharacterRule> rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1),
				new CharacterRule(EnglishCharacterData.LowerCase, 1), new CharacterRule(EnglishCharacterData.Digit, 1),new CharacterRule(EnglishCharacterData.Special, 1));

		PasswordGenerator generator = new PasswordGenerator();
		String password = generator.generatePassword(10, rules);
		System.out.println("gvbjklukhdshkbjdbdfbdfbbkdf"+password);
		return password;
		
	}

	
}
