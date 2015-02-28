package toolkit;

public class Calc {
  // FAIL FAST PRINCIPLE: falha rápida/evidente
  public static int soma(int a, int b) {
    int r = a + b;
    if (a > 0 && b > 0 && r < 0) {
      throw new RuntimeException("estouro de inteiro");
    }
    return r;
  }
  // reaproveitamento de lógica, delegação
  public static int multiplica(int a, int b) {
    int r = 0;
    for (int i = 0; i < a; i++) {
      r = soma(r, b);
    }
    return r;
  }

  public static int potencia(int base, int exp) {
    int r = base;
    for (int i = 1; i < exp; i++) {
      r = multiplica(r, base);
    }
    return r;
  }

  public static int quadrado(int base) {
    return potencia(base, 2);
  }

  public static void main(String[] args) {
    System.out.println(Calc.soma(7, 3) == 10);
    // System.out.println(Calc.subtrai(7, 3) == 4);
    // System.out.println(Calc.multiplica(7, 3) == 21);
    // System.out.println(Calc.divide(7, 3) == 2);
    // System.out.println(Calc.resto(7, 3) == 1);
    // System.out.println(Calc.potencia(7, 3) == 343);
    // System.out.println(Calc.cubo(7) == 343);
    // System.out.println(Calc.quadrado(7) == 49);
  }
}