package org.zerocouplage.clientcore.shared;

import com.google.gson.annotations.Expose;

public class MonObjet {

	
   private final String className = this.getClass().getName();;


  private final String champ1;
  @Expose(serialize = false, deserialize = false)
  private final String champ2;
  @Expose(serialize = false)
  private final String champ3;
  @Expose(deserialize = false)
  private final String champ4;
  public MonObjet(final String champ1, final String champ2, 
    final String champ3, final String champ4) {
    super();
    this.champ1 = champ1;
    this.champ2 = champ2;
    this.champ3 = champ3;
    this.champ4 = champ4;
  }

  public String getChamp1() {
    return this.champ1;
  }

  public String getChamp2() {
    return this.champ2;
  }

  public String getChamp3() {
    return this.champ3;
  }

  public String getChamp4() {
    return this.champ4;
  }

  
  
  
  @Override
  public String toString() {
    return "MonObjet [champ1=" + this.champ1 + ", champ2=" + this.champ2 + ",champ3=" + this.champ3 + ", champ4=" + this.champ4 + "]";
  }

public String getClassName() {
	return className;
}


}