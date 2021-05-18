package pruebas;

import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Laberinto.CargadorDeLaberintos;
import ModeloDeDominio.Personajes.Estrategias.AndarPorAhi;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;
import junit.framework.TestCase;

public class AndarPorAhiTest extends TestCase {
	private PosicionConcreta posicionInicial;
	private Estrategia estrategiaAProbar;

	/*
	  012345678901
	0 PPPPPPPPPPPP;   el mapa de prueba es este.
	1 PD        PP;   P son las paredes
	2 PPPPPPP PPPP;   D es el destino
	3 PP         P;   
	4 PP PPPPPPPPP;   
	5 PP PPP1PPPPP;   
	6 PP PPP PPPPP;   
	7 PP PPP PPPPP;
	8 PP       2PP;
	9 PP PPPPPPPPP;
	0 PPPPPPPPPPPP

	 */


	protected void setUp() throws Exception {
		super.setUp();
		JuegoConcreto.getInstancia().cargarLaberinto(CargadorDeLaberintos.levantarDeTXT("ArchivosNecesarios/laberintos/testEstrategias"));
		JuegoConcreto.getInstancia().inicializar();
		estrategiaAProbar = new AndarPorAhi();
	}

	/*
	 * Lo probamos sabiendo que existirá una unica forma de moverse desde la posicion 1. 
	 */
	public void testDecisionesCorrectasOK1(){
		posicionInicial = new PosicionConcreta(6.5,5.5);
		Direccion unaDireccion= estrategiaAProbar.haciaDondeIrDesdePosicionConDireccionActual(posicionInicial,Direccion.ABAJO);
		assertEquals(Direccion.ABAJO, unaDireccion);
	}

	/*
	 * Probamos lo mismo desde la posicion 2. 
	 */
	public void testDecisionesCorrectasOK2(){
		posicionInicial = new PosicionConcreta(9.5,8.5);
		Direccion unaDireccion= estrategiaAProbar.haciaDondeIrDesdePosicionConDireccionActual(posicionInicial,Direccion.IZQUIERDA);
		assertEquals(Direccion.IZQUIERDA, unaDireccion);
	}

}
