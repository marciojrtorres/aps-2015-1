package ava;

public abstract class Financiamento {
	// CTRL + 3 ggas
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
	//private String tipo;

	// só getters
	private int periodos;
	private double valorTarifaAberturaCredito;
	private double valorFinal;
	private double valorParcela;


	// CTRL + SHIFT + F: FORMATAR CODIGO

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getRendaBruta() {
		return rendaBruta;
	}

	public void setRendaBruta(double rendaBruta) {
		this.rendaBruta = rendaBruta;
	}

	public boolean isMoradiaPropria() {
		return moradiaPropria;
	}

	public void setMoradiaPropria(boolean moradiaPropria) {
		this.moradiaPropria = moradiaPropria;
	}

	public String getFabricanteVeiculo() {
		return fabricanteVeiculo;
	}

	public void setFabricanteVeiculo(String fabricanteVeiculo) {
		this.fabricanteVeiculo = fabricanteVeiculo;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public int getAnoFabricacaoVeiculo() {
		return anoFabricacaoVeiculo;
	}

	public void setAnoFabricacaoVeiculo(int anoFabricacaoVeiculo) {
		this.anoFabricacaoVeiculo = anoFabricacaoVeiculo;
	}

	public int getAnoModeloVeiculo() {
		return anoModeloVeiculo;
	}

	public void setAnoModeloVeiculo(int anoModeloVeiculo) {
		this.anoModeloVeiculo = anoModeloVeiculo;
	}

	public double getValorVeiculo() {
		return valorVeiculo;
	}

	public void setValorVeiculo(double valorVeiculo) {
		this.valorVeiculo = valorVeiculo;
	}

	public double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPeriodos() {
		return periodos;
	}

	public double getValorTarifaAberturaCredito() {
		return valorTarifaAberturaCredito;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void calcula(int meses) {
		// montante = capital * (1 + juros) ^ periodos
		if ("conv2015".equals(tipo)) {
			// CTRL + 1: CODE ASSIST
			this.valorFinal = getValorFinanciado() * Math.pow(1 + 0.02, meses);
			this.valorParcela = this.valorFinal / meses;
			this.valorTarifaAberturaCredito = valorTarifaAbertua();
			this.periodos = meses;
		} else if ("vip2015".equals(tipo)) {
			this.valorFinal = getValorFinanciado() * Math.pow(1 + 0.015, meses);
			this.valorParcela = this.valorFinal / meses;
			this.valorTarifaAberturaCredito = 100.0;
			this.periodos = meses;
		} else if ("vip2015TACembutida".equals(tipo)) {
			this.valorTarifaAberturaCredito = 100.0;
			this.valorFinal = (getValorFinanciado() + valorTarifaAberturaCredito)
					* Math.pow(1 + 0.015, meses);
			this.valorParcela = this.valorFinal / meses;
			this.periodos = meses;
		} else if ("+lucrobanco".equals(tipo)) {
			this.valorTarifaAberturaCredito = 500.0;
			if (moradiaPropria) {
				this.valorFinal = (getValorFinanciado() + valorTarifaAberturaCredito)
					* Math.pow(1 + 0.055, meses);
			} else {
				this.valorFinal = (getValorFinanciado() + valorTarifaAberturaCredito)
						* Math.pow(1 + 0.08, meses);
			}
			this.valorParcela = this.valorFinal / meses;
			this.periodos = meses;
		} else {
			throw new IllegalStateException("Tipo " + tipo + " nao reconhecido");
		}
	}

	public double getValorFinanciado() {
		return valorVeiculo - valorEntrada;
	}

}