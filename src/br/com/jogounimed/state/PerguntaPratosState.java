package br.com.jogounimed.state;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.jogounimed.model.ListaDePratos;
import br.com.jogounimed.model.Prato;

public class PerguntaPratosState implements State {

	private final int SIM = 0;
	private final int NAO = 1;
	private int respostaIsMassa;
	private State proximoState;

	public PerguntaPratosState(int respostaIsMassa) {
		this.respostaIsMassa = respostaIsMassa;
	}

	@Override
	public void executa(ListaDePratos pratos) {
		List<Prato> pratosPergunta;
		if(this.respostaIsMassa == SIM) {
			pratosPergunta = pratos.getPratosMassa();
		}else if(this.respostaIsMassa == NAO) {
			pratosPergunta = pratos.getPratosNaoMassa();
		}else {
			throw new RuntimeException("Aplicação encerrada");
		}
		
		for (int pratoIndex = 0; pratoIndex < pratosPergunta.size(); pratoIndex++) {
			Prato prato = pratosPergunta.get(pratoIndex);
			String nomeDoPrato = prato.getNome();
			int resposta = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + nomeDoPrato + " ?", 
					"Confirm", JOptionPane.YES_NO_OPTION);
			
			if(resposta == SIM) {
				this.proximoState = new AcerteiState();
				this.proximoState.executa(pratos);
			}else if(resposta == NAO) {
				this.proximoState = new PerguntaQualPratoPensouState(respostaIsMassa, prato);
				this.proximoState.executa(pratos);
			}else {
				throw new RuntimeException("Aplicação encerrada");
			}
		}

	}

}
