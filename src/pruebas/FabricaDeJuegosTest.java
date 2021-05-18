package pruebas;

import java.io.FileNotFoundException;
import java.io.IOException;

import ModeloDeDominio.Juego.FabricaDeJuegos;
import ModeloDeDominio.Laberinto.Excepciones.LaberintoInvalidoException;
import junit.framework.TestCase;

public class FabricaDeJuegosTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testMapaClasico(){
		try {
			FabricaDeJuegos.fabricarJuegoClasico();//lo carga en la unica instancai de JuegoConcreto
		} catch (FileNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (LaberintoInvalidoException e) {
			fail();
			e.printStackTrace();
		}	
	}

	public void testMapaDesdeArchivo(){
		try {
			FabricaDeJuegos.fabricarJuegoEnLaberinto("ArchivosNecesarios/Laberintos/testEstrategias");//lo carga en la unica instancai de JuegoConcreto
		} catch (FileNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (LaberintoInvalidoException e) {
			fail();
			e.printStackTrace();
		}	
	}


}
