package pruebas;

import ModeloDeDominio.Common.Direccion;
import junit.framework.TestCase;

public class DireccionTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testContraria(){
		assertEquals(Direccion.DERECHA, Direccion.IZQUIERDA.direccionContraria());
		assertEquals(Direccion.ARRIBA, Direccion.ABAJO.direccionContraria());
		assertEquals(Direccion.IZQUIERDA, Direccion.DERECHA.direccionContraria());
		assertEquals(Direccion.ABAJO, Direccion.ARRIBA.direccionContraria());
	}

}
