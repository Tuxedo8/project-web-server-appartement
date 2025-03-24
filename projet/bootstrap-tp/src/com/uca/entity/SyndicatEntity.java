package com.uca.entity;
import java.sql.Timestamp;

public class SyndicatEntity {
	private String Nom;
	private String Adresse;
	private String Nom_Referent;
	private String Telephone;
	private String Mail;


	public SyndicatEntity(){
	
	}

	public String getNom(){
		return this.Nom;
	}
	public String getAdresse(){
		return this.Adresse;
	}

	public String getNom_Referent(){
		return this.Nom_Referent;
	}
	public String getTelephone(){
		return this.Telephone;
	}
	public String getMail(){
		return this.Mail;
	}
	public void setNom(String nom){
		this.Nom=nom;
	}
	public void setAdresse(String adresse){
		this.Adresse=adresse;
	}

	public void setNom_Referent(String nom_personne){
		this.Nom_Referent=nom_personne;
	}
	public void setTelephone(String telephone){
		this.Telephone=telephone;
	}
	public void setMail(String mail){
		this.Mail=mail;
	}


	
}
