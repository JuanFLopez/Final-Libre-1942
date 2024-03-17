package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Enemy;

 class Tanda {
	private List<Enemy> enemigos;

	public Tanda() {
		enemigos = new LinkedList<Enemy>();
	}

	public boolean vacia() {
		return enemigos.isEmpty();
	}

	public void agregarEnemigo(Enemy inf) {
		enemigos.add(inf);
	}

	public void eliminarEnemigo(Enemy inf) {
		enemigos.remove(inf);
	}

	public void aparecer() {
		for (Enemy i : enemigos) {
			i.aparecer();
		}

	}

	public List<Enemy> getEnemigos() {
		return enemigos;
	}
}
