package Modelo;

public class Casilla extends Coordenada {

	private boolean velada = false;
	private boolean bomba = false;
	private boolean marcada = false;
	
	public Casilla(int x, int y, boolean velada, boolean bomba, boolean marcada) {
		super(x, y);
		this.velada = velada;
		this.bomba = bomba;
		this.marcada = marcada;
	}
	
	public boolean isMarcada() {
		return marcada;
	}
	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}
	public boolean isVelada() {
		return velada;
	}
	public boolean isBomba() {
		return bomba;
	}
	
	
	
}
