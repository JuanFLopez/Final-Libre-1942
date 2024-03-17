package EntidadesGraficas;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;

public abstract class Entidad_grafica extends JLabel {

	public Entidad_grafica() {
		Juego.getJuego().getMapa().add(this);
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(
					grafico.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	}
}
