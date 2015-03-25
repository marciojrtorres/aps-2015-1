package toolkit;

public class Dado2x6Faces implements Dado {

  private Dado6Faces[] dados = new Dado6Faces[2];

  public Dado2x6Faces() {
    dados[0] = new Dado6Faces();
    dados[1] = new Dado6Faces();
  }

  @Override
  public int getFaces() { return 12; }

  @Override
  public void jogar() {
    for (Dado6Faces dado : dados) dado.jogar();
  }

  @Override
  public int getValor() {
    return dados[0].getValor() + dados[1].getValor();
  }

}