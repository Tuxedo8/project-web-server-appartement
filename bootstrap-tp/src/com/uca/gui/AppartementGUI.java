package com.uca.gui;

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

public class AppartementGUI {

	public static String getAllAppartement() throws IOException, TemplateException {
		Configuration configuration = _FreeMarkerInitializer.getContext();

		Map<String, Object> input = new HashMap<>();

		input.put("allappartement", AppartementCore.getAllAppartement());

		Writer output = new StringWriter();
		Template template = configuration.getTemplate("users/allappartement.ftl");
		template.setOutputEncoding("UTF-8");
		template.process(input, output);

		return output.toString();
	}
	public static String getAppartement(String Adresse) throws IOException, TemplateException {

	    Configuration configuration = _FreeMarkerInitializer.getContext();

	    AppartementEntity newAppartement = new AppartementEntity();
	    newAppartement.setAdresse(Adresse);
	    
		Map<String, Object> input = new HashMap<>();

		input.put("appartement", AppartementCore.getAppartement(newAppartement));
		Writer output = new StringWriter();
		Template template = configuration.getTemplate("users/appartement.ftl");
		template.setOutputEncoding("UTF-8");
		template.process(input, output);

		return output.toString();

	}


	public static void createAppartement(String Adresse, int Etage, int Numero, int Superficie) throws IOException, TemplateException {


	    AppartementEntity newAppartement = new AppartementEntity();
	    newAppartement.setAdresse(Adresse);
	    newAppartement.setEtage(Etage);
	    newAppartement.setNumero(Numero);
	    newAppartement.setSuperficie(Superficie);

	    AppartementCore.createAppartement(newAppartement);	
	}
	public static void deleteAppartement(String Adresse, int Numero, int Etage) throws IOException, TemplateException {


	    AppartementEntity newAppartement = new AppartementEntity();
	    newAppartement.setAdresse(Adresse);
	    newAppartement.setNumero(Numero);
	    newAppartement.setEtage(Etage);

	    
	    
	    
	    AppartementCore.deleteAppartement(newAppartement);	
	}



}
