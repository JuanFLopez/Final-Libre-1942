package Entidades.Powerups;

import java.awt.Point;

import EntidadesGraficas.Etiqueta_Velocidad;
import Visitors.Visitor;
import Visitors.VisitorSuperVelocidad;

public class SuperVelocidad extends PremioTemporal {

	public SuperVelocidad(Point p) {
		super(new Etiqueta_Velocidad(p));
		duracion = 9000;
		velocidad=4;
		valor=2;
		visitor = new VisitorSuperVelocidad(this);		
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
