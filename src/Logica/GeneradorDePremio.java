package Logica;

import java.awt.Point;
import java.util.Random;

import Entidades.Powerups.Inmunidad;
import Entidades.Powerups.SuperArma;
import Entidades.Powerups.SuperVelocidad;


/**
 * clase que se encarga de crear los premios de forma aleatoria 
 */
public class GeneradorDePremio {

	
	private static final int cantidadPremiosTemporales=3;
	private static final int cantidadPremios=3;
	
	/**
	 * metodo que crea un premio, es llamado de forma estatica
	 */
	public static void generar(Point p) {
		Random r= new Random();
		int indice=r.nextInt(cantidadPremios);
		Juego juego=Juego.getJuego();
		while(indice<cantidadPremiosTemporales && juego.getEstadoPowerup(indice)) {
			//se chequea que no se cree un premio temporal que ya este activado
			indice=r.nextInt(cantidadPremios);
		}
		switch(indice) {
			
			case 0: new Inmunidad(p);
				break;
			case 1: new SuperArma(p);
				break;
			case 2: new SuperVelocidad(p);
				break;
			
		}
	}
}
