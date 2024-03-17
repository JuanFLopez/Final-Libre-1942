package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Etiqueta_Arma_Boost extends Etiqueta_Premio_Temporal
{

	public Etiqueta_Arma_Boost(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/GraficasSpritesPowerups/superArma.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
