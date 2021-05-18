package ModeloDeDominio.Laberinto;

import excepciones.PosicionFueraDeRangoException;
import ModeloDeDominio.Laberinto.Celdas.Celda;
import ModeloDeDominio.Laberinto.Celdas.FabricaDeCeldas;
import ModeloDeDominio.Laberinto.Celdas.IFabricaDeCeldas;
import ModeloDeDominio.Laberinto.Celdas.Pared;
import ModeloDeDominio.Laberinto.Excepciones.LaberintoInvalidoException;
import ModeloDeDominio.Laberinto.Excepciones.LineaDeRepresentacionInvalidaException;

/**
 * Esta clase es la encargada de agarrar un String y transformarlo en un laberinto de juego
 * siempre y cuando se cumplan algunas condiciones.
 * @author PABLO
 */
public class ParserDeLaberintos {

	private static Laberinto laberintoBuscado;
	private static int ancho;
	private static int alto;

	/**
	 * Este metodo es el encargado de interpretar y crear el laberinto, siempre y cuando se pueda.
	 * @param representacion
	 * @return unLaberinto
	 * @throws LaberintoInvalidoException
	 */
	public static Laberinto parsear(String representacion)throws LaberintoInvalidoException{
		int alturaActual = 0;
		ancho = 0;
		alto = 0;
		try{
			cargarDimensiones(representacion);

			laberintoBuscado = new LaberintoConcreto(ancho,alto);

			for(int i=0; i<laberintoBuscado.getAlto() ;i++){
				alturaActual = i;
				String unaLinea = obtenerLineaDeRepresentacion(i,representacion);
				parsearLineaDeRepresentacion(unaLinea,alturaActual);
			}
			alto = 0;
			ancho = 0;
			return laberintoBuscado;
		}catch (Exception ex){throw new LaberintoInvalidoException();}
	}

	private static Celda generarCelda(char representacionDeUnaCelda, int x, int y) {
		Celda unaCelda;
		IFabricaDeCeldas laFabrica= new FabricaDeCeldas();
		switch(representacionDeUnaCelda){
		case ' ':{
			unaCelda = laFabrica.fabricarPasilloVacio(x,y);
			break;
		}
		case '*':{
			unaCelda = laFabrica.fabricarPasilloConPastilla(x,y);
			break;
		}
		case 'P':{
			unaCelda = laFabrica.fabricarPared(x,y);
			break;
		}
		case '+':{
			unaCelda = laFabrica.fabricarPasilloConPastillaEspecial(x,y);
			break;
		}
		case 'F':{
			unaCelda = laFabrica.fabricarPasilloVacio(x, y);
			laberintoBuscado.setPosicionInicialFantasmas(x, y);	
			break;
		}
		case 'I':{
			unaCelda = laFabrica.fabricarPasilloVacio(x, y);
			laberintoBuscado.setPosicionInicialPacman(x, y);
			break;
		}
		case '=':{
			unaCelda = laFabrica.fabricarPuerta(x, y);
			laberintoBuscado.setPuertaDeLaCasaDeLosFantasmitas(x,y);
			break;
		}
		case '|':{
			unaCelda= laFabrica.fabricarPasaje(x, y);
			if (laberintoBuscado.getOtroLadoDelPasaje() == null)
				laberintoBuscado.setOtroLadoDelPasaje(x	, y);
			else
				laberintoBuscado.setUnLadoDelPasaje(x, y);
			break;				
		}
		//Aqui completar en un futuro
		default: unaCelda = new Pared(x,y);
		}
		return unaCelda;
	}

	private static void cargarDimensiones(String representacion) throws LaberintoInvalidoException {
		int cantidadDeFilas = 0;
		boolean mePaseConElIndice = false;
		String unaLinea = null;
		while (! mePaseConElIndice){
			try{
				unaLinea = obtenerLineaDeRepresentacion(cantidadDeFilas, representacion);
			}
			catch (IndexOutOfBoundsException e) {
				mePaseConElIndice = true;
			}
			if (ancho == 0)
				ancho = unaLinea.length();
			if (unaLinea.length() != ancho)
				throw new LaberintoInvalidoException();
			if (! mePaseConElIndice)
				cantidadDeFilas ++;
		}
		alto = cantidadDeFilas;
	}

	private static void parsearLineaDeRepresentacion(String unaLinea,int alturaActual) throws LineaDeRepresentacionInvalidaException{
		if (unaLinea.length() != ancho){
			throw new LineaDeRepresentacionInvalidaException();
		}else{
			for(int i=0; i<ancho ;i++){
				char representacionDeUnaCelda = unaLinea.charAt(i);
				Celda unaCelda = generarCelda(representacionDeUnaCelda,i,alturaActual);
				try{
					laberintoBuscado.setCelda(i,alturaActual,unaCelda);
				}catch (PosicionFueraDeRangoException ex){throw new LineaDeRepresentacionInvalidaException();}
			}
		}
	}

	private static String obtenerLineaDeRepresentacion(int i, String representacion) {
		String[] lista = representacion.split(";");
		return lista[i];
	}
}
