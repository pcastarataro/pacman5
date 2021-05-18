package ModeloDeDominio.Juego;

import ModeloDeDominio.ElementosEstaticos.Fruta;
import ModeloDeDominio.Laberinto.Laberinto;

public interface Juego {
	/**
	 * Cambia el estado del juego de pacman persigue a fantasmitas a fantasmitas persiguen a pacman o viceversa.
	 */
	public abstract void seComioUnaPastillaEspecial();

	/**
	 * @return verdadero en caso de que el usuario se quede sin vidas
	 */
	public abstract boolean estaPerdido();

	/**
	 * 
	 * @return verdadero en caso de que no haya mas pastillas que comer.
	 */
	public abstract boolean estaGanado();

	/**
	 * 
	 * @return verdadero en caso de que el juego este en proceso
	 */
	public abstract boolean seEstaJugando();

	/**
	 *  resta un vida y ubica a los personajes en las posiciones iniciales si no era la ultima vida
	 */
	public abstract void seComieronAPacman();

	/**
	 *  suma el puntaje de una pastilla al puntaje total
	 */
	public abstract void seComioUnaPastilla();

	/**
	 * suma al puntaje la cantidad de puntos que valia la fruta
	 * @param esta es la fruta que fue comida ya que las distintas frutas tienen distintos puntajes
	 */
	public abstract void seComioUnaFruta(Fruta esta);

	/**
	 * cambia el estado del juego a perdido
	 */
	public abstract boolean juegoPerdido();

	/**
	 * cambia el estado del juego a ganado
	 */
	public abstract boolean juegoGanado();

	/**
	 * cambia el estado del juego a pausado
	 */
	public abstract boolean juegoPausado();

	/**
	 * pausa el juego
	 */
	public abstract void pausarJuego();

	/**
	 * despause el juego
	 */
	public abstract void despausarJuego();

	/**
	 * auemnta el puntaje en el valor del fantasmita y regresa al fantasmita a la casa.
	 */
	public abstract void seComioUnFantasmita();

	/**
	 * setea el laberinto del juego
	 * @param laberinto es el laberinto a cargar.
	 */
	public abstract void cargarLaberinto(Laberinto laberinto);

	public boolean fantasmitasEstanPersiguiendoPacman();

	public boolean pacmanEstaPersiguiendoFantasmitas();
}

