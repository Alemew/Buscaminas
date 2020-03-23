package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Control.MarcarCasillaController;
import Modelo.Casilla;
import Modelo.Coordenada;
import Modelo.Tablero;

class MarcarCasillaTest {

	@Test
	void marcarCasillatest() {
		
		Coordenada coordenada = new Coordenada(0, 0);
		Casilla prueba = new Casilla();
		prueba.marcar();
		
		int dimension = 5;
		int numeroBombas = 10;
		Tablero pruebaTablero = new Tablero(dimension, numeroBombas);
		
		MarcarCasillaController test = new MarcarCasillaController(pruebaTablero);
		
		Coordenada prueba1 = new Coordenada(2, 4);
		test.marcarCasilla(prueba1);
		
		
		assertEquals(prueba.isMarcada(), pruebaTablero.getTablero()[2][4].isMarcada());
		
		
		
		
	}

}
