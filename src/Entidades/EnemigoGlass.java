package Entidades;

import java.awt.Point;
import EntidadesGraficas.Etiqueta_glass;
import Visitors.Visitor;

public class EnemigoGlass extends Enemy {

	protected boolean frenzy;

	public EnemigoGlass(Point p, int tiempoQuieto, boolean enEspera) {
		super(new Etiqueta_glass(p), tiempoQuieto, enEspera);
		valor=50;
		frenzy = false;
	}

	@Override
	public void bajarVida(int damage) {
		if (!muerto) {
			if (vida - damage <= 0) {
				vida = 0;
				morir();
			} else {
				vida -= damage;
				if (vida < 20 && !frenzy) {
					frenzy = true;
					velocidad = velocidad * 2; //al entrar en frenzy la velocidad del enemigo se duplica
				}
			}
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Proyectil disparar() {
		return new Proyectil_Glass(new Point(entidad_graf.getX(), entidad_graf.getY() + 40));
	}

}
