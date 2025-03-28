package com.uca.gui;

import com.uca.core.UserCore;
import com.uca.entity.UserEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class AccueilGUI {

    public static String getAccueil(int ID) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

	UserEntity newUser = new UserEntity();
	newUser.setId(ID);
	input.put("user", UserCore.getUserbyID(newUser));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("users/index.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
