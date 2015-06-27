package util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.InvalidTimeException;
import util.Time;

public class TimeTest {
	
	@Test
	public void test_time_inicio_relogio_zerado() {
		Time t1 = new Time();
		assertEquals("00:00:00", t1.toString());
		Time t2 = new Time(1, 40, 5);
		assertEquals("01:40:05", t2.toString());
		Time t3 = t1.plus(t2);
		assertEquals("01:40:05", t3.toString());
		assertEquals(1, t3.horas);
		assertEquals(40, t3.minutos);
		assertEquals(05, t3.segundos);
	}

	@Test
	public void test_hora_negativa_deve_lancar_excecao() {		
		// modo tosco de esperar uma excecao
		try {
			Time t = new Time(-9);
			fail("A excecao ITE nao aconteceu");
		} catch (InvalidTimeException e) {
			// ok
		}
	}
	
	@Test(expected=InvalidTimeException.class)
	public void test_hora_negativa_deve_lancar_excecao2() {
		Time t = new Time(-1);
	}
	
	@Test(expected=NumberFormatException.class)
	public void test_numero_com_espaco_deve_lancar_NumberFormatException() {
		Integer.parseInt(" 23");
	}
	
	@Test(timeout=100)
	public void deve_ser_capaz_de_somar_1000000_vezes_em_ate_100ms() {
		Time t1 = new Time(1);		
		Time t2 = new Time();
		for (int i = 0; i < 1000000; i++) {
			t2 = t2.plus(t1);
		}		
	}
	
	@Test(timeout=100)
	public void time_plus_more_than_60() {
		Time t1 = new Time(23, 20);
		assertEquals(0, t1.plus(new Time(0, 40)).minutos);
				
	}
}











