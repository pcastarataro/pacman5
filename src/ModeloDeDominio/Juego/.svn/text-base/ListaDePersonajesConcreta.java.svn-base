package ModeloDeDominio.Juego;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ModeloDeDominio.Personajes.FantasmitaConcreto;
import ModeloDeDominio.Personajes.Pacman;
import ModeloDeDominio.Personajes.Personaje;
import excepciones.NoHayPacmanException;

public class ListaDePersonajesConcreta implements ListaDePersonajes {
	private Collection<Personaje> personajes;

	public ListaDePersonajesConcreta(){
		personajes=new ArrayList<Personaje>();
	}

	class IteradorDeFantasmitas implements Iterator<FantasmitaConcreto>{

		private Iterator<FantasmitaConcreto> iterador;

		public IteradorDeFantasmitas(ListaDePersonajesConcreta unaListaDePersonajes){
			ArrayList<FantasmitaConcreto> fantasmas  = new ArrayList<FantasmitaConcreto>();
			for(Personaje actual : unaListaDePersonajes.personajes)
			{
				if(actual instanceof FantasmitaConcreto)
				{
					fantasmas.add((FantasmitaConcreto) actual);
				}
			}
			iterador = fantasmas.iterator();
		}

		@Override
		public boolean hasNext() {
			return (iterador.hasNext());
		}

		@Override
		public FantasmitaConcreto next() {
			return iterador.next();
		}

		@Override
		public void remove() {
			// no se removeran elementos
		}
	}

	/**
	 * @throws NoHayPacmanException 
	 * @see ModeloDeDominio.IListaDePersonajes#getPacman()
	 */
	public Pacman getPacman() throws NoHayPacmanException {
		Iterator<Personaje> iterador=personajes.iterator();
		boolean esPacman=false;
		Personaje actual = null;
		while (iterador.hasNext() && !esPacman){
			actual = iterador.next();
			if (actual instanceof Pacman)
				esPacman= true;
		}
		if (!esPacman)
			throw new NoHayPacmanException();
		return (Pacman) actual;
	}

	/**
	 * @see ModeloDeDominio.IListaDePersonajes#iteradorFantasmitas()
	 */
	public Iterator<FantasmitaConcreto> iteradorFantasmitas() {
		return new IteradorDeFantasmitas(this);
	}

	@Override
	public void add(Personaje personaje) {
		this.personajes.add(personaje);		
	}

	@Override
	public Iterator<Personaje> iterator() {
		return this.personajes.iterator();
	}
}

