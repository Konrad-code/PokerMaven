package com.poker.implementation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.poker.implemetation.Karta;
import com.poker.implemetation.SprawdzenieUkladu;
import com.poker.templates.Figura;
import com.poker.templates.Kolor;
import com.poker.templates.Uklad;

public class SprawdzenieUkladuTest {

	
	//JUnitCore
	// Result
	// TestCase
	// TestSuite
	
	// SPOJ - PL/ANG
	
	@BeforeClass
	public static void przedWszystkimiTestami() {
//		System.out.println("Przed wszystkimi testami");
	}
	
	
	@Before
	public void przedTestem() {
//		System.out.println("Przed testem");
	}
	
	@After
	public void poTescie() {
//		System.out.println("Po tescie");
	}
	
	@AfterClass
	public static void poKazdymTescie() {
//		System.out.println("Po wszystkich Testach");
	}
	
	@Ignore
	@Test
	public void test1() {
		ArrayList<Karta> ukladKart = new ArrayList<Karta>();
		ukladKart.add(new Karta(Figura.DZIESIATKA, Kolor.Karo));
		ukladKart.add(new Karta(Figura.SZOSTKA, Kolor.Karo));
		ukladKart.add(new Karta(Figura.DWOJKA, Kolor.Karo));
		ukladKart.add(new Karta(Figura.KROL, Kolor.Karo));
		ukladKart.add(new Karta(Figura.DAMA, Kolor.Karo));
		
		System.out.println("Test1");
		
		assertTrue(ukladKart.size() == 5);
		assertTrue(SprawdzenieUkladu.sprawdzUklad(ukladKart) == Uklad.KOLOR);
	}
	
	@Test
	public void test2() {
		ArrayList<Karta> ukladKart = new ArrayList<Karta>();
		ukladKart.add(new Karta(Figura.DZIESIATKA, Kolor.Kier));
		ukladKart.add(new Karta(Figura.SZOSTKA, Kolor.Karo));
		ukladKart.add(new Karta(Figura.DWOJKA, Kolor.Karo));
		ukladKart.add(new Karta(Figura.KROL, Kolor.Karo));
		ukladKart.add(new Karta(Figura.DAMA, Kolor.Karo));
		

		System.out.println("Test2");
		
		assertTrue(ukladKart.size() == 5);
		System.out.println(SprawdzenieUkladu.sprawdzUklad(ukladKart));
		assertFalse(SprawdzenieUkladu.sprawdzUklad(ukladKart) == Uklad.KOLOR);
	}
	
	
}
