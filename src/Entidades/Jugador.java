package Entidades;

import EntidadesGraficas.Etiqueta_Jugador;
import JugadorEstado.EstadoInicial;
import JugadorEstado.EstadoJugador;
import Movimientos.EstrategiaMovimiento;
import Movimientos.Horizontal;
import Movimientos.Vertical;
import TiposArma.ConArmaNormal;
import TiposArma.EstadoArma;
import Visitors.Visitor;

public class Jugador extends Entidad {
	protected EstrategiaMovimiento movimientoVertical;
	protected EstadoArma estado_arma;
	protected EstadoJugador estado_jugador;
	protected int damageRecibido;
	protected int tiros;
	protected int vidas;
	
	public Jugador() {
		super(new Etiqueta_Jugador());
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		movimientoVertical = new Vertical(this, Vertical.ARRIBA);
		estado_arma = new ConArmaNormal(this);
		estado_jugador = new EstadoInicial(this);
		damageRecibido = 0;
		tiros = 0;
		vidas=2;
		
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public void setVida(int vida) {
		if (vida < 0)
			vida = 0;
		this.damageRecibido = vida;
	}

	public int getDamageActual() {
		return damageRecibido;
	}

	public void recibirDamage(int damage) {
		estado_jugador.disminuirVida(damage);

		if (damageRecibido >= 100) {
			if(vidas<=0) {
			juego.eliminarEntidad(this);
			juego.perdio();}
			else {
				vidas--;
				juego.aumentarPuntaje(-10);
				juego.perderUnaVida(vidas);
				damageRecibido=0;
			}
		}
	}

	public void accionar() {
		if (juego.moviendoDerecha()) {
			this.movimiento.setDireccion(Horizontal.DERECHA);
			this.movimiento.mover();
		}

		if (juego.moviendoIzquierda()) {
			this.movimiento.setDireccion(Horizontal.IZQUIERDA);
			this.movimiento.mover();
		}
		
		if (juego.moviendoAbajo()) {
			this.movimientoVertical.setDireccion(Vertical.ABAJO);
			this.movimientoVertical.mover();
		}

		if (juego.moviendoArriba()) {
			this.movimientoVertical.setDireccion(Vertical.ARRIBA);
			this.movimientoVertical.mover();
		}

		if (juego.disparando()) {
			tiros++;
			if (tiros == 8) {
				this.estado_arma.disparar();
				tiros = 0;
				juego.seDisparo();
			}
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public Proyectil disparar() {
		return estado_arma.disparar();
	}

	public void setEstadoJugador(EstadoJugador estado_jugador) {
		this.estado_jugador = estado_jugador;
	}

	public void setEstadoArma(EstadoArma estado_arma) {
		this.estado_arma = estado_arma;
	}

	public EstadoArma getEstadoArma() {
		return estado_arma;
	}

	public EstadoJugador getEstadoJugador() {
		return estado_jugador;
	}

	@Override
	public int getVelocidad() {
		return estado_jugador.getVelocidad();
	}

	public void reiniciarVidas() {
		vidas=2;
		
	}

}
