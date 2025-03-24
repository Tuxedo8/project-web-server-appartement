package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;

            //Init articles table
		 statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS User (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
		statement.executeUpdate();


		statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Syndicat (Nom varchar(100) PRIMARY KEY, Adresse varchar(100), Nom_Referent varchar(100), Telephone varchar(100), Mail varchar(100)); ");
		statement.executeUpdate();

		statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Immeuble (Nom varchar(100), Adresse varchar(100) PRIMARY KEY, PourcentageEstLoue DOUBLE DEFAULT 0, NOM_SYNDICAT varchar(100), FOREIGN KEY (NOM_SYNDICAT) REFERENCES Syndicat(Nom)); ");
		statement.executeUpdate();

		statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Appartement (Adresse varchar(100), Etage INT, Numero INT, Superficie INT, EstLoue BOOLEAN, PRIMARY KEY (Adresse, Numero, Etage), FOREIGN KEY (Adresse) REFERENCES Immeuble(Adresse) ON DELETE CASCADE); ");
		statement.executeUpdate();

		statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Personne (Nom varchar(100), Prenom varchar(100), Telephone varchar(100) PRIMARY KEY, Proprietaire BOOLEAN, Adresse varchar(100), Numero INT, Etage INT, FOREIGN KEY (Adresse, Numero, Etage) REFERENCES Appartement(Adresse, Numero, Etage) ON DELETE CASCADE); ");
		statement.executeUpdate();


            //Todo Remove me !
            statement = connection.prepareStatement("INSERT INTO user (firstname, lastname) SELECT ?, ? WHERE NOT EXISTS (SELECT 1 FROM user WHERE firstname = ? AND lastname = ?);");
            statement.setString(1, "admin");
            statement.setString(2, "admin");
            statement.setString(3, "admin");
            statement.setString(4, "admin");
            statement.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
