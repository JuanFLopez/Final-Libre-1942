package Entidades;

import java.awt.Point;

import EntidadesGraficas.Etiqueta_Enemigo_Base;
import Visitors.Visitor;

public class EnemigoBase extends Enemy {

	public EnemigoBase(Point p, int tiempoQuieto, boolean enEspera) {
		super(new Etiqueta_Enemigo_Base(p), tiempoQuieto, enEspera);
		valor=10;
		this.vida = vida * 2;
	}

	@Override
	public Proyectil disparar() {
		return new Proyectil_Base(new Point(entidad_graf.getX(), entidad_graf.getY() + 40));
	}

	@Override
	public void bajarVida(int damage) {
		if (!muerto) {
			if (vida - damage <= 0) {
				vida = 0;
				morir();
			} else {
				vida -= damage;
			}
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
