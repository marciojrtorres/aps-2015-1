package toolkit;

public class UmJogo {
    private Dado dado;

    // tem vezes que a assinatura (api) não desonra o contrato
    // mas o comportamento sim
    public UmJogo(Dado dado) {
        this.dado = dado;
    }

    public void rodar() {
        dado.jogar();
        System.out.println(dado.getValor());
    }

    public void teste() {
        for (int i = 0; i < 100; i++) {
            rodar();
            int valorAnterior = dado.getValor();
            rodar();
            System.out.println(dado.getValor() == valorAnterior);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //Dado d = new Dado6Faces(); // isto deve funcionar, descomente para testar

        Dado d = new DadoViciado(new DadoEmDobro(new Dado18Faces())); // aqui está sua implementação

        UmJogo jogo = new UmJogo(d);
        //jogo.rodar(); // deve lançar o dado e imprimir um valor de 2 a 12
        jogo.teste(); // este método tem as assertivas
    }
}