package taller2;

public class Gimnasio {
	
	private int NumGimnasio;
	private String Lider;
	private String Estado;
	private int cantPokemons;
	private String Pokemons;
	
	public Gimnasio(int numGimnasio, String lider, String estado, int cantPokemons, String pokemons) {
		
		NumGimnasio = numGimnasio;
		Lider = lider;
		Estado = estado;
		this.cantPokemons = cantPokemons;
		Pokemons = pokemons;
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

	public String getPokemons() {
		return Pokemons;
	}

	public void setPokemons(String pokemons) {
		Pokemons = pokemons;
	}
	
	

}
