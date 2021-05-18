package ModeloDeDominio.ElementosEstaticos;

import ModeloDeDominio.Common.Constantes;

public class Melon extends Fruta {

	@Override
	public double getPuntaje() {
		return Constantes.getPuntajeDeMelon();
	}

}

