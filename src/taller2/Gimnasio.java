package taller2;

import java.util.ArrayList;

public class Gimnasio {
	
	private int NumGimnasio;
	private String Lider;
	private String Estado;
	private int cantPokemons;
	private ArrayList<String> pokemons;
	
	public Gimnasio(int numGimnasio, String lider, String estado, int cantPokemons, ArrayList<String> pokemons) {
		
		NumGimnasio = numGimnasio;
		Lider = lider;
		Estado = estado;
		this.cantPokemons = cantPokemons;
		this.setPokemons(pokemons);
	}

	public int getNumGimnasio() {
		return NumGimnasio;
	}

	public void setNumGimnasio(int numGimnasio) {
		NumGimnasio = numGimnasio;
	}

	public String getLider() {
		return Lider;
	}

	public void setLider(String lider) {
		Lider = lider;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public int getCantPokemons() {
		return cantPokemons;
	}

	public void setCantPokemons(int cantPokemons) {
		this.cantPokemons = cantPokemons;
	}

	public ArrayList<String> getPokemons() {
		return pokemons;
	}

	public void setPokemons(ArrayList<String> pokemons) {
		this.pokemons = pokemons;
	}

	

}
