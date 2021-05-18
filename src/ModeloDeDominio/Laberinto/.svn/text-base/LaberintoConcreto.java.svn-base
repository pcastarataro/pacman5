package ModeloDeDominio.Laberinto;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Matrix;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.ElementosEstaticos.ElementoEstatico;
import ModeloDeDominio.ElementosEstaticos.Pastilla;
import ModeloDeDominio.Laberinto.Celdas.Celda;
import ModeloDeDominio.Laberinto.Celdas.Pared;
import ModeloDeDominio.Personajes.Transitable;
import excepciones.PosicionFueraDeRangoException;




/**
 * Esta clase esta encargada de representar internamente un Laberinto para Jugar
 * @author PABLO
 */
public class LaberintoConcreto implements Laberinto, Transitable {

	private Matrix representacion;
	private Posicion posicionInicialDePacman;
	private Posicion posicionInicialDeFantasmas;
	PosicionConcreta puertaDeLosFantasmitas;
	private Posicion otroLadoDelPasaje;
	private Posicion unLadoDelPasaje;

	private Matrix getMatrizDeRepresentacion(){
		return this.representacion;
	}

	/**
	 * Constructor
	 * @param ancho
	 * @param alto
	 * @throws IllegalArgumentException
	 */
	public LaberintoConcreto(int ancho, int alto) throws IllegalArgumentException{
		if (!estaEnRango(ancho, alto)){
			throw new IllegalArgumentException();
		}else{
			representacion= new Matrix(ancho,alto);
			for(int i=0; i<ancho ; i++)
				for(int j=0; j<alto ; j++){
					representacion.setPosicion(i,j,new Pared(i,j));
				}
		}
	}

	/**
	 * @param ancho
	 * @param alto
	 * @param unaCelda
	 * @throws PosicionFueraDeRangoException
	 */
	public void setCelda(int ancho, int alto, Celda unaCelda) throws PosicionFueraDeRangoException{
		if (!estaEnRango(ancho,alto)){
			throw new PosicionFueraDeRangoException();
		}else{
			this.getMatrizDeRepresentacion().setPosicion(ancho, alto, unaCelda);
		}
	}

	private boolean estaEnRango(int ancho, int alto) {
		return (ancho >= 0) && (alto >= 0);
	}

	/**
	 * Devuelve verdadero cuando se puede avanzar hacia la derecha
	 * @param unaPosicion
	 */
	public boolean sePuedeAvanzarHaciaLaDerechaDesde(Posicion unaPosicion) {
		Celda unaCelda;
		try{
			unaCelda= this.getProximaCeldaALaDireccionDe(Direccion.DERECHA, unaPosicion);
			return unaCelda.esTransitable();
		}catch (PosicionFueraDeRangoException ex){ return false;}
	}
	/*
	 * verdadero en caso de que la poscion cno sus margenes este dentro del mismo casillero... en ese caso
	 * puede doblar... sino no...
	 */
	private boolean laPosicionHorizontalEstaContenidaEnUnaCelda(Posicion unaPosicion) {
		int casilleroCorresondienteAlMargenIzquierdo = (int)(unaPosicion.getPosicionHorizontal() - Constantes.getMargenDePersonajes());
		int casilleroCorrespondieteAlMargenDerecho = (int)(unaPosicion.getPosicionHorizontal() + Constantes.getMargenDePersonajes());
		return casilleroCorresondienteAlMargenIzquierdo == casilleroCorrespondieteAlMargenDerecho;
	}
	
	private boolean laPosicionVerticalEstaContenidaEnUnaCelda(Posicion unaPosicion) {
		int casilleroCorresondienteAlMargenIzquierdo = (int)(unaPosicion.getPosicionVertical() - Constantes.getMargenDePersonajes());
		int casilleroCorrespondieteAlMargenDerecho = (int)(unaPosicion.getPosicionVertical() + Constantes.getMargenDePersonajes());
		return casilleroCorresondienteAlMargenIzquierdo == casilleroCorrespondieteAlMargenDerecho;
	}
	
	public boolean laPosicionEstaAcotadaEnUnaCelda(Posicion unaPosicion){
		return (laPosicionHorizontalEstaContenidaEnUnaCelda(unaPosicion) && laPosicionVerticalEstaContenidaEnUnaCelda(unaPosicion));
	}

	/**
	 * Devuelve verdadero cuando se puede avanzar hacia la izquierda
	 * @param unaPosicion
	 */
	public boolean sePuedeAvanzarHaciaLaIzquierdaDesde(Posicion unaPosicion) {
		Celda unaCelda;
		try{
			unaCelda= this.getProximaCeldaALaDireccionDe(Direccion.IZQUIERDA, unaPosicion);
			return unaCelda.esTransitable();
		}catch (PosicionFueraDeRangoException ex){ return false;}
	}
	

	/**
	 * Devuelve verdadero cuando se puede avanzar hacia abajo
	 * @param unaPosicion
	 */
	public boolean sePuedeAvanzarHaciaAbajoDesde(Posicion unaPosicion) {
		Celda unaCelda;
		try{
			unaCelda = this.getProximaCeldaALaDireccionDe(Direccion.ABAJO, unaPosicion);
			return unaCelda.esTransitable();
		}catch (PosicionFueraDeRangoException ex){ return false;}
	}

	public Celda getProximaCeldaALaDireccionDe(Direccion direccion, Posicion posicion) {
		int horizontal = (int)posicion.getPosicionHorizontal();
		int vertical = (int)posicion.getPosicionVertical();
		Celda proxima;
		switch (direccion) {
		case ABAJO:
			vertical++;
			break;
		case ARRIBA:
			vertical--;
			break;
		case DERECHA:
			horizontal++;
			break;
		case IZQUIERDA:
			horizontal--;
			break;
		default:
			break;
		}
		proxima=this.getCeldaEn(horizontal, vertical);
		return proxima;
	}
	/**
	 * Devuelve verdadero cuando se puede avanzar hacia la izquierda
	 * @param unaPosicion
	 */
	public boolean sePuedeAvanzarHaciaArribaDesde(Posicion unaPosicion) {
		Celda unaCelda;
		try{
			unaCelda = this.getProximaCeldaALaDireccionDe(Direccion.ARRIBA, unaPosicion);
			return unaCelda.esTransitable();
		}catch (PosicionFueraDeRangoException ex){ return false;}
	}

	/**
	 * Devuelve la cantidad de pastillas que se encuentran en el tablero
	 */
	public int getCantidadDePastillas() {
		int contadorPastillas = 0;
		for (int i=0; i<this.getMatrizDeRepresentacion().getAncho() ;i++)
			for(int j=0; j<this.getMatrizDeRepresentacion().getAlto() ;j++){
				try{
					if (((Celda)this.getMatrizDeRepresentacion().getPosicion(i,j)).estaCargada()){
						ElementoEstatico estatico = ((Celda)this.getMatrizDeRepresentacion().getPosicion(i,j)).getElementoAlmacenado();
						if (estatico instanceof Pastilla){
							contadorPastillas++;
						}
					}
				}catch(PosicionFueraDeRangoException ex){}
			}
		return contadorPastillas;
	}

	@Override
	public Posicion getPosicionInicialDeLosFantasmas() {
		return this.posicionInicialDeFantasmas;
	}

	@Override
	public Posicion getPosicionInicialDePacman() {
		return this.posicionInicialDePacman;
	}

	@Override
	public void setPosicionInicialFantasmas(int posicionHorizontalCasaFantasma,
			int posicionVerticalCasaFantasma) {
		this.posicionInicialDeFantasmas = new PosicionConcreta(posicionHorizontalCasaFantasma + 0.5,
				posicionVerticalCasaFantasma + 0.5); 
	}

	@Override
	public void setPosicionInicialPacman(int posicionHorizontalInicialPacman,
			int posicionVerticalInicialPacman) {
		this.posicionInicialDePacman = new PosicionConcreta(posicionHorizontalInicialPacman + 0.5,
				posicionVerticalInicialPacman + 0.5); 

	}

	@Override
	public Celda casilleroEn(Posicion posicion) {
		return this.getCeldaEn((int)posicion.getPosicionHorizontal(),(int)posicion.getPosicionVertical());
	}

	/**
	 * Devuelve la celda en posicion
	 * @param posicionHorizontal
	 * @param posicionVertical
	 * @return
	 */
	private Celda getCeldaEn(int posicionHorizontal, int posicionVertical) {
		return (Celda) this.representacion.getPosicion(posicionHorizontal, posicionVertical);
	}

	public int getAlto() {
		return this.getMatrizDeRepresentacion().getAlto();
	}

	public int getAncho() {
		return this.getMatrizDeRepresentacion().getAncho();
	}

	public boolean sePuedeAvanzarEnDireccionDesde(Direccion direccion, Posicion origen) {
			if (direccion == null) return false;
			switch (direccion) {
			case ABAJO:
				return this.sePuedeAvanzarHaciaAbajoDesde(origen);
			case ARRIBA:
				return this.sePuedeAvanzarHaciaArribaDesde(origen);
			case DERECHA:
				return this.sePuedeAvanzarHaciaLaDerechaDesde(origen);
			case IZQUIERDA:
				return this.sePuedeAvanzarHaciaLaIzquierdaDesde(origen);
			default:
				return false;
			}
	}

	@Override
	public void setPuertaDeLaCasaDeLosFantasmitas(int x, int y) {
		this.puertaDeLosFantasmitas = new PosicionConcreta(x +0.5, y + 0.5);		
	}
	
	public Posicion getPuertaDeLaCasaDeLosFantasmitas(){
		return puertaDeLosFantasmitas;		
	}

	@Override
	public Celda casilleroEn(int i, int j) {
		return (Celda) representacion.getPosicion(i, j);
	}

	@Override
	public Posicion getInicioDelPasaje() {
		return unLadoDelPasaje;
	}

	@Override
	public Posicion getOtroLadoDelPasaje(Posicion pasaje) {
		if (pasaje.equals(unLadoDelPasaje))
			return otroLadoDelPasaje;
		else
			return unLadoDelPasaje;
	}

	@Override
	public Posicion getOtroLadoDelPasaje() {
		return otroLadoDelPasaje;
	}

	@Override
	public void setOtroLadoDelPasaje(int x, int y) {
		otroLadoDelPasaje = new PosicionConcreta(x + 0.5, y + 0.5);		
		
	}

	@Override
	public void setUnLadoDelPasaje(int x, int y) {
		unLadoDelPasaje = new PosicionConcreta(x + 0.5, y + 0.5);	
	}
}

