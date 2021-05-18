package ModeloDeDominio.Personajes.Estrategias;

import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Juego.JuegoConcreto;

public class QuedarseEnCasa extends Cazar{

	public Direccion haciaDondeIrDesdePosicionConDireccionActual(Posicion desdeDonde, Direccion direccionActual) {
		return super.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(JuegoConcreto.getInstancia().getLaberinto().getPosicionInicialDeLosFantasmas(), desdeDonde, direccionActual);
	}	
}
