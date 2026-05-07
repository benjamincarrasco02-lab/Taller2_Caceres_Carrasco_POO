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
			String pokemonAleatorio = pokemonesEspecificos.get(rand.nextInt(pokemonesEspecificos.size()));
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

	    if (registros.size() <= 1) {
	        System.out.println("No tienes pokemones capturados!");
	        return;
	    }

	    System.out.println("Estos son todos los pokemones que has capturado:\n");

	    for (int i = 1; i < registros.size(); i++) {

	        String[] partes = registros.get(i).split(";");

	        if (i <= 6) {
	            System.out.println(i + ") " + partes[0] + " -> En tu equipo");
	        } else {
	            System.out.println(i + ") " + partes[0] + " -> En el Pc");
	        }
	    }

	    System.out.println("\n¿Qué deseas hacer?");
	    System.out.println("1) Cambiar Pokémon.");
	    System.out.println("2) Salir.");

	    int op = scanner.nextInt();

	    while (op < 1 || op > 2) {
	        System.out.println("Opción inválida.");
	        op = scanner.nextInt();
	    }

	    if (op == 1) {

	        if (registros.size() <= 2) {
	            System.out.println("No tienes suficientes pokemones para intercambiar.");
	            return;
	        }

	        System.out.println("\nIngrese el número del primer pokemon:");
	        int p1 = scanner.nextInt();

	        while (p1 < 1 || p1 >= registros.size()) {
	            System.out.println("Número inválido.");
	            p1 = scanner.nextInt();
	        }

	        System.out.println("Ingrese el número del segundo pokemon:");
	        int p2 = scanner.nextInt();

	        while (p2 < 1 || p2 >= registros.size()) {
	            System.out.println("Número inválido.");
	            p2 = scanner.nextInt();
	        }

	        String aux = registros.get(p1);

	        registros.set(p1, registros.get(p2));
	        registros.set(p2, aux);

	        reescribirRegistros("Registros.txt", registros);

	        System.out.println("Pokemones intercambiados correctamente!");

	    } else {

	        System.out.println("Saliendo del PC...");
	    }
	}

	public static void retarGimnasio(ArrayList<Gimnasio> gimnasios, Scanner scanner) {
	    System.out.println("A cual Lider deseas retar??");

	    for (int i = 0; i < gimnasios.size(); i++) {
	        System.out.println((i + 1) + ") "+ gimnasios.get(i).getLider()+ " - Estado: "+ gimnasios.get(i).getEstado());
	    }

	    System.out.println("9) Volver al menu.");
	    System.out.println("\nIngrese opcion: ");

	    int op = scanner.nextInt();

	    if (op == 9) {
	        System.out.println("Volviendo al menu...");
	        return;
	    }

	    if (op < 1 || op > gimnasios.size()) {
	        System.out.println("Opcion invalida");
	        return;
	    }
	    Gimnasio gimnasioElegido = gimnasios.get(op - 1);

	    if (op > 1) {
	        Gimnasio gimnasioAnterior = gimnasios.get(op - 2);

	        if (gimnasioAnterior.getEstado().equals("Sin derrotar")) {
	            System.out.println("Calmado Entrenador!!! No puedes retar a "+ gimnasioElegido.getLider()+ " sin haber derrotado a los lideres anteriores!!");
	            return;
	        }
	    }

	    System.out.println("Desafiando a "+ gimnasioElegido.getLider()+ "!!");

	    ArrayList<String> equipoRival = gimnasioElegido.getPokemons();

	    boolean gano = combate(scanner,registros,pokemones,equipoRival,gimnasioElegido.getLider());

	    if (gano) {
	        gimnasioElegido.setEstado("Derrotado");
	        reescribirGimnasios("Gimnasios.txt", gimnasios);
	        String[] datos = registros.get(0).split(";");
	        registros.set(0,datos[0] + ";" + gimnasioElegido.getLider());
	        reescribirRegistros("Registros.txt", registros);

	        System.out.println("Has conseguido una nueva medalla");

	    } else {
	        System.out.println("Perdiste");
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
	
	public static ArrayList<String> pokemonesVivos() {

	    ArrayList<String> vivos = new ArrayList<>();

	    for (int i = 1; i < registros.size() && i <= 6; i++) {

	        String[] partes = registros.get(i).split(";");

	        if (partes[1].equals("Vivo")) {
	            vivos.add(partes[0]);
	        }
	    }

	    return vivos;
	}
	
	public static Pokemon buscarPokemon(String nombre) {

	    for (Pokemon p : pokemones) {
	        if (p.getPokemon().equals(nombre)) {
	            return p;
	        }
	    }

	    return null;
	}
	
	public static void debilitarPokemon(String nombre) {

	    for (int i = 1; i < registros.size(); i++) {

	        String[] partes = registros.get(i).split(";");

	        if (partes[0].equals(nombre)) {

	            registros.set(i, nombre + ";Debilitado");
	            break;
	        }
	    }

	    reescribirRegistros("Registros.txt", registros);
	}
	
	public static int sumaStats(Pokemon p) {

	    return p.getVida()
	        + p.getAtaque()
	        + p.getDefensa()
	        + p.getAtaqueEspecial()
	        + p.getDefensaEspecial()
	        + p.getVelocidad();
	}
	
	public static boolean combate(Scanner scanner,ArrayList<String> registros,ArrayList<Pokemon> pokemones,ArrayList<String> equipoRival,String nombreRival) {
	    ArrayList<String> vivos = pokemonesVivos();

	    if (vivos.isEmpty()) {
	        System.out.println("No tienes pokemones vivos!");
	        return false;
	    }

	    Pokemon pokemonJugador = buscarPokemon(vivos.get(0));

	    for (String nombrePokemonRival : equipoRival) {

	        Pokemon pokemonRival = buscarPokemon(nombrePokemonRival);

	        System.out.println("\n" + nombreRival + " saca a " + pokemonRival.getPokemon() + "!");
	        System.out.println("Tu sacas a " + pokemonJugador.getPokemon() + "!");

	        boolean rivalDerrotado = false;

	        while (!rivalDerrotado) {

	            System.out.println("Que deseas hacer?");
	            System.out.println("1) Atacar");
	            System.out.println("2) Cambiar pokemon");
	            System.out.println("3) Rendirse");

	            int op = scanner.nextInt();

	            switch (op) {

	                case 1:

	                    double statsJugador = sumaStats(pokemonJugador);
	                    double statsRival = sumaStats(pokemonRival);

	                    System.out.println("\nStats base:");
	                    System.out.println(pokemonJugador.getPokemon() + " -> " + statsJugador);
	                    System.out.println(pokemonRival.getPokemon() + " -> " + statsRival);

	                    double efectividadJugador =
	                            TablaTipos.obtenerEfectividad(
	                                    pokemonJugador.getTipo(),
	                                    pokemonRival.getTipo());

	                    double efectividadRival =
	                            TablaTipos.obtenerEfectividad(
	                                    pokemonRival.getTipo(),
	                                    pokemonJugador.getTipo());

	                    statsJugador *= efectividadJugador;
	                    statsRival *= efectividadRival;

	                    System.out.println("\nEfectividad aplicada:");

	                    if (efectividadJugador > 1) {
	                        System.out.println(pokemonJugador.getPokemon() + " es super efectivo!");
	                    }
	                    else if (efectividadJugador < 1) {
	                        System.out.println(pokemonJugador.getPokemon() + " no es muy efectivo...");
	                    }

	                    if (efectividadRival > 1) {
	                        System.out.println(pokemonRival.getPokemon() + " es super efectivo!");
	                    }
	                    else if (efectividadRival < 1) {
	                        System.out.println(pokemonRival.getPokemon() + " no es muy efectivo...");
	                    }

	                    System.out.println("\nNuevos stats:");
	                    System.out.println(pokemonJugador.getPokemon() + " -> " + statsJugador);
	                    System.out.println(pokemonRival.getPokemon() + " -> " + statsRival);

	                    if (statsJugador >= statsRival) {

	                        System.out.println("\nHa ganado " + pokemonJugador.getPokemon() + "!");
	                        System.out.println(pokemonRival.getPokemon() + " ha sido derrotado!");

	                        rivalDerrotado = true;

	                    } else {

	                        System.out.println("\nHa ganado " + pokemonRival.getPokemon() + "!");
	                        System.out.println(pokemonJugador.getPokemon() + " ha sido derrotado!");

	                        debilitarPokemon(pokemonJugador.getPokemon());

	                        vivos = pokemonesVivos();

	                        if (vivos.isEmpty()) {

	                            System.out.println("\nTe has quedado sin pokemones!");
	                            System.out.println("Volviendo al menu...");

	                            return false;
	                        }

	                        System.out.println("\nPokemones disponibles:");

	                        for (int i = 0; i < vivos.size(); i++) {
	                            System.out.println((i + 1) + ") " + vivos.get(i));
	                        }

	                        System.out.println("Elige un pokemon:");

	                        int cambio = scanner.nextInt();

	                        while (cambio < 1 || cambio > vivos.size()) {
	                            System.out.println("Opcion invalida");
	                            cambio = scanner.nextInt();
	                        }

	                        pokemonJugador = buscarPokemon(vivos.get(cambio - 1));
	                    }

	                    break;

	                case 2:

	                    vivos = pokemonesVivos();

	                    if (vivos.size() == 1) {
	                        System.out.println("No tienes otro pokemon disponible!");
	                        break;
	                    }

	                    System.out.println("\nPokemones disponibles:");

	                    for (int i = 0; i < vivos.size(); i++) {
	                        System.out.println((i + 1) + ") " + vivos.get(i));
	                    }

	                    System.out.println("Seleccione pokemon:");

	                    int cambio = scanner.nextInt();

	                    while (cambio < 1 || cambio > vivos.size()) {
	                        System.out.println("Opcion invalida");
	                        cambio = scanner.nextInt();
	                    }

	                    pokemonJugador = buscarPokemon(vivos.get(cambio - 1));

	                    System.out.println("Adelante " + pokemonJugador.getPokemon() + "!");

	                    break;

	                case 3:

	                    System.out.println("Te has rendido...");
	                    return false;

	                default:
	                    System.out.println("Opcion invalida");
	            }
	        }
	    }

	    System.out.println("\nHas derrotado a " + nombreRival + "!");
	    return true;
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
	
	public static void reescribirGimnasios(String txt, ArrayList<Gimnasio> gimnasios) {
	    try {
	        BufferedWriter bw = new BufferedWriter(new FileWriter(txt));
	        for (Gimnasio g : gimnasios) {
	            String linea =g.getNumGimnasio() + ";"+ g.getLider() + ";"+ g.getEstado() + ";"+ g.getPokemons().size();

	            for (String pokemon : g.getPokemons()) {
	                linea += ";" + pokemon;
	            }
	            bw.write(linea);
	            bw.newLine();
	        }
	        bw.close();

	    } catch (IOException e) {
	        System.out.println("Error al modificar gimnasios: " + e.getMessage());
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
		for (Gimnasio g : gimnasios) {
	        g.setEstado("Sin derrotar");
	    }
		
		reescribirGimnasios("Gimnasios.txt", gimnasios);
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
