package pruebas;

import excepciones.ModuloDeVelocidadInvalidoException;
import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Velocidad;
import ModeloDeDominio.Common.VelocidadConcreta;
import junit.framework.TestCase;

public class VelocidadTest extends TestCase {

	private Velocidad unaVelocidad;

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testConstructorOk(){
		try{
			unaVelocidad = new VelocidadConcreta(1,Direccion.ABAJO);
			assertTrue(unaVelocidad.tieneDireccionHaciaAbajo()== true);
			unaVelocidad = new VelocidadConcreta(1,Direccion.ARRIBA);
			assertTrue(unaVelocidad.tieneDireccionHaciaArriba()== true);
			unaVelocidad = new VelocidadConcreta(1,Direccion.DERECHA);
			assertTrue(unaVelocidad.tieneDireccionHaciaLaDerecha()== true);
			unaVelocidad = new VelocidadConcreta(1,Direccion.IZQUIERDA);
			assertTrue(unaVelocidad.tieneDireccionHaciaLaIzquierda()== true);
		}catch(ModuloDeVelocidadInvalidoException ex){}
	}

	public void testConstructorError(){
		try{
			unaVelocidad = new VelocidadConcreta(-1,Direccion.ABAJO);
			fail();
		}catch(ModuloDeVelocidadInvalidoException ex){
			assertTrue(true);
		}
	}

	public void testCambiarDireccionHaciaArriba(){
		try{
			unaVelocidad = new VelocidadConcreta(1,Direccion.ABAJO);
			assertFalse(unaVelocidad.getDireccion()== Direccion.ARRIBA);
			unaVelocidad.cambiarDireccionHaciaArriba();
			assertTrue(unaVelocidad.getDireccion()== Direccion.ARRIBA);
		}catch(ModuloDeVelocidadInvalidoException ex){
			fail();
		}
	}

	public void testCambiarDireccionHaciaDerecha(){
		try{
			unaVelocidad = new VelocidadConcreta(1,Direccion.ABAJO);
			assertFalse(unaVelocidad.getDireccion()== Direccion.DERECHA);
			unaVelocidad.cambiarDireccionHaciaLaDerecha();
			assertTrue(unaVelocidad.getDireccion()== Direccion.DERECHA);
		}catch(ModuloDeVelocidadInvalidoException ex){
			fail();
		}
	}

	public void testCambiarDireccionHaciaIzquierda(){
		try{
			unaVelocidad = new VelocidadConcreta(1,Direccion.ABAJO);
			assertFalse(unaVelocidad.getDireccion()== Direccion.IZQUIERDA);
			unaVelocidad.cambiarDireccionHaciaLaIzquierda();
			assertTrue(unaVelocidad.getDireccion()==Direccion.IZQUIERDA);
		}catch(ModuloDeVelocidadInvalidoException ex){
			fail();
		}
	}

	public void testCambiarDireccionHaciaAbajo(){
		try{
			unaVelocidad = new VelocidadConcreta(1,Direccion.ARRIBA);
			assertFalse(unaVelocidad.getDireccion()== Direccion.ABAJO);
			unaVelocidad.cambiarDireccionHaciaAbajo();
			assertTrue(unaVelocidad.getDireccion()==Direccion.ABAJO);
		}catch(ModuloDeVelocidadInvalidoException ex){
			fail();
		}
	}

}
