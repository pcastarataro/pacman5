package ModeloDeDominio.Laberinto.Celdas;

import ModeloDeDominio.ElementosEstaticos.ElementoEstatico;
import ModeloDeDominio.ElementosEstaticos.Pastilla;
import ModeloDeDominio.ElementosEstaticos.PastillaEspecial;

/**
 * Clase encargada de la creacion de los distintos tipos de celdas. Usa el patron factory.
 * @author PABLO
 *
 */
public class FabricaDeCeldas implements IFabricaDeCeldas{

	@Override
	public Celda fabricarPared(int x, int y) {
		return new Pared(x,y);
	}

	@Override
	public Celda fabricarPasilloConPastilla(int x, int y) {
		Celda unaCelda= new Pasillo(x,y);
		ElementoEstatico pastilla= new Pastilla();
		unaCelda.almacenarElementoEstatico(pastilla);
		return unaCelda;
	}

	@Override
	public Celda fabricarPasilloConPastillaEspecial(int x, int y) {
		Celda unaCelda= new Pasillo(x,y);
		ElementoEstatico pastillaEspecial= new PastillaEspecial();
		unaCelda.almacenarElementoEstatico(pastillaEspecial);
		return unaCelda;
	}

	@Override
	public Celda fabricarPasilloVacio(int x, int y) {
		return new Pasillo(x,y);
	}

	@Override
	public Celda fabricarPuerta(int x, int y) {
		return new Puerta(x, y);
	}

	@Override
	public Celda fabricarPasaje(int x, int y) {
		return new Pasaje(x,y);
	}
}
