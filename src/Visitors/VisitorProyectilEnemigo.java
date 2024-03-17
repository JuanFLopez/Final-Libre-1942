package Visitors;

import Entidades.*;

public class VisitorProyectilEnemigo extends Visitor {

	public VisitorProyectilEnemigo(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador j) {
		Proyectil p = (Proyectil) entidad;
		p.eliminar();
		j.recibirDamage(p.getDamage()) ;
	}
}
