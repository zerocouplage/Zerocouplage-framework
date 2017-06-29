package org.zerocouplage.tutorial.todomvc.views;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.zerocouplage.common.exceptions.ZCExceptionConfig;
import org.zerocouplage.component.api.component.ZCButton;
import org.zerocouplage.component.api.component.ZCCheckBox;
import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.api.component.ZCLabel;
import org.zerocouplage.component.api.component.ZCTextField;
import org.zerocouplage.component.api.exception.ZCCompNotFoundException;
import org.zerocouplage.component.api.layout.ZCFlowLayout;
import org.zerocouplage.component.api.layout.ZCLayout;
import org.zerocouplage.component.api.page.ZCPage;
import org.zerocouplage.component.api.view.ZCView;
import org.zerocouplage.component.common.ZCComponentFactory;
import org.zerocouplage.component.impl.style.ZCStyle;
import org.zerocouplage.tutorial.todomvc.beans.TodoBean;

public class Index implements ZCView { 
	
	public ZCCheckBox checkBoxTodo;


	ZCTextField tacheText = null;
	private List<TodoBean> listAllTodo;
	
	@Override
	public ZCPage display() throws IOException, ZCExceptionConfig, ZCCompNotFoundException, Exception {

		ZCPage page = (ZCPage) ZCComponentFactory.newComponent(ZCPage.class);
		page.setName("TodoMVC");
	
		
	
		ZCFlowLayout layoutMain = (ZCFlowLayout) ZCComponentFactory
				.newComponent(ZCFlowLayout.class);
		layoutMain.setDirection(ZCFlowLayout.Y_DIRECTION);
		layoutMain.setForm(true);
		
		ZCStyle styleOfComponent = new ZCStyle();
		styleOfComponent.setHeight(600);
	    layoutMain.setStyle(styleOfComponent);
		
		
		layoutMain.addComponent(createZoneSaisi());
		layoutMain.addComponent(displayAllTodo());
		layoutMain.addComponent(displayFooter());
		
		
		
		page.setTitle("Bienvenue dans TODO MVC DEMO");
		page.setBody(layoutMain);
		return page;

	}

	private ZCComponent displayFooter() throws Exception {
		
		ZCFlowLayout layoutFooter = (ZCFlowLayout) ZCComponentFactory
				.newComponent(ZCFlowLayout.class);
		layoutFooter.setDirection(ZCFlowLayout.X_DIRECTION);
		
		
		ZCButton allTodoButton = createButton("All", "allTodo", 50);
		ZCButton actifTodoButton = createButton("Actif", "actifTodo", 60);
		ZCButton completedTodoButton = createButton("Completed", "completedTodo", 120);
		ZCButton clearAllTodoButton = createButton("Clear", "clearAllTodo", 60);
		
		layoutFooter.addComponent(allTodoButton);
		layoutFooter.addComponent(actifTodoButton);
		layoutFooter.addComponent(completedTodoButton);
		layoutFooter.addComponent(clearAllTodoButton);
		
		
		return layoutFooter;
	}

	private ZCButton createButton(String textButton, String action, int withd) throws Exception {
		ZCButton deletButton = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
		ZCStyle styleOfButton = new ZCStyle();
		styleOfButton.setWidth(withd);
		styleOfButton.setColor("black");
		deletButton.setText(textButton);
		deletButton.setAction(action, this);
		deletButton.setStyle(styleOfButton);
		return deletButton;
	}

	private ZCComponent displayAllTodo() throws Exception {
		
		ZCFlowLayout layoutAllTodos = (ZCFlowLayout) ZCComponentFactory
				.newComponent(ZCFlowLayout.class);
		layoutAllTodos.setDirection(ZCFlowLayout.Y_DIRECTION);
		if(listAllTodo != null)
		{
			int currentPosition = 0;
			for (TodoBean todoBean : listAllTodo) 
			{
				todoBean.setIndex(currentPosition);
				layoutAllTodos.addComponent(createLigneTodo(todoBean, currentPosition++));	
			}	
		}
		return layoutAllTodos;
	}

	
	/*
	 * 
	 * 
	 * */
	
	private ZCComponent createLigneTodo(TodoBean todoBean, int currentPosition) throws Exception {

		ZCFlowLayout layoutOneTache = (ZCFlowLayout) ZCComponentFactory
				.newComponent(ZCFlowLayout.class);
		layoutOneTache.setDirection(ZCFlowLayout.X_DIRECTION);
		
		ZCStyle styleOfLabel = new ZCStyle();
		styleOfLabel.setWidth(340);
		if(todoBean.isCompleted())
		{
			styleOfLabel.setColor("green");
		}
		else
		{
			styleOfLabel.setColor("blue");
		}
		
		
		ZCLabel labelOfTache = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);
		labelOfTache.setLabel(todoBean.getTache());
		labelOfTache.setStyle(styleOfLabel);
		
		checkBoxTodo = (ZCCheckBox) ZCComponentFactory
		.newComponent(ZCCheckBox.class);
		
		checkBoxTodo.setName(""+todoBean.getIndex());
		checkBoxTodo.setAction("changeEtatTodo", this);
		checkBoxTodo.setChecked(todoBean.isCompleted());
		
		ZCButton deletButton = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
		
		ZCStyle styleOfButton = new ZCStyle();
		styleOfButton.setWidth(27);
		styleOfButton.setColor("black");
		deletButton.setName(""+todoBean.getIndex());
		deletButton.setText("X");
		deletButton.setAction("deleteTodo", this);
		deletButton.setStyle(styleOfButton);
		
		if(currentPosition % 2 == 0)
		{
			ZCStyle styleOfLayoutOneTache = new ZCStyle();
			styleOfLayoutOneTache.setColor("#d5e1df");
			layoutOneTache.setStyle(styleOfLayoutOneTache);
		}
		
		layoutOneTache.addComponent(checkBoxTodo);
		layoutOneTache.addComponent(labelOfTache);
		layoutOneTache.addComponent(deletButton);
		
		return layoutOneTache;
	}

	private ZCLayout createZoneSaisi() throws Exception {
		ZCFlowLayout layoutAddTache = (ZCFlowLayout) ZCComponentFactory
				.newComponent(ZCFlowLayout.class);
		ZCButton addTodoButton = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
	    tacheText = (ZCTextField) ZCComponentFactory
				.newComponent(ZCTextField.class);
		
		ZCStyle styleOfTextField = new ZCStyle();
		styleOfTextField.setWidth(310);
		styleOfTextField.setColor("black");
		
		ZCStyle styleOfButton = new ZCStyle();
		styleOfButton.setWidth(50);
		styleOfButton.setColor("black");
		
		tacheText.setName("tache");
		tacheText.setStyle(styleOfTextField);
	
		addTodoButton.setText("Add");
		addTodoButton.setAction("addNewTodo", this);
		addTodoButton.setStyle(styleOfButton);
		
		layoutAddTache.setDirection(ZCFlowLayout.X_DIRECTION); 
		layoutAddTache.addComponent(tacheText);
		layoutAddTache.addComponent(addTodoButton);
		
		return layoutAddTache;
	}

	public String getTache() {
		return tacheText.getText();
	}

	
	public void setAllTodos(List<TodoBean> listAllTodo)
	{
		this.listAllTodo = listAllTodo;
	}
	
	public void processError(HashMap<String, String> listError) {

	}

}
