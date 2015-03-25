package toolkit;

import static toolkit.Calc.*;
import static toolkit.StringUtil.eq;
import static toolkit.StringUtil.strip;
import static toolkit.StringUtil.upcase;
import static toolkit.StringUtil.downcase;
import static toolkit.StringUtil.capitalize;
import static java.lang.System.out;

public class Main {
  public static void jogo(Dado d) {
    d.jogar();
    System.out.println(d.getValor());
  }

  public static void main(String[] args) {

    // Padrão de Projeto
    // Motivação: permitir a
    // definição de um corpo comum de um
    // algoritmo (jogar) deixando ganchos
    // para a parte variável do algoritmo (faces)

    // Template Method
    Dado d = new Dado18Faces();
    jogo(d);
    jogo(new Dado6Faces());
    // jogo(new Dado2de6Faces());

    //Dado6Faces d1 = new Dado(); // falha
    //Object d2 = new Dado();
    //Object d3 = new Dado6Faces();


    // jogar é um comando, não consulta o estado
    // Princípio Separação Comando/Consulta
    //d.jogar(); // randomizar a face
    //int n = d.getValor(); // consultar
    //System.out.println(n);






    /*
    System.out.println(eq(upcase(" a1b#c% "), " A1B#C% "));
    System.out.println(eq(downcase(" A1B#C% "), " a1b#c% "));
    out.println(eq(capitalize("um texto"), "Um texto"));
    out.println(eq(capitalize("texto um"), "Texto um"));
    out.println(eq(capitalize("TEXTO UM"), "Texto um"));
    out.println(eq(capitalize("1texto um"), "1texto um"));
    out.println(eq(capitalize("1TEXTO UM"), "1texto um"));
    // out.println(eq(capitalize(""), ""));

    // refatoração:
    // alterações que
    // melhoram a qualidade interna
    // não altera, geralmente, a API


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
    */
  }

}

// javac -cp bin -d bin src/toolkit/Main.java
// cp:classpath:caminho das classes
// d:destination:destino

