package ModeloDeDominio.Laberinto.Celdas;

import ModeloDeDominio.ElementosEstaticos.ElementoEstatico;
import Vista.ConstantesVista;

public abstract class CeldaConcreta  implements Celda {

	private int posicionY;
	private int posicionX;
	private boolean sufrioUnCambio; // por el tema de la vista... si no esta re lagueado...
	private ElementoEstatico elemento;
	
	public CeldaConcreta(int posicionX, int posicionY) {
		sufrioUnCambio = true;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	@Override
	public int getX() {
		return ConstantesVista.ANCHO_CELDA*this.posicionX+(ConstantesVista.ANCHO_CELDA/2); 
	}

	@Override
	public int getY() {
		return ConstantesVista.ALTO_CELDA*this.posicionY+(ConstantesVista.ALTO_CELDA/2);
	}
	

	protected void setElementoEstatico(ElementoEstatico unElemento){
		this.elemento=unElemento;
	}

	/**
	 * @see ModeloDeDominio.Laberinto.Celdas.Celda#esTransitable()
	 * 
	 *  
	 */
	abstract public boolean esTransitable();

	/**
	 * @see ModeloDeDominio.Laberinto.Celdas.Celda#estaCargada()
	 */
	public boolean estaCargada() {
		return (elemento!=null);
	}

	/**
	 * @see ModeloDeDominio.Laberinto.Celdas.Celda#getElementoAlmacenado()
	 */
	public ElementoEstatico getElementoAlmacenado() {
		sufrioUnCambio = true;
		return elemento;
	}

	public void removeElementoEstatico(){
		if (this.elemento!= null){
			this.sufrioUnCambio=true;
			this.elemento=null;
		}
	}
	
	public void almacenarElementoEstatico(ElementoEstatico unElemento) {
		this.elemento=unElemento;
		this.sufrioUnCambio=true;
	}

	public boolean sufrioUnCambio() {
		return sufrioUnCambio;
	}

	public void cambioYaTenidoEnCuenta() {
		this.sufrioUnCambio = false;		
	}
	
}

