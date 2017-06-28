package org.zerocouplage.tutorial.todomvc.beans;


public class TodoBean {
	
	public int index;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	private String tache;
	private boolean isCompleted;
	
	
	public String getTache() {
		return tache;
	}
	public void setTache(String tache) {
		this.tache = tache;
	}
	public boolean isCompleted() {
		return isCompleted;
	} 
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	

}
