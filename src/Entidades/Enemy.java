package Entidades;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Etiqueta_Enemigo;
import Logica.GeneradorDePremio;
import Movimientos.Horizontal;
import Movimientos.Horizontal_remove;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;
import Visitors.VisitanteEnemigo;

public abstract class Enemy extends Entidad {
	protected int vida;
	protected boolean suelta_premio;
	protected boolean muerto;
	protected int tiempoEspera;
	protected int damage;
	protected boolean quieto;
	protected int valor;

	protected Random random;

	
	public Enemy(Entidad_grafica entidad_graf, int duracion, boolean enEspera) {
		super(entidad_graf);
		velocidad = 1;
		movimiento = null;
		random = new Random();
		suelta_premio = random.nextInt(3) == 1;
		vida = 50;
		damage = 1;
		muerto = false;
		quieto = false;

		tiempoEspera = duracion;
		if (!enEspera)
			aparecer();

		visitor = new VisitanteEnemigo(this);
	}

	
	public void aparecer() {
		Enemy inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new Vertical_loop(inf, Vertical.ABAJO);
				timer.cancel();// se ejecuta una vez el run y se cancela el timer
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);

	}

	public abstract void bajarVida(int damage);

	public abstract Proyectil disparar();

	public int getVida() {
		return this.vida;
	}

	public void eliminar() {
		juego.eliminarEnemigo(this);
	}

	public void accionar() {
		if (!quieto || muerto) {
			if (movimiento != null)
				movimiento.mover();

			if (!muerto && random.nextInt(100) == 1) {// para que no dispare demasiado se considera solo una de
															// cada 100 veces que se llame al accionar (en promedio)
				disparar();
			}
		}
	}

	
	public void morir() {
		
		muerto = true;
		int direccion = random.nextInt(2);
		Etiqueta_Enemigo li = (Etiqueta_Enemigo) this.getGrafico();
		if (direccion == 1) {
			li.seVa(1);
			movimiento = new Horizontal_remove(this, Horizontal.DERECHA);
		} else {
			li.seVa(0);
			movimiento = new Horizontal_remove(this, Horizontal.IZQUIERDA);
		}
		damage=0;
		velocidad = 3;
		if (suelta_premio) {
			GeneradorDePremio.generar(entidad_graf.getLocation());
		}
		
		juego.aumentarPuntaje(getPuntaje());
	}

	public int getDamage() {
		return damage;
	}

	public void setQuieto(boolean estado) {
		quieto = estado;
	}
	
	public int getPuntaje() {
		return valor;
	}

}
