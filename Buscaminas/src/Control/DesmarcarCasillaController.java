package Control;

import Modelo.Coordenada;
import Modelo.Tablero;

public class DesmarcarCasillaController {

	private Tablero tablero;

	public DesmarcarCasillaController(Tablero tablero) {
		super();
		this.tablero = tablero;
	}
	
	public void desmarcarCasilla(Coordenada cooordenadaMarcada) {
		tablero.casillaMarcada(cooordenadaMarcada);
	}
}
