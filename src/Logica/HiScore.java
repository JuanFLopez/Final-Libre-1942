package Logica;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HiScore {
	

	private String archivoHiScore = System.getProperty("user.dir")+("/src/Hi-Score/puntajeMaximo.txt");
	private String maxScore="";
	
	
	
	public String hiScore() {
		
		
		InputStream in = LectorArchivo.class.getClassLoader().getResourceAsStream("Hi-Score/puntajeMaximo.txt");
		InputStreamReader inr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(inr);
		
		try {
			String linea = br.readLine();
			maxScore = linea;
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(maxScore);
		return maxScore;
	}
	
	public void cambiarHiScore(int nuevoScore) {
		System.out.println(nuevoScore);
		
		if(nuevoScore>Integer.parseInt(maxScore)) {
			 StringBuilder content = new StringBuilder();
		        try (BufferedReader reader = new BufferedReader(new FileReader(archivoHiScore))) {
		            String line = reader.readLine(); // Read the first line
		            if (line != null) {
		                content.append(nuevoScore).append("\n"); // Replace with the new first line
		                // Append the rest of the lines
		                while ((line = reader.readLine()) != null) {
		                    content.append(line).append("\n");
		                }
		            }
		        } catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        // Write the modified content back to the file
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoHiScore))) {
		            writer.write(content.toString());
		        } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
