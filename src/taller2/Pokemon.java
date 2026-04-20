package taller2;

public class Pokemon {
	
	private String Pokemon;
	private String Habitat;
	private double porcentajeAparicion;
	private int Vida;
	private int Ataque;
	private int Defensa;
	private int ataqueEspecial;
	private int defensaEspecial;
	private int Velocidad;
	private String Tipo;
	
	public Pokemon(String pokemon, String habitat, double porcentajeAparicion, int vida, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, String tipo) {

		Pokemon = pokemon;
		Habitat = habitat;
		this.porcentajeAparicion = porcentajeAparicion;
		Vida = vida;
		Ataque = ataque;
		Defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		Velocidad = velocidad;
		Tipo = tipo;
	}

	public String getPokemon() {
		return Pokemon;
	}

	public void setPokemon(String pokemon) {
		Pokemon = pokemon;
	}

	public String getHabitat() {
		return Habitat;
	}

	public void setHabitat(String habitat) {
		Habitat = habitat;
	}

	public double getPorcentajeAparicion() {
		return porcentajeAparicion;
	}

	public void setPorcentajeAparicion(double porcentajeAparicion) {
		this.porcentajeAparicion = porcentajeAparicion;
	}

	public int getVida() {
		return Vida;
	}

	public void setVida(int vida) {
		Vida = vida;
	}

	public int getAtaque() {
		return Ataque;
	}

	public void setAtaque(int ataque) {
		Ataque = ataque;
	}

	public int getDefensa() {
		return Defensa;
	}

	public void setDefensa(int defensa) {
		Defensa = defensa;
	}

	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public void setAtaqueEspecial(int ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}

	public int getDefensaEspecial() {
		return defensaEspecial;
	}

	public void setDefensaEspecial(int defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}

	public int getVelocidad() {
		return Velocidad;
	}

	public void setVelocidad(int velocidad) {
		Velocidad = velocidad;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String toString() {
	    return Pokemon + ";" + Habitat + ";" + porcentajeAparicion + ";" +Vida + ";" + Ataque + ";" + Defensa + ";" + ataqueEspecial + ";" + defensaEspecial + ";" + Velocidad + ";" + Tipo; // los atributos que tengas
	}

}
