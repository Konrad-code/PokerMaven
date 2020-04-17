package com.poker.implementation;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.poker.implemetation.Karta;
import com.poker.implemetation.NWW;
import com.poker.implemetation.SprawdzenieUkladu;
import com.poker.templates.Figura;
import com.poker.templates.Kolor;
import com.poker.templates.Uklad;

@RunWith(Parameterized.class)
public class NWWTest {
	private NWW nww;
	private static int numerTestu;
	private int pierwszaLiczba;
	private int drugaLiczba;
	private int odpowiedz;
	
	public NWWTest(int pierwszaLiczba, int drugaLiczba, int odpowiedz) {
		this.nww = new NWW();
		this.pierwszaLiczba = pierwszaLiczba;
		this.drugaLiczba = drugaLiczba;
		this.odpowiedz = odpowiedz;
	}
	
	@Parameterized.Parameters
	public static Collection tests() {
		
		Object[][] tests = {
				{2, 10, 10},
				{12,24,24},
				{12,30,60},
				{12,13,156},
				{12,8,24},
				{11,22,22},
				{11,1,11},
				{5,14,70},
				{3,5,15},
				{14,8,56},
				{22,40,440},
				{7,33,231},
				{17,9,153},
				{109,17,1853},
				{22,22,22},
				
		};
		return Arrays.asList(tests);
	}
	
	@Test
	public void testSparametryzowany() {
		System.out.println("Numer Testu: " + ++numerTestu);
		assertTrue(nww.najWW(pierwszaLiczba, drugaLiczba) == odpowiedz);
	}
}
