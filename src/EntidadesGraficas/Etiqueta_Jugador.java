package EntidadesGraficas;

import javax.swing.ImageIcon;

public class Etiqueta_Jugador extends Entidad_grafica {
	
	private final int mejorasSinAfectarJugador=1;
	
	private String[] rutasImagen = { "/GraficasSpritesJugador/TanqueBase.png",
			"/GraficasSpritesJugador/TanqueInvulnerable.png", "/GraficasSpritesJugador/TanqueSuper.png",
			"/GraficasSpritesJugador/TanqueVeloz.png" };

	public Etiqueta_Jugador() {
		super();
		this.setSize(55, 80);
		ImageIcon imagen = new ImageIcon(getClass().getResource(rutasImagen[0]));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(430, 520);
		this.setVisible(true);
	}

	
	public void setPowerUp(boolean[] mejoras) {
		boolean encontre = false;
		for (int i = this.mejorasSinAfectarJugador; i < mejoras.length && !encontre; i++)
			if (mejoras[i]) {
				super.reDimensionar(this, new ImageIcon(Etiqueta_Jugador.class.getResource(rutasImagen[i+1])));
				encontre = true;
			}
		if (!encontre)
			super.reDimensionar(this, new ImageIcon(getClass().getResource(rutasImagen[0])));
	}
}
