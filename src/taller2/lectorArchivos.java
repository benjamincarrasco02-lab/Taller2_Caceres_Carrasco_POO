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
			br.close();
		} catch (IOException e ) {
			System.out.println("Error al leer el archivo" + e.getMessage());
		}		
		return habitats;
	}
	
	public static ArrayList<Pokemon> leerPokemones() {
		ArrayList<Pokemon> pokemones = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("Pokedex.txt"));
			String linea = br.readLine();
			
			while (linea != null) {
				String[] partes = linea.split(";");
				String Pokemon = partes[0];
				String Habitat = partes[1];
				double porcentajeAparicion = Double.parseDouble(partes[2]);
				int Vida = Integer.parseInt(partes[3]);
				int Ataque = Integer.parseInt(partes[4]);
				int Defensa = Integer.parseInt(partes[5]);
				int ataqueEspecial = Integer.parseInt(partes[6]);
				int defensaEspecial = Integer.parseInt(partes[7]);
				int Velocidad = Integer.parseInt(partes[8]);
				String Tipo = partes[9];
				
				pokemones.add(new Pokemon(Pokemon, Habitat, porcentajeAparicion, Vida, Ataque, Defensa, ataqueEspecial, defensaEspecial, Velocidad, Tipo));
				linea = br.readLine();
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("Error al leer el archivo" + e.getMessage());
		}

	
		return pokemones;
	}
	
	public static ArrayList<String> leerRegistros() {
		ArrayList<String> registros = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("Registros.txt"));
			String linea = br.readLine();
			
			while (linea != null) {
				registros.add(linea);
				linea = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("No se puede leer el archivo " + e.getMessage());
		}

		return registros;
	}
	
	
	
}
