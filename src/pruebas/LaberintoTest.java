package pruebas;

import excepciones.PosicionFueraDeRangoException;

import ModeloDeDominio.Laberinto.Laberinto;
import ModeloDeDominio.Laberinto.LaberintoConcreto;
import ModeloDeDominio.Laberinto.Celdas.FabricaDeCeldas;
import ModeloDeDominio.Laberinto.Celdas.Pared;
import junit.framework.TestCase;

public class LaberintoTest extends TestCase {

	private Laberinto laberintoUno;

	protected void setUp() throws Exception {
		super.setUp();
		laberintoUno= new LaberintoConcreto(1,1);
	}

	public void testConstructorError(){
		try{
			laberintoUno = new LaberintoConcreto(-1,1);
			fail();
		}catch (IllegalArgumentException ex){assertTrue(true);}
	}

	public void testConstructorOk(){
		try{
			laberintoUno = new LaberintoConcreto(10,10);
			assertTrue(true);
		}catch (IllegalArgumentException ex){fail();}
	}

	public void testSetElementoOk(){
		try{
			laberintoUno.setCelda(0, 0, new Pared(0,0));
			assertTrue(true);
		}catch(PosicionFueraDeRangoException ex){ fail();}
	}

	public void testSetElementoError(){
		try{
			laberintoUno.setCelda(15, 100, new Pared(15,100));
			fail();
		}catch(PosicionFueraDeRangoException ex){ assertTrue(true);}
	}

	public void testGetCantidadDePastillas(){
		laberintoUno = new LaberintoConcreto(2,2);
		assertEquals(0,laberintoUno.getCantidadDePastillas());
		FabricaDeCeldas laFabrica = new FabricaDeCeldas();
		laberintoUno.setCelda(0, 0, laFabrica.fabricarPared(0,0)); 
		laberintoUno.setCelda(0, 1, laFabrica.fabricarPasilloVacio(0,1));
		laberintoUno.setCelda(1, 0, laFabrica.fabricarPasilloConPastilla(1,0));
		laberintoUno.setCelda(1, 1, laFabrica.fabricarPasilloConPastillaEspecial(1,1));
		/*
		 * LaberintoUno toma esta forma:
		 *    P*
		 *     +
		 *     siendo P pared, * pasilloConPastilla, + PasilloConPastillaEspecial y ' 'PsilloVacio 
		 */
		assertEquals(2,laberintoUno.getCantidadDePastillas());
	}
}
