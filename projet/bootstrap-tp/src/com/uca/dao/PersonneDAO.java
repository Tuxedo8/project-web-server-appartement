package com.uca.dao;
import com.uca.entity.PersonneEntity;
import java.sql.*;
import java.util.ArrayList;

public class PersonneDAO extends _Generic<PersonneEntity>{
	public ArrayList<PersonneEntity> getAllPersonne() {
        ArrayList<PersonneEntity> entities = new ArrayList<>();
		try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM PERSONNE;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
        	PersonneEntity entity = new PersonneEntity();
                entity.setNom(resultSet.getString("Nom"));
                entity.setPrenom(resultSet.getString("Prenom"));
                entity.setTelephone(resultSet.getString("Telephone"));
                entity.setProprietaire(resultSet.getBoolean("Proprietaire"));
		entity.setAdresse(resultSet.getString("Adresse"));
		entity.setEtage(resultSet.getInt("Etage"));
                entity.setNumero(resultSet.getInt("Numero"));

                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }
    public ArrayList<PersonneEntity> getPersonne(PersonneEntity obj) {
        ArrayList<PersonneEntity> Perso = new ArrayList<PersonneEntity>();
	
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Personne Where Adresse=? AND Numero=? AND Etage=?;");
	
	    preparedStatement.setString(1, obj.getAdresse());
	    preparedStatement.setInt(2, obj.getNumero());
	    preparedStatement.setInt(3, obj.getEtage());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PersonneEntity entity = new PersonneEntity();
                entity.setEtage(resultSet.getInt("Etage"));
                entity.setNumero(resultSet.getInt("Numero"));
                entity.setAdresse(resultSet.getString("Adresse"));
		entity.setNom(resultSet.getString("Nom"));
                entity.setPrenom(resultSet.getString("Prenom"));
                entity.setTelephone(resultSet.getString("Telephone"));
                entity.setProprietaire(resultSet.getBoolean("Proprietaire"));


                Perso.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Perso;
    }

	
	@Override
	public PersonneEntity create(PersonneEntity obj) {
	
		try {
		    PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO PERSONNE (Nom, Prenom, Telephone, Proprietaire, Adresse, Numero, Etage) VALUES (?, ?, ?, ?, ?, ?, ?);");
		    preparedStatement.setString(1, obj.getNom());
		    preparedStatement.setString(2, obj.getPrenom());
		    preparedStatement.setString(3, obj.getTelephone());
		    preparedStatement.setBoolean(4, obj.getProprietaire());
		    preparedStatement.setString(5, obj.getAdresse());
		    preparedStatement.setInt(6, obj.getNumero());
		    preparedStatement.setInt(7, obj.getEtage());

		    preparedStatement.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		    }
		return null;
	}

	@Override
	public void delete(PersonneEntity obj) {
	 try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM PERSONNE WHERE Telephone=? AND Nom=? AND Prenom=?;");
            preparedStatement.setString(1, obj.getTelephone());
            preparedStatement.setString(2, obj.getNom());
            preparedStatement.setString(3, obj.getPrenom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            }
	}
}
