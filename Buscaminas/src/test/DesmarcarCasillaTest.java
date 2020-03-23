package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Control.DesmarcarCasillaController;
import Control.MarcarCasillaController;
import Modelo.Casilla;
import Modelo.Coordenada;
import Modelo.Tablero;

public class DesmarcarCasillaTest {

	@Test
	void desmarcarCasillatest() {
		
		Coordenada coordenada = new Coordenada(0, 0);
		Casilla prueba = new Casilla();
		
		int dimension = 5;
		int numeroBombas = 10;
		Tablero pruebaTablero = new Tablero(dimension, numeroBombas);
		
		DesmarcarCasillaController test = new DesmarcarCasillaController(pruebaTablero);
		
		Coordenada prueba1 = new Coordenada(2, 4);
		prueba.marcar();
		test.desmarcarCasilla(prueba1);
		
		
		assertEquals(prueba.isMarcada(), pruebaTablero.getTablero()[2][4].isMarcada());
		
		
		
		
	}
	
}
