package com.uca.core;
import com.uca.dao.UserDAO;
import com.uca.entity.UserEntity;
import java.util.ArrayList;

public class UserCore {
	public static ArrayList<UserEntity> getAllUser() {
		return new UserDAO().getAllUser();
	}
	public static UserEntity createUser(UserEntity user){
		return new UserDAO().create(user); 
	}
	public static void deleteUser(UserEntity user){
		new UserDAO().delete(user);
	}
	public static int CheckUser(String firstname, String lastname){
		return new UserDAO().CheckUser(firstname, lastname);
	}
	public static UserEntity getUserbyID(UserEntity id){
		return new UserDAO().getUserbyID(id);
	}




}
