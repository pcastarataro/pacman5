package ModeloDeDominio.ElementosEstaticos;

import ModeloDeDominio.Comestible;

public abstract class ElementoEstatico implements Comestible{

	abstract public void digerir();

	public boolean esFruta() {
		return false;
	}
	 
}

