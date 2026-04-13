package taller2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class lectorArchivos {
	
	public static ArrayList<Habitats> leerHabitats() {
		ArrayList<Habitats> habitats = new ArrayList<>();
		
		try { 
			String linea;
			BufferedReader br = new BufferedReader(new FileReader("Habitats.txt"));

			while ((linea = br.readLine()) != null) {				
				habitats.add(new Habitats(linea));
			}
			
		} catch (IOException e ) {
			System.out.println("Error al leer el archivo" + e.getMessage());
		}		
		return habitats;
	}
		
	
}
