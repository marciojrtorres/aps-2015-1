package game;

public class Personagem {

  private String nome;
  private int energia;
  private Ataque ataque;

  public Personagem(String nome, int energia, Ataque ataque) {
    this.nome = nome;
    this.energia = energia;
    this.ataque = ataque;
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
    if (ataque != null) ataque.ataca(this, outro);
  }

  public boolean equals(Personagem outro) {
    return this.getNome().equals(outro.getNome());
  }

  public String toString() {
    return this.nome + " " + this.energia;
  }
}