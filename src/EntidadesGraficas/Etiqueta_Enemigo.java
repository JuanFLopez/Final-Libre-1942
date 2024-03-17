package EntidadesGraficas;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

public abstract class Etiqueta_Enemigo extends Entidad_grafica {

	private String movLeft[] = new String[] { "/GraficasSpritesEnemigos/explota1.gif",
			 "/GraficasSpritesEnemigos/explota2.gif",
			 "/GraficasSpritesEnemigos/explota3.gif",
			"/GraficasSpritesEnemigos/explota4.gif", "/GraficasSpritesEnemigos/explota5.gif" };
	private String movRight[] = new String[] { "/GraficasSpritesEnemigos/explota1.gif",
			 "/GraficasSpritesEnemigos/explota2.gif",
			 "/GraficasSpritesEnemigos/explota3.gif",
			"/GraficasSpritesEnemigos/explota4.gif", "/GraficasSpritesEnemigos/explota5.gif" };

	public Etiqueta_Enemigo(Point p) {
		super();
		this.setSize(60, 100);
		this.setLocation(p);
	}

	public void seVa(int lado) {
		ImageIcon imagen = null;
		Random rand = new Random();
		int i = rand.nextInt(5);

		if (lado == 1) {// desaparece hacia la derecha
			imagen = new ImageIcon(this.getClass().getResource(this.movRight[i]));
		} else {// desaparece hacia la izquierda
			imagen = new ImageIcon(this.getClass().getResource(this.movLeft[i]));
		}

		this.setIcon(imagen);
		this.setBounds(getX(), getY(), 100, 75);
		this.repaint();

	}

}
