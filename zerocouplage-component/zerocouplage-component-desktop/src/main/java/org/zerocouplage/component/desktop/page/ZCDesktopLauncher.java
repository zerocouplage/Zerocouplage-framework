package org.zerocouplage.component.desktop.page;


/**
 * <p>
 * permet de faire abstraction des spécification des applications desktop (la méthode main)
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCDesktopLauncher {
	
	private static ZCFXApplication fxapp;
	
	public ZCDesktopLauncher(ZCFXApplication fxAPP) {
		
		fxapp=fxAPP;
		
	}

public static void main(String[] args) {
	
	ZCDesktopLauncher ZCDLauncher = new ZCDesktopLauncher(getFxapp());
}

public static ZCFXApplication getFxapp() {
	return fxapp;
}

public void setFxapp(ZCFXApplication fxapp) {
	this.fxapp = fxapp;
}
	

}
