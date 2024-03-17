package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class Etiqueta_glass extends Etiqueta_Enemigo {

	public Etiqueta_glass(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Etiqueta_glass.class.getResource("/GraficasSpritesEnemigos/enemigoGlass.gif"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
