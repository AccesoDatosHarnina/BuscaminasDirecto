package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParaUI extends UserInterface {

	public ParaUI() {
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Tenemos que crear una nueva botonera
				// Entonces es un evento de UI
				// Tambien hay que crear un nuevo tablero?
				// Entonces es un evento de informacion
				// Por lo tanto este evento va en el paraUI
				// meterBotonera
				getHuecoBotonera().removeAll();
				getHuecoBotonera().add(new Botonera(dificultad.getLado()));
				//Obliga al redibujado del ui cuando hay cambio de tamano de la ventana
				pack();
			}
		});
	}
}
