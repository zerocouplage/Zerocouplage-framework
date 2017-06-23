package org.zerocouplage.tutorial.todomvc.action;

import java.util.List;

import org.zerocouplage.tutorial.todomvc.beans.ListTodos;
import org.zerocouplage.tutorial.todomvc.beans.TodoBean;

public class TodoHandler {

	
	private List<TodoBean> listAllTodo;
	
	public String addTodo(TodoBean newTodo)
	{
		ListTodos.getAllTodos().add(newTodo);
		
		listAllTodo = ListTodos.getAllTodos();
		return "success";
	}

	public List<TodoBean> getAllTodos() {
		return listAllTodo;
	}

}
