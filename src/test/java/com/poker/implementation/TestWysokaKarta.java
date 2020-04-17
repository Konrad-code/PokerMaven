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
public class TestWysokaKarta {
	
	// Java Reflect
	
	private ArrayList<Karta> ukladKart;
	private Uklad odpowiedz;
	private static int numerTestu;
	
	public TestWysokaKarta(List<Karta> ukladKart, Uklad odpowiedz) {
		super();
		this.ukladKart = new ArrayList<Karta>(ukladKart);
		this.odpowiedz = odpowiedz;
	}
	
	@Parameterized.Parameters
	public static Collection tests() {
		
		Object[][] tests = {
				{Arrays.asList(new Object[] { 
						new Karta(Figura.KROL, Kolor.Kier),
						new Karta(Figura.TROJKA, Kolor.Karo),
						new Karta(Figura.DWOJKA, Kolor.Trefl),
						new Karta(Figura.AS, Kolor.Pik),
						new Karta(Figura.CZWORKA, Kolor.Kier)
						}), Uklad.WYSOKA_KARTA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.PIATKA, Kolor.Kier),
						new Karta(Figura.AS, Kolor.Karo),
						new Karta(Figura.WALET, Kolor.Trefl),
						new Karta(Figura.SIODEMKA, Kolor.Kier),
						new Karta(Figura.DZIESIATKA, Kolor.Pik)
						}), Uklad.WYSOKA_KARTA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.KROL, Kolor.Kier),
						new Karta(Figura.DWOJKA, Kolor.Karo),
						new Karta(Figura.WALET, Kolor.Trefl),
						new Karta(Figura.SIODEMKA, Kolor.Pik),
						new Karta(Figura.TROJKA, Kolor.Pik)
						}), Uklad.WYSOKA_KARTA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DWOJKA, Kolor.Kier),
						new Karta(Figura.SIODEMKA, Kolor.Karo),
						new Karta(Figura.SZOSTKA, Kolor.Trefl),
						new Karta(Figura.AS, Kolor.Pik),
						new Karta(Figura.OSEMKA, Kolor.Kier)
						}), Uklad.WYSOKA_KARTA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.TROJKA, Kolor.Kier),
						new Karta(Figura.DWOJKA, Kolor.Karo),
						new Karta(Figura.AS, Kolor.Trefl),
						new Karta(Figura.PIATKA, Kolor.Pik),
						new Karta(Figura.OSEMKA, Kolor.Kier)
						}), Uklad.WYSOKA_KARTA
				},
		};
		return Arrays.asList(tests);
	}
	
	@Test
	public void testSparametryzowany() {
		System.out.println("Numer Testu Wysoka Karta: " + ++numerTestu);
		System.out.println(SprawdzenieUkladu.sprawdzUklad(ukladKart));
		assertTrue(SprawdzenieUkladu.sprawdzUklad(ukladKart) == odpowiedz);
	}
}