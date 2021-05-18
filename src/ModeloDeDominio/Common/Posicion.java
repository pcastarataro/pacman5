package ModeloDeDominio.Common;

public interface Posicion { 
	public abstract double getPosicionHorizontal();
	public abstract double getPosicionVertical();
	public abstract void modificarPosicionVerticalEn(double variacion);
	public abstract void modificarPosicionHorizontalEn(double variacion);
	public abstract boolean estaDentroDelMargenCon(Posicion otraPosicion, double delta);
	public abstract PosicionConcreta clonar();
	
}

