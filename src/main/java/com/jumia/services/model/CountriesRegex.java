package com.jumia.services.model;

import java.util.HashMap;
import java.util.Map;

public class CountriesRegex {
	public Map<String, String> getRegexExpressions() {
		return populateRegexMap();
	}

	private Map<String, String> populateRegexMap() {
		Map<String, String> regexMap = new HashMap<>();
		regexMap.putIfAbsent("Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$");
		regexMap.putIfAbsent("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$");
		regexMap.putIfAbsent("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$");
		regexMap.putIfAbsent("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$");
		regexMap.putIfAbsent("Uganda", "\\(256\\)\\ ?\\d{9}$");
		return regexMap;
	}
}
