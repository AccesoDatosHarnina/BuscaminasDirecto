package model;

import utiles.Utiles;

public class Tablero {

	private Casilla[][] casillas;

	public Tablero(int lado, int numeroBombas) {
		super();
		crearTablero(lado);
		colocarMinas(lado, numeroBombas);
	}

	private void setMinasAlrededor(Coordenada posicion) {
		casillas[posicion.getPosX()][posicion.getPosY()]
		.setMinasAlrededor(casillas[posicion.getPosX()][posicion.getPosY()].getMinasAlrededor() + 1);

	}

	private void establecerMinasAlrededor(Coordenada posicionMinaCoordenada) {
		for (int i = 0; i < 8; i++) {
			Coordenada posicion = posicionMinaCoordenada.creaCoordenadaAlrededor(i);
			if (validaCoordenada(posicion)) {
				setMinasAlrededor(posicion);
			}
		}
	}

	private int getLado() {
		return casillas.length;
	}

	private void colocarMinas(int lado, int numeroMinas) {
		for (int i = 0; i < numeroMinas;) {
			Coordenada posicion = new Coordenada(Utiles.dameNumero(getLado()), Utiles.dameNumero(getLado()));
			if (!isMina(posicion)) {
				setMina(posicion, true);
				i++;
				establecerMinasAlrededor(posicion);
			}
		}
	}

	private void crearTablero(int lado) {
		this.casillas = new Casilla[lado][lado];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla();
			}
		}
	}

	// TODO antes todo esto era private
	public Casilla getCasilla(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()];
	}

	private void setMina(Coordenada posicion, boolean bandera) {
		getCasilla(posicion).setMina(bandera);
	}

	private boolean isMarcada(Coordenada lugar) {
		return casillas[lugar.getPosX()][lugar.getPosY()].isMarcada();
	}

	private boolean isVelada(Coordenada lugar) {
		return casillas[lugar.getPosX()][lugar.getPosY()].isVelada();
	}

	private boolean isMina(Coordenada posicion) {
		return getCasilla(posicion).isMina();
	}

	public int getMinasAlrededor(Coordenada lugar) {
		return casillas[lugar.getPosX()][lugar.getPosY()].getMinasAlrededor();
	}

	private void setVelada(Coordenada lugar, boolean b) {
		casillas[lugar.getPosX()][lugar.getPosY()].setVelada(b);

	}



	private boolean validaCoordenada(Coordenada posicion) {
		return posicion.getPosX() >= 0 && posicion.getPosY() >= 0 && posicion.getPosX() < getLado()
				&& posicion.getPosY() < getLado();
	}

	public void desvelarCasilla(Coordenada lugar) {
		if ((getMinasAlrededor(lugar) == 0) && (!isMina(lugar) && (isVelada(lugar)))
				&& !isMarcada(lugar)) {
			setVelada(lugar, false);
			for (int i = 0; i < 8; i++) {
				Coordenada posicion = lugar.creaCoordenadaAlrededor(i);
				if (validaCoordenada(posicion)) {
					desvelarCasilla(posicion);
				}
			}
		} else if (!isMarcada(lugar)) {
			setVelada(lugar, false);
		}
	}

	public boolean isDentroDeLosLimites(Coordenada coord) {
		return coord.getPosX()>=0&&coord.getPosX()<getLado()&&
				coord.getPosY()>=0&&coord.getPosY()<getLado();
	}
}
