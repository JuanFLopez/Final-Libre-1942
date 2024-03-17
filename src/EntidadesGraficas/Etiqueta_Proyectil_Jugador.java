package EntidadesGraficas;

import java.awt.Point;

public abstract class Etiqueta_Proyectil_Jugador extends Etiqueta_Proyectil {

	public Etiqueta_Proyectil_Jugador(Point p) {
		super(p);
		this.setSize(50, 50);
	}
}
