package com.poker.implemetation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.poker.templates.Figura;
import com.poker.templates.ITalia;
import com.poker.templates.Kolor;

public class Talia implements ITalia{

	private List<Karta> taliaKart;
	private String nazwaTalii;
	
	public Talia(String nazwaTalii) {
		this.nazwaTalii = nazwaTalii;
		this.taliaKart = new ArrayList<Karta>();
	}

	@Override
	public void tasuj() {
		Collections.shuffle(taliaKart);
	}

	@Override
	public void nowaTalia() {
		
		taliaKart.clear();
		
		for(Kolor k : Kolor.values())
			for(Figura f : Figura.values())
				taliaKart.add(new Karta(f, k));
	}

	@Override
	public void pokazTalia() {
		for(Karta k : taliaKart)
			System.out.println(k);
	}

	@Override
	public UkladKart rozdajKarty(int liczbaKart) {
		UkladKart nowyUkladKart = new UkladKart();
		
		while(liczbaKart-- > 0)
			nowyUkladKart.dobierz(taliaKart.remove(0));
		
		return nowyUkladKart;
	}

}
