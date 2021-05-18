package pruebas;

import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.Juego.FabricaDeJuegos;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.Cazar;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;
import junit.framework.TestCase;

public class CazarTest extends TestCase {

	private Estrategia cazar;
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
1 PD9    8 7PP;   D es el destino
2 PPPPPPP PPPP;   los numeros son distintas posiciones q se iran variando
3 PP5    6   P;   P son las paredes
4 PP PPPPPPPPP;   
5 PP PPP1PPPPP;   voy variando las pocisiones para ver si responde como se debe
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
		nueve = new PosicionConcreta(2.5, 1.5);
		destino = new PosicionConcreta(1.5, 1.5);
		cazar = new Cazar();
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
		assertFalse(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(nueve).esTransitable());//posicion de la puerta
		assertTrue(JuegoConcreto.getInstancia().getLaberinto().casilleroEn(destino).esTransitable());

	}
	/*
	 * que pasa si estoy en un pasillo y tengo que seguir derecho???
	 * sigue derecho
	 */
	public void testDecisionEnPasillosSeguirDerecho(){
		direccionActual = Direccion.ABAJO;
		Direccion futura = cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, uno, direccionActual);
		assertEquals(futura,Direccion.ABAJO);

		direccionActual = Direccion.ARRIBA;
		futura = cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, cuatro, direccionActual);
		assertEquals(futura,Direccion.ARRIBA);

		direccionActual = Direccion.IZQUIERDA;
		futura = cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, nueve, direccionActual);
		assertEquals(Direccion.IZQUIERDA,futura);		
	}
	/*
	 * que pasa si estoy en un pasillo y tengo q doblar???
	 * dobla
	 */
	public void testDecisionEnPasillosDoblar(){
		direccionActual = Direccion.ARRIBA;
		Direccion futura = cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, cinco, direccionActual);
		assertEquals(Direccion.DERECHA,futura);

		direccionActual = Direccion.IZQUIERDA;
		futura=cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, cinco, direccionActual);
		assertEquals(Direccion.ABAJO,futura);
		
		direccionActual = Direccion.IZQUIERDA;
		futura = cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, tres, direccionActual);
		assertEquals(Direccion.ARRIBA, futura);
		
		direccionActual = Direccion.DERECHA;
		futura = cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, seis, direccionActual);
		assertEquals(Direccion.ARRIBA, futura);
	}
	/*
	 * que pasa si vengo avanzando y mi mejor opcion es ir para atras???
	 * deberia no dar la vuelta...
	 */
	public void testDecisionEnPasillosDondeLoMejorSeriaVolverHaciaAtrasPeroDebeSeguirDerecho(){
		direccionActual = Direccion.ABAJO;
		Direccion futura = cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, cuatro, direccionActual);
		assertNotSame(Direccion.ARRIBA, futura);

		direccionActual = Direccion.ARRIBA;
		futura= cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, cuatro, direccionActual);
		assertNotSame(Direccion.ABAJO, futura);

		direccionActual = Direccion.DERECHA;
		futura= cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, ocho, direccionActual);
		assertNotSame(Direccion.IZQUIERDA, futura);
	}
	/*
	 * que pasa si me choco contra una pared y no puedo doblar??? 
	 * esto no lo deberia de permitir el mapa pero en caso que sea asi da la vuelta
	 */
	public void testDecisionDeDarLaVueltaSiNoHaySalida(){
		direccionActual = Direccion.ARRIBA;
		Direccion futura = cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, uno, direccionActual);
		assertEquals(Direccion.ABAJO, futura);

		direccionActual = Direccion.DERECHA;
		futura= cazar.haciaDondeIrDesdeUnaPosicionHastaOtraConDireccionActual(destino, siete, direccionActual);
		assertEquals(Direccion.IZQUIERDA, futura);
	}

}
