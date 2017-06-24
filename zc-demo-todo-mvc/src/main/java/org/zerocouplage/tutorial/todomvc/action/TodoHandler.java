package org.zerocouplage.tutorial.todomvc.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zerocouplage.component.api.component.ZCButton;
import org.zerocouplage.tutorial.todomvc.beans.ListTodos;
import org.zerocouplage.tutorial.todomvc.beans.TodoBean;

public class TodoHandler {

	
	private List<TodoBean> listAllTodo;
	
	public String addTodo(TodoBean newTodo)
	{
		
		newTodo.setCompleted((new Date().getTime() % 2) ==1);
		
		
		ListTodos.getAllTodos().add(newTodo);
		
		listAllTodo = ListTodos.getAllTodos();
		return "success";
	}

	
	public String filterForAllTodo()
	{
		
		listAllTodo = ListTodos.getAllTodos();
		return "success";
	}
	
	public String filterForActifTodo()
	{
		listAllTodo = new ArrayList<>();
		for (TodoBean todoBean : ListTodos.getAllTodos())
		{
			if(!todoBean.isCompleted())
			{
				listAllTodo.add(todoBean);
			}
		}
		return "success";
	}
	
	
	public String filterForCompletedTodo()
	{
		
		listAllTodo = new ArrayList<>();
		for (TodoBean todoBean : ListTodos.getAllTodos())
		{
			if(todoBean.isCompleted())
			{
				listAllTodo.add(todoBean);
			}
		}
		return "success";
	}
	
	public String clearAllTodo()
	{
		ListTodos.getAllTodos().clear();
		return "success";
	}

		
		
		
	public List<TodoBean> getAllTodos() {
		return listAllTodo;
	}

}
