package pruebas;

import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.Juego.FabricaDeJuegos;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Juego.JuegoConcreto.EstadosDelJuego;
import ModeloDeDominio.Personajes.FabricaDeFantasmitas;
import ModeloDeDominio.Personajes.FabricaDeFantasmitasConcreta;
import ModeloDeDominio.Personajes.FantasmitaConcreto;
import ModeloDeDominio.Personajes.Pacman;
import junit.framework.TestCase;

public class ChoquesTest extends TestCase {

	private FantasmitaConcreto fantasmita;
	private PosicionConcreta centro;
	private PosicionConcreta dentroDelMargen;
	private PosicionConcreta fueraDelMargen;
	private JuegoConcreto juegoActual;
	private Pacman pacman;

	protected void setUp() throws Exception {
		super.setUp();
		centro = new PosicionConcreta(6, 5);
		dentroDelMargen = new PosicionConcreta(6, 5);
		fueraDelMargen = new PosicionConcreta(10, 10);

		juegoActual = FabricaDeJuegos.fabricarJuegoEnLaberinto("ArchivosNecesarios/laberintos/testEstrategias");
		FabricaDeFantasmitas fabrica = new FabricaDeFantasmitasConcreta();
		fantasmita = fabrica.fabricarFantasmitaCazador();
		juegoActual.agregarPersonaje(fantasmita);
		pacman = juegoActual.getPacman();
	}

	public void testfantasmitaPersiguePacmanNoHayChoque(){
		int cantidadDeVidas = juegoActual.getCantidadDeVidas();
		pacman.setPosicion(centro);
		fantasmita.setPosicion(fueraDelMargen);
		juegoActual.resolverPosiblesChoques();
		assertEquals(cantidadDeVidas, juegoActual.getCantidadDeVidas());
	}

	public void testFantasmitaPersiguePacmanHayChoque(){
		pacman.setPosicion(centro);
		fantasmita.setPosicion(centro);
		juegoActual.resolverPosiblesChoques();
		assertEquals(EstadosDelJuego.SE_COMIERON_A_PACMAN, juegoActual.getEstadoGeneral());
	}

	public void testPacmanPersigueFantasmitaHayChoque(){
		double puntaje = juegoActual.getPuntaje();
		juegoActual.seComioUnaPastillaEspecial(); // cambio el estado
		pacman.setPosicion(centro);
		fantasmita.setPosicion(dentroDelMargen);
		juegoActual.resolverPosiblesChoques();
		assertNotSame(puntaje, juegoActual.getPuntaje());

		/*puntaje = juegoActual.getPuntaje();
		fantasmita.setPosicion(enElMargen);
		juegoActual.resolverPosiblesChoques();
		assertNotSame(puntaje, juegoActual.getPuntaje());*/

		//puntaje = juegoActual.getPuntaje() + Constantes.getPuntajePastillaEnNivel(juegoActual.getNivel());
		//porque se come la pastilla del casillero
		/*fantasmita.setPosicion(fueraDelMargen);
		juegoActual.resolverPosiblesChoques();
		assertEquals(puntaje, juegoActual.getPuntaje());*/
	}

	public void testPacmanPersigueFantasmitaNoHayChoque(){
		double puntaje = juegoActual.getPuntaje();
		//porque se come la pastilla del casillero
		juegoActual.seComioUnaPastillaEspecial(); // cambio el estado
		pacman.setPosicion(centro);
		fantasmita.setPosicion(fueraDelMargen);
		juegoActual.resolverPosiblesChoques();
		assertEquals(puntaje, juegoActual.getPuntaje());
	}

}
