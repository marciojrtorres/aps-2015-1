package game;

public class Soco implements Ataque {
  public String getNome() {
    return "Soco";
  }

  public int getDano() {
    return 10;
  }

  public void ataca(Personagem atacante, Personagem alvo) {
    System.out.println(atacante.getNome() + " ataca "
      + alvo.getNome() + " com "
      + this.getNome() + " POWWWW!");
    alvo.setEnergia(alvo.getEnergia() - this.getDano());
    if (alvo.getEnergia() <= 0) {
      System.out.println(alvo.getNome() + " esta morto");
    } else {
      System.out.println(alvo.getNome() + " continua vivo");
    }
  }
}