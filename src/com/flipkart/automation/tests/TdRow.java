package com.flipkart.automation.tests;

import java.util.HashMap;

public class TdRow {
	
	HashMap<String, String> columns;
	
	void addValue(String header, String value){
		columns.put(header, value);
	}

}
