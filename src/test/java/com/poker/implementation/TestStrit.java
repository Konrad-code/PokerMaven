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
public class TestStrit {
	
	// Java Reflect
	
	private ArrayList<Karta> ukladKart;
	private Uklad odpowiedz;
	private static int numerTestu;
	
	public TestStrit(List<Karta> ukladKart, Uklad odpowiedz) {
		super();
		this.ukladKart = new ArrayList<Karta>(ukladKart);
		this.odpowiedz = odpowiedz;
	}
	
	@Parameterized.Parameters
	public static Collection tests() {
		
		Object[][] tests = {
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DZIESIATKA, Kolor.Kier),
						new Karta(Figura.DAMA, Kolor.Karo),
						new Karta(Figura.DZIEWIATKA, Kolor.Trefl),
						new Karta(Figura.WALET, Kolor.Pik),
						new Karta(Figura.OSEMKA, Kolor.Kier)
						}), Uklad.STRIT
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DZIESIATKA, Kolor.Kier),
						new Karta(Figura.KROL, Kolor.Karo),
						new Karta(Figura.DZIEWIATKA, Kolor.Trefl),
						new Karta(Figura.WALET, Kolor.Pik),
						new Karta(Figura.DAMA, Kolor.Kier)
						}), Uklad.STRIT
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DZIESIATKA, Kolor.Kier),
						new Karta(Figura.SIODEMKA, Kolor.Kier),
						new Karta(Figura.DZIEWIATKA, Kolor.Trefl),
						new Karta(Figura.WALET, Kolor.Pik),
						new Karta(Figura.OSEMKA, Kolor.Kier)
						}), Uklad.STRIT
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DZIESIATKA, Kolor.Kier),
						new Karta(Figura.KROL, Kolor.Trefl),
						new Karta(Figura.AS, Kolor.Trefl),
						new Karta(Figura.WALET, Kolor.Pik),
						new Karta(Figura.DAMA, Kolor.Kier)
						}), Uklad.STRIT
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.TROJKA, Kolor.Pik),
						new Karta(Figura.DWOJKA, Kolor.Trefl),
						new Karta(Figura.PIATKA, Kolor.Trefl),
						new Karta(Figura.SZOSTKA, Kolor.Pik),
						new Karta(Figura.CZWORKA, Kolor.Kier)
						}), Uklad.STRIT
				},
		};
		return Arrays.asList(tests);
	}
	
	@Test
	public void testSparametryzowany() {
		System.out.println("Numer Testu Strit: " + ++numerTestu);
		System.out.println(SprawdzenieUkladu.sprawdzUklad(ukladKart));
		assertTrue(SprawdzenieUkladu.sprawdzUklad(ukladKart) == odpowiedz);
	}
}