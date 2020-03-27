package Control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import model.Coordenada;
import vista.Botonera;

public class MiMouseListener extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		JButton boton = ((JButton) e.getSource());
		if(SwingUtilities.isLeftMouseButton(e)) {
			Coordenada obtenCoordenada = Botonera.obtenCoordenada(boton.getName());
			desvelarCasilla()
		}
		if (SwingUtilities.isRightMouseButton(e)) {
			// queremos marcar
		}
	}
}
