package com.uca.dao;

import com.uca.entity.UserEntity;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO extends _Generic<UserEntity> {

    public ArrayList<UserEntity> getAllUser() {
        ArrayList<UserEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM USER ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserEntity entity = new UserEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));

                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }
    public int CheckUser(String firstname, String lastname){
		
	try{
		PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM USER WHERE firstname=? AND lastname=?;");
		preparedStatement.setString(1, firstname);
		preparedStatement.setString(2, lastname);
		ResultSet resultSet = preparedStatement.executeQuery();

		if(resultSet.next()){

		return resultSet.getInt("id");

		}
	}
	catch (SQLException e) {
		e.printStackTrace(); 	
	}
	    	    
	return -1;
    }
    public UserEntity getUserbyID(UserEntity obj) {
	
	UserEntity entity = new UserEntity();
	    try {

	    PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM USER WHERE ID=? LIMIT 1;");
	    preparedStatement.setInt(1, obj.getId());
	    ResultSet resultSet = preparedStatement.executeQuery();
		
	    	if(resultSet.next()){

			entity.setFirstName(resultSet.getString("firstname"));
			entity.setLastName(resultSet.getString("lastname"));


			//return entity;
			
		}
	} catch (SQLException e) {
		e.printStackTrace(); 
	}
	return entity;
    }


    @Override
    public UserEntity create(UserEntity obj) {
	try {
	    PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO USER (firstname, lastname) VALUES(?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
	    preparedStatement.setString(1, obj.getFirstName());
	    preparedStatement.setString(2, obj.getLastName());
	    preparedStatement.executeUpdate();

	    ResultSet resultSet = preparedStatement.getGeneratedKeys();
	    if(resultSet.next()) {
		obj.setId(resultSet.getInt(1));
		return obj;
	    }

	} catch (Exception e) {
	    System.out.println(e);
	}
	return null;
    }

    @Override
    public void delete(UserEntity obj) {
        try {
		
	PreparedStatement preparedStatement = this.connect.prepareStatement( "DELETE FROM USER WHERE id= ?");
	preparedStatement.setInt(1, obj.getId());
	preparedStatement.executeUpdate();
	} catch (Exception e) {
		    System.out.println(e);
	}
    }
}
