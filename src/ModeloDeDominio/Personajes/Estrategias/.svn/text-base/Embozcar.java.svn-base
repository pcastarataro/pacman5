package ModeloDeDominio.Personajes.Estrategias;

import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Laberinto.Laberinto;
import ModeloDeDominio.Personajes.Pacman;

public class Embozcar extends Estrategia {

	public Direccion haciaDondeIrDesdePosicionConDireccionActual(Posicion desdeDonde,Direccion direccionActual) {
		
		JuegoConcreto juegoActual = JuegoConcreto.getInstancia();
		Laberinto miLaberinto = (Laberinto) juegoActual.getLaberinto();
		Pacman PacMan=juegoActual.getPacman();
		Posicion posicionPacMan = truncarPosicion(PacMan.getPosicion()); // SOLO ME INTERESA LA PARTE ENTERA, ESTA PARTE NO INTERFIERE CON LA PARTE GRAFICA
		Direccion pacmanDireccion = PacMan.haciaDondeVa();
		Posicion interseccion = truncarPosicion(posicionPacMan);
		interseccion = new PosicionConcreta(interseccion.getPosicionHorizontal()+0.5, interseccion.getPosicionVertical()+0.5);
		
		int cantidadCaminosPacman=0;
		
		if (pacmanDireccion == null){pacmanDireccion = Direccion.DERECHA;} // SI NO ERA POSIBLE QUE TIRE NULL POINTER EXCEPTION, SI EL PACMAN NO TIENE DIR POR DEFECTO TOMA LA DERECHA
		
		while ((miLaberinto.sePuedeAvanzarEnDireccionDesde(pacmanDireccion,interseccion))&&(cantidadCaminosPacman<3)){
			interseccion=proximaPosicionEnDireccion (pacmanDireccion, interseccion);
			cantidadCaminosPacman=getCantidadDeCaminos(miLaberinto,interseccion);
		}
		
		if(desdeDonde.equals(interseccion)){ // SI DESDEDONDE ES IGUAL A LA INTERSECCION VOY A BUSCAR AL PACMAN COMO UN CAZADOR
			
			interseccion=PacMan.getPosicion();
		
		}
	
		return this.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(interseccion , desdeDonde, direccionActual);
	}

	/*
	 * Se fija para q lado esta el objetivo horizontalmente...
	 * la direccion devuelta es la necesaria para ir a ese lado si no hubiera obstaculs..
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

	/*
	 * Se fija si esta por encima o por debajo del objetivo..
	 * devuelve la direccion para acercarse si no hubiera obstaculos...
	 */
	protected Direccion decidirMejorDireccionVertical(Direccion direccionActual, double distanciaVertical) {
		Direccion direccionVerticalPrincipal;
		if (distanciaVertical>0){
			direccionVerticalPrincipal=Direccion.ARRIBA;
			if (direccionVerticalPrincipal.direccionContraria() == direccionActual)
				direccionVerticalPrincipal=Direccion.ABAJO;				
		}
		else
		{
			direccionVerticalPrincipal=Direccion.ABAJO;
			if (direccionVerticalPrincipal.direccionContraria() == direccionActual)
				direccionVerticalPrincipal=Direccion.ARRIBA;
		}
		return direccionVerticalPrincipal;
	}

	private Posicion proximaPosicionEnDireccion (Direccion direccion, Posicion origen){
		Posicion nuevaPosicion = truncarPosicion(origen);
		double horizontal = 0;
		double vertical = 0;

		horizontal=origen.getPosicionHorizontal();
		vertical= origen.getPosicionVertical();
			if (direccion == Direccion.ABAJO){ nuevaPosicion= new PosicionConcreta(horizontal, vertical+1 );}
			if (direccion == Direccion.ARRIBA){ nuevaPosicion= new PosicionConcreta(horizontal, vertical-1);}
			if (direccion == Direccion.IZQUIERDA){ nuevaPosicion= new PosicionConcreta(horizontal-1, vertical );}
			if (direccion == Direccion.DERECHA){ nuevaPosicion= new PosicionConcreta(horizontal+1, vertical );}
		return nuevaPosicion;
	}
	
	private Posicion truncarPosicion (Posicion miPosicion){
		Posicion posicionTruncada= null;
		int horizontal = 0;
		int vertical = 0;

		horizontal = (int)miPosicion.getPosicionHorizontal();
		vertical = (int)miPosicion.getPosicionVertical();
		
		posicionTruncada = new PosicionConcreta(horizontal,vertical);
		
		return posicionTruncada;
	}
	
	private int getCantidadDeCaminos(Laberinto miLaberinto,Posicion posicion){
		
		int cantidadDeCaminos=0;
		
		if (miLaberinto.sePuedeAvanzarEnDireccionDesde(Direccion.ABAJO,posicion)){
			cantidadDeCaminos++;
		}
		if (miLaberinto.sePuedeAvanzarEnDireccionDesde(Direccion.ARRIBA,posicion)){
			cantidadDeCaminos++;
		}
		if (miLaberinto.sePuedeAvanzarEnDireccionDesde(Direccion.DERECHA,posicion)){
			cantidadDeCaminos++;
		}
		if (miLaberinto.sePuedeAvanzarEnDireccionDesde(Direccion.IZQUIERDA,posicion)){
			cantidadDeCaminos++;
		}
		return cantidadDeCaminos;
	}

}


