package Control;

import Modelo.Coordenada;
import Modelo.Tablero;

public class MarcarCasillaController {

	private Tablero tablero;

	public MarcarCasillaController(Tablero tablero) {
		super();
		this.tablero = tablero;
	}
	
	public void marcarCasilla(Coordenada coordenadaMarcada) {
		tablero.casillaMarcada(coordenadaMarcada);
	}
	
	
	
	
	
}
