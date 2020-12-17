package br.com.jogounimed.model;

public class Prato {
	private String nome;
	private Boolean isMassa;
	private String catacteristica;

	public Prato(String nome, Boolean isMassa, String caracteristica) {
		this.nome = nome;
		this.isMassa = isMassa;
		this.catacteristica = caracteristica;
	}

	public String getCatacteristica() {
		return catacteristica;
	}

	public String getNome() {
		return nome;
	}
	
	public Boolean isMassa() {
		return isMassa;
	}

}
