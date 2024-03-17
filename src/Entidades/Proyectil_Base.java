package Entidades;

import java.awt.Point;

import EntidadesGraficas.Etiqueta_Proyectil_Base;
import Movimientos.Vertical;
import Movimientos.VerticalRemoveRango;

public class Proyectil_Base extends ProyectilEnemigo {

	public Proyectil_Base(Point posicion) {
		super(new Etiqueta_Proyectil_Base(posicion));
		velocidad = 5;
		damage = 3;
		rango = 300;
		movimiento = new VerticalRemoveRango(this, Vertical.ABAJO);
	}

}