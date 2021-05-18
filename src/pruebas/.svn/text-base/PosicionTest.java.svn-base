package pruebas;

import junit.framework.TestCase;
import ModeloDeDominio.Common.PosicionConcreta;

public class PosicionTest extends TestCase {
	private PosicionConcreta unaPosicion;
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testConstructorPosicionValida(){
		try{
			unaPosicion = new PosicionConcreta(2,1);
		}catch(IllegalArgumentException ex){fail();}
		double posicionHorizontal= unaPosicion.getPosicionHorizontal();
		double posicionVertical= unaPosicion.getPosicionVertical();
		assertEquals(2,posicionHorizontal,0.0001);
		assertEquals(1,posicionVertical,0.00001);
	}

	public void testConstructorPosicionInvalida(){
		try{
			unaPosicion = new PosicionConcreta(0,-1);
		}catch(IllegalArgumentException ex){assertTrue(true);}
	}

	public void testModificarPosicionHorizontal() {
		try{
			unaPosicion = new PosicionConcreta(5,5);
		}catch(IllegalArgumentException ex){fail();}
		unaPosicion.modificarPosicionHorizontalEn(2);
		double nuevaPosicionHorizontal= unaPosicion.getPosicionHorizontal();
		double nuevaPosicionVertical= unaPosicion.getPosicionVertical();
		assertEquals(7,nuevaPosicionHorizontal,0.0001);
		assertEquals(5,nuevaPosicionVertical,0.00001);
	}

	public void testModificarPosicionVertical() {
		try{
			unaPosicion = new PosicionConcreta(5,5);
		}catch(IllegalArgumentException ex){fail();}
		unaPosicion.modificarPosicionVerticalEn(2);
		double nuevaPosicionHorizontal= unaPosicion.getPosicionHorizontal();
		double nuevaPosicionVertical= unaPosicion.getPosicionVertical();
		assertEquals(5,nuevaPosicionHorizontal,0.0001);
		assertEquals(7,nuevaPosicionVertical,0.00001);
	}

}
