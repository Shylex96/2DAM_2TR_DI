package es.studium.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestCajaBlanca {

	@Test
	void testCamino1() {

		// Resultado real: Se obtiene al llamar al método con un número par
		boolean resultadoReal = CajaBlanca.esPar(2);

		// Resultado esperado: Se espera que el método devuelva true para un número par
		boolean resultadoEsperado = true;

		// Verificación: Compara los resultados y determina si el test pasa o no
		assertEquals(resultadoReal, resultadoEsperado);
	}
	
	@Test
	void testCamino2() {

		// Resultado real: Se obtiene al llamar al método con un número par
		boolean resultadoReal = CajaBlanca.esPar(2);

		// Resultado esperado: Se espera que el método devuelva true para un número par
		boolean resultadoEsperado = true;

		// Verificación: Compara los resultados y determina si el test pasa o no
		assertEquals(resultadoReal, resultadoEsperado);
	}
}
