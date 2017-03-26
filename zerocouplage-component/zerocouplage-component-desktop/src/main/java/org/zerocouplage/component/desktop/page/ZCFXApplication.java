package org.zerocouplage.component.desktop.page;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * <p>Method used to verify the JavaFX heritage from Application Class </p>
 * @author Taoufik RIFAI
 */
public class ZCFXApplication extends Application {

	

	private static String title;
	private static Object layout;
	private static Stage stage;
	private Group group ;
	public Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		ZCFXApplication.stage = stage;
	}

	public void start(Stage stage) throws Exception {
		
		ZCFXApplication.stage= stage;
		group = new Group();
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

		double screenW = primaryScreenBounds.getWidth();
		double screenH = primaryScreenBounds.getHeight();
		double x = screenW / 2;
		double y = screenH / 2;

		ZCFXApplication.stage.setX((screenW - x) / 2);
		ZCFXApplication.stage.setY((screenH - y) / 2);
		group.getChildren().add((Node) ZCFXApplication.getLayout());
		if (getTitle() != null) {
			ZCFXApplication.stage.setTitle(getTitle());
		}
		ZCFXApplication.stage.setScene(new Scene(group));
		ZCFXApplication.stage.sizeToScene();
		ZCFXApplication.stage.show();
		Platform.setImplicitExit(false);
		ZCFXApplication.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    public void handle(WindowEvent event) {
		    System.exit(1);
		    }
		});
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public static void draw(String[] argument) {
		launch(argument);
	}

	public static Object getLayout() {
		return layout;
	}

	public void setLayout(Object layout) {
		ZCFXApplication.layout = layout;
	}

	public static String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		ZCFXApplication.title = title;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
