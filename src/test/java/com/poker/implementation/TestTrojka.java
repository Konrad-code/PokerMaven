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
public class TestTrojka {
	
	// Java Reflect
	
	private ArrayList<Karta> ukladKart;
	private Uklad odpowiedz;
	private static int numerTestu;
	
	public TestTrojka(List<Karta> ukladKart, Uklad odpowiedz) {
		super();
		this.ukladKart = new ArrayList<Karta>(ukladKart);
		this.odpowiedz = odpowiedz;
	}
	
	@Parameterized.Parameters
	public static Collection tests() {
		
		Object[][] tests = {
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DWOJKA, Kolor.Kier),
						new Karta(Figura.KROL, Kolor.Karo),
						new Karta(Figura.WALET, Kolor.Trefl),
						new Karta(Figura.WALET, Kolor.Pik),
						new Karta(Figura.WALET, Kolor.Kier)
						}), Uklad.TROJKA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DAMA, Kolor.Kier),
						new Karta(Figura.AS, Kolor.Karo),
						new Karta(Figura.DAMA, Kolor.Trefl),
						new Karta(Figura.DWOJKA, Kolor.Kier),
						new Karta(Figura.DAMA, Kolor.Pik)
						}), Uklad.TROJKA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.KROL, Kolor.Kier),
						new Karta(Figura.WALET, Kolor.Karo),
						new Karta(Figura.WALET, Kolor.Trefl),
						new Karta(Figura.DWOJKA, Kolor.Pik),
						new Karta(Figura.WALET, Kolor.Pik)
						}), Uklad.TROJKA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.SZOSTKA, Kolor.Kier),
						new Karta(Figura.DWOJKA, Kolor.Karo),
						new Karta(Figura.SZOSTKA, Kolor.Trefl),
						new Karta(Figura.SZOSTKA, Kolor.Pik),
						new Karta(Figura.SIODEMKA, Kolor.Kier)
						}), Uklad.TROJKA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DAMA, Kolor.Kier),
						new Karta(Figura.DWOJKA, Kolor.Karo),
						new Karta(Figura.AS, Kolor.Trefl),
						new Karta(Figura.AS, Kolor.Pik),
						new Karta(Figura.AS, Kolor.Kier)
						}), Uklad.TROJKA
				},
		};
		return Arrays.asList(tests);
	}
	
	@Test
	public void testSparametryzowany() {
		System.out.println("Numer Testu Trojka: " + ++numerTestu);
		System.out.println(SprawdzenieUkladu.sprawdzUklad(ukladKart));
		assertTrue(SprawdzenieUkladu.sprawdzUklad(ukladKart) == odpowiedz);
	}
}