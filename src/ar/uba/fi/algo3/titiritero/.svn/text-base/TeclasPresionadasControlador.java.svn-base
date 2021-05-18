package ar.uba.fi.algo3.titiritero;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Pacman;
import ModeloDeDominio.Personajes.Estrategias.ControladoPorElUsuario;

public class TeclasPresionadasControlador extends KeyAdapter {

	ControladorJuego controlador;
	public TeclasPresionadasControlador(ControladorJuego unControlador) {
		this.controlador=unControlador;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_P){
			if (JuegoConcreto.getInstancia().seEstaJugando()){
				JuegoConcreto.getInstancia().pausarJuego();
			}else{
				JuegoConcreto.getInstancia().despausarJuego();
			}
		}else
		if ( e.getKeyCode() == KeyEvent.VK_UP){
			if (JuegoConcreto.getInstancia().seEstaJugando()){
				Pacman pacman = JuegoConcreto.getInstancia().getPacman();
				ControladoPorElUsuario controladorPacman = (ControladoPorElUsuario)pacman.getEstrategia();
				controladorPacman.irHaciaArriba();
			}
		}else
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			if (JuegoConcreto.getInstancia().seEstaJugando()){
				Pacman pacman = JuegoConcreto.getInstancia().getPacman();
				ControladoPorElUsuario controladorPacman = (ControladoPorElUsuario)pacman.getEstrategia();
				controladorPacman.irHaciaAbajo();
			}
		}else
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			if (JuegoConcreto.getInstancia().seEstaJugando()){
				Pacman pacman = JuegoConcreto.getInstancia().getPacman();
				ControladoPorElUsuario controladorPacman = (ControladoPorElUsuario)pacman.getEstrategia();
				controladorPacman.irHaciaLaDerecha();
			}
		}else
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			if (JuegoConcreto.getInstancia().seEstaJugando()){
				Pacman pacman = JuegoConcreto.getInstancia().getPacman();
				ControladoPorElUsuario controladorPacman = (ControladoPorElUsuario)pacman.getEstrategia();
				controladorPacman.irHaciaLaIzquierda();
			}
		}else if (e.getKeyCode() == KeyEvent.VK_COMMA){
				JuegoConcreto.getInstancia().incrementarVidas();
			}
		else if (e.getKeyCode()== KeyEvent.VK_BACK_SPACE){
			JuegoConcreto.getInstancia().nuevaPartida();
			JuegoConcreto.getInstancia().incrementarNivel();
		}else if (e.getKeyCode()== KeyEvent.VK_PAGE_UP){
			JuegoConcreto.getInstancia().seComioUnaPastilla();
		}

	}
}
