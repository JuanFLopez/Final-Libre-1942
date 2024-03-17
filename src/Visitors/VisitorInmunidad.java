package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Powerups.PremioTemporal;
import JugadorEstado.EstadoInmune;
import JugadorEstado.EstadoJugador;
import Logica.Juego;

public class VisitorInmunidad extends VisitorPremioTemporal {

	public VisitorInmunidad(PremioTemporal inmu) {
		super(inmu);
		duracion = inmu.getDuracion();
		
	}
	
	public void visit(Jugador jug) {
		EstadoJugador estado_actual = jug.getEstadoJugador();
		jug.setEstadoJugador(new EstadoInmune(jug));
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
		timer.schedule(timer_task, this.duracion, 1);
	}

}
