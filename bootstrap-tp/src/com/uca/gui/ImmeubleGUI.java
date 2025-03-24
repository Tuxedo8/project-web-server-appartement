package com.uca.gui;

import com.uca.core.ImmeubleCore;
import com.uca.entity.ImmeubleEntity;
import com.uca.core.SyndicatCore;
import com.uca.core.AppartementCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.sql.*;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ImmeubleGUI {

    public static String getAllImmeuble() throws IOException, TemplateException {
        try{
	Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

	ArrayList<ImmeubleEntity> ListImmeuble = ImmeubleCore.getAllImmeuble();

	for(int i=0; i<ListImmeuble.size(); i++){
		String Adresse = ListImmeuble.get(i).getAdresse();
		double newPourcentage = AppartementCore.PourcentageEstLoue(Adresse);
		ListImmeuble.get(i).setPourcentageEstLoue(newPourcentage);
		ImmeubleCore.ChangePourcentageEstLoue(Adresse, newPourcentage);
	}	

	

        input.put("immeuble", ListImmeuble);
        input.put("nom_syndicat", SyndicatCore.getNomSyndicat());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("users/immeuble.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
	} catch (IOException | TemplateException e) {
		    e.printStackTrace();
		    }
		return null;
	}

    public static void createImmeuble(String Nom, String Adresse, String Nom_Syndicat) throws IOException, TemplateException {


	    ImmeubleEntity newImmeuble = new ImmeubleEntity();
	    newImmeuble.setNom(Nom);
	    newImmeuble.setAdresse(Adresse);
	    newImmeuble.setNom_Syndicat(Nom_Syndicat);

	    ImmeubleCore.createImmeuble(newImmeuble);	
	}
    public static void deleteImmeuble(String Adresse) throws IOException, TemplateException {


	    ImmeubleEntity newImmeuble = new ImmeubleEntity();
	    newImmeuble.setAdresse(Adresse);
	    
	    
	    
	    ImmeubleCore.deleteImmeuble(newImmeuble);	
	}



}
