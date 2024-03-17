package Entidades;

import java.awt.Point;

import EntidadesGraficas.Etiqueta_Proyectil_Glass;
import Movimientos.Vertical;
import Movimientos.VerticalRemoveRango;

public class Proyectil_Glass extends ProyectilEnemigo {

	public Proyectil_Glass(Point posicion) {
		super(new Etiqueta_Proyectil_Glass(posicion));
		velocidad = 6;
		damage = 5;
		rango = 400;
		movimiento = new VerticalRemoveRango(this, Vertical.ABAJO);
	}

}
