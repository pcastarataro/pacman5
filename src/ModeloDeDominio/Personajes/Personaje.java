package ModeloDeDominio.Personajes;

import ModeloDeDominio.Comestible;
import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.Common.Velocidad;
import ModeloDeDominio.Common.VelocidadConcreta;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Laberinto.Laberinto;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;
import ModeloDeDominio.Personajes.Estrategias.QuedarseEnCasa;
import Vista.ConstantesVista;
import ar.uba.fi.algo3.titiritero.Posicionable;
import excepciones.ModuloDeVelocidadInvalidoException;

public abstract class Personaje implements Movible, Ubicable, Comedor, Comestible, Posicionable {

	@Override
	public int getX() {
		return (int)(this.getPosicion().getPosicionHorizontal()*ConstantesVista.ANCHO_CELDA);
	}

	@Override
	public int getY() {
		return (int)(this.getPosicion().getPosicionVertical()*ConstantesVista.ALTO_CELDA);
	}

	/**
	 * @see ModeloDeDominio.Personajes.Movible#getVelocidad()
	 */
	public Velocidad getVelocidad() {
		return velocidad;
	}

	/**
	 * @see ModeloDeDominio.Personajes.Ubicable#getPosicion()
	 */
	public Posicion getPosicion() {
		return posicion;
	}

	/**
	 * @see ModeloDeDominio.Comedor#comerA(ModeloDeDominio.Comestible) 
	 */
	public void comerA(Comestible esto) {
		esto.digerir();
	}

	/**
	 * @see ModeloDeDominio.Comestible#digerir()
	 */
	abstract public void digerir();

	public Estrategia getEstrategia() {
		return this.estrategia;
	}

	public void setPosicionInicial(){
		this.setPosicion(this.posicionInicial());
		this.centrar();
		this.estuvoCentradoEnLaCelda = false;
		this.setEstrategia(new QuedarseEnCasa());
		this.actualizarVelocidad();
	}

	public Personaje(){
		this.setPosicion(posicionInicial().clonar());
		try {
			this.velocidad= new VelocidadConcreta(0, Direccion.ABAJO);
		} catch (ModuloDeVelocidadInvalidoException e) {
			e.printStackTrace();
		}
		estuvoCentradoEnLaCelda = false;
	}

	/**
	 * @see ModeloDeDominio.Personajes.Movible#mover()
	 */
	public void mover() {
		this.actualizarVelocidad();
		this.moverHorizontal();
		this.moverVertical();
		this.acomodar();
		
		controlarPasaje();
	}

	private void controlarPasaje() {
		Laberinto laberinto = JuegoConcreto.getInstancia().getLaberinto();
		boolean huboPasaje = false;
		if (getPosicion().equals(laberinto.getInicioDelPasaje()) && ! huboPasaje){
			this.setPosicion( laberinto.getOtroLadoDelPasaje().clonar());
			huboPasaje = true;
		}
		if (getPosicion().equals(laberinto.getOtroLadoDelPasaje()) && ! huboPasaje ){
			this.setPosicion( laberinto.getInicioDelPasaje().clonar());
			huboPasaje = true;
		}
	}

	public void setPosicion(Posicion posicionNueva) {
		this.posicion = posicionNueva;
	}

	private Velocidad velocidad;

	protected Estrategia estrategia;

	private Posicion posicion;
	
	protected boolean estuvoCentradoEnLaCelda;

	protected void setEstrategia(Estrategia nueva){
		this.estrategia = nueva;
	}

	/*
	 * Acomodar asegura que el personaje pase por el centro de la celda... en esa posicion es en la
	 * unica que puede cambiar de direccion
	 */
	private void acomodar() {
		Velocidad v = this.getVelocidad();
		int truncadoX = (int)this.getPosicion().getPosicionHorizontal();
		int truncadoY = (int)this.getPosicion().getPosicionVertical();
		double restoX = this.getPosicion().getPosicionHorizontal() - truncadoX;
		double restoY = this.getPosicion().getPosicionVertical() - truncadoY;
		
		if (v.tieneDireccionHaciaAbajo() || v.tieneDireccionHaciaLaDerecha()){
			if ( !estuvoCentradoEnLaCelda ){
				if (restoX > 0.5){
					acomdarPosicionHorizontal();
					estuvoCentradoEnLaCelda = true;
				}
				if (restoY > 0.5){
					acomodarPosicionVertical();
					estuvoCentradoEnLaCelda = true;
				}				
			}
			else
				if (restoX < 0.5 || restoY < 0.5)
					estuvoCentradoEnLaCelda = false;		
		}
		if (v.tieneDireccionHaciaArriba() || v.tieneDireccionHaciaLaIzquierda())
		{
			if ( ! estuvoCentradoEnLaCelda ){
				if (restoX < 0.5){
					acomdarPosicionHorizontal();
					estuvoCentradoEnLaCelda = true;
				}
				if (restoY < 0.5)
				{
					acomodarPosicionVertical();
					estuvoCentradoEnLaCelda = true;
				}			
			}
			else
				if (restoX > 0.5 || restoY > 0.5)
					estuvoCentradoEnLaCelda = false;		
		}
		
	}

	private void acomodarPosicionVertical() {
		this.setPosicion(new PosicionConcreta(this.getPosicion().getPosicionHorizontal(), ((int)(this.getPosicion().getPosicionVertical()))+0.5));
	}

	private void acomdarPosicionHorizontal() {
		this.setPosicion(new PosicionConcreta(((int)(this.getPosicion().getPosicionHorizontal()))+0.5, this.getPosicion().getPosicionVertical()));
	}

	abstract void actualizarVelocidad();
	

	private void moverVertical() {
		Velocidad estaVelocidad= this.getVelocidad();
		if(estaVelocidad.tieneDireccionHaciaArriba())
			this.getPosicion().modificarPosicionVerticalEn(-this.getVelocidad().getModulo());
		if(estaVelocidad.tieneDireccionHaciaAbajo())
			this.getPosicion().modificarPosicionVerticalEn(this.getVelocidad().getModulo());
	}

	private void moverHorizontal() {
		Velocidad estaVelocidad= this.getVelocidad();
		if(estaVelocidad.tieneDireccionHaciaLaDerecha())
			this.getPosicion().modificarPosicionHorizontalEn(this.getVelocidad().getModulo());
		if(estaVelocidad.tieneDireccionHaciaLaIzquierda())
			this.getPosicion().modificarPosicionHorizontalEn(-this.getVelocidad().getModulo());	
	}

	protected void centrar() {
		this.setPosicion(new PosicionConcreta((int)this.getPosicion().getPosicionHorizontal() + 0.5, (int)this.getPosicion().getPosicionVertical() + 0.5));
	}

	abstract protected Posicion posicionInicial();

	protected void setDireccionDeLaVelocidad(Direccion direccionNueva) {
		this.getVelocidad().cambiarDireccionHacia(direccionNueva);		
	}

	protected void setModuloDeLaVelocidad(double moduloNuevo){
		this.getVelocidad().setModulo(moduloNuevo);
	}
}

