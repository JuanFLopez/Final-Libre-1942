package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

import Entidades.Jugador;

public class Etiqueta_Proyectil_Normal extends Etiqueta_Proyectil_Jugador {

	public Etiqueta_Proyectil_Normal(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Etiqueta_Proyectil_Normal.class.getResource("/GraficasSpritesJugador/disparo.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
