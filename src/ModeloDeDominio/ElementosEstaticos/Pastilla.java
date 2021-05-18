package ModeloDeDominio.ElementosEstaticos;

import ModeloDeDominio.Juego.JuegoConcreto;

public class Pastilla extends ElementoEstatico {

	@Override
	public void digerir() {
		JuegoConcreto.getInstancia().seComioUnaPastilla();
	}

}

