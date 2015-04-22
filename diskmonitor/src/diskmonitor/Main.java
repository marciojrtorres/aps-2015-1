package diskmonitor;

public class Main {
  public static void main(String[] args) {

    // não é observer, não é estratégia
    // é parecido com ambos (camada de abstração)
    ShowFreeSpace printer = new PrintFreeSpace();
    DiskMonitor disk = new DiskMonitor("/home", new ShowFreeSpace() {
        public void show(long bytes) {
            try {
                Runtime.getRuntime().exec("notify-send -t=100 " + bytes + "b free");
            } catch (Exception e) {}
        }
    });
    disk.start();
  }
}
// 347823843 bytes livres
// 347823043 bytes livres
// 347821043 bytes livres
