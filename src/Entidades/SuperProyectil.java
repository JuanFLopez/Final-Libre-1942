package Entidades;

import java.awt.Point;
import EntidadesGraficas.Etiqueta_Proyectil_Boost;
import Visitors.Visitor;

public class SuperProyectil extends ProyectilBoost {

	public SuperProyectil(Point p) {
		super(new Etiqueta_Proyectil_Boost(p));
		damage = 10;
		velocidad = 4;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
