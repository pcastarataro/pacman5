package pruebas;

import java.io.FileNotFoundException;

import junit.framework.TestCase;
import ModeloDeDominio.Laberinto.CargadorDeLaberintos;
import ModeloDeDominio.Laberinto.Laberinto;

public class CargadorDeLaberintosTest extends TestCase {

	private String pathDelArchivoConLaberinto;
	private Laberinto unLaberinto;
	protected void setUp() throws Exception {
		super.setUp();
		pathDelArchivoConLaberinto= "ArchivosNecesarios/Laberintos/LaberintoDePrueba1";
	}
	
	public void testCargadorTXTConArchivoInexistente(){
		try{
			CargadorDeLaberintos.levantarDeTXT("RutaInvalida");
			fail();
		}catch(FileNotFoundException ex){assertTrue(true);}
		catch (Exception ex){}
	}

	public void testCargadorTXTOk(){
		try{
			unLaberinto= CargadorDeLaberintos.levantarDeTXT(pathDelArchivoConLaberinto);
			// si llega hasta aqui no hubo problemas y lo parsea sin problemas
			assertEquals(14,unLaberinto.getAlto());
			assertEquals(30, unLaberinto.getAncho());
		}catch(Exception ex){
			ex.printStackTrace();
			fail();}
	}
	
	public void tearDown(){
		unLaberinto = null;
	}

}
