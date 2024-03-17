package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Etiqueta_Invencible extends Etiqueta_Premio_Temporal {

	public Etiqueta_Invencible(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/GraficasSpritesPowerups/inmunidad.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
