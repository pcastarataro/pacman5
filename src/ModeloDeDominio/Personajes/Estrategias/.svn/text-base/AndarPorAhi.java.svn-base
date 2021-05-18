package ModeloDeDominio.Personajes.Estrategias;

import java.util.Random;

import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.Juego.JuegoConcreto;

public class AndarPorAhi extends Estrategia {
	
	public Direccion haciaDondeIrDesdePosicionConDireccionActual(Posicion desdeDonde,Direccion direccionActual) {
		PosicionConcreta aleatoria = this.generarPosicionAleatoria();
		return this.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(aleatoria, desdeDonde, direccionActual);
	}

	private PosicionConcreta generarPosicionAleatoria() {
		Random aleatorio = new Random();
		return new PosicionConcreta(aleatorio.nextDouble()*JuegoConcreto.getInstancia().getLaberinto().getAncho(), aleatorio.nextDouble()*JuegoConcreto.getInstancia().getLaberinto().getAlto());
	}	
}