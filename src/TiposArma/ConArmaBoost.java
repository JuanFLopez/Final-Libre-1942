package TiposArma;

import java.awt.Point;

import Entidades.Jugador;
import Entidades.Proyectil;
import Entidades.SuperProyectil;
import EntidadesGraficas.Entidad_grafica;

public class ConArmaBoost extends EstadoArma {

	public ConArmaBoost(Jugador jugador) {
		super(jugador);
		velocidad_disparo *= 2;
	}

	@Override
	public Proyectil disparar() {
		Entidad_grafica g = this.jugador.getGrafico();
		return new SuperProyectil(new Point(g.getX(), g.getY() - 53));
	}

}
