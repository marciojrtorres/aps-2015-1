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
        int[] resultados = new int[13];
        for (int i = 0; i < 1000; i++) {
            dado.jogar();
            int v = dado.getValor();
            // não pode ser > 12
            if (v > 12) throw new RuntimeException("maior que doze");
            resultados[v]++;
        }
        // não pode dar 0
        System.out.println(resultados[0] == 0);
        // não pode dar 1
        System.out.println(resultados[1] == 0);
        for (int i = 0; i < resultados.length; i++) {
            // 7 deve ser o resultado mais frequente (ver referências)
            if (i != 7) System.out.println(resultados[i] < resultados[7]);
        }
    }

    public static void main(String[] args) {
        //Dado d = new Dado6Faces(); // isto deve funcionar, descomente para testar

        Dado d = new Dado2x6Faces(); // aqui está sua implementação

        UmJogo jogo = new UmJogo(d);
        jogo.rodar(); // deve lançar o dado e imprimir um valor de 2 a 12
        jogo.teste(); // este método tem as assertivas
    }
}