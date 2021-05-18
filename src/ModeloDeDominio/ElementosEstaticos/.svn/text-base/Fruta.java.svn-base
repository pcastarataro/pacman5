package ModeloDeDominio.ElementosEstaticos;

import ModeloDeDominio.Juego.JuegoConcreto;

public abstract class Fruta extends ElementoEstatico {

	public void digerir() {
		JuegoConcreto.getInstancia().seComioUnaFruta(this);
	}

	public abstract double getPuntaje();

	public boolean esFruta() {
		return true;
	}	
}

