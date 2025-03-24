package com.uca.dao;

import com.uca.entity.ImmeubleEntity;
import com.uca.entity.AppartementEntity;
import java.sql.*;
import java.util.ArrayList;

public class ImmeubleDAO extends _Generic<ImmeubleEntity> {

    public ArrayList<ImmeubleEntity> getAllImmeuble() {
        ArrayList<ImmeubleEntity> Immeubles = new ArrayList<ImmeubleEntity>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Immeuble;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ImmeubleEntity entity = new ImmeubleEntity();
                entity.setNom(resultSet.getString("Nom"));
                entity.setAdresse(resultSet.getString("Adresse"));
                entity.setNom_Syndicat(resultSet.getString("NOM_SYNDICAT"));
		/*	
		PreparedStatement appartementStatement = this.connect.prepareStatement("SELECT * FROM Appartement WHERE Adresse=?");
		appartementStatement.setString(1, entity.getAdresse());
		ResultSet resultSetAppart = appartementStatement.executeQuery();

		while(resultSetAppart.next()){
		AppartementEntity Appart = new AppartementEntity();
			Appart.setEtage(resultSetAppart.getInt("Etage"));
			Appart.setNumero(resultSetAppart.getInt("Numero"));
			Appart.setSuperficie(resultSetAppart.getInt("Superficie"));
			Appart.setAdresse(resultSetAppart.getString("Adresse"));
			Appart.setEstLoue(resultSetAppart.getBoolean("EstLoue"));
			entity.addAppartement(Appart);
		}
		*/
                Immeubles.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Immeubles;
    }	
    public void ChangePourcentageEstLoue(String Adresse, double Pourcentage){
		try {
		    PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Immeuble SET PourcentageEstLoue=? WHERE Adresse=?;");


		    preparedStatement.setDouble(1, Pourcentage);
		    preparedStatement.setString(2, Adresse);
		    preparedStatement.executeUpdate();
		
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}


	@Override
	public ImmeubleEntity create(ImmeubleEntity obj) {
		
		try {

			PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO IMMEUBLE (Nom, Adresse, NOM_SYNDICAT) VALUES (?, ?, ?);");
			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getAdresse());
			preparedStatement.setString(3, obj.getNom_Syndicat());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public void delete(ImmeubleEntity obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Immeuble WHERE Adresse=?;");
            preparedStatement.setString(1, obj.getAdresse());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            }
	}

}
