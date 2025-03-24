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

public class UserGUI {

	public static String getAllUser() throws IOException, TemplateException {
		Configuration configuration = _FreeMarkerInitializer.getContext();

		Map<String, Object> input = new HashMap<>();

		input.put("user", UserCore.getAllUser());

		Writer output = new StringWriter();
		Template template = configuration.getTemplate("users/user.ftl");
		template.setOutputEncoding("UTF-8");
		template.process(input, output);

		return output.toString();
	}
	public static int CheckUser(String firstname, String lastname) throws IOException, TemplateException {

	    return UserCore.CheckUser(firstname, lastname);	
	}

	public static void createUser(String firstname, String lastname) throws IOException, TemplateException {


	    UserEntity newUser = new UserEntity();
	    newUser.setFirstName(firstname);
	    newUser.setLastName(lastname);

	    UserCore.createUser(newUser);	
	}
	public static void deleteUser(int id) throws IOException, TemplateException {


	    UserEntity newUser = new UserEntity();
	    newUser.setId(id);

	    UserCore.deleteUser(newUser);	
	}


}
