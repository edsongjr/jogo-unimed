package br.com.jogounimed.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListaDePratos {
	private List<Prato> pratos;
	
	public ListaDePratos() {
		this.pratos = new ArrayList<>();
	}
	
	public void adicionarPrato(Prato novoPrato) {
		this.pratos.add(novoPrato);
	}
	
	public List<String> getCaracteristicasPratosMassa(){
		return this.getPratosMassa().stream()
				.filter(prato -> prato.getCatacteristica() != null)
				.map(prato -> prato.getCatacteristica()).collect(Collectors.toList());
	}
	
	public List<String> getCaracteristicasPratosNaoMassa(){
		return getPratosNaoMassa().stream()
				.filter(prato -> prato.getCatacteristica() != null)
				.map(prato -> prato.getCatacteristica()).collect(Collectors.toList());
	}
	
	public List<Prato> getPratosMassa() {
		return pratos.stream().filter(prato -> prato.isMassa()).collect(Collectors.toList());
	}
	
	public List<Prato> getPratosNaoMassa() {
		return pratos.stream().filter(prato -> !prato.isMassa()).collect(Collectors.toList());
	}

	public Optional<Prato> buscarPorCaracteristica(String caracteristica) {
		return this.pratos.stream().filter(prato -> prato.getCatacteristica() != null && prato.getCatacteristica().equals(caracteristica)).findFirst();
	}
}
