package com.passwordsecurity.model;

public enum Classificacao {
	MUITO_CURTA("Muito Curta","danger"),
	MUITO_FRACA("Muito Fraca","danger"),
	FRACA("Fraca","warning"),
	BOA("Boa","info"),
	FORTE("Forte","success"),
	MUITO_FORTE("Muito Forte","success");
	
	private String dsClassificacao;
	private String classeClassificacao;
	public String teste="success";
	
	Classificacao(String dsClassificacao, String classeClassificacao) {
		this.dsClassificacao = dsClassificacao;
		this.classeClassificacao = classeClassificacao;
	}

	public String getDsClassificacao() {
		return dsClassificacao;
	}

	public String getClasseClassificacao() {
		return classeClassificacao;
	}
	
	
}
