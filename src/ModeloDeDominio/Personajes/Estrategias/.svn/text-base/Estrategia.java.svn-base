package ModeloDeDominio.Personajes.Estrategias;

import java.util.ArrayList;
import java.util.List;

import excepciones.NoExistePosibleMovimientoException;
import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Laberinto.Laberinto;
/**
 * La estrategia define la futura direccion de un personaje. 
 * @author lea
 *
 */
public abstract class Estrategia {

	/**
	 * 
	 * devuelve la direccion a seguir para llegar al objetivo
	 * 
	 * @param hastaDonde hasta que posicion se desea ir
	 * @param desdeDonde desde que posicion se parte
	 * @param direccionActual cual es la direccion que se tiene actualmente
	 * @return direccion para llegar a hastaDonde desde desdeDonde
	 */
	public Direccion haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(Posicion hastaDonde, Posicion desdeDonde, Direccion direccionActual) {

		double distanciaHorizontal = desdeDonde.getPosicionHorizontal() - hastaDonde.getPosicionHorizontal();
		double distanciaVertical = desdeDonde.getPosicionVertical() - hastaDonde.getPosicionVertical();

		if (sePuedeRealizarUnCambioDeDireccionEnPosicion(desdeDonde)){
			Direccion direccionVerticalPrincipal = this.decidirMejorDireccionVertical(direccionActual, distanciaVertical);
			Direccion direccionHorizontalPrincipal = this.decidirMejorDireccionHorizontal(direccionActual, distanciaHorizontal);

			ArrayList<Direccion> prioridadDeDirecciones = definirPrioridadesDeDireccion(
					direccionActual, distanciaHorizontal, distanciaVertical,
					direccionVerticalPrincipal, direccionHorizontalPrincipal); 

			return getMejorDireccionPosible(desdeDonde, prioridadDeDirecciones);	
		}
		else
			return direccionActual;
	}
	public abstract Direccion haciaDondeIrDesdePosicionConDireccionActual(Posicion desdeDonde,Direccion direccionActual);
	/**
	 * el cambio de direccion es posible solo si unaPosicion esta centrada, es decir, si ambas componentes son del tipo
	 * x.5 e y.5 . En todo caso que no cumpla esto el cmabio no es posible...
	 * 
	 * @param unaPosicion
	 * @return verdadero en caso de que se pueda
	 */
	
	protected boolean sePuedeRealizarUnCambioDeDireccionEnPosicion(Posicion unaPosicion) {
		int truncadoX = (int)unaPosicion.getPosicionHorizontal();
		int truncadoY = (int)unaPosicion.getPosicionVertical();
		double restoX = unaPosicion.getPosicionHorizontal() - truncadoX;
		double restoY = unaPosicion.getPosicionVertical() - truncadoY;
		return (restoX == 0.5 && restoY == 0.5);		
	}

	/**
	 * devuelve la mejor direccion que se deberia tomar para acercarse al objetivo horizontalmente. 
	 * El criterio utilizado es la distancia horizontal al objeivo, sin tener en cuenta la vertical.
	 * 
	 * @param direccionActual para bloquear la direccion contraria a la actual
	 * @param distanciaHorizontal en base a este numero se decide cual es la mejor
	 * @return
	 */
	protected Direccion decidirMejorDireccionHorizontal(
			Direccion direccionActual, double distanciaHorizontal) {
		Direccion direccionHorizontalPrincipal;
		if (distanciaHorizontal>0 ){
			direccionHorizontalPrincipal=Direccion.IZQUIERDA;
			if (direccionHorizontalPrincipal.direccionContraria() == direccionActual)
				direccionHorizontalPrincipal=Direccion.DERECHA;				
		}
		else
		{
			direccionHorizontalPrincipal=Direccion.DERECHA;
			if (direccionHorizontalPrincipal.direccionContraria() == direccionActual)
				direccionHorizontalPrincipal=Direccion.IZQUIERDA;
		}
		return direccionHorizontalPrincipal;
	}

	/**
	 * devuelve la mejor direccion que se deberia tomar para acercarse al objetivo verticalmente. 
	 * El criterio utilizado es la distancia vertical al objetivo, sin tener en cuenta la horizontal.
	 * 
	 * @param direccionActual para bloquear la direccion contraria a la actual
	 * @param distanciaVertcial en base a este numero se decide cual es la mejor
	 * @return
	 */
	protected Direccion decidirMejorDireccionVertical(Direccion direccionActual, double distanciaVertical) {
		Direccion direccionVerticalPrincipal;
		if (distanciaVertical>0){
			direccionVerticalPrincipal=Direccion.ARRIBA;
			if (direccionVerticalPrincipal.direccionContraria() == direccionActual)
				direccionVerticalPrincipal = Direccion.ABAJO;				
		}
		else
		{
			direccionVerticalPrincipal=Direccion.ABAJO;
			if (direccionVerticalPrincipal.direccionContraria() == direccionActual)
				direccionVerticalPrincipal = Direccion.ARRIBA;
		}
		return direccionVerticalPrincipal;
	}
	/**
	 * 
	 * recorre la lista de direcciones ordenada pro prioridad y devuelve la direccion con mayor prioridad en la que es posible avanzar
	 * 
	 * @param desdeDonde 
	 * @param prioridadDeDirecciones Colleccion ordenada por prioridad.
	 * @return
	 */
	private Direccion getMejorDireccionPosible(Posicion desdeDonde, List<Direccion> prioridadDeDirecciones) {
		boolean futuraPosicionValida=false;
		int orden = 0;
		Direccion direccionADevolver = null ;
		while (! futuraPosicionValida && orden < prioridadDeDirecciones.size()){
			direccionADevolver = prioridadDeDirecciones.get(orden);
			Laberinto laberinto = JuegoConcreto.getInstancia().getLaberinto();
			if (sePuedeAvanzarEnDireccionDesdeParaEstaEstrategia(desdeDonde,direccionADevolver, laberinto))
				futuraPosicionValida = true;
			orden++;
		}
		if (! futuraPosicionValida)
			throw new NoExistePosibleMovimientoException();
		return direccionADevolver;
	}

	protected boolean sePuedeAvanzarEnDireccionDesdeParaEstaEstrategia(Posicion desdeDonde, Direccion direccionADevolver,	Laberinto laberinto) {
		return laberinto.sePuedeAvanzarEnDireccionDesde(direccionADevolver,desdeDonde);
	}
	
	private Direccion direccionFaltante(ArrayList<Direccion> arrayDeDirecciones) {
		ArrayList<Direccion> todasLasDirecciones=new ArrayList<Direccion>(4);
		todasLasDirecciones.add(Direccion.ARRIBA);
		todasLasDirecciones.add(Direccion.ABAJO);
		todasLasDirecciones.add(Direccion.DERECHA);
		todasLasDirecciones.add(Direccion.IZQUIERDA);
		todasLasDirecciones.remove(arrayDeDirecciones.get(0));
		todasLasDirecciones.remove(arrayDeDirecciones.get(1));
		todasLasDirecciones.remove(arrayDeDirecciones.get(3));
		return todasLasDirecciones.get(0);
	}

	/*
	 * Carga las prioridades segun las distancias... la ultuima prioridad es dar la vuelta...
	 */
	private ArrayList<Direccion> definirPrioridadesDeDireccion(Direccion direccionActual, double distanciaHorizontal,	double distanciaVertical, Direccion direccionVerticalPrincipal,		Direccion direccionHorizontalPrincipal) {
		Direccion prioridadUno;
		Direccion prioridadDos;
		if ( distanciaHorizontal < distanciaVertical){
			prioridadUno = direccionHorizontalPrincipal;
			prioridadDos = direccionVerticalPrincipal;
		}
		else
		{
			prioridadUno = direccionVerticalPrincipal;
			prioridadDos = direccionHorizontalPrincipal;
		}
		if (distanciaHorizontal >= 0 && distanciaHorizontal <= Constantes.getMargenDePersonajes()){
			prioridadUno = direccionVerticalPrincipal;
			prioridadDos = direccionHorizontalPrincipal;
		}
		if (distanciaVertical >= 0 && distanciaVertical <= Constantes.getMargenDePersonajes()){
			prioridadUno = direccionHorizontalPrincipal;
			prioridadDos = direccionVerticalPrincipal;
		}

		ArrayList<Direccion> prioridadDeDirecciones=new ArrayList<Direccion>();
		prioridadDeDirecciones.add(prioridadUno);
		prioridadDeDirecciones.add(prioridadDos);
		prioridadDeDirecciones.add(direccionActual);
		prioridadDeDirecciones.add(direccionActual.direccionContraria());
		prioridadDeDirecciones.set(2, this.direccionFaltante(prioridadDeDirecciones));
		return prioridadDeDirecciones;
	}
}

