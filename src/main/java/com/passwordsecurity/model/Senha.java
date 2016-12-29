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
	private int qtSeqNumSimb;
	private int bnsSeqNumSimb;
	private int qtRequisitos;
	private int bnsRequisitos;
	private int qtApenasLetras;
	private int bnsApenasLetras;
	private int qtApenasNumeros;
	private int bnsApenasNumeros;
	private int qtCarcRepetidos;
	private int bnsCarcRepetidos;
	private int qtCaracMaiusculosConsecutivos;
	private int bnsCaracMaiusculosConsecutivos;
	private int qtCaracMinusculosConsecutivos;
	private int bnsCaracMinusculosConsecutivos;
	private int qtNumerosConsecutivos;
	private int bnsNumerosConsecutivos;
	private int qtSequenciaLetras;
	private int bnsSequenciaLetras;
	private int qtSequenciaNumeros;
	private int bnsSequenciaNumeros;
	private int qtSequenciaSimbolos;
	private int bnsSequenciaSimbolos;
	private int soma;
	private Classificacao classificacao = Classificacao.MUITO_CURTA;

	public Classificacao getClassificacao() {
		return classificacao;
	}
	
	public int getQtSeqNumSimb() {
		return qtSeqNumSimb;
	}

	public int getBnsSeqNumSimb() {
		return bnsSeqNumSimb;
	}

	public int getQtRequisitos() {
		return qtRequisitos;
	}

	public int getBnsRequisitos() {
		return bnsRequisitos;
	}

	public int getQtApenasLetras() {
		return qtApenasLetras;
	}

	public int getBnsApenasLetras() {
		return bnsApenasLetras;
	}

	public int getQtApenasNumeros() {
		return qtApenasNumeros;
	}

	public int getBnsApenasNumeros() {
		return bnsApenasNumeros;
	}

	public int getQtCarcRepetidos() {
		return qtCarcRepetidos;
	}

	public int getBnsCarcRepetidos() {
		return bnsCarcRepetidos;
	}

	public int getQtCaracMaiusculosConsecutivos() {
		return qtCaracMaiusculosConsecutivos;
	}

	public int getBnsCaracMaiusculosConsecutivos() {
		return bnsCaracMaiusculosConsecutivos;
	}

	public int getQtCaracMinusculosConsecutivos() {
		return qtCaracMinusculosConsecutivos;
	}

	public int getBnsCaracMinusculosConsecutivos() {
		return bnsCaracMinusculosConsecutivos;
	}

	public int getQtNumerosConsecutivos() {
		return qtNumerosConsecutivos;
	}

	public int getBnsNumerosConsecutivos() {
		return bnsNumerosConsecutivos;
	}

	public int getQtSequenciaLetras() {
		return qtSequenciaLetras;
	}

	public int getBnsSequenciaLetras() {
		return bnsSequenciaLetras;
	}

	public int getQtSequenciaNumeros() {
		return qtSequenciaNumeros;
	}

	public int getBnsSequenciaNumeros() {
		return bnsSequenciaNumeros;
	}

	public int getQtSequenciaSimbolos() {
		return qtSequenciaSimbolos;
	}

	public int getBnsSequenciaSimbolos() {
		return bnsSequenciaSimbolos;
	}

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

	public int getSoma() {
		return soma;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	public void calcular() {
		calcNumcaracteres();
		calcCarcMinusculos();
		calcCarcMaiusculos();
		calcQtNumeros();
		calcQtSimbolos();
		calcQtSeqNumSimb();
		calcQtRequisitos();
		calcQtApenasLetras();
		calcQtApenasNumeros();
		calcQtCarcRepetidos();
		calcQtCaracMaiusculosConsecutivos();
		calcQtCaracMinusculosConsecutivos();
		calcQtNumerosConsecutivos();
		calcQtSequenciaLetras();
		calcQtSequenciaNumeros();
		calcQtSequenciaSimbolos();
		calcComplexibilidadeSenha();
		calcClassificacao();
	}

	private void calcNumcaracteres() {
		qtNumCaracteres = this.dsSenha.length();
		bnsNumCaracteres = qtNumCaracteres * 4;
	}

	private void calcCarcMinusculos() {
		qtCarcMinusculos = getNumOfLowerCase(dsSenha);
		if (qtCarcMinusculos > 0)
			bnsCarcMinusculos = (qtNumCaracteres - qtCarcMinusculos) * 2;
	}

	private void calcCarcMaiusculos() {
		qtCarcMaiusculos = getNumOfUpperCase(dsSenha);
		if (qtCarcMaiusculos > 0)
			bnsCarcMaiusculos = (qtNumCaracteres - qtCarcMaiusculos) * 2;
	}

	private void calcQtNumeros() {
		qtNumbers = getNumOfNumbers(dsSenha);
		bnsNumbers = qtNumbers * 4;
	}

	private void calcQtSimbolos() {
		qtSimbolos = getNumOfSymbols(dsSenha);
		bnsSimbolos = qtSimbolos * 6;
	}

	private void calcQtSeqNumSimb() {
		qtSeqNumSimb = getNumOfNumberOrSymbols(dsSenha);
	}

	private void calcQtRequisitos() {
		boolean minCarac = false;
		int itens = 0;
		if (qtNumCaracteres>= 8){
			minCarac = true;
			qtRequisitos++;
		} 
		if(qtNumbers>0)itens++;
		if(qtCarcMaiusculos>0)itens++;
		if(qtCarcMinusculos>0)itens++;
		if(qtSimbolos>0)itens++;
		qtRequisitos+=itens;
		if(qtNumCaracteres>= 8 && itens>=3){
			bnsRequisitos = qtRequisitos*2;
		}
	}

	private void calcQtApenasLetras() {
		int numLetters = getNumOfLetters(dsSenha);
		if (qtNumCaracteres == numLetters){
			qtApenasLetras = numLetters *(-1);
			bnsApenasLetras = qtApenasLetras;
		}		
	}

	private void calcQtApenasNumeros() {
		int numNumbers = getNumOfNumbers(dsSenha);
		if (qtNumCaracteres == numNumbers){
			qtApenasNumeros = numNumbers *(-1);
			bnsApenasNumeros = qtApenasNumeros;
		}	
	}

	private void calcQtCarcRepetidos() {
		qtCarcRepetidos = getNumCaracRepetidos(dsSenha);
		bnsCarcRepetidos = (-1) * (qtCarcRepetidos*(qtCarcRepetidos-1));
	}

	private void calcQtCaracMaiusculosConsecutivos() {

	}

	private void calcQtCaracMinusculosConsecutivos() {

	}

	private void calcQtNumerosConsecutivos() {

	}

	private void calcQtSequenciaLetras() {

	}

	private void calcQtSequenciaNumeros() {

	}

	private void calcQtSequenciaSimbolos() {

	}

	private void calcComplexibilidadeSenha() {
		this.soma = bnsNumCaracteres + bnsCarcMinusculos + bnsCarcMaiusculos + bnsNumbers + bnsSimbolos + bnsSeqNumSimb
				+ bnsRequisitos + bnsApenasLetras + bnsApenasNumeros + bnsCarcRepetidos + bnsCaracMaiusculosConsecutivos
				+ bnsCaracMinusculosConsecutivos + bnsNumerosConsecutivos + bnsSequenciaLetras + bnsSequenciaNumeros
				+ bnsSequenciaSimbolos;
		if (soma>100) soma = 100;
		if (soma<0) soma = 0;
		
	}
	private void calcClassificacao(){
		if (qtNumCaracteres == 0){
			classificacao = Classificacao.MUITO_CURTA;
		} else if (soma < 20){
			classificacao = Classificacao.MUITO_FRACA;
		} else if (soma < 40){
			classificacao = Classificacao.FRACA;
		} else if (soma < 60){
			classificacao = Classificacao.BOA;
		} else if (soma < 80){
			classificacao = Classificacao.FORTE;
		} else {
			classificacao = Classificacao.MUITO_FORTE;
		}
	}
}
