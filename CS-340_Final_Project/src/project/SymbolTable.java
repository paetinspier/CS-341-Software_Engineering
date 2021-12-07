package project;

import java.util.HashMap;
import java.util.Map;


public class SymbolTable {
	
	Map<String, String> table;
	
	public SymbolTable() {
		table = new HashMap<>();
		table.put("CHAR", null);
		table.put("BOOLEAN", null);
		table.put("INTEGER", null);
		table.put("TRUE", null);
		table.put("FALSE", null);
		table.put("DOUBLE", null);
		
	}

}
