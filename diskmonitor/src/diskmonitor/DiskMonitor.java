package diskmonitor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// DiskMonitor é o EventSource (fonte de eventos: DiskSpaceChange)

public class DiskMonitor {

  private String unidade;
  // lista de ouvites/observadores
  private List<DiskSpaceListener> listeners =
		  new ArrayList<DiskSpaceListener>();
  // meios de adicionar e remover ouvintes
  // add/remove Listener
  public void addDiskSpaceListener(DiskSpaceListener l) {
	  listeners.add(l);
  }
  
  public void removeDiskSpaceListener(DiskSpaceListener l) {
	  listeners.remove(l);
  }
  
  public DiskMonitor(String unidade) {
    this.unidade = unidade;
  }

  public void start() {
    try {
      File f = new File(unidade);
      long free = 0;
      while (true) {
        Thread.sleep(1000); // tick
        long bytes = f.getFreeSpace();
        if (bytes != free) {
        	free = bytes;
        	
        	long used = f.getTotalSpace() - free;
        	DiskSpaceEvent evt = 
        			new DiskSpaceEvent(free, used, unidade);
        	// notificar os ouvintes
        	for (DiskSpaceListener l : listeners) {
        		l.diskSpaceChange(evt);
        	}
        }
      }
    } catch (Exception e) {
      // deixar quebrar
      throw new RuntimeException(e);
    }
  }
}