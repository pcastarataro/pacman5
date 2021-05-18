package ModeloDeDominio.Juego;

import java.io.FileNotFoundException;
import java.io.IOException;

import ModeloDeDominio.Laberinto.Excepciones.LaberintoInvalidoException;

/**
 * Esta clase será la encargada de, usando el patron factory method, crear instancias de juegos con distintas caracteristicas.
 * @author PABLO
 *
 */
public class FabricaDeJuegos {
	/**
	 * El juego clasico en el tablero basico
	 * @return unJuego
	 * @throws LaberintoInvalidoException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static JuegoConcreto fabricarJuegoClasico() throws FileNotFoundException, IOException, ClassNotFoundException, LaberintoInvalidoException{
		return fabricarJuegoEnLaberinto("ArchivosNecesarios/Laberintos/Laberintoposta");
	}

	/**
	 * Crea un juego utilizando el archivo
	 * @param pathDelArchivoConLaberinto
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws LaberintoInvalidoException
	 */
	public static JuegoConcreto fabricarJuegoEnLaberinto(String pathDelArchivoConLaberinto) throws FileNotFoundException, IOException, ClassNotFoundException, LaberintoInvalidoException{
		JuegoConcreto unJuego=  JuegoConcreto.getInstancia();
		JuegoConcreto.setearLaberinto(pathDelArchivoConLaberinto);
		unJuego.inicializar();
		return unJuego;
	}
}
