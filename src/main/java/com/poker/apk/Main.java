package com.poker.apk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.poker.implemetation.Talia;
import com.poker.implemetation.UkladKart;
import com.poker.templates.ITalia;

public class Main {

	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/postgres";
	private static final String URL2 = "jdbc:postgresql://localhost/zadanie1";
	private static final String LOGIN = "postgres";
	private static final String PASSWORD = "maxi55";
	
	public static void main(String[] args) {

		ITalia talia = new Talia("Talia czerwonego smoka");
		talia.nowaTalia();
		talia.tasuj();
//		talia.pokazTalia();
		
		System.out.println("===============================================================");
		
		UkladKart uklad1 = talia.rozdajKarty(5);
		uklad1.pokazUkladKart();
		
		//	ZADANIE 1
		
		try {
			Class.forName(JDBC_DRIVER);
			
			Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM OSOBA";
			
			// executeQuery - Select (zwraca nam zbior informacji czy operacja sie powiodla na zasadzie np. 100 danych)
			// execute - Create, Drop (zwraca boolean - czy sie powiodlo)
			// executeUpdate - Insert
			
			ResultSet rs = statement.executeQuery(query);
			
			// Przeczytac o Iterator w domu
			
			while(rs.next()) {
				int id = rs.getInt("ID_Osoba");
				String imie = rs.getString("Imie");
				String nazwisko = rs.getString("Nazwisko");
				int wiek = rs.getInt("Wiek");
				
//				System.out.printf("ID: %d, Imie: %s, Nazwisko: %s, Wiek: %s\n", id, imie, nazwisko, wiek);
			}
			
		}catch(ClassNotFoundException e) {
			System.err.println("Bledny sterownik do bazy danych: " + e.getMessage());
		}catch(SQLException e) {
			System.err.println("Bledny sterownik do bazy danych: " + e.getMessage());
		}
		
		//	ZADANIE 2
		
		try {
			Class.forName(JDBC_DRIVER);
			
			Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			
			String query = "SELECT ID_Osoba, Osoba.Imie, Osoba.Nazwisko, Zwierze.Rasa, Zwierze.Imie AS Imie_Zwierzecia FROM OSOBA, Zwierze WHERE Osoba.Zwierze_ID = Zwierze.ID_Zwierze";
			
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				int id = rs.getInt("ID_Osoba");
				String imie = rs.getString("Imie");
				String nazwisko = rs.getString("Nazwisko");
				String rasaZwierza = rs.getString("Rasa");
				String imieZwierza = rs.getString("Imie_Zwierzecia");
				
//				System.out.printf("ID: %d, Imie opiekuna: %s, Nazwisko opiekuna: %s, Rasa zwierza: %s, Imie zwierza: %s\n", id, imie, nazwisko, rasaZwierza, imieZwierza);
			}
			
		}catch(ClassNotFoundException e) {
			System.err.println("Bledny sterownik do bazy danych: " + e.getMessage());
		}catch(SQLException e) {
			System.err.println("Bledny sterownik do bazy danych: " + e.getMessage());
		}
		
		//	ZADANIE 3 - PRACA DOMOWA
		/*
		try {
			Class.forName(JDBC_DRIVER);
			
			Connection connection = DriverManager.getConnection(URL2, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			
			String query = "SELECT ID_Osoba, Osoba.Imie, Osoba.Nazwisko, Zwierze.Rasa, Zwierze.Imie AS Imie_Zwierzecia FROM OSOBA, Zwierze WHERE Osoba.Zwierze_ID = Zwierze.ID_Zwierze";

			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("ID_Osoba");
				String imie = rs.getString("Imie");
				String nazwisko = rs.getString("Nazwisko");
				String rasaZwierza = rs.getString("Rasa");
				String imieZwierza = rs.getString("Imie_Zwierzecia");
				
				System.out.printf("ID: %d, Imie opiekuna: %s, Nazwisko opiekuna: %s, Rasa zwierza: %s, Imie zwierza: %s\n", id, imie, nazwisko, rasaZwierza, imieZwierza);
			}
			
		}catch(ClassNotFoundException e) {
			System.err.println("Bledny sterownik do bazy danych: " + e.getMessage());
		}catch(SQLException e) {
			System.err.println("Bledny sterownik do bazy danych: " + e.getMessage());
		}
		*/
		/*
		INSERT INTO ZWIERZE
		VALUES
			(1, 'Sloñ Afrykañski', 'Bella', 1200, 30),
			(2, 'Ryba Fugu', 'As', 120, 20),
			(3, 'Sum', 'Sumik', 100, 100),
			(4, '¯yrafa', 'Iwona', 430, 11),
			(5, 'Hipopotam', 'Hipo', 2000, 40),
			(6, 'Sloñ Indyjski', 'Paolo', 1600, 21);

		INSERT INTO OSOBA
		VALUES 
			(1, 2, 'Pawel', 'Kowalski', 40),
			(2, 3, 'Damian', 'weryt', 50),
			(3, 2, 'Albert', 'POIUY', 44),
			(4, 1, 'Monika', 'OLQ', 20),
			(5, 5,'Justyna', 'Maciejewski', 14),
			(6, 6,'Darek', 'XVC', 4);
			*/
		
	}

}
