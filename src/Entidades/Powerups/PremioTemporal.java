package Entidades.Powerups;

import EntidadesGraficas.Entidad_grafica;
import Visitors.Visitor;

public abstract class PremioTemporal extends Premio {
	protected int duracion;
	protected int valor;

	public PremioTemporal(Entidad_grafica entidad_graf) {
		super(entidad_graf);
	}

	public int getDuracion() {
		return duracion;
	}

	public int getValor() {
		return valor;
	}

	public abstract void accept(Visitor visitor);
}
