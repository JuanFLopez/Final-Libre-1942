package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Visitors.Visitor;
import Visitors.VisitorProyectilEnemigo;

public abstract class ProyectilEnemigo extends Proyectil {
	
	protected int rango;
	
	public ProyectilEnemigo(Entidad_grafica entidad_graf) {
		super(entidad_graf);		
		visitor = new VisitorProyectilEnemigo(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public int getRango() {
		return rango;
	}
}
