package Entidades;

import java.awt.Point;

import EntidadesGraficas.Etiqueta_Proyectil_Normal;
import Visitors.Visitor;

public class ProyectilNormal extends ProyectilBoost {

	public ProyectilNormal(Point posicion) {
		super(new Etiqueta_Proyectil_Normal(posicion));
		velocidad = 6;
		damage = 5;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
