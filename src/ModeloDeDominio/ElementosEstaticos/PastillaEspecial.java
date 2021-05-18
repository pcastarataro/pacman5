package ModeloDeDominio.ElementosEstaticos;

import ModeloDeDominio.Juego.JuegoConcreto;

public class PastillaEspecial extends Pastilla {

	@Override
	public void digerir() {
		JuegoConcreto.getInstancia().seComioUnaPastillaEspecial();
	}

}

