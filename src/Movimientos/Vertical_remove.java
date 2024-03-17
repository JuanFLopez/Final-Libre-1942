package Movimientos;

import Entidades.Entidad;
import EntidadesGraficas.Entidad_grafica;

public class Vertical_remove extends Vertical {


	public Vertical_remove(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		Entidad_grafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();

		if (siguientePosY > limiteY+100) {
			entidad.eliminar();
		}else 
			if (siguientePosY < 0) {
				entidad.eliminar();
			}else
				g.setLocation(g.getX(), siguientePosY);
		
	}
}
