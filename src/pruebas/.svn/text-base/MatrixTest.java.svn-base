package pruebas; 

import excepciones.PosicionFueraDeRangoException;
import junit.framework.TestCase;
import ModeloDeDominio.Common.Matrix;

public class MatrixTest extends TestCase{

	Matrix matriz1;
	protected void setUp() throws Exception {
		matriz1 = new Matrix(3);
	}

	public void testPosicionValida(){
		try{
			Integer nuevoValor = 2;
			matriz1.setPosicion(1, 1, nuevoValor);
			assertTrue(nuevoValor.equals((Integer)matriz1.getPosicion(1, 1)));
		}catch (PosicionFueraDeRangoException ex){fail();}
	}

	public void testPosicionInvalida(){
		try{
			Integer nuevoValor = 2;
			matriz1.setPosicion(-3,1 , nuevoValor);
			fail();
		}catch (PosicionFueraDeRangoException ex){assertTrue(true);}
	}

}
