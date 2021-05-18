package ModeloDeDominio.Juego;

import ModeloDeDominio.Personajes.Personaje;

public class FantasmitasPersiguenPacMan implements EstadoDelJuego {

	@Override
	public void consecuenciaDelChoqueEntre(Personaje pacman, Personaje fantasmita) {
		fantasmita.comerA(pacman);		
	}



}

