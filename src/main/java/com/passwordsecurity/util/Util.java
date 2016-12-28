package com.passwordsecurity.util;

public class Util {
	private static final char [] SIMBOLOS = {'\'','"','!','@','#','$','%','¨','&','*','(',')','_','-','+','=','/','?'};
	
	public static int getNumOfLowerCase(String strt){
		int count = 0;
		char [] caracteres = strt.toCharArray();
		for (int i=0; i<caracteres.length;i++){
			if (Character.isLowerCase(caracteres[i])) count++;
		}		
		return count;
	}
	public static int getNumOfUpperCase(String strt){
		int count = 0;
		char [] caracteres = strt.toCharArray();
		for (int i=0; i<caracteres.length;i++){
			if (Character.isUpperCase(caracteres[i])) count++;
		}		
		return count;
	}
	public static int getNumOfNumbers(String strt){
		int count = 0;
		char [] caracteres = strt.toCharArray();
		for (int i=0; i<caracteres.length;i++){
			if (Character.isDigit(caracteres[i])) count++;
		}		
		return count;
	}
	public static int getNumOfSymbols(String strt){
		int count = 0;
		char [] caracteres = strt.toCharArray();
		for (int i=0; i<caracteres.length;i++){
			for(int y=0; y<SIMBOLOS.length;y++){
				if (caracteres[i]==SIMBOLOS[y])count++;
			}
		}		
		return count;
	}
}
