package ava;

public class Financiamento {

	// setters e getters
	private String cliente;
	private double rendaBruta;
	private boolean moradiaPropria;
	private String fabricanteVeiculo;
	private String modeloVeiculo;
	private int anoFabricacaoVeiculo;
	private int anoModeloVeiculo;
	private double valorVeiculo;
	private double valorEntrada;
	private String tipo;

	// só getters
	private int periodos;
	private double valorTarifaAberturaCredito;
	private double valorFinal;
	private double valorParcela;

	
	
	public void calcula(int meses) {
		// montante = capital * (1 + juros) ^ periodos
		if ("conv2015".equals(tipo)) {
			this.valorFinal = getValorFinanciado() * Math.pow(1 + 0.02, meses);
			this.valorParcela = this.valorFinal / meses;
			this.valorTarifaAberturaCredito = 200.0;
			this.periodos = meses;
		} else if ("vip2015".equals(tipo)) {
			this.valorFinal = getValorFinanciado() * Math.pow(1 + 0.015, meses);
			this.valorParcela = this.valorFinal / meses;
			this.valorTarifaAberturaCredito = 100.0;
			this.periodos = meses;
		} else if ("vip2015TACembutida".equals(tipo)) {
			this.valorTarifaAberturaCredito = 100.0;
			this.valorFinal = (getValorFinanciado() + valorTarifaAberturaCredito) * Math.pow(1 + 0.015, meses);
			this.valorParcela = this.valorFinal / meses;			
			this.periodos = meses;
		} else {
			throw new IllegalStateException("Tipo " + tipo + " nao reconhecido");
		}
	}

}