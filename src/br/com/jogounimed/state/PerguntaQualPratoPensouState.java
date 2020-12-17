package br.com.jogounimed.state;

import javax.swing.JOptionPane;

import br.com.jogounimed.model.ListaDePratos;
import br.com.jogounimed.model.Prato;

public class PerguntaQualPratoPensouState implements State {

	private int respostaIsMassa;
	private Prato ultimoPratoVerificado;
	private State proximoState = new InicioState();

	public PerguntaQualPratoPensouState(int respostaIsMassa, Prato ultimoPratoVerificado) {
		this.respostaIsMassa = respostaIsMassa;
		this.ultimoPratoVerificado = ultimoPratoVerificado;
	}

	@Override
	public void executa(ListaDePratos pratos) {
		String nomeDoPratoPensado = JOptionPane.showInputDialog("Qual prato você pensou?");
		String caracteristica = JOptionPane.showInputDialog(nomeDoPratoPensado + " é _______ mas " + ultimoPratoVerificado.getNome() + " não.");
		Prato novoPrato = new Prato(nomeDoPratoPensado, (respostaIsMassa == 0 ? true : false), caracteristica);
		pratos.adicionarPrato(novoPrato);
		proximoState.executa(pratos);
	}

}
