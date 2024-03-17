package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Logica.Juego;
import Movimientos.EstrategiaMovimiento;
import Visitors.Element;
import Visitors.Visitor;

/**
 * Clase que modela la Entidad del juego
 *
 */
public abstract class Entidad extends Element {
	protected int velocidad;
	protected Entidad_grafica entidad_graf;
	protected EstrategiaMovimiento movimiento;
	protected Juego juego;
	protected Visitor visitor;

	public Entidad(Entidad_grafica entidad_graf) {
		this.juego = Juego.getJuego();
		this.juego.agregarEntidad(this);
		this.entidad_graf = entidad_graf;
	}

	public void accionar() {
		this.movimiento.mover();
	}
	
	@Override
	public abstract void accept(Visitor visitor);

	public void setMovimiento(EstrategiaMovimiento movimiento) {
		this.movimiento = movimiento;
	}

	public int getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void eliminar() {
		juego.eliminarEntidad(this);
	}

	public Entidad_grafica getGrafico() {
		return entidad_graf;
	}

	public Visitor getVisitor() {
		return visitor;
	}
}
