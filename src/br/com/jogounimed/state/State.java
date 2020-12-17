package br.com.jogounimed.state;
import br.com.jogounimed.model.ListaDePratos;

public interface State {
	public void executa(ListaDePratos pratos);
}
