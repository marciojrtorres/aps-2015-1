package toolkit;

// Padrão de Projeto conhecido como PROXY
// Um objeto responde por outro de mesma interface
// modificando as consultas e/ou os comandos
// criteriosamente.

// Padrão de Projeto Proxy também é conhecido
// como WRAPPER (embrulhar um objeto em outro)
public class DadoEmDobro implements Dado {

  private Dado dado;


  public DadoEmDobro(Dado dado) {
    this.dado = dado;
  }

  @Override
  public int getFaces() {
    return dado.getFaces() * 2;
  }

  public void jogar() {
    dado.jogar();
  }

  public int getValor() {
    return dado.getValor() * 2;
  }
}