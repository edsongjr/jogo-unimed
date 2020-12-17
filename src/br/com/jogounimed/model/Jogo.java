package br.com.jogounimed.model;

import br.com.jogounimed.state.InicioState;
import br.com.jogounimed.state.State;

public class Jogo {
	
	private ListaDePratos pratos = new ListaDePratos();
	
	private State estadoInicial = new InicioState();
	
	public void iniciar() {
		inicializarPratos();
		estadoInicial.executa(this.pratos);
	}
	
	private void inicializarPratos() {
		Prato lasanha = new Prato("lasanha", true, null);
		Prato boloDeChocolate = new Prato("bolo de chocolate", false, null);
		pratos.adicionarPrato(lasanha);
		pratos.adicionarPrato(boloDeChocolate);
	}
}
