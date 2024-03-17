package TiposArma;

import java.awt.Point;

import Entidades.Jugador;
import Entidades.Proyectil;
import Entidades.ProyectilNormal;
import EntidadesGraficas.Entidad_grafica;

public class ConArmaNormal extends EstadoArma {

	public ConArmaNormal(Jugador jugador) {
		super(jugador);
	}

	@Override
	public Proyectil disparar() {
		Entidad_grafica g = this.jugador.getGrafico();
		return new ProyectilNormal(new Point(g.getX(), g.getY() - 30));
	}
}
