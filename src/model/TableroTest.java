package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableroTest {

	@Test
	void testIncrementarMinasAlrededor() {
		int posX=0;
		int posY=0;
		int lado=4;
		Coordenada miMinaCoordenada=new Coordenada(posX, posY);
		Tablero tablero=new Tablero();
		tablero.getCasilla(miMinaCoordenada).setMina(true);
		tablero.establecerMinasAlrededor(miMinaCoordenada);
		int resultado[][]= {
				{0,1,0,0},
				{1,1,0,0},
				{0,0,0,0},
				{0,0,0,0}};
		probando(tablero, resultado);
		//Si coloco la segundaMina;
		posX=3;
		posY=3;
		miMinaCoordenada=new Coordenada(posX, posY);
		tablero.getCasilla(miMinaCoordenada).setMina(true);
		tablero.establecerMinasAlrededor(miMinaCoordenada);
		int resultadoDos[][]= {
				{0,1,0,0},
				{1,1,0,0},
				{0,0,1,1},
				{0,0,1,0}};
		probando(tablero, resultadoDos);
		
	}

	private void probando(Tablero tablero, int[][] resultado) {
		Casilla[][] casillas = tablero.getCasillas();
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				assertEquals(resultado[i][j],casillas[i][j].getMinasAlrededor());
			}
		}
	}

}
