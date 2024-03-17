package Logica;


public class Director {

	private int enemigosPorNivel[][];

	private int nivelActual;
	private int ultimoNivel;
	private BuilderNivel builder;

	private final int tandasPorNivel = 2;

	public Director() {
		nivelActual = 0;
		LectorArchivo l = new LectorArchivo();
		enemigosPorNivel = l.obtenerMatrizEnemigos();
		builder = new BuilderDefault();
		ultimoNivel = (enemigosPorNivel.length / tandasPorNivel);
	}

	public Nivel construirSiguienteNivel() {
		int cantEnemigos;
		for (int n = 0; n < tandasPorNivel; n++) {// recorre cada tanda del nivel a construir
			for (int j = 0; j < enemigosPorNivel[0].length; j++) {
				// recorre cada columna de la matriz, cada iteracion correspondera a un tipo de
				// enemigo
				cantEnemigos = enemigosPorNivel[nivelActual * tandasPorNivel + n][j];
				for (int i = 0; i < cantEnemigos; i++)
					builder.construirEnemigo(j);
			}
			builder.siguienteTanda();
		}
		Nivel retorno = builder.getNivel();
		retorno.setValor(nivelActual++);
		return retorno;
	}

	public boolean finJuego() {
		return nivelActual == ultimoNivel;
	}
}
