package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Powerups.PremioTemporal;
import Logica.Juego;
import TiposArma.ConArmaBoost;
import TiposArma.EstadoArma;


public class VisitorSuperArma extends VisitorPremioTemporal {

	public VisitorSuperArma(PremioTemporal premioTemp) {
		super(premioTemp);
		duracion = premioTemp.getDuracion();
	}

	@Override
	public void visit(Jugador jug) {
		EstadoArma estado_actual = jug.getEstadoArma();
		jug.setEstadoArma(new ConArmaBoost(jug));
		PremioTemporal p=(PremioTemporal) entidad;
		int valor=p.getValor();
		entidad.eliminar();
		Juego.getJuego().setEstadoPowerup(valor, true);

		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoArma(estado_actual);
				Juego.getJuego().setEstadoPowerup(valor, false);
				this.cancel();
			};
		};
		timer.schedule(timer_task, this.duracion , 1);
	}

}
