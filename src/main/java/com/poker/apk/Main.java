package com.poker.apk;

import com.poker.implemetation.Talia;
import com.poker.implemetation.UkladKart;
import com.poker.templates.ITalia;

public class Main {
	
	public static void main(String[] args) {

		ITalia talia = new Talia("Talia czerwonego smoka");
		talia.nowaTalia();
		talia.tasuj();
//		talia.pokazTalia();
		
		System.out.println("===============================================================");
		
		UkladKart uklad1 = talia.rozdajKarty(5);
		uklad1.pokazUkladKart();
	}

}
