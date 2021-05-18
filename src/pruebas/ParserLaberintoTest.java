package pruebas;

import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.Laberinto.*;
import ModeloDeDominio.Laberinto.Celdas.Pared;
import ModeloDeDominio.Laberinto.Celdas.Pasillo;
import ModeloDeDominio.Laberinto.Excepciones.LaberintoInvalidoException;
import junit.framework.TestCase;

public class ParserLaberintoTest extends TestCase {
	private Laberinto unLaberinto;
	private String cadenaOk;
	private String cadenaErronea;
	protected void setUp() throws Exception {
		super.setUp();
		cadenaOk=
		"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPP;"+
		"P+**PPPPPPPPPPPPPPPPPPPPPP**+P;"+
		"P*P************************P*P;"+
		"P*PPPPPPPPPP*****PPPPPPPPPPP*P;"+
		"P****************************P;"+
		"P*PPPPPPPPPPPP=PPPPPPPPPPPPP*P;"+
		"P******PP           PP*******P;"+
		"P*PPPP*PP     F     PP*PPPPP*P;"+
		"P*PPPP*PP           PP*PPPPP*P;"+
		"P*PPPP*PPPPPPPPPPPPPPP*PPPPP*P;"+
		"P****************************P;"+
		"P*PPPP*PPPPPPPPPPPPPPP*PPPPP*P;"+
		"P+************I*************+P;"+
		"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPP";

		cadenaErronea= 
		"   PPPPPPPPPPPPPPPPPPPPPPPPPPPPPP;"+
		"P***PPPPPPPPPPPPPPPPPPPPPP**+P;"+
		"P*P************************P*P;"+
		"P*PPPPPPPPPP*****PPPPPPPPPPP*P;"+
		"P****************************P;"+
		"P*PPPPPPPPPP     PPPPPPPPPPP*P;"+
		"P******PP           PP*******P;"+
		"P*PPPP*PP           PP*PPPPP*P;"+
		"P*PPPP*PP           PP*PPPPP*P;"+
		"P*PPPP*PPPPPPPPPPPPPPP*PPPPP*P;"+
		"P****************************P;"+
		"P*PPPP*PPPPPPPPPPPPPPP*PPPPP*P;"+
		"P****************************P;"+
		"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPP";	
	}

	public void testParserOk(){
		try{
			ParserDeLaberintos.parsear(cadenaOk);
			assertTrue(true);
		}catch (LaberintoInvalidoException ex){fail();}
	}

	public void testParserError(){
		try{
			ParserDeLaberintos.parsear(cadenaErronea);
			fail();
		}catch(LaberintoInvalidoException ex){assertTrue(true);}
	}

	public void testEstaBienParseado(){
		try{
			unLaberinto = ParserDeLaberintos.parsear(cadenaOk);
			assertEquals(14,unLaberinto.getAlto());
			assertEquals(30,unLaberinto.getAncho());
			assertTrue( unLaberinto.casilleroEn(new PosicionConcreta(0,0))instanceof Pared);
			assertTrue(unLaberinto.casilleroEn(new PosicionConcreta(2,1))instanceof Pasillo);
			assertTrue(unLaberinto.casilleroEn(new PosicionConcreta(28,1))instanceof Pasillo);
			assertEquals(14.5,unLaberinto.getPosicionInicialDeLosFantasmas().getPosicionHorizontal(),0.0001);
			assertEquals(7.5,unLaberinto.getPosicionInicialDeLosFantasmas().getPosicionVertical(),0.0001);
			assertEquals(14.5, unLaberinto.getPosicionInicialDePacman().getPosicionHorizontal(),0.0001);
			assertEquals(12.5, unLaberinto.getPosicionInicialDePacman().getPosicionVertical(),0.0001);
		}catch (LaberintoInvalidoException ex){fail();}
	}

}
