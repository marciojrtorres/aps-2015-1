package toolkit;

// Padrão de Projeto conhecido como PROXY
// Um objeto responde por outro de mesma interface
// modificando as consultas e/ou os comandos
// criteriosamente.

// Padrão de Projeto Proxy também é conhecido
// como WRAPPER (embrulhar um objeto em outro)
public class DadoViciado implements Dado {

  private Dado dado;
  private boolean primeira = true;

  public DadoViciado(Dado dado) {
    this.dado = dado;
  }

  @Override
  public int getFaces() {
    return dado.getFaces();
  }

  public void jogar() {
    if (primeira) {
      dado.jogar();
      primeira = false;
    } else {
      primeira = true;
    }
  }

  public int getValor() {
    return dado.getValor();
  }
}