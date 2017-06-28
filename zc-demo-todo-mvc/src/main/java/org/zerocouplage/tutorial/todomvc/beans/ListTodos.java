package org.zerocouplage.tutorial.todomvc.beans;

import java.util.ArrayList;
import java.util.List;

public class ListTodos {
	
	private static List<TodoBean> allTodos = new ArrayList<TodoBean>();
	private static int sequenceID = 0;

	public static List<TodoBean> getAllTodos() {
		return allTodos;
	}

	public static void setAllTodos(List<TodoBean> allTodos) {
		ListTodos.allTodos = allTodos;
	}
	
	public static int generateUniqueId(){
		
		return sequenceID++;
	}

}
