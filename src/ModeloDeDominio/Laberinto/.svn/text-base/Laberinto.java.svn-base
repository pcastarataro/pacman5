package ModeloDeDominio.Laberinto;


import excepciones.PosicionFueraDeRangoException;
import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Juego.Transitable;
import ModeloDeDominio.Laberinto.Celdas.Celda;


public interface Laberinto extends Transitable{

	int getCantidadDePastillas();

	/*void setCantidadDePastillas(int i);*/

	void setCelda(int alto, int i, Celda unaCelda)throws PosicionFueraDeRangoException;

	Posicion getPosicionInicialDeLosFantasmas();

	Posicion getPosicionInicialDePacman();

	void setPosicionInicialPacman(int posicionHorizontalInicialPacman,
			int posicionVerticalInicialPacman);

	void setPosicionInicialFantasmas(int posicionHorizontalCasaFantasma,
			int posicionVerticalCasaFantasma);

	Celda casilleroEn(Posicion posicion);

	int getAncho();

	int getAlto();

	boolean sePuedeAvanzarEnDireccionDesde(Direccion direccion, Posicion origen);

	void setPuertaDeLaCasaDeLosFantasmitas(int x, int y);

	public Posicion getPuertaDeLaCasaDeLosFantasmitas();

	Celda casilleroEn(int i, int j);

	Posicion getOtroLadoDelPasaje(Posicion pasaje);

	Posicion getInicioDelPasaje();
	
	Posicion getOtroLadoDelPasaje();

	void setOtroLadoDelPasaje(int x, int y);

	void setUnLadoDelPasaje(int x, int y);
}

