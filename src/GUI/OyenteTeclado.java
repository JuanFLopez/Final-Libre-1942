package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Logica.Juego;

public class OyenteTeclado implements KeyListener {
	private Juego juego;

	public OyenteTeclado(Juego j) {
		juego = j;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int codigoTecla = e.getKeyCode();
		if (codigoTecla == KeyEvent.VK_LEFT || codigoTecla == KeyEvent.VK_A) {
			juego.setMoviendoIzquierda(true);
		}
		if (codigoTecla == KeyEvent.VK_RIGHT || codigoTecla == KeyEvent.VK_D) {
			juego.setMoviendoDerecha(true);
		}
		if (codigoTecla == KeyEvent.VK_UP || codigoTecla == KeyEvent.VK_W) {
				juego.setMoviendoArriba(true);
		}
		if (codigoTecla == KeyEvent.VK_DOWN || codigoTecla == KeyEvent.VK_S) {
				juego.setMoviendoAbajo(true);
		}	
			
		
		if (codigoTecla == KeyEvent.VK_SPACE) {
			juego.setDisparando(true);

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int codigoTecla = e.getKeyCode();
		if (codigoTecla == KeyEvent.VK_LEFT || codigoTecla == KeyEvent.VK_A) {
			juego.setMoviendoIzquierda(false);

		}
		if (codigoTecla == KeyEvent.VK_RIGHT || codigoTecla == KeyEvent.VK_D) {
			juego.setMoviendoDerecha(false);
		}
		
		if (codigoTecla == KeyEvent.VK_UP || codigoTecla == KeyEvent.VK_W) {
			juego.setMoviendoArriba(false);
		}
		if (codigoTecla == KeyEvent.VK_DOWN || codigoTecla == KeyEvent.VK_S) {
			juego.setMoviendoAbajo(false);
		}
		
		if (codigoTecla == KeyEvent.VK_SPACE) {
			juego.setDisparando(false);
		}

	}

}
