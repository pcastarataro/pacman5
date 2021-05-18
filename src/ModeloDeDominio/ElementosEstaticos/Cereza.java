package ModeloDeDominio.ElementosEstaticos;

import ModeloDeDominio.Common.Constantes;

public class Cereza extends Fruta {

	@Override
	public double getPuntaje() {
		return Constantes.getPuntajeDeCereza();
	}

}

