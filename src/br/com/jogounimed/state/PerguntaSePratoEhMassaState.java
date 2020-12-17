package br.com.jogounimed.state;
import javax.swing.JOptionPane;

import br.com.jogounimed.model.ListaDePratos;

public class PerguntaSePratoEhMassaState implements State {
	
	private final int SIM = 0;
	private final int NAO = 1;
	
	private State proximoState;

	@Override
	public void executa(ListaDePratos pratos) {
		int resposta = JOptionPane.showConfirmDialog(null, "O prato que você pensou é massa?", 
				"Confirm", JOptionPane.YES_NO_OPTION);
		
		if(resposta == SIM || resposta == NAO) {
			this.proximoState = new PerguntaCaracteristicasState(resposta);
			this.proximoState.executa(pratos);
		}else {
			throw new RuntimeException("Aplicação encerrada");
		}

	}

}
