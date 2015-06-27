package util.test;

import util.Time;

public class Main {
	public static void main(String[] args) {		
		long inicio = System.currentTimeMillis();
		
		Time t1 = new Time(1);
		Time t2 = new Time();
		for (int i = 0; i < 1_000_000; i++) {
			t2 = t2.plus(t1);
		}
		
		long fim = System.currentTimeMillis();		
		
		System.out.println((fim - inicio) + "ms decorridos");
	}
}