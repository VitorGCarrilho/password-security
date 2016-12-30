package com.passwordsecurity.model;

public class ClassificacaoSenha {

	private String dsClassificacao;
	private String classeClassificacao;
	
	public ClassificacaoSenha(){}
	public ClassificacaoSenha(Classificacao classificacao){
		this.dsClassificacao = classificacao.getDsClassificacao();
		this.classeClassificacao = classificacao.getClasseClassificacao();
	}
	
	public String getDsClassificacao() {
		return dsClassificacao;
	}
	public String getClasseClassificacao() {
		return classeClassificacao;
	}
	
	

}
