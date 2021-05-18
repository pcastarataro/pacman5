package ModeloDeDominio.ElementosEstaticos;

import ModeloDeDominio.Common.Constantes;

public class Manzana extends Fruta {

	@Override
	public double getPuntaje() {
		return Constantes.getPuntajeDeManzana();
	}
}

