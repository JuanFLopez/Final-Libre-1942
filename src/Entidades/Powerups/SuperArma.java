package Entidades.Powerups;

import java.awt.Point;

import EntidadesGraficas.Etiqueta_Arma_Boost;
import Visitors.Visitor;
import Visitors.VisitorSuperArma;

public class SuperArma extends PremioTemporal {

	public SuperArma(Point p) {
		super(new Etiqueta_Arma_Boost(p));
		duracion = 15000;
		velocidad=3;
		valor=1;
		visitor = new VisitorSuperArma(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
