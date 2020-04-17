package com.poker.implemetation;

import com.poker.templates.Figura;
import com.poker.templates.IKarta;
import com.poker.templates.Kolor;

public class Karta implements IKarta{
	private Figura figura;
	private Kolor kolor;
	
	public Karta(Figura figura, Kolor kolor) {
		this.figura = figura;
		this.kolor = kolor;
	}

	@Override
	public String toString() {
		return "Karta [figura=" + figura + ", kolor=" + kolor + "]";
	}

	@Override
	public Kolor getKolor() {
		return kolor;
	}

	@Override
	public Figura getFigura() {
		return figura;
	}
}
