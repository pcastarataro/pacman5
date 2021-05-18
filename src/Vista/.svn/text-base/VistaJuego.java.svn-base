package Vista;

import java.util.ArrayList;
import java.util.Iterator;

import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Juego.ListaDePersonajes;
import ModeloDeDominio.Laberinto.Celdas.Celda;
import ModeloDeDominio.Personajes.FantasmitaConcreto;
import ModeloDeDominio.Personajes.Pacman;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaJuego implements Dibujable{

	private static final int FIUBA_X = 160;
	private static final int FIUBA_Y = 490;
	private Posicionable posicionable;
	private JuegoConcreto juego;
	private static int PUNTAJE_POSICOINY = 470;
	private static int PUNTAJE_POSICIONX = 20;
	private static int VIDAS_POSICIONY = 470;
	private static int VIDAS_POSICIONX = 400;
	private static int AUTORES_POSICIONY = 490;
	private static int AUTORES_POSICIONX = 80;
	private static int NIVEL_POSICIONX = 220;
	private static int NIVEL_POSICIONY = 80;
	private ArrayList<Dibujable> listaVistas;
	private Skin skin;
	
	public void cambiarSkin(Skin nuevoSkin){
		this.skin= nuevoSkin;
	}
	
	private Skin getSkin(){
		return this.skin;
	}
	
	public VistaJuego(JuegoConcreto juego,Skin skin){
		this.skin=skin;
		this.juego=juego;
		listaVistas = new ArrayList<Dibujable>();
		PUNTAJE_POSICOINY = (juego.getLaberinto().getAlto()+2)*ConstantesVista.ALTO_CELDA;
		AUTORES_POSICIONY = (juego.getLaberinto().getAlto()+7)*ConstantesVista.ALTO_CELDA;
		VIDAS_POSICIONY = (juego.getLaberinto().getAlto()+2)*ConstantesVista.ALTO_CELDA;
		NIVEL_POSICIONY = (juego.getLaberinto().getAlto()+2)*ConstantesVista.ALTO_CELDA;
		
		
		// cargo las vistas de cada celda
		for(int i=0;i<juego.getLaberinto().getAncho();i++)
			for(int j=0;j<juego.getLaberinto().getAlto();j++){
				Celda unaCelda= juego.getLaberinto().casilleroEn(new PosicionConcreta(i,j));
				VistaCelda vista= new VistaCelda(this.getSkin());
				vista.setPosicionable(unaCelda);
				listaVistas.add(vista);
			}
		//cargo las vistas de cada personaje
		ListaDePersonajes personajes= juego.getListaDePersonajes();
		Iterator<FantasmitaConcreto> iterador= personajes.iteradorFantasmitas();
		while (iterador.hasNext()){
			FantasmitaConcreto fantasma = iterador.next();
			VistaFantasma vistaFantasmita= new VistaFantasma(this.getSkin());
			vistaFantasmita.setPosicionable(fantasma);
			listaVistas.add(vistaFantasmita);
		}
		
		//cargo la vista del pacman
		Pacman pacman= juego.getPacman();
		VistaPacman vistaPacman= new VistaPacman(this.getSkin());
		vistaPacman.setPosicionable(pacman);
		listaVistas.add(vistaPacman);
		
		//cargo las vistas de los indicacores en pantalla
		VistaPuntaje vistaPuntaje= new VistaPuntaje();
		vistaPuntaje.setPosicionable(new PosicionadorFijo(PUNTAJE_POSICIONX,PUNTAJE_POSICOINY));
		listaVistas.add(vistaPuntaje);
		
		VistaNivel vistaNivel = new VistaNivel();
		vistaNivel.setPosicionable(new PosicionadorFijo(NIVEL_POSICIONX, NIVEL_POSICIONY));
		listaVistas.add(vistaNivel);
		
		VistaVidasRestantes vistaVidas= new VistaVidasRestantes();
		vistaVidas.setPosicionable(new PosicionadorFijo(VIDAS_POSICIONX,VIDAS_POSICIONY));
		listaVistas.add(vistaVidas);
		
		VistaAutores vistaAutor= new VistaAutores();
		vistaAutor.setPosicionable(new PosicionadorFijo(AUTORES_POSICIONX,AUTORES_POSICIONY));
		listaVistas.add(vistaAutor);
		
		VistaFiuba fiuba = new VistaFiuba();
		fiuba.setPosicionable(new PosicionadorFijo(FIUBA_X, FIUBA_Y));
		listaVistas.add(fiuba);
		
		VistaPuntosFreeze vistaPuntos = new VistaPuntosFreeze();
		vistaPuntos.setPosicionable(new PosicionadorFijo(0,0));
		listaVistas.add(vistaPuntos);
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superfice) {

		if (juego.estaPerdido()){
			VistaJuegoPerdido vistaPerdido= new VistaJuegoPerdido(this.getSkin());
			vistaPerdido.setPosicionable(new PosicionadorFijo(150,130));
			vistaPerdido.dibujar(superfice);
			
		}else if (juego.estaGanado()){
			
		}else {
			Iterator<Dibujable> iteradorVistas= listaVistas.iterator();
			while (iteradorVistas.hasNext()){
				Dibujable vista=iteradorVistas.next();
				vista.dibujar(superfice);
			}
			if (juego.juegoPausado()){
				VistaPausa vistaPausa= new VistaPausa();
				vistaPausa.dibujar(superfice);
			}
		}
	}

	@Override
	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.posicionable=posicionable;
	}

}
