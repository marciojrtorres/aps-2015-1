package reajuste;

public class Pagamento {
	
	private final double valorBase;
	private CotacaoWebService cotacao = new CotacaoWebService();
	private int bonus;

	public Pagamento(double valorBase, int bonus) {
		this.valorBase = valorBase;
		this.bonus = bonus;
	}
	

	public double calcula() {
		return valorBase * cotacao.getCotacao() + bonus * cotacao.getCotacao();
	}

}
