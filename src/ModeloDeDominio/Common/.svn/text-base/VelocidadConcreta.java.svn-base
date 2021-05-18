package ModeloDeDominio.Common;

import excepciones.ModuloDeVelocidadInvalidoException;

public class VelocidadConcreta implements Velocidad {

	private Direccion direccion;
	private double modulo;

	public VelocidadConcreta(float moduloVelocidad, Direccion haciaDonde) throws ModuloDeVelocidadInvalidoException{
		this.setModulo(moduloVelocidad);
		this.setDireccion(haciaDonde);
	}

	public void setDireccion(Direccion haciaDonde) {
		this.direccion = haciaDonde;
	}

	public void setModulo(float modulo)throws ModuloDeVelocidadInvalidoException{
		if (modulo >= 0){
			this.modulo = modulo;
		}else throw new ModuloDeVelocidadInvalidoException();
	}

	/**
	 * @see ModeloDeDominio.Common.Velocidad#getModulo() 
	 */
	public double getModulo() {
		return this.modulo;
	}

	/**
	 * @see ModeloDeDominio.Common.Velocidad#getDireccion()
	 */
	public final Direccion getDireccion() {
		return this.direccion;
	}

	/**
	 * @see ModeloDeDominio.Common.Velocidad#cambiarDireccionHaciaLaIzquierda() 
	 */
	public void cambiarDireccionHaciaLaIzquierda() {
		this.setDireccion(Direccion.IZQUIERDA);
	}

	/**
	 * @see ModeloDeDominio.Common.Velocidad#cambiarDireccionHaciaLaDerecha()
	 */
	public void cambiarDireccionHaciaLaDerecha() {
		this.setDireccion(Direccion.DERECHA);
	}

	/**
	 * @see ModeloDeDominio.Common.Velocidad#cambiarDireccionHaciaArriba()
	 */
	public void cambiarDireccionHaciaArriba() {
		this.setDireccion(Direccion.ARRIBA);
	}

	/**
	 * @see ModeloDeDominio.Common.Velocidad#cambiarDireccionHaciaAbajo()
	 */
	public void cambiarDireccionHaciaAbajo() {
		this.setDireccion(Direccion.ABAJO);
	}

	@Override
	public boolean tieneDireccionHaciaAbajo(){
		return this.getDireccion()== Direccion.ABAJO;
	}

	@Override
	public boolean tieneDireccionHaciaArriba() {
		return this.getDireccion() == Direccion.ARRIBA;
	}

	@Override
	public boolean tieneDireccionHaciaLaDerecha() {
		return this.getDireccion() == Direccion.DERECHA;
	}

	@Override
	public boolean tieneDireccionHaciaLaIzquierda() {
		return this.getDireccion() == Direccion.IZQUIERDA;
	}

	@Override
	public void cambiarDireccionHacia(Direccion nuevaDireccion) {
		this.setDireccion(nuevaDireccion);
	}

	@Override
	public void setModulo(double modulo) {
		this.modulo = modulo;

	}

}

