package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Enemy;

/**
 * clase que modela un nivel, almacena los infectados en cada tanda
 *
 */
public class Nivel {

	private int valor; // num de nivel, para el fondo
	private int tandaActual;
	private Juego juego;

	private List<Tanda> tandas;

	public Nivel(int valor) {
		tandas = new LinkedList<Tanda>();
		tandaActual = 0;
		this.valor = valor;
		juego = Juego.getJuego();
	}

	
	public void agregarTanda(Tanda t) {
		tandas.add(t);
	}

	public void setValor(int nivel) {
		this.valor = nivel;
	}

	public void eliminarEnemigo(Enemy i) {
		Tanda tanda = tandas.get(tandaActual);
		tanda.eliminarEnemigo(i);
		if (tanda.vacia()) { // ya se elimino todos los enemigos
			if (tandaActual + 1 < tandas.size()) { // quedan tandas en el nivel
				tandaActual++;
				tandas.get(tandaActual).aparecer();
			} else {
				juego.nivelCompleto(); // si ya no quedan tandas se le notifica al juego que el nivel fue completado
			}
		}
	}

	public int getValor() {
		return this.valor;
	}

	public int getNumeroTanda() {
		return this.tandaActual;
	}

	public Tanda getTanda() {
		return tandas.get(tandaActual);
	}

}
