package br.com.jogounimed.state;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.jogounimed.model.ListaDePratos;

public class PerguntaCaracteristicasState implements State {

	private int respostaIsMassa;
	private final int SIM = 0;
	private State proximoState;

	public PerguntaCaracteristicasState(int respostaIsMassa) {
		this.respostaIsMassa = respostaIsMassa;
	}

	@Override
	public void executa(ListaDePratos pratos) {
		List<String> caracteristicas;
		if (this.respostaIsMassa == SIM) {
			caracteristicas = pratos.getCaracteristicasPratosMassa();
		} else {
			caracteristicas = pratos.getCaracteristicasPratosNaoMassa();
		}

		if (caracteristicas.isEmpty()) {
			this.proximoState = new PerguntaPratosState(respostaIsMassa);
			this.proximoState.executa(pratos);
		} else {
			for (int pratoIndex = 0; pratoIndex < caracteristicas.size(); pratoIndex++) {
				String caracteristica = caracteristicas.get(pratoIndex);
				int resposta = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + 
				caracteristica + " ?", "Confirm", JOptionPane.YES_NO_OPTION);

				if (resposta == SIM) {
					this.proximoState = new PerguntaPratoAPartirDaCaracteristicaState(respostaIsMassa, 
							caracteristica);
					this.proximoState.executa(pratos);
				}
			}
			this.proximoState = new PerguntaPratosState(respostaIsMassa);
			this.proximoState.executa(pratos);
		}

	}

}
