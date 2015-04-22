package diskmonitor;

public class PrintFreeSpaceEnhanced extends PrintFreeSpace {
  @Override
  public void show(long free) {
    super.show(free);
    System.out.println("-------------------------------");
  }
}