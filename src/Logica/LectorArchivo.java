package Logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * clase que se encarga de leer el archivo que indica en que cantidades se
 * genera los enemigos de cada tipo de cada tanda
 */
public class LectorArchivo {

	private String archivo = "Datos/generacionEnemigos.txt";
	
	private int cantTiposEnemigos = 2;
	private int cantTandas = 6;

	
	public int[][] obtenerMatrizEnemigos() {

		int[][] toReturn = new int[cantTandas][cantTiposEnemigos];

		try {
			String rutaArchivo = archivo;
			InputStream in = LectorArchivo.class.getClassLoader().getResourceAsStream(rutaArchivo);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);

			String linea = br.readLine();
			int fila = 0;
			while (linea != null) {

				String[] enteros = linea.split(" ");
				for (int i = 0; i < cantTiposEnemigos; i++)
					toReturn[fila][i] = Integer.parseInt(enteros[i]);

				fila++;
				linea = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra archivo");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("No se pudo convertir a entero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error accediendo al archivo.");
			e.printStackTrace();
		}
		return toReturn;
	}
}
