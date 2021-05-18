package Audio;

import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Juego.JuegoConcreto.EstadosDelJuego;

public class SonidoJuego extends Thread{
	private JuegoConcreto juego;
	private Sonido comioPastilla;
	private Sonido comioFruta;
	private Sonido fueComido;
	private Sonido inicioNivel;
	private int pastillasAnteriores;
	private int pastillasActuales;
	private SonidoMusicaPastillaEspecial musiquitaEstrella;
	private SonidoMusicaDeFondo musiquitaDeFondo;
	private SonidaVidaNueva vidaGanada;
	private int vidasAnteriores;
	private int vidasActuales;
	private SonidoNivelGanado ganado;
	private boolean seReprodujoPerdido;
	private SonidoSinVidas sinVidas;
	
	public SonidoJuego(JuegoConcreto juego){
		this.juego = juego;
		this.inicioNivel = new InicioNivel();
		this.fueComido = new SonidoComido();
		this.comioFruta = new SonidoComioFruta();
		this.comioPastilla = new SonidoComioPastilla();
		musiquitaEstrella = new SonidoMusicaPastillaEspecial();
		musiquitaDeFondo = new SonidoMusicaDeFondo();
		vidaGanada = new SonidaVidaNueva();
		ganado = new SonidoNivelGanado();
		sinVidas = new SonidoSinVidas();
		seReprodujoPerdido = false;

	}
	
	public void play(){
		while (true){
			hacerRuidoNesesario();
		}
	}
	
	private void hacerRuidoNesesario(){
		if ((juego.getEstadoGeneral() == EstadosDelJuego.INICIANDO) && (! this.inicioNivel.isPlaying()) ){
			pastillasActuales = JuegoConcreto.getInstancia().getCantidadDePastillas();
			vidasActuales = JuegoConcreto.getInstancia().getCantidadDeVidas();
			//inicioNivel.play();
		}
		if (juego.seEstaJugando() || juego.getEstadoGeneral() == EstadosDelJuego.INICIANDO){
			seReprodujoPerdido = false;
			if (juego.pacmanEstaPersiguiendoFantasmitas()){
				musiquitaDeFondo.stop();
				if (! this.musiquitaEstrella.isPlaying())
					musiquitaEstrella.play();
			}
			else{
				musiquitaEstrella.stop();
				if (! this.musiquitaDeFondo.isPlaying() &&  ! inicioNivel.isPlaying())
					musiquitaDeFondo.play();
			}	
		}
		
		if (juego.estaGanado() && ! ganado.isPlaying()){
			musiquitaDeFondo.stop();
			musiquitaEstrella.stop();
			ganado.play();
		}
		
		if ( juego.getEstadoGeneral() == EstadosDelJuego.SE_COMIERON_A_PACMAN ){
			musiquitaDeFondo.stop();
			musiquitaEstrella.stop();
		}
		
		if (seGanoUnaVida() && ! vidaGanada.isPlaying() && ! juego.estaPerdido())
			vidaGanada.play();
		
		if (juego.getEstadoGeneral() == EstadosDelJuego.GANADO && ! ganado.isPlaying())
			ganado.play();
		
		if (juego.estaPerdido() && ! seReprodujoPerdido){
			sinVidas.play();
			seReprodujoPerdido=true;
		}
		
		if ((juego.getEstadoGeneral() == EstadosDelJuego.SE_COMIERON_A_PACMAN)&& (! this.fueComido.isPlaying())){
			fueComido.play();
		}
		if ((juego.getEstadoGeneral() == EstadosDelJuego.SE_COMIERON_UNA_FRUTA)&& (! this.comioFruta.isPlaying())){	
			comioFruta.play();
		}
		if ((juego.getEstadoGeneral() == EstadosDelJuego.SE_COMIERON_UN_FANTASMITA)&& (! this.comioFruta.isPlaying())){	
			comioFruta.play();
		}
		if ((pacmanEstaComiendo())&&(!comioPastilla.isPlaying())){
			comioPastilla.play();
		}	
		try {
			sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private boolean seGanoUnaVida() {
		vidasAnteriores = vidasActuales;
		vidasActuales = JuegoConcreto.getInstancia().getCantidadDeVidas();
		return (vidasActuales != vidasAnteriores);
	}

	private boolean pacmanEstaComiendo() {
		pastillasAnteriores = pastillasActuales;
		pastillasActuales = JuegoConcreto.getInstancia().getCantidadDePastillas();
		return (pastillasActuales != pastillasAnteriores);
	}

	public void run(){
		play();
	}
}
