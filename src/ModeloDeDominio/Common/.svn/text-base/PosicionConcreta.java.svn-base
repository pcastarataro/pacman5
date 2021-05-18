package ModeloDeDominio.Common;

public class PosicionConcreta implements Posicion{
	private double posicionHorizontal;
	private double posicionVertical;

	private void setPosicionVertical(double posicionY) {
		if (posicionY<0){
			throw new IllegalArgumentException();
		}
		posicionVertical= posicionY;
	}
	private void setPosicionHorizontal(double posicionX) {	
		if (posicionX<0){
			throw new IllegalArgumentException();
		}
		posicionHorizontal = posicionX;
	}

	public PosicionConcreta(double posicionHorizontal, double posicionVertical) throws IllegalArgumentException{
		setPosicionHorizontal(posicionHorizontal);
		setPosicionVertical(posicionVertical);
	}

	/**
	 * @see ModeloDeDominio.Common.Posicion#getPosicionHorizontal()
	 */
	public double getPosicionHorizontal() {
		return this.posicionHorizontal;
	}

	/**
	 * @see ModeloDeDominio.Common.Posicion#getPosicionVertical()
	 */
	public double getPosicionVertical() {
		return this.posicionVertical;
	}
	@Override
	public void modificarPosicionHorizontalEn(double variacion) {
		this.setPosicionHorizontal(this.getPosicionHorizontal() + variacion);		
	}
	@Override
	public void modificarPosicionVerticalEn(double variacion) {
		this.setPosicionVertical(this.getPosicionVertical() + variacion);

	}
	@Override
	public boolean equals(Object obj) {
		return ( ( this.getPosicionHorizontal()==((PosicionConcreta)obj).getPosicionHorizontal() ) && ( this.getPosicionVertical()==((PosicionConcreta)obj).getPosicionVertical() ) );
	}
	@Override
	public boolean estaDentroDelMargenCon(Posicion otraPosicion, double delta) {
		return (this.estaDentroDelMargenHorizontal(otraPosicion,delta) && this.estaDentroDelMargenVertical(otraPosicion, delta));
	}
	private boolean estaDentroDelMargenVertical(Posicion otraPosicion, double delta) {
		return ((acotadoDesdeArriba(otraPosicion, delta))&&(acotadoDesdeAbajo(otraPosicion, delta) ));
	}
	private boolean acotadoDesdeAbajo(Posicion otraPosicion, double delta) {
		return (this.getPosicionVertical() + delta) > (otraPosicion.getPosicionVertical()- delta);
	}
	private boolean acotadoDesdeArriba(Posicion otraPosicion, double delta) {
		return (this.getPosicionVertical() - delta) < (otraPosicion.getPosicionVertical()+ delta);
	}

	private boolean estaDentroDelMargenHorizontal(Posicion otraPosicion, double delta) {
		return ((acotadoDesdeDerecha(otraPosicion, delta))&&(acotadoDesdeIzquierda(otraPosicion, delta) ));
	}
	private boolean acotadoDesdeIzquierda(Posicion otraPosicion, double delta) {
		return (this.getPosicionHorizontal() - delta) < (otraPosicion.getPosicionHorizontal() + delta);
	}
	private boolean acotadoDesdeDerecha(Posicion otraPosicion, double delta) {
		return (this.getPosicionHorizontal() + delta) > otraPosicion.getPosicionHorizontal() - delta;
	}
	@Override
	public PosicionConcreta clonar() {
		return new PosicionConcreta(this.getPosicionHorizontal(), this.getPosicionVertical());
	}
}

