package pruebas;

import ModeloDeDominio.Juego.FabricaDeJuegos;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Juego.JuegoConcreto.EstadosDelJuego;
import junit.framework.TestCase;

public class MensajesAJuegoTest extends TestCase {

	private JuegoConcreto juego;

	protected void setUp() throws Exception {
		super.setUp();
		juego= FabricaDeJuegos.fabricarJuegoEnLaberinto("ArchivosNecesarios/Laberintos/laberintoPosta");
	}

	public void testEstadoInicialDelJuego() {
		assertFalse(juego.seEstaJugando()); //El juego esta iniciando
	}

	public void testPausarYDespausarJuego() {
		juego.pausarJuego();
		assertFalse(juego.juegoPausado()); // el juego inicialmente no se esta jugando esta iniciando
	}

	public void testSeComieronAPacman(){
		juego.seComieronAPacman();
		assertEquals(EstadosDelJuego.SE_COMIERON_A_PACMAN, juego.getEstadoGeneral());
	}

	public void testSeComieronAFantasmita(){
		double puntajeInicial = juego.getPuntaje();
		juego.seComioUnFantasmita();
		assertNotSame(puntajeInicial, juego.getPuntaje());
	}

	public void testSeComieronUnaPastillita(){
		double puntajeInicial = juego.getPuntaje();
		juego.seComioUnaPastilla();
		assertNotSame(puntajeInicial, juego.getPuntaje());
	}

	public void testSeComieronUnaPastillaEspecial(){
		double puntajeInicial = juego.getPuntaje();
		juego.seComioUnaPastillaEspecial();
		assertNotSame(puntajeInicial, juego.getPuntaje());
		assertTrue(juego.pacmanEstaPersiguiendoFantasmitas());
	}

	/*public void testEstaPerdido(){
		int cantidadDeVidas = juego.getCantidadDeVidas();
		for (int i=0 ; i < cantidadDeVidas ; i++){
			juego.seComieronAPacman();
		}
		assertTrue(juego.estaPerdido());		
	}*/

	public void testEstaGanado(){
		int CantidadDePastillas = juego.getLaberinto().getCantidadDePastillas();
		assertFalse(juego.seEstaJugando()); //El juego empieza en estado INICIANDO
		for (int i = 0; i < CantidadDePastillas ; i++)
			juego.seComioUnaPastilla();
		assertTrue(juego.estaGanado());
	}
}