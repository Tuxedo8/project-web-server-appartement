package com.uca.dao;
import com.uca.entity.AppartementEntity;
import java.sql.*;
import java.util.ArrayList;

public class AppartementDAO extends _Generic<AppartementEntity> {

    public ArrayList<AppartementEntity> getAllAppartement() {
        ArrayList<AppartementEntity> Appart = new ArrayList<AppartementEntity>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Appartement ORDER BY Adresse ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AppartementEntity entity = new AppartementEntity();
                entity.setEtage(resultSet.getInt("Etage"));
                entity.setNumero(resultSet.getInt("Numero"));
                entity.setSuperficie(resultSet.getInt("Superficie"));
                entity.setAdresse(resultSet.getString("Adresse"));
		entity.setEstLoue(resultSet.getBoolean("EstLoue"));

                Appart.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Appart;
    }
    public ArrayList<AppartementEntity> getAppartement(AppartementEntity obj) {
        ArrayList<AppartementEntity> Appart = new ArrayList<AppartementEntity>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Appartement Where Adresse=?;");
	
	    preparedStatement.setString(1, obj.getAdresse());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AppartementEntity entity = new AppartementEntity();
                entity.setEtage(resultSet.getInt("Etage"));
                entity.setNumero(resultSet.getInt("Numero"));
                entity.setSuperficie(resultSet.getInt("Superficie"));
                entity.setAdresse(resultSet.getString("Adresse"));
		entity.setEstLoue(resultSet.getBoolean("EstLoue"));

                Appart.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Appart;
    }
    public boolean CheckEstLoue(AppartementEntity obj){
	try{
		PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM APPARTEMENT WHERE Adresse=? AND Numero=? AND Etage=?;");
		preparedStatement.setString(1, obj.getAdresse());
		preparedStatement.setInt(2, obj.getNumero());
		preparedStatement.setInt(3, obj.getEtage());
		ResultSet resultSet = preparedStatement.executeQuery();

		if(resultSet.next()){
			return resultSet.getBoolean("EstLoue");

		}
	}
	catch (SQLException e) {
		e.printStackTrace(); 	
	}
	    	    
	return false;
    }


	public void ChangeEstLoue(AppartementEntity obj){
	    //System.out.println("Fonction Change EstLoue = "+ obj.getEstLoue());
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Appartement SET EstLoue=? WHERE Adresse=? AND Numero=? AND Etage=?;");

	    preparedStatement.setBoolean(1, obj.getEstLoue());
	    preparedStatement.setString(2, obj.getAdresse());
	    preparedStatement.setInt(3, obj.getNumero());
	    preparedStatement.setInt(4, obj.getEtage());
            preparedStatement.executeUpdate();
        
	    //System.out.println("Fonction Change = "+ obj.getEstLoue());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	public double PourcentageEstLoue(String Adresse){
		try{
			PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT CASE WHEN COUNT(*) > 0 THEN (SUM(CASE WHEN EstLoue = true THEN 1 ELSE 0 END) * 100.0 / COUNT(*)) ELSE 0 END AS PourcentageEstLoue FROM Appartement WHERE Adresse=?;");
			preparedStatement.setString(1, Adresse);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				return resultSet.getDouble("PourcentageEstLoue");

			}
		}
		catch (SQLException e) {
			e.printStackTrace(); 	
		}
			    
		return 0;
	}

 
    @Override
    public AppartementEntity create(AppartementEntity obj) {
       	try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Appartement (Etage, Adresse, Numero, Superficie, EstLoue) VALUES (?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, obj.getEtage());
            preparedStatement.setString(2, obj.getAdresse());
            preparedStatement.setInt(3, obj.getNumero());
            preparedStatement.setInt(4, obj.getSuperficie());
            preparedStatement.setBoolean(5, obj.getEstLoue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return null;
        }
    

    @Override
    public void delete(AppartementEntity obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Appartement WHERE Adresse=? AND Numero=? AND Etage=?");
            preparedStatement.setString(1, obj.getAdresse());
            preparedStatement.setInt(2, obj.getNumero());
	    preparedStatement.setInt(3, obj.getEtage());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            }
	}

    
}
