//Antonia Ignacia Cáceres Calderón - 22.050.742-4 - ICCI
//Benjamín Andrés Carrasco Santander - 21.983.969-3 - ICCI
package taller2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;

public class menuPrincipal {
	
	//Se llaman las listas
	static ArrayList<Habitats> habitats = new ArrayList<>();
	
	public static void main(String[] args) {
		
		habitats = lectorArchivos.leerHabitats();
		Scanner scanner = new Scanner(System.in);
		
		menuPrincipall(scanner);
		

	}

	
	public static void salirACapturar(Scanner scanner) {
		System.out.println("Donde deseas ir a explorar?");
		System.out.println();
		System.out.println("Zonas disponibles: ");
		System.out.println();
		
		for (int i = 0; i < habitats.size(); i++) {
			System.out.println((i + 1) + ") " + habitats.get(i));
			
		}
	
		
	}
	
	
	public static void reescribirArchivos(String txt, String[] lista, int datos) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(txt));
			for (int i = 0; i < datos; i++) {
				bw.write(lista[i]);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error al modificar el texto" + e.getMessage());
		}
	}
	
	public static void menuContinuar(Scanner scanner) {
		System.out.println("Sapo");
	}
	
	public static void menuNuevaPartida(Scanner scanner) {
		int op;
		
		do {
			System.out.println("Ingrese su apodo de jugador: ");
			String apodo = scanner.nextLine();
			System.out.println("Bienvenido " + apodo + "!!");
			System.out.println(apodo + ", qué deseas hacer?: ");
			System.out.println("\n1) Revisar equipo.\n2) Salir a capturar.\n3) Acceso al PC.\n4) Retar un gimnasio.\n5) Desafío al Alto Mando.\n6) Curar Pokémon.\n7) Guardar.\n8) Guardar y Salir.");
			System.out.println("Ingrese opción: ");
			op = Integer.valueOf(scanner.nextLine());
			
			switch (op) {
			
				case 2:
					salirACapturar(scanner);
					break;
					
					
				case 8:
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
			System.out.println("Bienvenido al juego! Ingrese alguna de las siguientes opciones: ");
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
