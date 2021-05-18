package ModeloDeDominio.Common;

public interface Velocidad {
	public abstract double getModulo();
	public abstract Direccion getDireccion();
	public abstract void cambiarDireccionHaciaLaIzquierda();
	public abstract void cambiarDireccionHaciaLaDerecha();
	public abstract void cambiarDireccionHaciaArriba();
	public abstract void cambiarDireccionHaciaAbajo();
	public abstract boolean tieneDireccionHaciaArriba();
	public abstract boolean tieneDireccionHaciaLaDerecha();
	public abstract boolean tieneDireccionHaciaLaIzquierda();
	public abstract boolean tieneDireccionHaciaAbajo();
	public abstract void cambiarDireccionHacia(Direccion nuevaDireccion);
	public abstract void setModulo(double modulo);
	public abstract void setDireccion(Direccion direccion);

}

