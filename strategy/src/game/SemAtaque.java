package game;

public class SemAtaque implements Ataque {
  public String getNome() {
    return "nenhum";
  }

  public int getDano() {
    return 0;
  }

  public void ataca(Personagem atacante, Personagem alvo) {
    System.out.println(atacante.getNome() + " nao ataca");
  }
}