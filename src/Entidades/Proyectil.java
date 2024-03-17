package Entidades;

import EntidadesGraficas.Entidad_grafica;

public abstract class Proyectil extends Entidad {
	protected int damage;

	public Proyectil(Entidad_grafica entidad_graf) {
		super(entidad_graf);
	}

	public int getDamage() {
		return this.damage;
	}
}
