package Logica;

import java.awt.Point;
import Entidades.Enemy;
import Entidades.EnemigoGlass;


public class FabricaGlass extends Factory {

	public FabricaGlass() {
		super();
	}

	@Override
	public Enemy crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemy inf = new EnemigoGlass(p, tiempo, enEspera);
		tiempo = tiempo + 5000;// cada infectado aparecera con una diferencia de 5 segundos
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
