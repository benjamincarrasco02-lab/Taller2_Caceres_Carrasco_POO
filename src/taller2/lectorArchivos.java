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
	
	public static ArrayList<Gimnasio> leerGimnasios() {
		ArrayList<Gimnasio> listaGimnasios = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("Gimnasios.txt"));
			String linea;
			
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(";");
				int NumGimnasio = Integer.parseInt(partes[0]);
				String Lider = partes[1];
				String Estado = partes[2];
				ArrayList<String> pokemonesTotales = new ArrayList<>();
				int cantPokemons = Integer.parseInt(partes[3]);
				for (int i = 4; i < partes.length; i++) {
					pokemonesTotales.add(partes[i]);
				}
				
				listaGimnasios.add(new Gimnasio(NumGimnasio, Lider, Estado, cantPokemons, pokemonesTotales));
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("Error al leer el archivo " + e.getMessage());
		}
		return listaGimnasios;
	}
	
	public static ArrayList<AltoMando> leerAltoMando() {
	    ArrayList<AltoMando> altosMandos = new ArrayList<>();

	    try {
	        BufferedReader br = new BufferedReader(new FileReader("Alto Mando.txt"));
	        String linea;

	        while ((linea = br.readLine()) != null) {
	            String[] partes = linea.split(";");
	            int numero = Integer.parseInt(partes[0]);
	            String nombre = partes[1];
	            ArrayList<String> pokemons = new ArrayList<>();

	            for (int i = 2; i < partes.length; i++) {
	                pokemons.add(partes[i]);
	            }
	            AltoMando miembro = new AltoMando(numero, nombre, pokemons);

	            altosMandos.add(miembro);
	        }

	        br.close();

	    } catch (IOException e) {
	        System.out.println("Error al leer Alto Mando");
	    }

	    return altosMandos;
	}
	
	
	
}
