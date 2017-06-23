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
import org.zerocouplage.tutorial.todomvc.beans.ListTodos;
import org.zerocouplage.tutorial.todomvc.beans.TodoBean;

public class Index implements ZCView {

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
		layoutMain.addComponent(createZoneSaisi());
		layoutMain.addComponent(displayAllTodo());
		//layoutMain.addComponent(displayFooter());
		
		page.setTitle("Bienvenue");
		page.setBody(layoutMain);
		return page;

	}

	private ZCComponent displayFooter() {
		// TODO Auto-generated method stub
		return null;
	}

	private ZCComponent displayAllTodo() throws Exception {
		
		ZCFlowLayout layoutAllTodos = (ZCFlowLayout) ZCComponentFactory
				.newComponent(ZCFlowLayout.class);
		layoutAllTodos.setDirection(ZCFlowLayout.Y_DIRECTION);
		//layoutMain.setForm(true);
		
		
		for (TodoBean todoBean : listAllTodo) 
		{
			layoutAllTodos.addComponent(createLigneTodo(todoBean));	
		}
		
		return layoutAllTodos;
	}

	private ZCComponent createLigneTodo(TodoBean todoBean) throws Exception {

		ZCFlowLayout layoutOneTache = (ZCFlowLayout) ZCComponentFactory
				.newComponent(ZCFlowLayout.class);
		layoutOneTache.setDirection(ZCFlowLayout.X_DIRECTION);
		ZCStyle styleOfComponent = new ZCStyle();
		styleOfComponent.setColor("black");
		styleOfComponent.setWidth(200);

		ZCLabel labelOfLogin = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);
		labelOfLogin.setLabel(todoBean.getTache());
		labelOfLogin.setStyle(styleOfComponent);
		
		ZCCheckBox checkBoxTodo = (ZCCheckBox) ZCComponentFactory
		.newComponent(ZCCheckBox.class);
		
		checkBoxTodo.setName("todo");
		checkBoxTodo.setChecked(todoBean.isCompleted());
		checkBoxTodo.setStyle(styleOfComponent);
		
		layoutOneTache.addComponent(checkBoxTodo);
		layoutOneTache.addComponent(labelOfLogin);
		//layoutOneTache.addComponent(component);
		
		return labelOfLogin;
	}

	private ZCLayout createZoneSaisi() throws Exception {
		ZCFlowLayout layoutAddTache = (ZCFlowLayout) ZCComponentFactory
				.newComponent(ZCFlowLayout.class);
		ZCButton addTodoButton = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
	    tacheText = (ZCTextField) ZCComponentFactory
				.newComponent(ZCTextField.class);
		
		
		ZCStyle styleOfTextField = new ZCStyle();
		styleOfTextField.setWidth(200);
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
		layoutAddTache.setForm(true);
		
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
