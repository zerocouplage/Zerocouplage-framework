package org.zerocouplage.clientcore.shared;

import com.google.gson.annotations.Expose;

public class MonBean {

	private final String className = this.getClass().getName();;
	  
  private final String nom;
  @Expose(serialize = false, deserialize = false)
  private final String prenom;
  @Expose(serialize = false)
  private final String adresse;
  @Expose(deserialize = false)
  private final String numero;
  public MonBean(final String champ1, final String champ2, 
    final String champ3, final String champ4) {
    super();
    this.nom = champ1;
    this.prenom = champ2;
    this.adresse = champ3;
    this.numero = champ4;
  }

  public String getNom() {
    return this.nom;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public String getAdresse() {
    return this.adresse;
  }

  public String getNumero() {
    return this.numero;
  }
  

  @Override
  public String toString() {
    return "MonObjet [nom=" + this.nom + ", prenom=" + this.prenom + ",adresse=" + this.adresse + ", numero=" + this.numero + "]";
  }

public String getClassName() {
	return className;
}
}