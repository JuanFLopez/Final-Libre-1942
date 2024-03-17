package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class Etiqueta_Enemigo_Base extends Etiqueta_Enemigo {

	public Etiqueta_Enemigo_Base(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Etiqueta_Enemigo_Base.class.getResource("/GraficasSpritesEnemigos/enemigoBase.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
