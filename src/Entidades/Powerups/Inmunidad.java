package Entidades.Powerups;

import java.awt.Point;

import EntidadesGraficas.Etiqueta_Invencible;
import Visitors.Visitor;
import Visitors.VisitorInmunidad;

public class Inmunidad extends PremioTemporal {

	public Inmunidad(Point p) {
		super(new Etiqueta_Invencible(p));
		duracion = 20000;
		velocidad = 5;
		valor = 0;
		visitor = new VisitorInmunidad(this);		
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
