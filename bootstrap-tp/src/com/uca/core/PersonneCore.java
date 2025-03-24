package com.uca.core;
import com.uca.dao.PersonneDAO;
import com.uca.entity.PersonneEntity;
import java.util.ArrayList;

public class PersonneCore {
	public static ArrayList<PersonneEntity> getAllPersonne() {
		return new PersonneDAO().getAllPersonne();
	}
	public static PersonneEntity createPersonne(PersonneEntity personne){
		return new PersonneDAO().create(personne); 
	}
	public static void deletePersonne(PersonneEntity personne){
		new PersonneDAO().delete(personne);
	}
	public static ArrayList<PersonneEntity> getPersonne(PersonneEntity personne) {
		return new PersonneDAO().getPersonne(personne);
	}


}
