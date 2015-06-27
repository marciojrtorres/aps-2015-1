package util;

public class Time {
	
	public final int horas, minutos, segundos;
	
	public Time(int h, int m, int s) {
		this.horas = h % 24;
		this.minutos = m;
		this.segundos = s;
	}

	public String toString() {		
		return (horas < 10 ? "0" + horas : horas) 
			+ ":"
			+ (minutos < 10 ? "0" + minutos : minutos)
			+ ":"
			+ (segundos < 10 ? "0" + segundos : segundos);
	}

	public Time(int h, int m) {
		this.horas = h % 24;
		this.minutos = m % 60;
		this.segundos = 0;
	}

	public Time(int h) {
		if (h < 0) {
			throw new InvalidTimeException("Hora negativa recebida " + h + ", esperado um numero positivo");
		}
		this.horas = h % 24;
		this.minutos = 0;
		this.segundos = 0;
	}

	public Time() {
		this.horas = 0;
		this.minutos = 0;
		this.segundos = 0;
	}

	public Time plus(Time t) {
		int hora;
		hora = this.horas + t.horas;
		int minuto;
		minuto = this.minutos + t.minutos;
		int segundo;
		segundo = this.segundos + t.segundos;
		if(segundo > 60) {
			int aux2 = segundo / 60;
			minuto = minuto + aux2;
		}
		if(minuto > 60){
			int aux;
			aux = minuto / 60;
			hora = hora + aux;
			int aux2 = minuto % 60;
			minuto = minuto - (aux * 60);
		}
		return new Time(hora, minuto, segundo);
	}

	public Time plusHours(int h){
		int hora;
		hora = horas + h;
		if(hora >= 24) {
			hora = hora % 24;
		}
		return new Time(hora, minutos, segundos);
	}

	public Time plusMinutes(int m){
		int minuto;
		minuto = this.minutos + m;
		int hora;
		hora = this.horas;
		if(minuto > 60){
			int aux;
			aux = minuto / 60;
			hora = hora + aux;
			int aux2 = minuto % 60;
			minuto = minuto - (aux * 60);
		}
		return new Time(hora, minuto, segundos);
	}

	public Time plusSeconds(int s){
		int segundos = this.segundos;
		segundos = segundos + s;
		int minutos = this.minutos;
		if(segundos >= 60){
			int aux2 = segundos / 60;
			minutos = minutos + aux2;
			int aux = segundos / 60;
			segundos = segundos - (aux * 60);
		}
		return new Time(horas, minutos, segundos);
	}

	public Time minus(Time t){
		int hora;
		hora = this.horas - t.horas;
		int minuto;
		minuto = this.minutos - t.minutos;
		int segundo;
		segundo = this.segundos - t.segundos;
		if(segundo > 60) {
			int aux2 = segundo / 60;
			minuto = minuto + aux2;
		}
		if(minuto > 60){
			int aux;
			aux = minuto / 60;
			hora = hora + aux;
			int aux2 = minuto % 60;
			minuto = minuto - (aux * 60);
		}
		if(hora < 0){
			hora = 24 + hora;
		}
		return new Time(hora, minuto, segundo);
	}

	public Time minusHours(int h){
		int hora;
		hora = horas - h;
		if(hora >= 24) {
			hora = hora % 24;
		}
		return new Time(hora, minutos, segundos);
	}

	public Time minusMinutes(int m){
		int minuto = minutos - m;
		return new Time(horas, minuto, segundos);
	}

	public Time minusSeconds(int s){
		int segundos = this.segundos;
		segundos = segundos - s;
		int minutos = this.minutos;
		int hora = this.horas;
		if(segundos >= 60){
			int aux2 = segundos / 60;
			minutos = minutos + aux2;
			int aux = segundos / 60;
			segundos = segundos - (aux * 60);
		}
		if(hora > 24){
			hora =  hora - 24;
		}	
		if(segundos < 0){
			segundos =  (segundos * -1) - 24;
		}
		return new Time(hora, minutos, segundos);
	}

	public boolean isMidDay(){
		boolean teste = false;
		if(this.horas == 12 && this.minutos == 00 && this.segundos == 00){
			teste = true;
		}
		return teste;
	}

	public boolean isMidNight(){
		boolean teste = false;
		if(this.horas == 00 && this.minutos == 00 && this.segundos == 00){
			teste = true;
		}
		return teste;
	}

	public Time shift(){
		int hora = this.horas + 12;
		int minuto = this.minutos;
		int segundo = this.segundos;
		if(hora > 24){
			hora =  hora - 24;
		}	
		return new Time(hora, minuto, segundo);
	}

	public Time tick(){
		int segundo = this.segundos;
		segundo = segundo + 1;
		return new Time(horas, minutos, segundo);
	}

}