package JugadorEstado;

import Entidades.Jugador;

public abstract class EstadoJugador {
	protected Jugador jugador;
	protected int velocidad;

	public EstadoJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void disminuirVida(int damage) {
		jugador.setVida(jugador.getDamageActual() + damage);
	}
}
