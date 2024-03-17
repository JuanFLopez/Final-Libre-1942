package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Etiqueta_Proyectil_Glass extends Etiqueta_Proyectil_Enemigo {

	public Etiqueta_Proyectil_Glass(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Etiqueta_Proyectil_Base.class.getResource("/GraficasSpritesEnemigos/disparoGlass.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
