package org.zerocouplage.component.desktop.component;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.zerocouplage.component.impl.component.ZCAbstractFile;

/**
 * <p>
 * ZCFileDesktop is the ZCFile component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCFileDesktop extends ZCAbstractFile {
	private Button buttonLoad = new Button("Browse...");
	private FileChooser fileChooser = new FileChooser();
	private TextField textF = new TextField("No file selected");
	private FlowPane flowFilchooser = new FlowPane();

	@Override
	public Object display() throws Exception {

		buttonLoad.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				fileChooser = new FileChooser();
				if (getFilter() == Filter_Video) {
					FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
							"Video Files ", "*.mp4,*.avi,*.flv,*.mpeg,*.3gp");
					fileChooser.getExtensionFilters().add(extFilter);
				}
				if (getFilter() == Filter_Audio) {
					FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
							"Audio Files ", "*.mp3,*.wav");
					fileChooser.getExtensionFilters().add(extFilter);
				}
				if (getFilter() == Filter_Image) {
					FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
							"Image Files ", "*.bmp,*.gif,*.jpge,*.png,*.jpg");
					fileChooser.getExtensionFilters().add(extFilter);
				}
				File file = fileChooser.showOpenDialog(new Stage());
				if (file == null) {
					textF.setText("No file selected");
				}
				else{
					textF.setText(file.toString());
				}
			}
		});

		flowFilchooser.setOrientation(Orientation.HORIZONTAL);
		flowFilchooser.getChildren().add(buttonLoad);
		flowFilchooser.getChildren().add(textF);
		textF.setEditable(false);
		textF.setStyle("-fx-text-fill:" + getStyle().getColor());

		return flowFilchooser;
	}

}
