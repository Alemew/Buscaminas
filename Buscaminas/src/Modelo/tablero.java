package Modelo;

public class tablero {

	private int numeroBombas;
	private int dimension;
	private Casilla[][] tablero;
	public tablero(Dificultad dificultad, Densidad densidad, Casilla[][] tablero) {
		super();
		this.numeroBombas = (dimension * dimension) * Integer.valueOf(densidad.getMensaje())/100;
		this.dimension = Integer.valueOf(dificultad.getMensaje());
		this.tablero = new Casilla[dimension][dimension];
	}
	public int getNumeroBombas() {
		return numeroBombas;
	}
	public int getDimension() {
		return dimension;
	}
	public Casilla[][] getTablero() {
		return tablero;
	}
	
	
	
	
	
	
}
