//Antonia Ignacia Cáceres Calderón - 22.050.742-4 - ICCI
//Benjamín Andrés Carrasco Santander - 21.983.969-3 - ICCI
package taller2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class menuPrincipal {

	//Se llaman las listas
	static ArrayList<Habitats> habitats = lectorArchivos.leerHabitats();
	static ArrayList<Pokemon> pokemones = lectorArchivos.leerPokemones();
	static ArrayList<Gimnasio> gimnasios = lectorArchivos.leerGimnasios();
	static ArrayList<String> registros = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		menuPrincipall(scanner);
		
		scanner.close();
	}
	
	


	public static ArrayList<String> salirACapturar(Scanner scanner, ArrayList<Habitats> habitats, ArrayList<Pokemon> pokemones, ArrayList<String> registros) {

		System.out.println("Donde deseas ir a explorar?");
		System.out.println();
		System.out.println("Zonas disponibles: ");
		System.out.println();

		for (int i = 0; i < habitats.size(); i++) {
			System.out.println((i + 1) + ") " + habitats.get(i));
		} 
		System.out.println("7) Volver al menu.");
		System.out.println("\nIngrese Zona: ");

		int opcion = scanner.nextInt();

		while (opcion > 7) {
			System.out.println("Opción inválida");
			System.out.println("Ingrese Zona: ");
			opcion = scanner.nextInt();
		}

		if (opcion == 7) {
			System.out.print("Volviendo al menú...");

		} else {
			String[] opcionesHabitat = {"Lago", "Cueva", "Montaña", "Bosque", "Prado", "Mar"};
			String habitatElegido = opcionesHabitat[opcion - 1];
			ArrayList<String> pokemonesEspecificos = new ArrayList<>();

			for (Pokemon p : pokemones) {
				if (p.getHabitat().equals(habitatElegido)) {
					pokemonesEspecificos.add(p.getPokemon());
				}
			}

			Random rand = new Random();
			String pokemonAleatorio = pokemonesEspecificos.get(rand.nextInt(opcionesHabitat.length));
			System.out.print("Oh!! Ha aparecido un increíble " + pokemonAleatorio + "!!");
			System.out.println("\n¿Qué deseas hacer?\n1) Capturar. \n2) Huir.");
			int opcion2 = scanner.nextInt();

			if (opcion2 == 1) {
				if (!registros.get(0).contains(pokemonAleatorio)) {
					registros.add(pokemonAleatorio + ";Vivo");
					reescribirRegistros("Registros.txt", registros);
					System.out.println(pokemonAleatorio + " ha sido agregado a tu equipo!\n");
				} else {
					System.out.println("El pokemon ya se encuentra en tu equipo!!");
				}
				
			} else {
				System.out.println("Huyendo...");
			}

		}
		return registros;
	}

	public static void revisarEquipo(ArrayList<Pokemon> pokemones, ArrayList<String> registros) {

		System.out.println("Equipo actual: \n");
		for (int i = 0; i < registros.size(); i++) {


			String[] partes = registros.get(i).split(";");
	        String nombrePokemon = partes[0];
	        String estado = partes[1];
	        Pokemon pokemon = null;

			for (Pokemon p : pokemones) {
				if (p.getPokemon().equals(nombrePokemon)) {
					pokemon = p;
					break;
				}
			}

			 if (pokemon != null) {
		            int stats = pokemon.getVida() + pokemon.getAtaque() + pokemon.getDefensa() +
		                    pokemon.getAtaqueEspecial() + pokemon.getDefensaEspecial() + pokemon.getVelocidad();

		            System.out.println(i + ") " + nombrePokemon + " | " + pokemon.getTipo() +
		                    " | " + estado + " | Stats totales: " + stats);
		        }
		    }

		System.out.println();
		}
	
	public static void accesoPC(Scanner scanner, ArrayList<String> registros) {
		System.out.println("Estos son todos los pokemones que has capturado: \n");
		
		for (int i = 1; i < registros.size(); i++) {
			String[] partes = registros.get(i).split(";");
			System.out.println(i + ") " + partes[0]);
		}
		System.out.println("\n¿Qué deseas hacer?\n1) Cambiar Pokémon.\n2) Salir.");
		int op = scanner.nextInt();
		
		while (op > 2) {
			System.out.println("Opción inválida. Intente de nuevo");
			op = scanner.nextInt();
		}
		
		if (op == 1) {
			
		} else {
			System.out.println("Saliendo...");
		}
		
		
	
	}

	public static void retarGimnasio(ArrayList<Gimnasio> gimnasios, Scanner scanner) {
		System.out.println("A cual Lider deseas retar??");

		for (int i = 1; i < gimnasios.size(); i++) {
			System.out.println(i + ") " + gimnasios.get(i).getLider() + " - Estado: " + gimnasios.get(i).getEstado());
		}
		System.out.println("9) Volver al menu.\n\nIngrese opcion: ");

		int op = scanner.nextInt();

		for (int i = 1; i < gimnasios.size(); i++) {
			if (op == 1) {
				System.out.println("Desafiando a " + gimnasios.get(i - 1).getLider() + "!!");
				break;
			}
			else if (op == i) {
				if ((gimnasios.get(i - 1).getEstado().equals("Sin derrotar"))) {
					System.out.println("Calmado Entrenador!!! No puedes retar a "+ gimnasios.get(i).getLider() + " sin haber derrotado a los lideres anteriores!!");
				} else {
					System.out.println("Desafiando a " + gimnasios.get(i - 1).getLider() + "!!");
					
					
					
					
					
					break;
				}
			}
		}



		System.out.println();
	}
	
	public static void desafioAltoMando(Scanner scanner) {
		for (Gimnasio g : gimnasios) {
	        if (g.getEstado().equals("Sin derrotar")) {
	            System.out.println("Debes derrotar todos los gimnasios primero!");
	            return;
	        }
	    }  
	}
	
	public static void curarPokemones() {

	    for (int i = 1; i < registros.size(); i++) {

	        String[] partes = registros.get(i).split(";");
	        String nombre = partes[0];

	        registros.set(i, nombre + ";Vivo");
	    }
	    reescribirRegistros("Registros.txt", registros);

	    System.out.println("Tu equipo se ha recuperado!");
	}

	public static void reescribirRegistros(String txt, ArrayList<String> lista) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(txt));
			for (String linea : lista) {
				bw.write(linea);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error al modificar el texto" + e.getMessage());
		}
	}

	public static void menuContinuar(Scanner scanner) {
		registros = lectorArchivos.leerRegistros();

	    if (registros.isEmpty()) {
	        System.out.println("No hay partida guardada...");
	        return;
	    }

	    String[] datosJugador = registros.get(0).split(";");
	    String nombre = datosJugador[0];
	    String medalla = datosJugador[1];

	    System.out.println("Bienvenido de nuevo " + nombre + "!!");

	    int op;

	    do {
	        System.out.println(nombre + ", ¿Qué deseas hacer?: ");
	        System.out.println("\n1) Revisar equipo.\n2) Salir a capturar.\n3) Acceso al PC.\n4) Retar un gimnasio.\n5) Desafío al Alto Mando.\n6) Curar Pokémon.\n7) Guardar.\n8) Guardar y Salir.");
	        System.out.println("Ingrese opción: ");

	        op = scanner.nextInt();

	        switch (op) {
	            case 1:
	            	revisarEquipo(pokemones, registros);
	                break;
	            case 2:
	                salirACapturar(scanner, habitats, pokemones, registros);
	                break;
	            case 3:
	            	accesoPC(scanner,registros);
	            	break;
	            case 4:
	                retarGimnasio(gimnasios, scanner);
	                break;
	            case 5:
	            	desafioAltoMando(scanner);
	            	break;
	            case 6:
	            	curarPokemones();
	                break;
	            case 7:
	                reescribirRegistros("Registros.txt", registros);
	                System.out.println("Partida guardada!");
	                break;
	            case 8:
	                reescribirRegistros("Registros.txt", registros);
	                System.out.println("Nos vemos entrenador...");
	                break;
	            default:
	                System.out.println("Opción inválida");
	        }

	    } while (op != 8);
	}

	public static void menuNuevaPartida(Scanner scanner) {
		int op;
		System.out.println("Ingrese su apodo de jugador: ");
		String apodo = scanner.nextLine();
		System.out.println("Bienvenido " + apodo + "!!");
		registros.clear();
		registros.add(apodo + ";none");
		reescribirRegistros("Registros.txt", registros);
		do {
			System.out.println(apodo + ", ¿Qué deseas hacer?: ");
			System.out.println("\n1) Revisar equipo.\n2) Salir a capturar.\n3) Acceso al PC (cambiar Pokémon del equipo).\n4) Retar un gimnasio.\n5) Desafío al Alto Mando.\n6) Curar Pokémon.\n7) Guardar.\n8) Guardar y Salir.");
			System.out.println("Ingrese opción: ");
			op = scanner.nextInt();

			switch (op) {
				case 1:
					revisarEquipo(pokemones, registros);
					break;
				case 2:
					salirACapturar(scanner, habitats, pokemones, registros);
					break;
				case 3:
					accesoPC(scanner,registros);
					break;	
				case 4:
					retarGimnasio(gimnasios, scanner);
					break;
				case 5:
	            	desafioAltoMando(scanner);
	            	break;
				case 6:
					curarPokemones();
					break;	
				case 7:
	                reescribirRegistros("Registros.txt", registros);
	                System.out.println("Partida guardada!");
	                break;
				case 8:
					reescribirRegistros("Registros.txt", registros);
					System.out.println("Saliendo...");
					break;

				default:
					System.out.println("Opción inválida");

			}

		} while (op != 8);

	}

	public static void menuPrincipall(Scanner scanner) {
		int op;
		do {
			System.out.println("Bienvenido al juego!\nIngrese alguna de las siguientes opciones: ");
			System.out.println("1) Continuar.\n2) Nueva partida.\n3) Salir.");
			op = Integer.parseInt(scanner.nextLine());

			switch (op) {
				case 1: 
					menuContinuar(scanner);
					break;
				case 2:
					menuNuevaPartida(scanner);
					break;
				case 3:
					System.out.println("Saliendo...");
					break;

				default:
					System.out.println("Opcion inválida");
			}

		} while (op != 3);
	}




}
