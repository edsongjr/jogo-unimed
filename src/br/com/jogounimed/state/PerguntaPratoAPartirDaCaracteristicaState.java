package br.com.jogounimed.state;

import java.util.Optional;

import javax.swing.JOptionPane;

import br.com.jogounimed.model.ListaDePratos;
import br.com.jogounimed.model.Prato;

public class PerguntaPratoAPartirDaCaracteristicaState implements State {

	private final int SIM = 0;
	private final int NAO = 1;
	private String caracteristica;
	private State proximoState;
	private int respostaIsMassa;

	public PerguntaPratoAPartirDaCaracteristicaState(int respostaIsMassa, String caracteristica) {
		this.respostaIsMassa = respostaIsMassa;
		this.caracteristica = caracteristica;
	}

	@Override
	public void executa(ListaDePratos pratos) {
		Optional<Prato> prato = pratos.buscarPorCaracteristica(this.caracteristica);
		if(prato.isPresent()) {
			int resposta = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + prato.get().getNome() + "?", 
					"Confirm", JOptionPane.YES_NO_OPTION);
			
			if(resposta == SIM) {
				this.proximoState = new AcerteiState();
				this.proximoState.executa(pratos);
			}else if(resposta == NAO) {
				this.proximoState = new PerguntaQualPratoPensouState(this.respostaIsMassa, prato.get());
				this.proximoState.executa(pratos);
			}else {
				throw new RuntimeException("Aplicação encerrada");
			}
		}
	}
}
