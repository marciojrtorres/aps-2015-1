package game;

public interface Ataque {

  public String getNome();

  public int getDano();

  public void ataca(Personagem atacante, Personagem alvo);

}