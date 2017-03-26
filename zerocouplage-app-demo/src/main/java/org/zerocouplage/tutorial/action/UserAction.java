package org.zerocouplage.tutorial.action;

import java.io.File;

import org.zerocouplage.tutorial.beans.UserBeanIn;
import org.zerocouplage.tutorial.beans.UserBeanOut;

public class UserAction {

	UserBeanOut beanResult;

	private File photoFile;
	public UserBeanOut getBeanResult() {
		return beanResult;
	}

	public void setBeanResult(UserBeanOut beanResult) {
		this.beanResult = beanResult;
	}

	public String traiterUser(UserBeanIn userIn) {
		String R;
		beanResult = new UserBeanOut();
		if("admin".equals(userIn.getNomUtilisateur()) && "admin".equals(userIn.getMotDepasse())){
			beanResult.setLogin(userIn.getNomUtilisateur());
			R="PageResultat";
			System.out.println("succes");
		}
		else{
			R="echec";
			System.out.println("fail");
		}

		
		return R;

	}
	public String process(UserBeanIn in) {
		beanResult = new UserBeanOut();
		beanResult.setLogin(in.getNomUtilisateur());
		beanResult.setPassword(in.getMotDepasse());
		beanResult.setEmail(in.getMail());
		beanResult.setDateNaissance(in.getDatN());


		return "success";
	}
	
	//
	public String download(UserBeanIn in) {
		photoFile = new File("C:\\Users\\Belkheir\\Desktop\\Test\\S6.pdf");
		return "success";
	}

	public String upload(UserBeanIn in) {
		
		File folderOfUpload=new File("./"+in.getNomUtilisateur());
		
		folderOfUpload.mkdirs();
		
		copyfileTofolder(in.getCvFile(), folderOfUpload);
		return "success";
	}
	
	
	private void copyfileTofolder(File cvFile, File folderOfUpload) {

      System.out.println("copy de " +cvFile.getAbsolutePath()+" à "+folderOfUpload.getAbsolutePath());
		
	}

	public File getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(File photoFile) {
		this.photoFile = photoFile;
	}
	
	
	
	
}
