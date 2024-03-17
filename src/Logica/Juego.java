package Logica;

import java.awt.Container;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import Entidades.Enemy;
import Entidades.Jugador;
import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Etiqueta_Jugador;
import GUI.Gui;


public class Juego implements Runnable {

	// Atributos booleanos que indican el comportamiento del usuario
	private boolean moviendoIzquierda;
	private boolean moviendoDerecha;
	private boolean moviendoArriba;
	private boolean moviendoAbajo;
	private boolean disparando;
	private boolean restandoUnaVida;


	// Atributo utilizado para el patron singleton
	private static Juego juego;

	// Listas de entidades

	private List<Entidad> entidades;
	private List<Entidad> aEliminar;
	private List<Entidad> aAgregar;

	// Otros atributos
	private HiScore puntajeMax;
	private boolean jugando;
	private Gui gui;
	private Jugador jugador;
	private Director director;
	private Nivel nivelActual;
	private int puntaje;
	
	

	private boolean[] powerUps;

	/**
	 * El constructor es privado para que funcione el patron singleton
	 */
	private Juego() {
		juego = this;
		
		restandoUnaVida = false;
		moviendoIzquierda = false;
		moviendoDerecha = false;
		moviendoArriba=false;
		moviendoAbajo=false;
		disparando = false;
		puntaje=0;
		entidades = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();
		aAgregar = new LinkedList<Entidad>();
		puntajeMax = new HiScore();
		powerUps = new boolean[3];
		for (int i = 0; i < 3; i++) {
			powerUps[i] = false;
		}

	}
	
	public String puntaje() {
		String toReturn= Integer.toString(puntaje);
		return toReturn;
	}
	
	public void aumentarPuntaje(int bono) {
		puntaje=puntaje+bono;
		
	}
	
	public static Juego getJuego() {
		if (juego == null) {
			juego = new Juego();
		}
		return juego;
	}


	public boolean moviendoIzquierda() {
		return moviendoIzquierda;
	}

	public boolean moviendoDerecha() {
		return moviendoDerecha;
	}

	public boolean disparando() {
		return disparando;
	}

	public void setMoviendoIzquierda(boolean mov) {
		this.moviendoIzquierda = mov;
	}

	public void setMoviendoDerecha(boolean mov) {
		this.moviendoDerecha = mov;
	}

	public void setDisparando(boolean mov) {
		this.disparando = mov;
	}

	
	
	public void setRestandoVidas(boolean restar) {
		restandoUnaVida = restar;
	}
	
	public boolean restandoVidas() {
		return restandoUnaVida;
	}
	
	public void agregarEntidad(Entidad nueva) {
		aAgregar.add(nueva);						
	}

	public void eliminarEntidad(Entidad a_eliminar) {
		aEliminar.add(a_eliminar);

		Entidad_grafica ent = a_eliminar.getGrafico();
		if (jugando) {
			getMapa().remove(ent);
			getMapa().repaint();
		}
	}

	public void nivelCompleto() {
		if (director.finJuego()) {
			juego = null;
			
			gui.gano();
			jugando = false;// corta la ejecucion del juego
		} else {
			siguienteNivel();
		}
	}

	private void siguienteNivel() {
		for (Entidad e : entidades) {
										
			if (e != jugador) {
				gui.getMapa().remove(e.getGrafico());
			}
		}
		entidades = new LinkedList<Entidad>();
		entidades.add(jugador);
		nivelActual = director.construirSiguienteNivel();
		this.gui.cambioNivel(nivelActual.getValor() + 1);

	}

	public void setGUI(Gui gui) {
		this.gui = gui;
	}

	public int getNivel() {
		return this.nivelActual.getValor();
	}

	public void jugar() {

	}

	private void actualizarDatosJuego() {
		gui.actualizarBarraVida(jugador.getDamageActual());
		gui.actualizarNivelTanda(nivelActual.getValor() + 1, nivelActual.getNumeroTanda() + 1);
		gui.actualizarPowerUps(powerUps);
		Etiqueta_Jugador labelJugador=(Etiqueta_Jugador)jugador.getGrafico();
		labelJugador.setPowerUp(powerUps);
	}

	private void detectarColisiones() {
		int cantEntidades = entidades.size();
		for (int i = 0; i < cantEntidades; i++) {
			Entidad a = entidades.get(i);
			for (int j = i + 1; j < cantEntidades; j++) {
				Entidad b = entidades.get(j);
				if (colisionan(a, b)) {
					a.accept(b.getVisitor());
					b.accept(a.getVisitor());
				}
			}
		}
	}

	private boolean colisionan(Entidad a, Entidad b) {
		Rectangle A = a.getGrafico().getBounds();
		Rectangle B = b.getGrafico().getBounds();
		return A.intersects(B);
	}

	private void removerEntidadesEliminadas() {
		for (Entidad e : aEliminar) {
			entidades.remove(e);
		}
		aEliminar = new LinkedList<Entidad>();
	}

	private void agregarEntidadesNuevas() {
		for (Entidad e : aAgregar) {
			entidades.add(e);
		}
		aAgregar = new LinkedList<Entidad>();
	}

	public Container getMapa() {
		return gui.getMapa();
	}

	@Override
	public void run() {
		try {
			jugando = true;
			director = new Director();
			this.gui.cambioNivel(1);
			nivelActual = director.construirSiguienteNivel();
			jugador = new Jugador();
			while (jugando) {
				for (Entidad e : entidades) {
					e.accionar();
				}
				Thread.sleep(10);
				removerEntidadesEliminadas();
				agregarEntidadesNuevas();
				detectarColisiones();
				actualizarDatosJuego();
				gui.actualizarPuntaje();
			}
		} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void eliminarEnemigo(Enemy enemigo) {
		nivelActual.eliminarEnemigo(enemigo);
		eliminarEntidad(enemigo);

	}

	
	public void pausa() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	
	public void nuevoHiScore(int puntos) {
		puntajeMax.cambiarHiScore(puntaje);
	}
	
	public void perdio() {
		nuevoHiScore(puntaje);
		this.juego = null;
		jugando = false;
		gui.perdio();
	}

	public List<Enemy> getEnemigos() {
		return nivelActual.getTanda().getEnemigos();
	}

	
	public void seDisparo() {
		gui.sonidoDisparar();
	}

	

	public boolean jugando() {
		return jugando;
	}

	
	public void setEstadoPowerup(int i, boolean estado) {
		powerUps[i] = estado;
	}

	public boolean getEstadoPowerup(int valorPremio) {
		return powerUps[valorPremio];
	}

	public String puntajeMaximo() {
		
		return puntajeMax.hiScore();
		
	}

	public void perderUnaVida(int vidas) {
		gui.perderUnaVida(vidas);		
	}

	public void reiniciarVidas() {
		jugador.reiniciarVidas();
		
	}

	public boolean moviendoAbajo() {
		return moviendoAbajo;
	}

	public boolean moviendoArriba() {
		return moviendoArriba;
	}

	public void setMoviendoArriba(boolean b) {
		moviendoArriba=b;
		
	}

	public void setMoviendoAbajo(boolean b) {
		moviendoAbajo=b;
		
	}

}
