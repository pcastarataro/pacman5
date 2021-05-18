package ModeloDeDominio.Juego;

import ModeloDeDominio.Personajes.Personaje;

public class PacManPersigueFantasmitas implements EstadoDelJuego {

	@Override
	public void consecuenciaDelChoqueEntre(Personaje pacman, Personaje fantasmita) {
		pacman.comerA(fantasmita);		
	}
}

