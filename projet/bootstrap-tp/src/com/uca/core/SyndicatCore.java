package com.uca.core;
import com.uca.dao.SyndicatDAO;
import com.uca.entity.SyndicatEntity;
import java.util.ArrayList;

public class SyndicatCore {

	public static ArrayList<SyndicatEntity> getAllSyndicat() {
		return new SyndicatDAO().getAllSyndicat();
	}
	public static ArrayList<String> getNomSyndicat() {
		return new SyndicatDAO().getNomSyndicat();
	}		
	public static SyndicatEntity createSyndicat(SyndicatEntity syndicat){
		return new SyndicatDAO().create(syndicat); 
	}
	public static void deleteSyndicat(SyndicatEntity syndicat){
		new SyndicatDAO().delete(syndicat);
	}


}
