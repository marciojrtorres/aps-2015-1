package ava;

public class Main {
    public static void main(String[] args) {

        Financiamento f = new Financiamento();
        f.setCliente("Alan Turing");
        f.setRendaBruta(3000.0);
        f.setMoradiaPropria(true);
        f.setFabricanteVeiculo("Chevrolet");
        f.setModeloVeiculo("Agile");
        f.setAnoFabricacaoVeiculo(2013);
        f.setAnoModeloVeiculo(2014);
        f.setValorVeiculo(32000.0);
        f.setValorEntrada(22000.0);

        System.out.println(f.getValorFinanciado() == 10000.0);

        f.setTipo("+lucrobanco");
        // CTRL + CLIQUE = IR PARA
        f.calcula(24); // parcelas

        System.out.println(f.getValorTarifaAberturaCredito()); // 200.0
        System.out.println(f.getValorParcela());  // 670.18      
        System.out.println(f.getValorFinal()); // 16084.37
        System.out.println(f.getPeriodos()); // 24
    }
}