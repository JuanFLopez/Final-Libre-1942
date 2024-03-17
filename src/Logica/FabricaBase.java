package Logica;


import java.awt.Point;
import Entidades.Enemy;
import Entidades.EnemigoBase;


public class FabricaBase extends Factory {

	public FabricaBase() {
		super();
	}

	@Override
	public Enemy crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemy inf = new EnemigoBase(p, tiempo, enEspera);
		tiempo = tiempo + 2000; //Dos mil milisegundos entre spawn de enemigos
		return inf;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth() - 60), -100);
	}

	@Override
	protected void reiniciar() {
		tiempo = 1;

	}

}
