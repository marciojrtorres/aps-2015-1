package diskmonitor;


// OBSERVADOR:

// nome padrão Java: EventoListener
// public interface ShowFreeSpace {
// outros nomes: TempListener, WeatherListener, ...

public interface DiskSpaceListener {

	// o evento é recebido no método
	// existe um padrão de nomes para o método
	// não precisa existir só um método
	
	// onEvento (EVENTO NO METODO) OBJETO DO EVENTO
	public void diskSpaceChange(DiskSpaceEvent evt);

}