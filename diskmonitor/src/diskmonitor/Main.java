package diskmonitor;

public class Main {
  public static void main(String[] args) {

    DiskSpaceListener printer = new PrintFreeSpace();
    DiskSpaceWindow window = new DiskSpaceWindow();
    
    DiskMonitor disk = new DiskMonitor("/home"); // EventSource (fonte de eventos)
    
    disk.addDiskSpaceListener(printer);
    disk.addDiskSpaceListener(window);
 
    disk.start();
   
  }
}
