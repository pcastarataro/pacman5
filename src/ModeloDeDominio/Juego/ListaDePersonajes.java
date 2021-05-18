package ModeloDeDominio.Juego;

import java.util.Iterator;

import excepciones.NoHayPacmanException;

import ModeloDeDominio.Personajes.FantasmitaConcreto;
import ModeloDeDominio.Personajes.Pacman;
import ModeloDeDominio.Personajes.Personaje;

public interface ListaDePersonajes extends Iterable<Personaje> {
	public abstract Pacman getPacman() throws NoHayPacmanException;
	public abstract Iterator<FantasmitaConcreto> iteradorFantasmitas();
	public void add(Personaje personaje);
	public abstract Iterator<Personaje> iterator();
}

