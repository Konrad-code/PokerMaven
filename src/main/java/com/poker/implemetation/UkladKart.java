package com.poker.implemetation;

import java.util.ArrayList;

import com.poker.templates.IUkladKart;

public class UkladKart implements IUkladKart{

	private ArrayList<Karta> ukladKart;

	public UkladKart() {
		this.ukladKart = new ArrayList<Karta>();
	}

	@Override
	public void dobierz(Karta k) {
		ukladKart.add(k);
	}

	@Override
	public Karta odrzuc() {
		return null;
	}

	@Override
	public void pokazUkladKart() {
		for(Karta k : ukladKart)
			System.out.println(k);
	}
	
}
