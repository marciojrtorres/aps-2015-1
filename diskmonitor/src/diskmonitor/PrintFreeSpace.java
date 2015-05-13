package diskmonitor;

// observador concreto
public class PrintFreeSpace implements DiskSpaceListener {
	@Override
	public void diskSpaceChange(DiskSpaceEvent evt) {
		System.out.println(evt.getUnidade() 
				+ " com " 
				+ (evt.getFree() / 1024 / 1024)
				+ " MB livres");
	}
}