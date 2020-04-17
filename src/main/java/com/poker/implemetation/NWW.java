package com.poker.implemetation;

public class NWW {
	public int najWW(int liczba1, int liczba2){
        int result = 0;
        int a = liczba1;
        int b = liczba2;
        result = ((a * b) / najwiekszyWD(a, b));
        System.out.println("result: " + result);
        return result;
	}
	
public int najwiekszyWD(int liczba1, int liczba2){
        int a = liczba1;
        int b = liczba2;
        
        while(a != b)
            if(a > b)
                a -= b;
            else
                b -= a;
        return a;
	}
}
