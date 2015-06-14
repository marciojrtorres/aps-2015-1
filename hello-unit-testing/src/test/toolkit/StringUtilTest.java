package test.toolkit;

import static toolkit.StringUtil.eq;
import static toolkit.StringUtil.titleize;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import toolkit.StringUtil;

public class StringUtilTest {
	
	// Quem é o SUT? System Under Test -> Classe StringUtil

	// Um TC (Test Case / Caso de Tese)
	@Test       // nomes bem descritivos
	public void test_titleize_frase_4_palavras_minusculas() {
		// System.out.println(eq(titleize("um texto de teste"), "Um Texto De Teste"));
									 // esperado,         obtido
		org.junit.Assert.assertEquals("Um Texto De Teste", titleize("um texto de teste"));
	}
	
	// @Ignore descomentar caso queira ignorar o caso de teste 
	@Test // metadado, annotation que indica um Caso de Teste
	public void test_titleize_string_vazia_retorna_string_vazia() {
		assertEquals("", titleize(""));
	}
	
	@Test
	public void test_titleize_1_palavra_minuscula_fica_inicial_maiuscula() {
		assertEquals("Teste", titleize("teste"));
	}
	
	@Test
	public void test_titleize_1_palavra_com_espaco_antes_removido_espaco_inicial_maiuscula() {
		assertEquals("Teste", titleize("    teste"));
	}
	
	@Test
	public void test_frase_maiuscula_vira_minuscula_titleized() {
		// System.out.println(eq(titleize("UM TEXTO DE TESTE"), "Um Texto De Teste"));
		assertEquals("Um Texto De Teste", titleize("UM TEXTO DE TESTE"));
	}
	
	@Test
	public void test_string_sem_caracteres_fica_inalterada() {
		assertEquals("2323%%#!!@#@@#!@@#$%#", titleize("2323%%#!!@#@@#!@@#$%#"));
	}
	
	@Test
	public void test_trimRight_string_vazia_fica_inalterada() {
		assertEquals("", StringUtil.trimRight(""));
	}
	
	@Test
	public void test_trimRight_string_soh_com_espacos_fica_vazia() {
		assertEquals("", StringUtil.trimRight("             "));
	}
	
	@Test
	public void test_trimRight_string_com_espacos_direita_tem_espacos_removidos() {
		assertEquals("teste", StringUtil.trimRight("teste      "));
	}
	
	@Test
	public void test_split_duas_strings_com_espaco_volta_vetor_duas_strings() {
		String input = "uma frase de teste";
		String[] output = {"uma", "frase", "de", "teste"};
		assertArrayEquals(output, StringUtil.split(input, ' '));
	}
	
	@Test
	public void test_eq_true_duas_strings_iguais() {
		assertTrue(StringUtil.eq("teste", "teste"));
	}
	
	@Test
	public void test_eq_true_duas_strings_diferentes() {		
		assertFalse(StringUtil.eq("teste", "testa"));		
	}
	
	
	@Test
	public void test_doubles() {
		assertEquals(0.2, 0.1 + 0.1, 0.0);
		assertEquals(0.3, 0.1 + 0.1 + 0.1, 0.00000001);
	}
	
	
}
