package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Etiqueta_Velocidad extends Etiqueta_Premio_Temporal {

	public Etiqueta_Velocidad(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/GraficasSpritesPowerups/velocidad.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);

	}
}
