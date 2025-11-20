package symboltable;

import java.util.*;
import ast.Definition;

public class SymbolTable {
	
	private int scope=0;
	private final List<Map<String,Definition>> table;
	public SymbolTable()  {
		table=new ArrayList<>();
		table.add(new HashMap<>());
	}

	public void set() {
		table.add(new HashMap<>());
		scope++;
	}
	
	public void reset() {
		if(scope>0){
			table.removeLast();
			scope--;
		}
	}
	
	public boolean insert(Definition definition) {
		if(table.get(scope).containsKey(definition.getName())) {
			return false;
		}
		definition.setScope(scope);
		table.get(scope).put(definition.getName(), definition);
		return true;
	}
	
	public Definition find(String id) {
		Definition d=table.get(scope).get(id);
		for(int i=scope;i>=0 && d==null;i--){
			d=table.get(i).get(id);
		}
		return d;
	}

	public Definition findInCurrentScope(String id) {
		return table.get(scope).get(id);
	}
}
