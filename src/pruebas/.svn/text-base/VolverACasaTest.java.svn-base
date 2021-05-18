package pruebas;

import junit.framework.TestCase;
import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.Juego.FabricaDeJuegos;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;
import ModeloDeDominio.Personajes.Estrategias.VolverACasa;

public class VolverACasaTest extends TestCase {

	private Estrategia volverACasa;
	private PosicionConcreta uno;
	private PosicionConcreta dos;
	private PosicionConcreta tres;
	private PosicionConcreta cuatro;
	private PosicionConcreta cinco;
	private PosicionConcreta seis;
	private PosicionConcreta siete;
	private PosicionConcreta ocho;
	private PosicionConcreta nueve;
	private PosicionConcreta destino;
	private Direccion direccionActual;

	/*
  012345678901
0 PPPPPPPPPPPP;   el mapa de prueba es este.
1 P 9    8 7PP;   C es es la casa del fantasmita
2 PPPPPPP PPPP;   los numeros son distintas posiciones q se iran variando
3 PP5    6   P;   P son las paredes
4 PP PPPPPPPPP;   
5 PP PPPCPPPPP;   voy variando las pocisiones para ver si responde como se debe
6 PP4PPP PPIPP;   siempre tiene q encontrar la mejor opcion hacia D...
7 PP PPP PPPPP;   
8 PP3   2   PP;
9 PP PPPPPPPPP;
0 PPPPPPPPPPPP

	 */
	protected void setUp() throws Exception {
		super.setUp();
		uno = new PosicionConcreta(6.5, 5.5);
		dos = new PosicionConcreta(6.5, 8.5);
		tres = new PosicionConcreta(2.5, 8.5);
		cuatro = new PosicionConcreta(2.5, 6.5);
		cinco = new PosicionConcreta(2.5, 3.5);
		seis = new PosicionConcreta(7.5, 3.5);
		siete = new PosicionConcreta(9.5, 1.5);
		ocho = new PosicionConcreta(7.5, 1.5);
		nueve = new PosicionConcreta(3.5, 1.5);
		destino= new PosicionConcreta(1.5, 1.5);
		volverACasa = new VolverACasa();
		FabricaDeJuegos.fabricarJuegoEnLaberinto("ArchivosNecesarios/Laberintos/testEstrategias");
	}

	public void testPosicionesCorrectasEnElLaberinto(){
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(uno).esTransitable());
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(dos).esTransitable());
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(tres).esTransitable());
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(cuatro).esTransitable());
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(cinco).esTransitable());
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(seis).esTransitable());
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(siete).esTransitable());
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(ocho).esTransitable());
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(nueve).esTransitable());
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(destino).esTransitable());
	}


	/*
	  012345678901
	0 PPPPPPPPPPPP;   el mapa de prueba es este.
	1 PF= 9  8 7PP;   C es es la casa del fantasmita
	2 PPPPPPP PPPP;   los numeros son distintas posiciones q se iran variando
	3 PP5    6   P;   P son las paredes
	4 PP PPPPPPPPP;   
	5 PP PPP PPPPP;   voy variando las pocisiones para ver si responde como se debe
	6 PP4PPP PPIPP;   siempre tiene q encontrar la mejor opcion hacia D...
	7 PP PPP PPPPP;   
	8 PP3   2   PP;
	9 PP PPPPPPPPP;
	0 PPPPPPPPPPPP

	 */
	/*
	 * que pasa si estoy en un pasillo y tengo que seguir derecho???
	 * sigue derecho
	 */
	public void testDecisionVolverACasa(){
		direccionActual = Direccion.IZQUIERDA;
		Direccion futura = volverACasa.haciaDondeIrDesdePosicionConDireccionActual( nueve, direccionActual);
		assertEquals(Direccion.IZQUIERDA,futura);

		direccionActual = Direccion.ARRIBA;
		futura= volverACasa.haciaDondeIrDesdePosicionConDireccionActual( ocho, direccionActual);
		assertEquals(Direccion.IZQUIERDA,futura);

		direccionActual = Direccion.ABAJO;
		futura= volverACasa.haciaDondeIrDesdePosicionConDireccionActual(seis, direccionActual);
		assertEquals(Direccion.IZQUIERDA,futura);	

		direccionActual = Direccion.IZQUIERDA;
		futura= volverACasa.haciaDondeIrDesdePosicionConDireccionActual(cinco, direccionActual);
		assertEquals(Direccion.ABAJO,futura);

		direccionActual = Direccion.ABAJO;
		futura= volverACasa.haciaDondeIrDesdePosicionConDireccionActual(cuatro, direccionActual);
		assertEquals(Direccion.ABAJO,futura);	

		direccionActual = Direccion.IZQUIERDA;
		futura= volverACasa.haciaDondeIrDesdePosicionConDireccionActual(tres, direccionActual);
		assertEquals(Direccion.ARRIBA,futura);	
	}
}
