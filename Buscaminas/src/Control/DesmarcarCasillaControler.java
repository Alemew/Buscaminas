package Control;

import Modelo.Coordenada;
import Modelo.Tablero;

public class DesmarcarCasillaControler {

	private Tablero tablero;

	public DesmarcarCasillaControler(Tablero tablero) {
		super();
		this.tablero = tablero;
	}
	
	public void desmarcarCasilla(Coordenada cooordenadaMarcada) {
		tablero.casillaMarcada(cooordenadaMarcada);
	}
}
