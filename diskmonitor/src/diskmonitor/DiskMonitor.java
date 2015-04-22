package diskmonitor;

import java.io.*;

// lógica do problema // observado // observável
public class DiskMonitor {

  private String unidade;
  private ShowFreeSpace[] observadores = new ShowFreeSpace[1000];
  // acoplamento mínimo (depender de uma interface (abstração))
  private ShowFreeSpace presentation; // = new PrintFreeSpace(); == reduzir o acoplamento

  public DiskMonitor(String unidade, ShowFreeSpace presentation) {
    this.unidade = unidade;
    this.presentation = presentation;
  }

  public void start() {
    // engessado
    // dependência de uma classe concreta
    // declara e instancia
    // ou seja, ele conhece o abstrato e também o concreto
    // PrintFreeSpace printer = new PrintFreeSpace();
    // controle da leitura da unidade
    // missão: reduzir o acoplamento
    // acoplamento: nível de dependência
    // entre classes e objetos
    // mais dependência -> mais acoplamento -> acoplamento forte
    // menos dependência -> menos acoplamento -> acoplamento fraco
    try {
      File f = new File(unidade);
      long free = 0;
      while (true) {
        Thread.sleep(1000); // tick
        long bytes = f.getFreeSpace();
        if (bytes != free) {
          // apresentação da informação --------------
          presentation.show(bytes);
          // -----------------------------------------
          free = bytes;
        }
      }
    } catch (Exception e) {
      // deixar quebrar
      throw new RuntimeException(e);
    }
  }
}