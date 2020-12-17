package br.com.jogounimed.state;
import javax.swing.JOptionPane;

import br.com.jogounimed.model.ListaDePratos;

public class InicioState implements State {
	
	private State proximoState = new PerguntaSePratoEhMassaState();

	@Override
	public void executa(ListaDePratos pratos) {
		JOptionPane.showMessageDialog(null, "Pense num prato que gosta", "Jogo Unimed Fortaleza",
				JOptionPane.DEFAULT_OPTION);
		
		this.proximoState.executa(pratos);
	}

}
