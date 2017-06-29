package org.zerocouplage.tutorial.todomvc.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zerocouplage.tutorial.todomvc.beans.ListTodos;
import org.zerocouplage.tutorial.todomvc.beans.TodoBean;

public class TodoHandler {

	private List<TodoBean> listAllTodo;
	private String idSourceEvent;

	public String addTodo(TodoBean newTodo) {
		newTodo.setIndex(ListTodos.generateUniqueId());
		ListTodos.getAllTodos().add(newTodo);
		listAllTodo = ListTodos.getAllTodos();
		return "success";
	}

	public String filterForAllTodo() {

		listAllTodo = ListTodos.getAllTodos();
		return "success";
	}

	public String filterForActifTodo() {
		listAllTodo = new ArrayList<>();
		for (TodoBean todoBean : ListTodos.getAllTodos()) {
			if (!todoBean.isCompleted()) {
				listAllTodo.add(todoBean);
			}
		}
		return "success";
	}

	public String filterForCompletedTodo() {

		listAllTodo = new ArrayList<>();
		for (TodoBean todoBean : ListTodos.getAllTodos()) {
			if (todoBean.isCompleted()) {
				listAllTodo.add(todoBean);
			}
		}
		return "success";
	}

	public String clearAllTodo() {
		listAllTodo = new ArrayList<>();
		for (TodoBean todoBean : ListTodos.getAllTodos()) {
			if (todoBean.isCompleted()) {
				listAllTodo.add(todoBean);
			}
		}
		ListTodos.getAllTodos().removeAll(listAllTodo);
		listAllTodo = ListTodos.getAllTodos();
		return "success";
	}

	public List<TodoBean> getAllTodos() {
		return listAllTodo;
	}

	public String deleteTodo() {

		for (TodoBean todoBean : ListTodos.getAllTodos()) {
			if (("" + todoBean.getIndex()).equals(this.idSourceEvent)) {
				ListTodos.getAllTodos().remove(todoBean);
				break;
			}
		}

		listAllTodo = ListTodos.getAllTodos();
		return "success";
	}
	
	public String changeEtatTodo() {

		for (TodoBean todoBean : ListTodos.getAllTodos()) {
			if (("" + todoBean.getIndex()).equals(this.idSourceEvent)) {
				todoBean.setCompleted(!todoBean.isCompleted());
				break;
			}
		}

		listAllTodo = ListTodos.getAllTodos();
		return "success";
	}
	
	
	

	public String getIdSourceEvent() {
		return idSourceEvent;
	}

	public void setIdSourceEvent(String idSourceEvent) {
		this.idSourceEvent = idSourceEvent;
	}

}
