package game;

public class Personagem {

  private String nome;
  private int energia;

  public Personagem(String nome, int energia) {
    this.nome = nome;
    this.energia = energia;
  }

  public String getNome() {
    return nome;
  }

  public int getEnergia() {
    return this.energia;
  }

  public void setEnergia(int energia) {
    this.energia = energia;
  }

  public void ataca(Personagem outro) {
    System.out.println(this.getNome() + " ataca "
      + outro.getNome() + " com "
      + "machado");
    outro.setEnergia(outro.getEnergia() - 10);
    if (outro.getEnergia() <= 0) {
      System.out.println(outro.getNome() + " esta morto");
    }
  }

  public boolean equals(Personagem outro) {
    return this.getNome().equals(outro.getNome());
  }

  public String toString() {
    return this.nome + " " + this.energia;
  }
}