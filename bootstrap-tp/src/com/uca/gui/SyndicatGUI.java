package com.uca.gui;

import com.uca.core.SyndicatCore;
import com.uca.entity.SyndicatEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class SyndicatGUI {

    public static String getAllSyndicat() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("syndicat", SyndicatCore.getAllSyndicat());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("users/syndicat.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    /*
    public static String getNomSyndicat() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("nomsyndicat", SyndicatCore.getNomSyndicat());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("users/syndicat.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
	*/



        public static void createSyndicat(String Nom, String Adresse, String Telephone, String Mail, String Nom_Referent) throws IOException, TemplateException {


	    SyndicatEntity newSyndicat = new SyndicatEntity();
	    newSyndicat.setNom(Nom);
	    newSyndicat.setAdresse(Adresse);
	    newSyndicat.setTelephone(Telephone);
	    newSyndicat.setMail(Mail);
	    newSyndicat.setNom_Referent(Nom_Referent);

	    SyndicatCore.createSyndicat(newSyndicat);	
	}
	public static void deleteSyndicat(String Nom) throws IOException, TemplateException {


	    SyndicatEntity newSyndicat = new SyndicatEntity();
	    newSyndicat.setNom(Nom);
	    
	    SyndicatCore.deleteSyndicat(newSyndicat);	
	}


}
