package ModeloDeDominio.ElementosEstaticos;

import ModeloDeDominio.Common.Constantes;

public class Banana extends Fruta {

	@Override
	public double getPuntaje() {
		return Constantes.getPuntajeDeBanana();
	}

	

}

