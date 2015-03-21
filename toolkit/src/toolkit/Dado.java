package toolkit;

public abstract class Dado {

  private int valor;

  // Template Method (método modelo) é o método jogar
  // a parte fixa mas incompleta (falta uma parte do algoritmo)
  // qual é a parte variável? faces
  // a parte variável é o gancho do algoritmo
  // é um método abstrato
  public void jogar() {
    this.valor = (int) (Math.random() * getFaces() + 1);
  }

  public int getValor() {
    if (this.valor == 0) this.jogar();
    return this.valor;
  }

  // hook (gancho) parte do variável do algoritmo
  protected abstract int getFaces();
}