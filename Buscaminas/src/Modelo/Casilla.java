package Modelo;

public class Casilla {

	private boolean velada = false;
	private boolean bomba = false;
	private boolean marcada = false;
	              
	
	
	public void marcar() {
		if (marcada==false) {
			marcada = true;
		}else {
			marcada = false;
		}
		
	}
	
	public void setVelada(boolean velada) {
		this.velada = velada;
	}
	public void setBomba(boolean bomba) {
		this.bomba = bomba;
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
