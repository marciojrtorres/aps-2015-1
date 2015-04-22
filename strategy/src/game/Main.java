package game;

public class Main {
    public static void main(String[] args) {
        // Biblioteca b = new Biblioteca();
        // b.usar();

        // Arcabouço de um RPG = JOGO INCOMPLETO
        // Arcabouço = todo o código base (mínimo)

        // FRAMEWORK: bibloteca, parte de código tal como um componente
        // ou toolkit, porém com uma diferença fundamental: INCOMPLETO.
        Soco s = new Soco();
        Personagem p1 = new Personagem("Elfo", 100, s);
        // System.out.println(p1);
        Personagem p2 = new Personagem("Anao", 80, s);
        Personagem p3 = new Personagem("Humano", 90, s);
        Personagem p4 = new Personagem("Orc", 30, s);
        Personagem p5 = new Personagem("Mago", 120, s);
        Personagem p6 = new Personagem("Ogro", 90, s);
        Personagem p7 = new Personagem("Aldeão", 40, new SemAtaque());

        // OBJETIVO: PERMITIR NOVAS ARMAS, NOVOS ATAQUES, MAS
        // SEM ALTERAR A CLASSE PERSONAGEM

        // FECHAR A CLASSE PERSONAGEM PARA MODIFICAÇÕES
        // ABERTA A NOVOS COMPORTAMENTOS (ATAQUE)

        // PRINCÍPIO ABERTO/FECHADO (OCP OPEN/CLOSE PRINCIPLE)

        // ARMA COM UM COMPORTAMENTO VARIÁVEL
        // PERMITIR A TROCA DO COMPORTAMENTO A QUALQUER MOMENTO (TROCA DA ARMA)
        // UM COMPORTAMENTO (ALGORITMO) VARIÁVEL E INTERCAMBIÁVEL
        // É UM PADRÃO DE PROJETO: ESTRATÉGIA

        GameSimulador simulador = new GameSimulador(p1, p2, p3, p4, p5, p6, p7);
        simulador.simula();

        System.out.println(simulador.sobrou());
    }
}