package Modelo;

public class Tablero {

	private Casilla[][] tablero;
	
	public Tablero(int dimension, int numeroBombas) {
		super();
		
		generarTablero(dimension);
		colocarBombas(dimension, numeroBombas);
		
	}
	
	private void generarTablero(int dimension) {
		tablero = new Casilla[dimension][dimension];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = new Casilla();
			}
		}
	}
	
	private void colocarBombas(int dimension, int numeroBombas) {
		for (int i = 0; i < numeroBombas; i++) {
			int aleatorioX = (int) (Math.random() * dimension);
			int aleatorioY = (int) (Math.random() * dimension);
			if (tablero[aleatorioX][aleatorioY].isBomba()) {
				i--;
			}else {
				tablero[aleatorioX][aleatorioY].setBomba(true);
			}
		}

	}
	
	public Casilla[][] getTablero() {
		return tablero;
	}
	public void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}
	
	public void casillaMarcada(Coordenada coordenada) {
		this.tablero[coordenada.getX()][coordenada.getY()].marcar();;
	}
	
	public void desmarcarCasilla(Coordenada coordenada) {
		casillaMarcada(coordenada);

	}
	
	
	
}
