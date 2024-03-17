package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;
import Movimientos.Vertical_remove;
import Visitors.VisitorProyectilSanitario;

public abstract class ProyectilBoost extends Proyectil {

	public ProyectilBoost(Entidad_grafica entidad_graf) {
		super(entidad_graf);
		movimiento = new Vertical_remove(this, Vertical.ARRIBA);
		visitor = new VisitorProyectilSanitario(this);
	}

}
