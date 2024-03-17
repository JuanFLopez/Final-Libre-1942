package Visitors;

import Entidades.*;

public class VisitorProyectilSanitario extends Visitor {

	public VisitorProyectilSanitario(Proyectil entidad) {
		super(entidad);
	}
	
	public void visit(EnemigoGlass i) {
		ProyectilBoost e = (ProyectilBoost) entidad;
		e.eliminar();
		i.bajarVida(e.getDamage());		
	}

	public void visit(EnemigoBase i) {
		ProyectilBoost e = (ProyectilBoost) entidad;		
		e.eliminar();     
		i.bajarVida(e.getDamage());		
	}

}
