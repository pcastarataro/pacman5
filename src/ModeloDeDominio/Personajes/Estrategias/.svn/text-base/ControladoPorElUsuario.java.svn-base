package ModeloDeDominio.Personajes.Estrategias;


import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Laberinto.Laberinto;

/**
 * Esta estrategia maneja dos posibles direcciones siempre...
 * la prioridad la tiene la q indica el usuario y es almacenada en el tope de una pila.. en caso de no poder avanzar en esa direccion se mantiene la direccion actual...
 * @author lea
 *
 */
public class ControladoPorElUsuario extends Estrategia {
	
	private Direccion direccionDelJugador;

	/**
	 * @see ModeloDeDominio.Estrategia#haciaDondeIrDesdePosicionConDireccionActual(Posicion, Direccion)
	 */
	public Direccion haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(Posicion hastaDonde, Posicion desdeDonde, Direccion direccionActual){
		return null;
	}
	
	@Override
	protected Direccion decidirMejorDireccionHorizontal(Direccion direccionActual, double distanciaHorizontal) {
		return null;
	}

	@Override
	protected Direccion decidirMejorDireccionVertical(Direccion direccionActual, double distanciaVertical) {
		return null;
	}
	
	public void irHaciaArriba(){
		direccionDelJugador = Direccion.ARRIBA;
	}

	public void irHaciaAbajo(){
		direccionDelJugador = Direccion.ABAJO;
	}
	
	public void irHaciaLaDerecha(){
		direccionDelJugador = Direccion.DERECHA;
	}
	
	public void irHaciaLaIzquierda(){
		direccionDelJugador = Direccion.IZQUIERDA;
	}

	@Override
	public Direccion haciaDondeIrDesdePosicionConDireccionActual(Posicion desdeDonde,Direccion direccionActual) {
		Direccion direccionADevolver;
		Laberinto laberinto = JuegoConcreto.getInstancia().getLaberinto();
		if (sePuedeRealizarUnCambioDeDireccionEnPosicion(desdeDonde)){
			direccionADevolver = direccionDelJugador;
			if (laberinto.sePuedeAvanzarEnDireccionDesde(direccionADevolver, desdeDonde)){
				return direccionADevolver;
			}
		}
		if (laberinto.sePuedeAvanzarEnDireccionDesde(direccionActual, desdeDonde))
			return direccionActual;
		return direccionActual;
	}
}

