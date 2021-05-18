package ModeloDeDominio.Personajes.Estrategias;

import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Juego.JuegoConcreto;

public class Escapar extends Estrategia {

	@Override
	public Direccion haciaDondeIrDesdePosicionConDireccionActual(Posicion desdeDonde, Direccion direccionActual) {
		return this.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(JuegoConcreto.getInstancia().getPacman().getPosicion(),desdeDonde,direccionActual);
	}

	@Override
	protected Direccion decidirMejorDireccionHorizontal(
			Direccion direccionActual, double distanciaHorizontal) {
		Direccion direccionHorizontalPrincipal;
		if (distanciaHorizontal>0){
			direccionHorizontalPrincipal=Direccion.DERECHA;
			if (direccionHorizontalPrincipal.direccionContraria() == direccionActual)
				direccionHorizontalPrincipal=Direccion.IZQUIERDA;				
		}
		else
		{
			direccionHorizontalPrincipal=Direccion.IZQUIERDA;
			if (direccionHorizontalPrincipal.direccionContraria() == direccionActual)
				direccionHorizontalPrincipal=Direccion.DERECHA;
		}
		return direccionHorizontalPrincipal;
	}
	@Override
	protected Direccion decidirMejorDireccionVertical(Direccion direccionActual, double distanciaVertical) {
		Direccion direccionVerticalPrincipal;
		if (distanciaVertical>0){
			direccionVerticalPrincipal=Direccion.ABAJO;
			if (direccionVerticalPrincipal.direccionContraria() == direccionActual)
				direccionVerticalPrincipal=Direccion.ARRIBA;				
		}
		else
		{
			direccionVerticalPrincipal=Direccion.ARRIBA;
			if (direccionVerticalPrincipal.direccionContraria() == direccionActual)
				direccionVerticalPrincipal=Direccion.ABAJO;
		}
		return direccionVerticalPrincipal;
	}
}

