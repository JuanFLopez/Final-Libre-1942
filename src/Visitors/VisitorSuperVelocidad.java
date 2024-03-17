package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Powerups.PremioTemporal;
import JugadorEstado.EstadoJugador;
import JugadorEstado.EstadoSuperVeloz;
import Logica.Juego;


public class VisitorSuperVelocidad extends VisitorPremioTemporal {

	public VisitorSuperVelocidad(PremioTemporal premioTemp) {
		super(premioTemp);
		duracion = premioTemp.getDuracion();
	}

	@Override
	public void visit(Jugador jug) {
		EstadoJugador estado_actual = jug.getEstadoJugador();
		jug.setEstadoJugador(new EstadoSuperVeloz(jug));
		PremioTemporal p=(PremioTemporal) entidad;
		int valor=p.getValor();
		entidad.eliminar();
		Juego.getJuego().setEstadoPowerup(valor, true);
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoJugador(estado_actual);
				Juego.getJuego().setEstadoPowerup(valor, false);
				this.cancel();
			};
		};
		timer.schedule(timer_task, this.duracion , 1);
	}

}
