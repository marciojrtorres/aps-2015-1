package diskmonitor;

// interface
// observador
public class PrintFreeSpace implements ShowFreeSpace {

  @Override
  public void show(long bytes) {
    System.out.println(bytes + " bytes livres");
  }

}