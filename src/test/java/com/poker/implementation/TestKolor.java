package com.poker.implementation;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.poker.implemetation.Karta;
import com.poker.implemetation.SprawdzenieUkladu;
import com.poker.templates.Figura;
import com.poker.templates.Kolor;
import com.poker.templates.Uklad;

@RunWith(Parameterized.class)
public class TestKolor {
	
	// Java Reflect
	
	private ArrayList<Karta> ukladKart;
	private Uklad odpowiedz;
	private static int numerTestu;
	
	public TestKolor(List<Karta> ukladKart, Uklad odpowiedz) {
		super();
		this.ukladKart = new ArrayList<Karta>(ukladKart);
		this.odpowiedz = odpowiedz;
	}
	
	@Parameterized.Parameters
	public static Collection tests() {
		
		Object[][] tests = {
				{Arrays.asList(new Object[] { 
						new Karta(Figura.CZWORKA, Kolor.Kier),
						new Karta(Figura.DWOJKA, Kolor.Kier),
						new Karta(Figura.KROL, Kolor.Kier),
						new Karta(Figura.DAMA, Kolor.Kier),
						new Karta(Figura.WALET, Kolor.Kier)
						}), Uklad.KOLOR
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.CZWORKA, Kolor.Kier),
						new Karta(Figura.DAMA, Kolor.Kier),
						new Karta(Figura.DZIESIATKA, Kolor.Kier),
						new Karta(Figura.WALET, Kolor.Kier),
						new Karta(Figura.WALET, Kolor.Kier)
						}), Uklad.KOLOR
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.TROJKA, Kolor.Kier),
						new Karta(Figura.OSEMKA, Kolor.Kier),
						new Karta(Figura.DWOJKA, Kolor.Kier),
						new Karta(Figura.CZWORKA, Kolor.Kier),
						new Karta(Figura.KROL, Kolor.Kier)
						}), Uklad.KOLOR
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.KROL, Kolor.Karo),
						new Karta(Figura.AS, Kolor.Karo),
						new Karta(Figura.WALET, Kolor.Karo),
						new Karta(Figura.DWOJKA, Kolor.Karo),
						new Karta(Figura.TROJKA, Kolor.Karo)
						}), Uklad.KOLOR
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DWOJKA, Kolor.Trefl),
						new Karta(Figura.TROJKA, Kolor.Trefl),
						new Karta(Figura.CZWORKA, Kolor.Trefl),
						new Karta(Figura.PIATKA, Kolor.Trefl),
						new Karta(Figura.AS, Kolor.Trefl)
						}), Uklad.KOLOR
				},
		};
		return Arrays.asList(tests);
	}
	
	@Test
	public void testSparametryzowany() {
		System.out.println("Numer Testu Kolory: " + ++numerTestu);
		assertTrue(SprawdzenieUkladu.sprawdzUklad(ukladKart) == odpowiedz);
	}
}
