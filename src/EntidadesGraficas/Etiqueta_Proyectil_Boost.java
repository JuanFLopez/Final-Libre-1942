package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class Etiqueta_Proyectil_Boost extends Etiqueta_Proyectil_Jugador{

	public Etiqueta_Proyectil_Boost(Point p) {
		super(p);
		this.setSize(50, 100);
		;
		ImageIcon imagen = new ImageIcon(
				Etiqueta_Proyectil_Boost.class.getResource("/GraficasSpritesJugador/disparo_boost.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation((int) p.getX(), (int) p.getY() - 30);
	}

}
