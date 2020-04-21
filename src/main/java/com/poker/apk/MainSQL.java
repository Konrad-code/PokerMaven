package com.poker.apk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.poker.implemetation.Talia;
import com.poker.implemetation.UkladKart;
import com.poker.templates.ITalia;

public class MainSQL {

	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/postgres";
	private static final String URL2 = "jdbc:postgresql://localhost/zadanie1";
	private static final String LOGIN = "postgres";
	private static final String PASSWORD = "maxi55";
	
	public static void main(String[] args) {
		
		//	ZADANIE 3 - PRACA DOMOWA

		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			
			connection = DriverManager.getConnection(URL2, LOGIN, PASSWORD);
			statement = connection.createStatement();
			
			//	1. JEZYK TABLE
			String query = "CREATE TABLE jezyk(\n"
						 + " id_jezyk SERIAL,\n"
						 + " jezyk VARCHAR(50) COLLATE pg_catalog.\"default\",\n"
						 + " CONSTRAINT jezyk_pkey PRIMARY KEY (id_jezyk))";

			int rowsAffected = statement.executeUpdate(query);
			
			if(rowsAffected > 0)
				System.out.println("Table `jezyk` created successfully");
			
			// 2. KONTYNENT TABLE
			query = "CREATE TABLE public.kontynent(\n"
					 + " id_kontynent SERIAL,\n"
					 + " nazwa_kontynentu VARCHAR(50) COLLATE pg_catalog.\"default\",\n"
					 + " powierzchnia_bez_wysp INTEGER NOT NULL,\n"
					 + " powierzchnia_z_wyspami INTEGER NOT NULL,\n"
					 + " CONSTRAINT kontynent_pkey PRIMARY KEY (id_kontynent))";

			rowsAffected = statement.executeUpdate(query);
		
			if(rowsAffected > 0)
				System.out.println("Table `kontynent` created successfully");
			
			// 3. MIASTO TABLE
			query = "CREATE TABLE public.miasto(\n"
					 + " id_miasto SERIAL,\n"
					 + " nazwa_miasta VARCHAR(50) COLLATE pg_catalog.\"default\",\n"
					 + " liczba_mieszkancow INTEGER NOT NULL,\n"
					 + " czystolica boolean,\n"
					 + " CONSTRAINT miasto_pkey PRIMARY KEY (id_miasto))";

			rowsAffected = statement.executeUpdate(query);
					
			if(rowsAffected > 0)
				System.out.println("Table `miasto` created successfully");
			
			// 4. MORZE TABLE
			query = "CREATE TABLE public.morze(\n"
					 + " id_morze SERIAL,\n"
					 + " nazwa_morza VARCHAR(50) COLLATE pg_catalog.\"default\",\n"
					 + " powierzchnia_morza INTEGER NOT NULL,\n"
					 + " CONSTRAINT morze_pkey PRIMARY KEY (id_morze))";

			rowsAffected = statement.executeUpdate(query);
					
			if(rowsAffected > 0)
				System.out.println("Table `morze` created successfully");

			// 5. PANSTWO TABLE
			query = "CREATE TABLE public.panstwo(\n"
					 + " id_panstwo SERIAL,\n"
					 + " miasto_id INTEGER,\n"
					 + " kontynent_id INTEGER,\n" 
					 + " morze_id INTEGER,\n" 
					 + " jezyk_id INTEGER,\n"
					 + " nazwa_panstwa VARCHAR(50) COLLATE pg_catalog.\"default\",\n"
					 + " powierzchnia_panstwa INTEGER NOT NULL,\n"
					 + " liczba_ludnosci INTEGER,\n"
					 + " jednostka_monetarna character varying(50) COLLATE pg_catalog.\"default\",\n"
					 + " ustroj VARCHAR(50) COLLATE pg_catalog.\"default\",\n"
					 + " informacje_dodatkowe VARCHAR(50) COLLATE pg_catalog.\"default\",\n"
					 + " CONSTRAINT panstwo_pkey PRIMARY KEY (id_panstwo),\n"
					 + " CONSTRAINT panstwo_jezyk_id_fkey FOREIGN KEY (jezyk_id)\n"
					 + "    REFERENCES public.jezyk (id_jezyk) MATCH SIMPLE\n"
					 + "    ON UPDATE NO ACTION\n"
					 + "    ON DELETE NO ACTION,\n"
					 + " CONSTRAINT panstwo_kontynent_id_fkey FOREIGN KEY (kontynent_id)\n"
					 + "    REFERENCES public.kontynent (id_kontynent) MATCH SIMPLE\n"
					 + "    ON UPDATE NO ACTION\n"
					 + "    ON DELETE NO ACTION,\n"
					 + " CONSTRAINT panstwo_miasto_id_fkey FOREIGN KEY (miasto_id)\n"
					 + "    REFERENCES public.miasto (id_miasto) MATCH SIMPLE\n"
					 + "    ON UPDATE NO ACTION\n"
					 + "    ON DELETE NO ACTION,\n"
					 + " CONSTRAINT panstwo_morze_id_fkey FOREIGN KEY (morze_id)\n"
					 + "    REFERENCES public.morze (id_morze) MATCH SIMPLE\n"
					 + "    ON UPDATE NO ACTION\n"
					 + "    ON DELETE NO ACTION)";

			rowsAffected = statement.executeUpdate(query);
					
			if(rowsAffected > 0)
				System.out.println("Table `panstwo` created successfully");
			
		}catch(ClassNotFoundException e) {
			System.err.println("Bledny sterownik do bazy danych: " + e.getMessage());
		}catch(SQLException e) {
			System.err.println("Blad po stronie bazy danych - polaczenie lub wykonanie komendy: " + e.getMessage());
		}finally {
			try { statement.close(); } catch (Exception e) { /* leave action */ }
			try { connection.close(); } catch (Exception e) { /* leave action */ }
		}
		
		try {
			Class.forName(JDBC_DRIVER);
			
			connection = DriverManager.getConnection(URL2, LOGIN, PASSWORD);
			statement = connection.createStatement();
			
			//	1. JEZYK TABLE
			String query = "INSERT INTO jezyk (jezyk) VALUES ('english'), ('Mandarin Chinese'), ('Spanish'), ('Hindi'), ('Bengali'), ('Portuguese'), ('Russian'), ('Japanese');";

			int rowsAffected = statement.executeUpdate(query);
			
			if(rowsAffected > 0)
				System.out.println("Inserted records in `jezyk` successfully, " + rowsAffected + " rows affected");
			
			// 2. KONTYNENT TABLE
			query = "INSERT INTO kontynent (nazwa_kontynentu, powierzchnia_bez_wysp, powierzchnia_z_wyspami) VALUES\n"
				  + " ('Africa', 300000, 295000),\n"
				  + " ('North America', 500000, 400000),\n"
				  + " ('South America', 450000, 430000),\n"
				  + " ('Europe', 300000, 260000),\n"
				  + " ('Asia', 800000, 750000);";

			rowsAffected = statement.executeUpdate(query);
		
			if(rowsAffected > 0)
				System.out.println("Inserted records in `kontynent` successfully, " + rowsAffected + " rows affected");
			
			// 3. MIASTO TABLE
			query = "INSERT INTO miasto (nazwa_miasta, liczba_mieszkancow, czystolica) VALUES\n"
					  + " ('Zamosc', 66000, FALSE),\n"
					  + " ('Paris', 7000000, TRUE),\n"
					  + " ('Rome', 4500000, TRUE),\n"
					  + " ('Hulcze', 1000, FALSE),\n"
					  + " ('Manchester', 4000000, FALSE),\n"
					  + " ('Miami', 120000, FALSE);";

			rowsAffected = statement.executeUpdate(query);
					
			if(rowsAffected > 0)
				System.out.println("Inserted records in `miasto` successfully, " + rowsAffected + " rows affected");
			
			// 4. MIASTO TABLE
			query = "INSERT INTO morze (nazwa_morza, powierzchnia_morza) VALUES\n"
					  + " ('Baltic', 66000),\n"
					  + " ('Caribbean', 7000000),\n"
					  + " ('Ligurian', 400000),\n"
					  + " ('Mediterranean', 5000000);";

			rowsAffected = statement.executeUpdate(query);
					
			if(rowsAffected > 0)
				System.out.println("Inserted records in `morze` successfully, " + rowsAffected + " rows affected");

			// 5. PANSTWO TABLE
			query = "INSERT INTO panstwo (miasto_id, kontynent_id, morze_id, jezyk_id,\n"
				  + " nazwa_panstwa, powierzchnia_panstwa, liczba_ludnosci, jednostka_monetarna, ustroj, informacje_dodatkowe) VALUES\n"
					  + " (2, 2, 2, 1, 'Poland', 900000, 36000000, 'PLN', 'panstwo teoretyczne - kaczystan', 'NOPE'),\n"
					  + " (1, 3, 2, 4, 'Mongolia', 9000000, 70000000, 'Tugrik', 'democratic', 'NOPE'),\n"
					  + " (3, 3, 4, 2, 'China', 90000000, 999999999, 'Renminbi', 'comunistic dictatorship of party', 'COVID-19');";

				rowsAffected = statement.executeUpdate(query);
			
				if(rowsAffected > 0)
					System.out.println("Inserted records in `panstwo` successfully, " + rowsAffected + " rows affected");
			
		}catch(ClassNotFoundException e) {
			System.err.println("Bledny sterownik do bazy danych: " + e.getMessage());
		}catch(SQLException e) {
			System.err.println("Blad po stronie bazy danych - polaczenie lub wykonanie komendy: " + e.getMessage());
		}finally {
			try { statement.close(); } catch (Exception e) { /* leave action */ }
			try { connection.close(); } catch (Exception e) { /* leave action */ }
		}
		
		// CHECK FOR EXAMPLE `miasto` IF MADE INSERTIONS CORRECTLY
		ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER);
			
			connection = DriverManager.getConnection(URL2, LOGIN, PASSWORD);
			statement = connection.createStatement();
			
			String query = "SELECT id_miasto, nazwa_miasta, liczba_mieszkancow, czystolica FROM miasto";
			
			rs = statement.executeQuery(query);

			while(rs.next()) {
				int id = rs.getInt("id_miasto");
				String nazwa_miasta = rs.getString("nazwa_miasta");
				int liczba_mieszkancow = rs.getInt("liczba_mieszkancow");
				boolean czystolica = rs.getBoolean("czystolica");
				
				System.out.printf("ID: %d, Miasto: %s, Ludnoœæ: %d, Stolica: %b\n", id, nazwa_miasta, liczba_mieszkancow, czystolica);
			}
			
		}catch(ClassNotFoundException e) {
			System.err.println("Bledny sterownik do bazy danych: " + e.getMessage());
		}catch(SQLException e) {
			System.err.println("Bledny sterownik do bazy danych: " + e.getMessage());
		}finally {
			try { rs.close(); } catch (Exception e) { /* leave action */ }
			try { statement.close(); } catch (Exception e) { /* leave action */ }
			try { connection.close(); } catch (Exception e) { /* leave action */ }
		}
		
		
		
		/*
//		ZADANIE 1
		
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
					
//					System.out.printf("ID: %d, Imie: %s, Nazwisko: %s, Wiek: %s\n", id, imie, nazwisko, wiek);
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
					
//					System.out.printf("ID: %d, Imie opiekuna: %s, Nazwisko opiekuna: %s, Rasa zwierza: %s, Imie zwierza: %s\n", id, imie, nazwisko, rasaZwierza, imieZwierza);
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
