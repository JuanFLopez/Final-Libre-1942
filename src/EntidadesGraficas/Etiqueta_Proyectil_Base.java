package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Etiqueta_Proyectil_Base extends Etiqueta_Proyectil_Enemigo {

	public Etiqueta_Proyectil_Base(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Etiqueta_Proyectil_Base.class.getResource("/GraficasSpritesEnemigos/disparoBase.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
