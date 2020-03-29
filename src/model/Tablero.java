package model;

public class Tablero {

	private Casilla[][] casillas;

	public Tablero(int lado, int numeroBombas) {
		super();
		crearTablero(lado);
		colocarMinas(lado,numeroBombas);
	}
	

	
	public Tablero() {
		super();
		// TODO Auto-generated constructor stub
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
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				casillas[i][j]=new Casilla();
			}
		}
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

	public void desvelarCasilla(Coordenada coordenada) {
		 getCasilla(coordenada).setVelada(false);
	}
	public boolean marcarCasilla(Coordenada coord) {
		return getCasilla(coord).marcar();
	}
	
	
}
