package com.uca.core;
import com.uca.dao.ImmeubleDAO;
import com.uca.entity.ImmeubleEntity;
import java.util.ArrayList;

public class ImmeubleCore {

	public static ArrayList<ImmeubleEntity> getAllImmeuble() {
		return new ImmeubleDAO().getAllImmeuble();
	}	
	public static ImmeubleEntity createImmeuble(ImmeubleEntity immeuble){
		return new ImmeubleDAO().create(immeuble); 
	}
	public static void deleteImmeuble(ImmeubleEntity immeuble){
		new ImmeubleDAO().delete(immeuble);
	}
	public static void ChangePourcentageEstLoue(String adresse, double pourcentage){
		new ImmeubleDAO().ChangePourcentageEstLoue(adresse, pourcentage);
	}


}
