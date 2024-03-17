package EntidadesGraficas;

import java.awt.Point;

public abstract class Etiqueta_Premio extends Entidad_grafica{

	public Etiqueta_Premio(Point p) {
		super();
		this.setLocation(p);
		this.setSize(50,50);
	}
}
