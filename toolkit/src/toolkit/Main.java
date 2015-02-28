package toolkit;

import static toolkit.Calc.*;

public class Main {
  public static void main(String[] args) {

    System.out.println(StringUtil.eq("abc", "abc") == true);
    System.out.println(StringUtil.eq("abc", "abc ") == false);
    System.out.println(StringUtil.eq("xyz", "qqq") == false);
    System.out.println(StringUtil.eq("xyzmno", "") == false);
    System.out.println(StringUtil.eq("", "") == true);


    // String texto = "programador";
    // // System.out.println(texto instanceof Object);
    // char[] caracteres = texto.toCharArray();
    // System.out.println(caracteres);
    // System.out.println(caracteres.length);
    // caracteres[1] = 'l';
    // caracteres[4] = 'l';
    // System.out.println(caracteres);
    // for (int i = 0; i < caracteres.length; i++) {
    //     System.out.println(caracteres[i]);
    // }
    // char[] teste = new char[3];
    // teste[0] = 'a';
    // teste[1] = 'b';
    // teste[2] = caracteres[10];
    // System.out.println(teste);
    // String tstr = new String(teste);
    // System.out.println(tstr);
    // System.out.println((int) 'a');
    // for (int i = 0; i < caracteres.length; i++) {
    //     System.out.println((int) caracteres[i]);
    // }
    // char c = 95;
    // System.out.println(c); // Tabela: ASC II
    // System.out.println((char) ('a' + 10));
    // System.out.println('a' - 'A');
  }
}

// javac -cp bin -d bin src/toolkit/Main.java
// cp:classpath:caminho das classes
// d:destination:destino