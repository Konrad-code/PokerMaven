package com.poker.templates;

import com.poker.implemetation.Karta;

public interface IUkladKart {
	public void dobierz(Karta k);
	public Karta odrzuc();
	public void pokazUkladKart();
}
