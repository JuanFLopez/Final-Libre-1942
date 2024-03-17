package Movimientos;

import Entidades.Entidad;
import EntidadesGraficas.Entidad_grafica;

public class Vertical_loop extends Vertical {

	public Vertical_loop(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		Entidad_grafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();
		if (siguientePosY > limiteY+100)
			g.setLocation(g.getX(), -50);
		else
			g.setLocation(g.getX(), siguientePosY);

	}

}
