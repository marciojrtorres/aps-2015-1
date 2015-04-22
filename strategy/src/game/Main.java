package game;

public class Main {
    public static void main(String[] args) {
        Personagem p1 = new Personagem("Elfo", 100);
        Personagem p2 = new Personagem("Anao", 80);
        Personagem p3 = new Personagem("Humano", 90);
        Personagem p4 = new Personagem("Orc", 30);
        Personagem p5 = new Personagem("Mago", 120);
        Personagem p6 = new Personagem("Ogro", 90);

        GameSimulador simulador = new GameSimulador(p1, p2, p3, p4, p5, p6);
        simulador.simula();

        System.out.println(simulador.sobrou());
    }
}