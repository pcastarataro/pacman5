package ModeloDeDominio.Personajes.Estrategias;

import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Laberinto.Laberinto;
import ModeloDeDominio.Laberinto.LaberintoConcreto;
import ModeloDeDominio.Laberinto.Celdas.Puerta;


public class VolverACasa extends Estrategia {

	public Direccion haciaDondeIrDesdePosicionConDireccionActual(Posicion desdeDonde,Direccion direccionActual) {
		return this.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(JuegoConcreto.getInstancia().getLaberinto().getPuertaDeLaCasaDeLosFantasmitas(), desdeDonde, direccionActual);
	}

	@Override
	protected boolean sePuedeAvanzarEnDireccionDesdeParaEstaEstrategia(Posicion desdeDonde, Direccion direccionADevolver,Laberinto laberinto) {
		LaberintoConcreto l = (LaberintoConcreto) laberinto;
		if (super.sePuedeAvanzarEnDireccionDesdeParaEstaEstrategia(desdeDonde, direccionADevolver, laberinto))
			return true;
		else
			if (l.getProximaCeldaALaDireccionDe(direccionADevolver, desdeDonde).getClass() == Puerta.class)
				return true;
		return false;		
	}
	
	

}