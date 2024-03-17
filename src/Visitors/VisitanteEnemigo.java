package Visitors;

import Entidades.*;

public class VisitanteEnemigo extends Visitor {

	public VisitanteEnemigo(Enemy entidad) {
		super(entidad);
	}
	public void visit(Jugador j) {
		Enemy enemigo=(Enemy) this.entidad;
		j.recibirDamage(enemigo.getDamage());
	}



}
