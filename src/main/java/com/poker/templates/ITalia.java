package com.poker.templates;

import com.poker.implemetation.UkladKart;

public interface ITalia {
	public void tasuj();
	public void nowaTalia();
	public void pokazTalia();
	public UkladKart rozdajKarty(int liczbaKart);
}
