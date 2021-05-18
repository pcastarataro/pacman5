package ModeloDeDominio.Laberinto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ModeloDeDominio.Laberinto.Excepciones.LaberintoInvalidoException;

/**
 * Clase creado con la funcion de levantar un Laberinto para jugar desde un archivo de texto que debe cumplir ciertas cosas.(Se explica en la documentacion).
 * @author PABLO
 */ 
public class CargadorDeLaberintos {

	/**
	 * 
	 * @param ruta
	 * @return unTablero
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws LaberintoInvalidoException
	 */
	public static Laberinto levantarDeTXT(java.lang.String ruta)throws FileNotFoundException,IOException, ClassNotFoundException, LaberintoInvalidoException{ 
		BufferedReader bufferDeLectura = new BufferedReader(new FileReader(ruta));
		java.lang.String cadenaDelArchivo = "";
		java.lang.String cadenaAuxiliar = "";
		while((cadenaAuxiliar = bufferDeLectura.readLine())!=null){
			cadenaDelArchivo += cadenaAuxiliar;
		}

		Laberinto laberintoPedido = ParserDeLaberintos.parsear(cadenaDelArchivo);

		return laberintoPedido;
	}

}

