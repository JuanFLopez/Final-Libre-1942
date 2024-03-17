package Logica;

import Entidades.Enemy;

/**
 * clase que se encarga de la construccion de un nivel
 */
public class BuilderDefault extends BuilderNivel {

	private Tanda tandaActual;
	private int nivelesCreados;
	private boolean primerTanda;

	public BuilderDefault() {
		super();
		misFabricas.add(new FabricaGlass());
		misFabricas.add(new FabricaBase());
		nivelesCreados = 0;
		tandaActual = new Tanda();
		primerTanda = true;
	}

	@Override
	public void reset() {
		nivel = new Nivel(nivelesCreados);
		tandaActual = new Tanda();
		primerTanda = true;
	}

	@Override
	public void construirEnemigo(int tipoEnemigo) {
		
		Enemy inf = misFabricas.get(tipoEnemigo).crearEnemigo(!primerTanda);
		tandaActual.agregarEnemigo(inf);
	}

	@Override
	public Nivel getNivel() {
		Nivel aRetornar = nivel;
		nivel = new Nivel(nivelesCreados);
		tandaActual = new Tanda();
		primerTanda=true;
		return aRetornar;
	}

	@Override
	public void siguienteTanda() {
		for (Factory f : misFabricas) {
			f.reiniciar();
		}
		nivel.agregarTanda(tandaActual);
		tandaActual = new Tanda(); // se crea la proxima tanda
		primerTanda = false;
	}

}
