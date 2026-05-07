package taller2;

import java.util.ArrayList;

public class AltoMando {
	int numero;
	String nombre;
	ArrayList<String> pokemons;
	public AltoMando(int numero, String nombre, ArrayList<String> pokemons) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.pokemons = pokemons;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<String> getPokemons() {
		return pokemons;
	}
	public void setPokemons(ArrayList<String> pokemons) {
		this.pokemons = pokemons;
	}
	
	
}
