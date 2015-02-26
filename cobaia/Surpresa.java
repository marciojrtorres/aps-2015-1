// Princípio da Menor Surpresa
public class Surpresa {
  public static void main(String[] args) {
    // assertiva 1 é igual a 1!
    System.out.println(1 == 1);
    System.out.println(0.1 + 0.1 == 0.2);
    // CTRL + SHIFT + D -> duplica linha
    // violação do princípio
    System.out.println(0.1 + 0.1 + 0.1 == 0.3);
    // assertiva
    System.out.println("casa".toUpperCase().equals("CASA"));
    // assertivas para pluralizar
    System.out.println(plural("casa").equals("casas"));
    System.out.println(plural("poder").equals("poderes"));
    // o certo depende de uma especificação!
    // devolve a raiz como num positivo: documentar
    System.out.println(raizQuadrada(4) == 2);
  }

  /**
  * Este método recebe uma palavra no singular
  * e devolve no plural
  *
  * @param palavra Palavra no singular
  * @return palavra no plural
  */
  static String plural(String palavra) {
    return palavra + "s";
  }
}