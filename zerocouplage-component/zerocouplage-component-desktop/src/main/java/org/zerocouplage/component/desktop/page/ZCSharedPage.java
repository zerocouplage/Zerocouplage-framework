package org.zerocouplage.component.desktop.page;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;

import org.zerocouplage.component.api.page.ZCPage;
/**
 * <p>
 * ZCSharedPage is the common window for all components, it's instantiated 
 * on the first level.
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCSharedPage {

	private static ZCSharedPage INSTANCE;
	private ZCPageDesktop mainPage;
	private boolean isFirstStart = true;
	/**
	 * <p>
	 * constructor of the component
	 * </p>
	 * 
	 */
	private ZCSharedPage() {
	}
	/**
	 * <p>
	 * gets instance of the component
	 * </p>
	 * 
	 *@return instance 
	 */
	public static ZCSharedPage getINSTANCE() {
		if (INSTANCE == null) {
			INSTANCE = new ZCSharedPage();
		}
		return INSTANCE;
	}
	/**
	 * <p>
	 * gets mainPage of the component
	 * </p>
	 * 
	 *@return mainPage 
	 */
	public ZCPageDesktop getMainPage() throws Exception {

		return mainPage;
	}
	/**
	 * <p>
	 * Method draws our page over the first window that had already created
	 * </p>
	 * 
	 *@param currentPage
	 *@throws Exception
	 */
	public void drawPage(ZCPage currentPage) throws Exception {

		if (isFirstStart) {
			isFirstStart = false;
			String[] args = {};
			mainPage = (ZCPageDesktop) currentPage;
			ZCFXApplication zcApps = (ZCFXApplication) currentPage.display();
			zcApps.launch(zcApps.getClass(), args);
		}

		Group groupTmp = new Group();
		groupTmp.getChildren().addAll((Node) currentPage.getBody().display());
		ZCPageDesktop parent = getMainPage();
		(parent).getFxapp().setGroup(groupTmp);
		(parent).getFxapp()
				.getStage()
				.setScene(
						new Scene(((ZCPageDesktop) parent).getFxapp()
								.getGroup()));

	}

}
