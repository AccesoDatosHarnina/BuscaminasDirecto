package Control;

import model.Coordenada;
import model.Tablero;
import utiles.ConversorGrafico;
import vista.Botonera;

public class DesveladorController {

	Tablero tablero;
	private Botonera botonera;
	
	public Tablero getTablero() {
		return tablero;
	}


	public DesveladorController(Tablero tablero, Botonera botonera) {
		super();
		this.tablero = tablero;
		this.botonera = botonera;
	}


	public boolean desvelarCasilla(String name) {
		// Este pequeno detalle de convertir el nombre en coordenada
		// hace que estemos ante un adapter
		// porque adecua API´s
		Coordenada obtenCoordenada = Botonera.obtenCoordenada(name);
		return tablero.desvelarCasilla(obtenCoordenada);
	}
	
	public void actualizaTodo() {
		botonera.actualizaBotonera(ConversorGrafico.convertir(tablero.getCasillas()));
	}
}
