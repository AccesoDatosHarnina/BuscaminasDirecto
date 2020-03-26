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
		lado = 12;
		porcentaje = 20;
		minas = Utiles.calculaMinas(lado, porcentaje);
		tablero = new Tablero(lado, minas);
	}

	public void mostrarTablero() {
		System.out.println();
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				Coordenada coordenada = new Coordenada(i, j);
				Casilla casilla = tablero.getCasilla(coordenada);
				String letrero;
				if (casilla.isVelada()) {
					letrero = "#";
					if (casilla.isMina()) {
						letrero="X";
					}
				} else if (casilla.isMina()) {
					letrero = "M";
				} else {
					letrero = String.valueOf(casilla.getMinasAlrededor());
				}
				System.out.print(" " + letrero);
			}
			System.out.println();
		}
	}

	@Test
	void testDesvelarCasilla() {
		boolean error = false;
		int i = 0, j = 0;
		do {
			do {
				Coordenada posicion = new Coordenada(i, j);
				Casilla actual = tablero.getCasilla(posicion);
				mostrarTablero();
				if (!actual.isMina() && actual.getMinasAlrededor() == 0 && actual.isVelada()) {
					tablero.desvelarCasilla(posicion);
					error = comprobarDesvelo();
				}
				mostrarTablero();
			} while (++j < lado && !error);
			j = 0;
		} while (++i < lado && !error);
		assertTrue(!error);
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
			j = 0;
		} while (++i < lado && !error);
		return error;
	}

	private boolean desveladasAroundMe(Coordenada posicion) {
		boolean error = false;
		for (int i = 0; i < 8&&!error; i++) {
			Coordenada alrededor = posicion.creaCoordenadaAlrededor(i);
			if (tablero.isDentroDeLosLimites(alrededor)) {
				Casilla actual = tablero.getCasilla(alrededor);
				if (!posicion.equals(actual)) {
					error = actual.isVelada();
				}
			}
		}
		return error;
	}

}
