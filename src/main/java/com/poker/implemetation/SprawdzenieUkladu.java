package com.poker.implemetation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import com.poker.templates.Figura;
import com.poker.templates.Kolor;
import com.poker.templates.Uklad;

public class SprawdzenieUkladu {

	private static LinkedList<Integer> listaFigur = new LinkedList<Integer>();
	private static LinkedList<Integer> listaKolorow = new LinkedList<Integer>();

	private static ArrayList<Karta> ukladKart;
	
	public static Uklad sprawdzUklad(ArrayList<Karta> ukladKart) {
		SprawdzenieUkladu.ukladKart = ukladKart;
    	createLists();	
		fillLists();
//		showLists();
		
		if(czyPokerKrolewski())
			return Uklad.POKER_KROLEWSKI;
		else if(czyPoker())
			return Uklad.POKER;
		else if(czyKareta())
			return Uklad.KARETA;
		else if(czyFull())
			return Uklad.FULL;
		else if(czyKolor())
			return Uklad.KOLOR;
		else if(czyStrit())
			return Uklad.STRIT;
		else if(czyTrojka())
			return Uklad.TROJKA;
		else if(czyDwiePary())
			return Uklad.DWIE_PARY;
		else if(czyPara())
			return Uklad.PARA;
		
		return Uklad.WYSOKA_KARTA;
	}

	private static void createLists() {
		// 0 - 12
		int ilosc2 = 0, ilosc3 = 0, ilosc4 = 0, ilosc5 = 0, ilosc6 = 0, ilosc7 = 0, ilosc8 = 0, ilosc9 = 0, ilosc10 = 0, iloscWaletow = 0, iloscDam = 0, iloscKrolow = 0, iloscAsow = 0;
		LinkedList<Integer> listaFigurTemp = new LinkedList<Integer>();
		LinkedList<Integer> listaKolorowTemp = new LinkedList<Integer>();
		listaFigurTemp.add(ilosc2);
		listaFigurTemp.add(ilosc3);
		listaFigurTemp.add(ilosc4);
		listaFigurTemp.add(ilosc5);
		listaFigurTemp.add(ilosc6);
		listaFigurTemp.add(ilosc7);
		listaFigurTemp.add(ilosc8);
		listaFigurTemp.add(ilosc9);
		listaFigurTemp.add(ilosc10);
		listaFigurTemp.add(iloscWaletow);
		listaFigurTemp.add(iloscDam);
		listaFigurTemp.add(iloscKrolow);
		listaFigurTemp.add(iloscAsow);
		listaFigur = listaFigurTemp;
		// 0 - 3
		int iloscKierow = 0, iloscKaro = 0, iloscTrefli = 0, iloscPikow = 0;
		listaKolorowTemp.add(iloscKierow);
		listaKolorowTemp.add(iloscKaro);
		listaKolorowTemp.add(iloscTrefli);
		listaKolorowTemp.add(iloscPikow);
		listaKolorow = listaKolorowTemp;
	}
	
	private static void fillLists() {
		for(Karta k : ukladKart) {
			if(k.getFigura().equals(Figura.DWOJKA))
				listaFigur.set(0, listaFigur.get(0) + 1);
			if(k.getFigura().equals(Figura.TROJKA))
				listaFigur.set(1, listaFigur.get(1) + 1);
			if(k.getFigura().equals(Figura.CZWORKA))
				listaFigur.set(2, listaFigur.get(2) + 1);
			if(k.getFigura().equals(Figura.PIATKA))
				listaFigur.set(3, listaFigur.get(3) + 1);
			if(k.getFigura().equals(Figura.SZOSTKA))
				listaFigur.set(4, listaFigur.get(4) + 1);
			if(k.getFigura().equals(Figura.SIODEMKA))
				listaFigur.set(5, listaFigur.get(5) + 1);
			if(k.getFigura().equals(Figura.OSEMKA))
				listaFigur.set(6, listaFigur.get(6) + 1);
			if(k.getFigura().equals(Figura.DZIEWIATKA))
				listaFigur.set(7, listaFigur.get(7) + 1);
			if(k.getFigura().equals(Figura.DZIESIATKA))
				listaFigur.set(8, listaFigur.get(8) + 1);
			if(k.getFigura().equals(Figura.WALET))
				listaFigur.set(9, listaFigur.get(9) + 1);
			if(k.getFigura().equals(Figura.DAMA))
				listaFigur.set(10, listaFigur.get(10) + 1);
			if(k.getFigura().equals(Figura.KROL))
				listaFigur.set(11, listaFigur.get(11) + 1);
			if(k.getFigura().equals(Figura.AS))
				listaFigur.set(12, listaFigur.get(12) + 1);
		}
		
		for(Karta k : ukladKart) {
			if(k.getKolor().equals(Kolor.Kier))
				listaKolorow.set(0, listaKolorow.get(0) + 1);
			if(k.getKolor().equals(Kolor.Karo))
				listaKolorow.set(1, listaKolorow.get(1) + 1);
			if(k.getKolor().equals(Kolor.Trefl))
				listaKolorow.set(2, listaKolorow.get(2) + 1);
			if(k.getKolor().equals(Kolor.Pik))
				listaKolorow.set(3, listaKolorow.get(3) + 1);
		}
	}
	
	private static void showLists() {
		System.out.println("FIGURY");
		for (Integer integer : listaFigur) {
			System.out.println(integer);
		}
		System.out.println("KOLORY");
		for (Integer integer : listaKolorow) {
			System.out.println(integer);
		}
	}
	
	private static boolean czyPokerKrolewski() {
		if(czyPoker() && listaFigur.get(12) == 1)
			return true;
		else
			return false;
	}
	
	private static boolean czyPoker() {
		if(czyKolor() && czyStrit())
			return true;
		else
			return false;
	}
	
	private static boolean czyKolor() {
		Set<Kolor> zbiorKolorow = new TreeSet<Kolor>();
		ukladKart.forEach(e -> zbiorKolorow.add(e.getKolor()));
		return zbiorKolorow.size() == 1;
	}
	
	private static boolean czyStrit() {
		boolean result = false;
		for(int i = 0; i < listaFigur.size(); i++) {
			if(listaFigur.get(i) != 0) {
				int temp = 0;
				if(listaFigur.get(i) == 1) {
					for(int j = i; j < i + 5 && j < listaFigur.size(); j++) {
						if(listaFigur.get(j) == 1)
							temp++;
					}
//					System.out.println("TEMP: " + temp);
					if(temp == 5) {
						result = true;
						return result;
					}
				}
				else
					return false;
			}
		}
		return result;
	}
	
	private static boolean czyKareta() {
		boolean result = false;
		for(Integer i : listaFigur)
			if(i == 4)
				result = true;
		return result;
	}

	private static boolean czyFull() {
		ArrayList<Karta> tempKarty = new ArrayList<Karta>();
		tempKarty.addAll(ukladKart);
		int licznikTrojek = 0, licznikDwojek = 0;
		boolean result = false;
		for(Integer i : listaFigur) {
			if(i == 3)
				licznikTrojek++;
			if(i == 2)
				licznikDwojek++;
		}
		if(licznikDwojek == 1 && licznikTrojek == 1)
			result = true;
		return result;
	}

	private static boolean czyTrojka() {
		boolean result = false;
		for(Integer i : listaFigur)
			if(i == 3)
				result = true;
		return result;
	}
	
	private static boolean czyDwiePary() {
		boolean result = false;
		int iloscPar = 0;
		for(Integer i : listaFigur)
			if(i == 2)
				iloscPar++;
		if(iloscPar == 2)		
			result = true;
		return result;
	}
	
	private static boolean czyPara() {
		boolean result = false;
		for(Integer i : listaFigur)
			if(i == 2)
				result = true;
		return result;
	}
}
