package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utiles.Utiles;

class TableroTestDesvelarCasilla {
	private int lado;
	private int porcentaje;
	private int minas;
	private Tablero tablero;

	@BeforeEach
	void setUp() {
		lado = 4;
		porcentaje = 20;
		minas = Utiles.calculaMinas(lado, porcentaje);
		tablero = new Tablero(lado, minas);
	}

	@Test
	void testDesvelarCasilla() {
		boolean error = false;
		int i = 0, j = 0;
		do {
			do {
				Coordenada posicion = new Coordenada(i, j);
				Casilla actual = tablero.getCasilla(posicion);
				if (!actual.isMina() && actual.getMinasAlrededor() == 0 && actual.isVelada()) {
					tablero.desvelarCasilla(posicion,false);
					error = comprobarDesvelo();
				}
			} while (++j < lado && !error);
		} while (++i< lado && !error);
	}

	private boolean comprobarDesvelo() {
		boolean error = false;
		int i = 0, j = 0;
		do {
			do {
				Coordenada posicion = new Coordenada(i, j);
				Casilla actual = tablero.getCasilla(posicion);
				if (actual.getMinasAlrededor() == 0 && !actual.isVelada()) {
					error = desveladasAroundMe(posicion);
				}
			} while (++j < lado && !error);
		} while (++i < lado && !error);
		return error;
	}

	private boolean desveladasAroundMe(Coordenada posicion) {
		boolean error = false;
		int i = posicion.getPosX() - 1, j = posicion.getPosY() - 1;
		do {
			do {
				Coordenada alrededor = new Coordenada(i, j);
				//TODO dentro de los limites si no, falla
				Casilla actual = tablero.getCasilla(alrededor);
				if (!posicion.equals(actual)) {
					error = actual.isVelada();
				}
			} while (j++ < posicion.getPosY() + 1 && !error);
		} while (i++ < posicion.getPosX() + 1 && !error);
		return error;
	}

}
