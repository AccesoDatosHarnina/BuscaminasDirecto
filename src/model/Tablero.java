package model;

public class Tablero {

	private Casilla[][] casillas;

	public Tablero(int lado, int numeroBombas) {
		super();
		crearTablero(lado);
		colocarMinas(lado,numeroBombas);
	}
	
	public Tablero() {
	}
	
	public Casilla[][] getCasillas() {
		return casillas;
	}


	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}


	public void establecerMinasAlrededor(Coordenada posicionMinaCoordenada) {
		// TODO Auto-generated method stub
	}

	public void colocarMinas(int lado, int numeroBombas) {
		// TODO Auto-generated method stub
		
	}
	
	private void crearTablero(int lado) {
		this.casillas=new Casilla[lado][lado];
	}

	//TODO antes todo esto era private
	public Casilla getCasilla(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()];
	}
	
	private void setMina(Coordenada posicion, boolean bandera) {
		getCasilla(posicion).setMina(bandera);
	}

	private boolean isMina(Coordenada posicion) {
		return getCasilla(posicion).isMina();
	}

	public boolean desvelarCasilla(Coordenada coordenada) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
