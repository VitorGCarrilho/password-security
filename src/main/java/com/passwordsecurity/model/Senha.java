package com.passwordsecurity.model;

import static com.passwordsecurity.util.Util.*;

public class Senha {
	private String dsSenha;
	private int qtNumCaracteres;
	private int bnsNumCaracteres;
	private int qtCarcMinusculos;
	private int bnsCarcMinusculos;
	private int qtCarcMaiusculos;
	private int bnsCarcMaiusculos;
	private int qtNumbers;
	private int bnsNumbers;
	private int qtSimbolos;
	private int bnsSimbolos;

	public String getDsSenha() {
		return dsSenha;
	}
	
	public int getQtNumCaracteres() {
		return qtNumCaracteres;
	}
	
	public int getBnsNumCaracteres() {
		return bnsNumCaracteres;
	}
		
	public int getQtCarcMinusculos() {
		return qtCarcMinusculos;
	}

	public int getBnsCarcMinusculos() {
		return bnsCarcMinusculos;
	}
	
	public int getQtCarcMaiusculos() {
		return qtCarcMaiusculos;
	}

	public int getBnsCarcMaiusculos() {
		return bnsCarcMaiusculos;
	}
		
	public int getQtNumbers() {
		return qtNumbers;
	}

	public int getBnsNumbers() {
		return bnsNumbers;
	}
	
	public int getQtSimbolos() {
		return qtSimbolos;
	}

	public int getBnsSimbolos() {
		return bnsSimbolos;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
		calcNumcaracteres();
		calcCarcMinusculos();
		calcCarcMaiusculos();
		calcQtNumeros();
		calcQtSimbolos();
		System.out.println("Senha setada");
	}
	
	private void calcNumcaracteres(){
		qtNumCaracteres = this.dsSenha.length();
		bnsNumCaracteres = qtNumCaracteres * 4;
	}
	
	private void calcCarcMinusculos(){
		qtCarcMinusculos = getNumOfLowerCase(dsSenha);
		if(qtCarcMinusculos>0) bnsCarcMinusculos = (qtNumCaracteres - qtCarcMinusculos)*2;
	}
	
	private void calcCarcMaiusculos(){
		qtCarcMaiusculos = getNumOfUpperCase(dsSenha);
		if(qtCarcMaiusculos>0) bnsCarcMaiusculos = (qtNumCaracteres - qtCarcMaiusculos)*2;
	}
	
	private void calcQtNumeros(){
		qtNumbers = getNumOfNumbers(dsSenha);
		bnsNumbers = qtNumbers * 4;
	}
	
	private void calcQtSimbolos(){
		qtSimbolos = getNumOfSymbols(dsSenha);
		bnsSimbolos = qtSimbolos * 6;
	}
}
