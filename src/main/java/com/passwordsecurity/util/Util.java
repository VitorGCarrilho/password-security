package com.passwordsecurity.util;

public class Util {
	private static final char[] SIMBOLOS = { '\'', '"', '!', '@', '#', '$', '%', '&', '*', '(', ')', '-', '+',
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

	public static int getNumConsecutiveUpperCase(String strt){
		int count=0;
		char[] caracteres = strt.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if(i+1<caracteres.length){
				if (Character.isUpperCase(caracteres[i]) && Character.isUpperCase(caracteres[i+1])){
					count++;
				}
			}
		}
		return count;
	}

	public static int getNumConsecutiveLowerCase(String strt){
		int count=0;
		char[] caracteres = strt.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if(i+1<caracteres.length){
				if (Character.isLowerCase(caracteres[i]) && Character.isLowerCase(caracteres[i+1])){
					count++;
				}
			}
		}
		return count;
	}
	
	public static int getNumConsecutiveNumbers(String strt){
		int count=0;
		char[] caracteres = strt.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if(i+1<caracteres.length){
				if (Character.isDigit(caracteres[i]) && Character.isDigit(caracteres[i+1])){
					count++;
				}
			}
		}
		return count;
	}
	
	public static int getNumSequenciaLetras(String strt){
		int count = 0;
		char[] caracteres = strt.toLowerCase().toCharArray();//97-122
		for (int i = 0; i < caracteres.length; i++) {
			if(i+2<caracteres.length){
				if (isBetween(caracteres[i],97,122) && isBetween(caracteres[i+2],97,122)){
					if(caracteres[i]+1 == caracteres[i+1] && caracteres[i]+2 == caracteres[i+2])
						count++;
					if(caracteres[i]-1 == caracteres[i+1] && caracteres[i]-2 == caracteres[i+2])
						count++;
				}
			}
		}
		return count;
	}
	
	public static int getNumSequenciaNumeros(String strt){
		int count = 0;
		char[] caracteres = strt.toLowerCase().toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if(i+2<caracteres.length){
				if (Character.isDigit(caracteres[i]) && Character.isDigit(caracteres[i+1]) && Character.isDigit(caracteres[i+2])){
					if(caracteres[i]+1 == caracteres[i+1] && caracteres[i]+2 == caracteres[i+2])
						count++;
					if(caracteres[i]-1 == caracteres[i+1] && caracteres[i]-2 == caracteres[i+2])
						count++;
				}
			}
		}
		return count;
	}
	
	public static int getNumSequenciaSimbolos(String strt){
		int count = 0;
		char[] caracteres = strt.toLowerCase().toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			for (int y = 0; y < SIMBOLOS.length; y++){
				if(caracteres[i] == SIMBOLOS[y] && i+2 < caracteres.length){
					if(caracteres[i+1] == SIMBOLOS[y+1] && caracteres[i+2] == SIMBOLOS[y+2])
						count ++;
					if(caracteres[i+1] == SIMBOLOS[y-1] && caracteres[i+2] == SIMBOLOS[y-2])
						count ++;
				}
			}
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
	
	private static boolean isBetween(int numero, int menor, int maior){
		return numero>=menor && numero<=maior;
	}
}
