package Modelo;

public class Tablero {

	private Casilla[][] casillas;
	
	public Tablero(int dimension, int numeroBombas) {
		super();
		
		generarTablero(dimension);
		colocarBombas(dimension, numeroBombas);
		
	}
	public Tablero(Casilla[][] casillas) {
		super();
		this.casillas = casillas;
	}
	
	public Casilla[][] getCasillas() {
		return casillas;
	}


	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}
	
	private void generarTablero(int dimension) {
		casillas = new Casilla[dimension][dimension];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				casillas[i][j] = new Casilla();
			}
		}
	}
	
	private void colocarBombas(int dimension, int numeroBombas) {
		for (int i = 0; i < numeroBombas; i++) {
			int aleatorioX = (int) (Math.random() * dimension);
			int aleatorioY = (int) (Math.random() * dimension);
			if (casillas[aleatorioX][aleatorioY].isBomba()) {
				i--;
			}else {
				casillas[aleatorioX][aleatorioY].setBomba(true);
			}
		}

	}
	
	private void asignarBA() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				if (!casillas[i][j].isBomba()) {
					casillas[i][j].setMinasAlrededor(compruebaBA(new Coordenada(i, j)));
				}
			}
		}

	}
	
	private int compruebaBA(Coordenada actual) {
		int numeroBomAlr = 0;
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				Coordenada posibleContigua = new Coordenada(i, j);
				if (IsCasillaContinua(actual, posibleContigua)) {
					if (casillas[i][j].isBomba()) {
						numeroBomAlr++;
					}
				}
			}
		}
		return numeroBomAlr;
	}
	
	private boolean IsCasillaContinua(Coordenada actual, Coordenada posibleContigua) {
		boolean continua = false;

		if (posibleContigua.getX() < actual.getX() + 2 && posibleContigua.getX() > actual.getX() - 2) {
			if (posibleContigua.getY() < actual.getY() + 2 && posibleContigua.getY() > actual.getY() - 2) {
				if (actual.isContigua(posibleContigua)) {
					continua = true;
				}
			}
		}
		return continua;
	}
	
	public boolean desvelaCasillas(Coordenada inicial) {
		int inicialX = inicial.getX();
		int inicialY = inicial.getY();
		boolean bombasOcultas = true;
		
		if (!casillas[inicialX][inicialY].isMarcada()) {

			if (casillas[inicialX][inicialY].isVelada() && casillas[inicialX][inicialY].getMinasAlrededor() != 0) {
				bombasOcultas = desvelaCasillaUnica(inicial);

			} else {

				desvelarVaciasyProximasRecursivo(inicialX, inicialY);
			}
		} else {
			if (contarMarcadasAlrededor(inicial, casillas.length) >= casillas[inicialX][inicialY].getMinasAlrededor()) {
				bombasOcultas = desvelarCasillasContiguas(inicial);
			}
		}

		return bombasOcultas;
	}

	private boolean desvelarCasillasContiguas(Coordenada inicial) {
		int inicialX = inicial.getX();
		int inicialY = inicial.getY();
		boolean bombasOcultas = true;

		for (int i = inicialX - 1; i <= inicialX + 1; i++) {
			for (int j = inicialY - 1; j <= inicialY + 1; j++) {
				Coordenada alrededor = new Coordenada(i, j);
				if (!alrededor.equals(inicial)) {
					if (isDentroLimites(alrededor, casillas.length) && !casillas[i][j].isMarcada()) {
						casillas[i][j].isVelada();
						if (casillas[i][j].isBomba()) {
							desvelaBombas();
							bombasOcultas = false;
						}

					}
				}
			}
		}
		return bombasOcultas;
	}

	private void desvelarVaciasyProximasRecursivo(int inicialX, int inicialY) {
		for (int i = inicialX - 1; i <= inicialX + 1; i++) {
			for (int j = inicialY - 1; j <= inicialY + 1; j++) {
				Coordenada posibleContinua = new Coordenada(i, j);
				if (isDentroLimites(posibleContinua, casillas.length) && casillas[i][j].isVelada()) {
					casillas[inicialX][inicialY].isVelada();
					desvelaCasillas(posibleContinua);
				}
			}
		}
	}

	private boolean desvelaCasillaUnica(Coordenada inicial) {
		int inicialX = inicial.getX();
		int inicialY = inicial.getY();
		boolean bombasOcultas = true;

		casillas[inicialX][inicialY].isVelada();
		if (casillas[inicialX][inicialY].isBomba()) {
			desvelaBombas();
			bombasOcultas = false;
		}

		return bombasOcultas;
	}

	private void desvelaBombas() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				if (casillas[i][j].isBomba() && !casillas[i][j].isMarcada()) {
					casillas[i][j].isVelada();
				}
			}
		}
	}

	private byte contarMarcadasAlrededor(Coordenada posicion, int lado) {
		byte marcadasAlrededor = 0;
		int x = posicion.getX();
		int y = posicion.getY();
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				Coordenada alrededor = new Coordenada(i, j);
				if (!alrededor.equals(posicion)) {
					if (isDentroLimites(alrededor, lado) && casillas[i][j].isMarcada()) {
						marcadasAlrededor++;
					}
				}
			}
		}
		return marcadasAlrededor;
	}

	public boolean tableroWin(Tablero tablero) {
		int desveladas = 0;
		byte bombas = 0;
		int lado = getCasillas().length;
		int total = lado * lado;
		for (int i = 0; i < getCasillas().length; i++) {
			for (int j = 0; j < getCasillas().length; j++) {
				if (getCasillas()[i][j].isBomba()) {
					bombas++;
				} else {
					if (!getCasillas()[i][j].isVelada()) {

						desveladas++;
					}
				}
			}
		}
		total = total - bombas;
		return (desveladas == total);
	}
	
	
	public Casilla getCasilla(Coordenada posicion) {
		return casillas[posicion.getX()][posicion.getY()];
	}
	
	public void desvelarCasilla(Coordenada coordenada) {
		 getCasilla(coordenada).setVelada(false);
	}
	public boolean marcarCasilla(Coordenada coord) {
		return getCasilla(coord).marcar();
	}
	private boolean isDentroLimites(Coordenada alrededor, int lado) {
		return alrededor.getX() >= 0 && alrededor.getX() < lado && alrededor.getY() >= 0 && alrededor.getY() < lado;
	}
	
}
