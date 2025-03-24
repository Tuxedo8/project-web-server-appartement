package com.uca.dao;
import com.uca.entity.SyndicatEntity;
import java.sql.*;
import java.util.ArrayList;

public class SyndicatDAO extends _Generic<SyndicatEntity> {

    public ArrayList<SyndicatEntity> getAllSyndicat() {
        ArrayList<SyndicatEntity> syndicat = new ArrayList<SyndicatEntity>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Syndicat ORDER BY Nom ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SyndicatEntity entity = new SyndicatEntity();
                entity.setNom(resultSet.getString("Nom"));
                entity.setAdresse(resultSet.getString("Adresse"));
                entity.setNom_Referent(resultSet.getString("Nom_Referent"));
                entity.setTelephone(resultSet.getString("Telephone"));
                entity.setMail(resultSet.getString("Mail"));

                syndicat.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return syndicat;
    }
    public ArrayList<String> getNomSyndicat() {
        ArrayList<String> syndicat = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Syndicat Nom;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String entity = "";
                entity=resultSet.getString("Nom");
                
                syndicat.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return syndicat;
    }


    @Override
    public SyndicatEntity create(SyndicatEntity obj) {

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Syndicat (Nom, Adresse, Nom_Referent, Telephone, Mail) VALUES (?, ?, ?, ?, ?);");
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getAdresse());
            preparedStatement.setString(3, obj.getNom_Referent());
            preparedStatement.setString(4, obj.getTelephone());
            preparedStatement.setString(5, obj.getMail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return null;
        }

    @Override
    public void delete(SyndicatEntity obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Syndicat WHERE Nom=?;");
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            }
        }
}
