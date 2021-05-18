package ModeloDeDominio.Personajes.Estrategias;

import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Juego.JuegoConcreto;

public class Cazar extends Estrategia {

	public Direccion haciaDondeIrDesdePosicionConDireccionActual(Posicion desdeDonde,Direccion direccionActual) {
		Posicion posicionDelPacman = JuegoConcreto.getInstancia().getPacman().getPosicion();
		return this.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(posicionDelPacman, desdeDonde, direccionActual);
	}
}

