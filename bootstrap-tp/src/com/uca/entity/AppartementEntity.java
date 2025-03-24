package com.uca.entity;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AppartementEntity {
	private int Etage;
	private int Numero;
	private int Superficie;
	//private String Adresse;
	private boolean EstLoue;
	private ImmeubleEntity Immeuble;

	public AppartementEntity(){
		this.Immeuble = new ImmeubleEntity();
		this.EstLoue=false;
	}

	public int getEtage(){
		return this.Etage;
	}
	public void setEtage(int etage){
		this.Etage=etage;
	}
	public int getNumero(){
		return this.Numero;
	}
	public void setNumero(int numero){
		this.Numero=numero;
	}
	public int getSuperficie(){
		return this.Superficie;
	}
	public void setSuperficie(int superficie){
		this.Superficie=superficie;
	}
	public boolean getEstLoue(){
		return this.EstLoue;
	}
	public void setEstLoue(boolean flag){
		this.EstLoue=flag;
	}
	public String getAdresse(){
		return this.Immeuble.getAdresse();
	}
	public void setAdresse(String adresse){
		this.Immeuble.setAdresse(adresse);
	}

}
