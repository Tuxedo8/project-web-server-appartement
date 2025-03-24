package com.uca.core;
import com.uca.dao.AppartementDAO;
import com.uca.entity.AppartementEntity;
import java.util.ArrayList;

public class AppartementCore {

	public static ArrayList<AppartementEntity> getAllAppartement() {
		return new AppartementDAO().getAllAppartement();
	}
	public static AppartementEntity createAppartement(AppartementEntity appartement){
		return new AppartementDAO().create(appartement); 
	}
	public static void deleteAppartement(AppartementEntity appartement){
		new AppartementDAO().delete(appartement);
	}
	public static ArrayList<AppartementEntity> getAppartement(AppartementEntity appartement){
		return new AppartementDAO().getAppartement(appartement);
	}
	public static void ChangeEstLoue(AppartementEntity appartement){
		new AppartementDAO().ChangeEstLoue(appartement);
	}
	public static boolean CheckEstLoue(AppartementEntity appartement){
		return new AppartementDAO().CheckEstLoue(appartement);
	}	
	public static double PourcentageEstLoue(String adresse){
		return new AppartementDAO().PourcentageEstLoue(adresse);

	}
}
