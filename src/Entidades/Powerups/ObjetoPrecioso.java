package Entidades.Powerups;

import EntidadesGraficas.Entidad_grafica;
import Visitors.Visitor;

public abstract class ObjetoPrecioso extends Premio {

	public ObjetoPrecioso(Entidad_grafica entidad_graf) {
		super(entidad_graf);
	}

	public abstract void accept(Visitor visitor);
}
