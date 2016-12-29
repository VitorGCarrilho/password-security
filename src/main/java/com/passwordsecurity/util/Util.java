package com.passwordsecurity.util;

public class Util {
	private static final char[] SIMBOLOS = { '\'', '"', '!', '@', '#', '$', '%', '¨', '&', '*', '(', ')', '_', '-', '+',
			'=', '/', '?' };

	public static int getNumOfLowerCase(String strt) {
		int count = 0;
		char[] caracteres = strt.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if (Character.isLowerCase(caracteres[i]))
				count++;
		}
		return count;
	}

	public static int getNumOfUpperCase(String strt) {
		int count = 0;
		char[] caracteres = strt.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if (Character.isUpperCase(caracteres[i]))
				count++;
		}
		return count;
	}

	public static int getNumOfNumbers(String strt) {
		int count = 0;
		char[] caracteres = strt.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if (Character.isDigit(caracteres[i]))
				count++;
		}
		return count;
	}

	public static int getNumOfSymbols(String strt) {
		int count = 0;
		char[] caracteres = strt.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if (isSimbolo(caracteres[i]))
				count++;
		}
		return count;
	}

	public static int getNumOfNumberOrSymbols(String strt) {
		int count = 0;
		char[] caracteres = strt.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if ((isSimbolo(caracteres[i]) || Character.isDigit(caracteres[i]))){
				if (i+1<caracteres.length){
					if ((isSimbolo(caracteres[i + 1]) || Character.isDigit(caracteres[i + 1])))
						count++;
				}
			}
		}
		return count;
	}
	
	public static int getNumOfLetters(String strt){
		int count = 0;
		char[] caracteres = strt.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if (Character.isLetter(caracteres[i]))
				count++;
		}
		return count;
		
	}
	
	public static int getNumCaracRepetidos(String s){
		int count = 0;
		int distinct = 0 ;

	    for (int i = 0; i < s.length(); i++) {

	        for (int j = 0; j < s.length(); j++) {

	            if(s.charAt(i)==s.charAt(j))
	            {
	                distinct++;

	            }
	        }
	        String d=String.valueOf(s.charAt(i)).trim();
	        s=s.replaceAll(d,"");
	        if(distinct>1){
	        	count += distinct;
	        }
	        distinct=0;

	    }
		return count;
	}


	private static boolean isSimbolo(char c) {
		for (int y = 0; y < SIMBOLOS.length; y++) {
			if (c == SIMBOLOS[y])
				return true;
		}

		return false;
	}

}
