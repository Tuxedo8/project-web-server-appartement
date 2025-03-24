package com.uca.entity;
import java.sql.Timestamp;

public class PersonneEntity{
	private String Nom;
	private String Prenom;
	private String Telephone;
	//private String Adresse;
	//private int Etage;
	//private int Numero;
	private boolean Proprietaire;
	private AppartementEntity Appartement;
	
	public PersonneEntity(){
		this.Appartement = new AppartementEntity();	
	}

	public String getNom(){
		return this.Nom;
	}
	public void setNom(String nom){
		this.Nom=nom;
	}

	public String getPrenom(){
		return this.Prenom;
	}
	public void setPrenom(String prenom){
		this.Prenom=prenom;
	}

	public String getTelephone(){
		return this.Telephone;
	}
	public void setTelephone(String telephone){
		this.Telephone=telephone;
	}

	public boolean getProprietaire(){
		return this.Proprietaire;
	}
	public void setProprietaire(boolean proprio){
		this.Proprietaire=proprio;
	}
	public String getAdresse(){
		return this.Appartement.getAdresse();
	}
	public void setAdresse(String adresse){
		this.Appartement.setAdresse(adresse);
	}	
	public int getEtage(){
		return this.Appartement.getEtage();
	}
	public void setEtage(int etage){
		this.Appartement.setEtage(etage);
	}
	public int getNumero(){
		return this.Appartement.getNumero();
	}
	public void setNumero(int numero){
		this.Appartement.setNumero(numero);
	}


	


}
