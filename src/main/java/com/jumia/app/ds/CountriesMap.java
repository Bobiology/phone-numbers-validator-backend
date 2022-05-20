package com.jumia.app.ds;

import java.util.HashMap;
import java.util.Map;

public class CountriesMap {
	public Map<Integer, String> getCountries() {
		
		return addCountriesToMap();
	}
	public Map<Integer, String> addCountriesToMap(){
		Map<Integer, String> countries = new HashMap<>();
		countries.putIfAbsent(237, "Cameroon");
		countries.putIfAbsent(251, "Ethiopia");
		countries.putIfAbsent(212, "Morocco");
		countries.putIfAbsent(258, "Mozambique");
		countries.putIfAbsent(256, "Uganda");
		
		return countries;
	}

}
