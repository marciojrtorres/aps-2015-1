package diskmonitor;

public class DiskSpaceEvent {

	private final long free;
	private final long used;
	private final String unidade;

	public DiskSpaceEvent(long free, long used, String unidade) {
		this.free = free;
		this.used = used;
		this.unidade = unidade;
	}
	
	public long getFree() { return free; }
	public long getUsed() { return used; }
	public String getUnidade() { return unidade; }

}