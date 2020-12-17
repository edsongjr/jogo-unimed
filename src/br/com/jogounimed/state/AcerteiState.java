package br.com.jogounimed.state;
import javax.swing.JOptionPane;

import br.com.jogounimed.model.ListaDePratos;

public class AcerteiState implements State {
	
	private State proximoState = new InicioState();
	
	public void executa(ListaDePratos pratos) {
		JOptionPane.showMessageDialog(null, "Acertei denovo", "Jogo Unimed Fortaleza",
				JOptionPane.DEFAULT_OPTION);
		
		this.proximoState.executa(pratos);
	}
}
