package com.uca.entity;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ImmeubleEntity {
	private String Nom;
	private String Adresse;
	private String Nom_Syndicat;
	private double PourcentageEstLoue;
	//private ArrayList<AppartementEntity> AllAppartement;

	public ImmeubleEntity(){
	//	ArrayList<AppartementEntity> AllAppartement = new ArrayList<AppartementEntity>();
		this.PourcentageEstLoue=0;
	}

	public String getNom(){
		return this.Nom;
	}
	public void setNom(String nom){
		this.Nom=nom;
	}
	public String getAdresse(){
		return this.Adresse;
	}
	public void setAdresse(String adresse){
		this.Adresse=adresse;
	}
	public String getNom_Syndicat(){
		return this.Nom_Syndicat;
	}
	public void setNom_Syndicat(String nom_syndicat){
		this.Nom_Syndicat=nom_syndicat;
	}
	public void setPourcentageEstLoue(double pourcentage){
		if(pourcentage>=0){
			this.PourcentageEstLoue=pourcentage;
		}
	}
	public double getPourcentageEstLoue(){
		return this.PourcentageEstLoue;
	}

	//public ArrayList<AppartementEntity> getAllAppartement(){
	//	return this.AllAppartement;
	//}
	//public void addAppartement(AppartementEntity appartement){
	//	this.AllAppartement.add(appartement);
	//}
	//public void clearAppartement(){
	//	this.AllAppartement.clear();
	//}


}
