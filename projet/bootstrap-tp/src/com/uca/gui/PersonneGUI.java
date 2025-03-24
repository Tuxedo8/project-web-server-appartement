package com.uca.gui;

import com.uca.core.PersonneCore;
import com.uca.entity.PersonneEntity;
import com.uca.core.AppartementCore;
import com.uca.entity.AppartementEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class PersonneGUI {

    public static String getAllPersonne() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
	
	ArrayList<PersonneEntity> ListPersonne = PersonneCore.getAllPersonne();
	
	input.put("personne", ListPersonne);
        Writer output = new StringWriter();
	try {
         Template template = configuration.getTemplate("users/allpersonne.ftl");
	template.setOutputEncoding("UTF-8");
        template.process(input, output);
	} catch(Exception e) {
		System.out.println(e.toString());
	}
        return output.toString();
    }
    
    public static String getPersonne(String Adresse, int Numero, int Etage) throws IOException, TemplateException {

	    Configuration configuration = _FreeMarkerInitializer.getContext();

	    PersonneEntity newPersonne = new PersonneEntity();
	    newPersonne.setAdresse(Adresse);
	    newPersonne.setNumero(Numero);
	    newPersonne.setEtage(Etage);

	    AppartementEntity newAppartement = new AppartementEntity();
	    newAppartement.setAdresse(Adresse);
	    newAppartement.setNumero(Numero);
	    newAppartement.setEtage(Etage);


	    
		Map<String, Object> input = new HashMap<>();

		ArrayList<PersonneEntity> ListPersonne = PersonneCore.getPersonne(newPersonne);

		modifyAppartement(newPersonne, newAppartement, ListPersonne);
		
		input.put("personne", ListPersonne);
		Writer output = new StringWriter();
		Template template = configuration.getTemplate("users/personne.ftl");
		template.setOutputEncoding("UTF-8");
		template.process(input, output);

		return output.toString();

	}


	public static void createPersonne(String Nom, String Prenom, String Telephone, boolean Proprio, String Adresse, int Numero, int Etage) throws IOException, TemplateException {


	    PersonneEntity newPersonne = new PersonneEntity();
	    newPersonne.setNom(Nom);
	    newPersonne.setPrenom(Prenom);
	    newPersonne.setTelephone(Telephone);
	    newPersonne.setProprietaire(Proprio);
	    newPersonne.setAdresse(Adresse);
	    newPersonne.setNumero(Numero);
	    newPersonne.setEtage(Etage);


	    PersonneCore.createPersonne(newPersonne);	
	}
	public static void deletePersonne(String Telephone, String Prenom, String Nom) throws IOException, TemplateException {


	    PersonneEntity newPersonne = new PersonneEntity();
	    newPersonne.setNom(Nom);
	    newPersonne.setPrenom(Prenom);
	    newPersonne.setTelephone(Telephone);
	    
	    	    
	    PersonneCore.deletePersonne(newPersonne);	
	}
	private static void modifyAppartement(PersonneEntity newPersonne, AppartementEntity newAppartement, ArrayList<PersonneEntity> ListPersonne){
		for( int i=0; i<ListPersonne.size(); i++){
			if(AppartementCore.CheckEstLoue(newAppartement)==false){
				if(ListPersonne.get(i).getProprietaire() == false){
					newAppartement.setEstLoue(true);
					break;
				}
				
			}
			else {
				if(ListPersonne.get(i).getProprietaire()==true && i==ListPersonne.size()-1){
					newAppartement.setEstLoue(false);
					break;
				}
				else if(ListPersonne.get(i).getProprietaire() == false){
					newAppartement.setEstLoue(true);
					break;
				}

			}
		}
		AppartementCore.ChangeEstLoue(newAppartement);

	}




}
