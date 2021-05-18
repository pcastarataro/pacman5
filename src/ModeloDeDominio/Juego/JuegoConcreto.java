package ModeloDeDominio.Juego;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.ElementosEstaticos.Banana;
import ModeloDeDominio.ElementosEstaticos.Cereza;
import ModeloDeDominio.ElementosEstaticos.ElementoEstatico;
import ModeloDeDominio.ElementosEstaticos.Fruta;
import ModeloDeDominio.ElementosEstaticos.Manzana;
import ModeloDeDominio.ElementosEstaticos.Melon;
import ModeloDeDominio.ElementosEstaticos.Pastilla;
import ModeloDeDominio.ElementosEstaticos.PastillaEspecial;
import ModeloDeDominio.Laberinto.CargadorDeLaberintos;
import ModeloDeDominio.Laberinto.Laberinto;
import ModeloDeDominio.Laberinto.Celdas.Celda;
import ModeloDeDominio.Laberinto.Celdas.Pared;
import ModeloDeDominio.Laberinto.Excepciones.LaberintoInvalidoException;
import ModeloDeDominio.Personajes.FantasmitaConcreto;
import ModeloDeDominio.Personajes.Pacman;
import ModeloDeDominio.Personajes.Personaje;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

/**
 * Singleton.
 * Controla el estado del juego y los choques. 
 * Decide ademas cual sera la respuesta hacia las situaciones ocurridas luego de los choques.
 * Implementa la interfaz Juego.
 * @see ModeloDeDominio#Juego 
 * @author lea
 *
 */
public class JuegoConcreto implements Juego, ObjetoVivo {

	public enum EstadosDelJuego{
		INICIANDO, 
		PERDIDO, 
		FANTASMITAS_PERSIGUEN_PACMAN, 
		PACMAN_PERSIGUE_FANTASMITAS, 
		ESTA_PASANDO_EL_EFECTO, 
		GANADO, //PASANDO DE NIVEL 
		SE_COMIERON_A_PACMAN, 
		SE_COMIERON_UNA_FRUTA, 
		SE_COMIERON_UN_FANTASMITA,
		PAUSADO;
	}
	
	private int ticsFruta;
	private double cantidadDeFantasmitasComidos;

	public JuegoConcreto(){ 
		this.setCantidadDeVidas(3);
		this.setNivel(1);
	}

	static public JuegoConcreto getInstancia() {
		if(unicaInstancia == null)
			unicaInstancia = new JuegoConcreto();	
		return unicaInstancia;
	}

	public EstadosDelJuego getEstadoGeneral(){
		return estadoGeneral;
	}

	public static void setearLaberinto(String path){
		try {
			getInstancia().cargarLaberinto(CargadorDeLaberintos.levantarDeTXT(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (LaberintoInvalidoException e) {
			e.printStackTrace();
		}	
		getInstancia().pathDelLaberinto=path;
	}

	public void inicializar() {
		this.listaDePersonajes = new ListaDePersonajesConcreta();
		this.getListaDePersonajes().add(new Pacman());
		this.setEstadoGeneral(EstadosDelJuego.INICIANDO);
		this.setCantidadDePastillas(this.getLaberinto().getCantidadDePastillas());
		this.setEstado(new FantasmitasPersiguenPacMan());
		this.setPuntaje(0);
		this.setCantidadDeVidas(3);
	}

	public ListaDePersonajes getListaDePersonajes() {
		return this.listaDePersonajes;
	}

	public void resolverPosiblesChoques() {
		Iterator<FantasmitaConcreto> iteradorDeFantasmitas = this.getListaDePersonajes().iteradorFantasmitas();
		while (iteradorDeFantasmitas.hasNext()){
			FantasmitaConcreto esteFantasmita = iteradorDeFantasmitas.next();
			this.resolverPosiblesChoquesConFantasmita(esteFantasmita);
		}
		this.resolverPosiblesChoquesConElementosEstaticos();
	}

	public boolean fantasmitasEstanPersiguiendoPacman() {
		return ! pacmanEstaPersiguiendoFantasmitas();
	}

	/**
	 * @see ModeloDeDominio.Juego#actualizarPosiciones()
	 */
	public void actualizarPosiciones() {
		for (Personaje estePersonaje : this.getListaDePersonajes())
			estePersonaje.mover();
	}

	public int getCantidadDeVidas() {
		return this.cantidadDeVidas;
	}

	/**
	 * @see ModeloDeDominio.Juego#seComioUnaPastillaEspecial()
	 */
	public void seComioUnaPastillaEspecial() {
		this.decrementarCantidadDePastillas();
		if (fantasmitasEstanPersiguiendoPacman())
			this.cambiarEstado();
		if (estadoGeneral == EstadosDelJuego.ESTA_PASANDO_EL_EFECTO)
			setEstadoGeneral(EstadosDelJuego.PACMAN_PERSIGUE_FANTASMITAS);
		ticsEfectoDePastilla = 0;
		ticsEstaPasandoElEfecto = 0;
		if ( ! this.quedanPastillas())
			this.seGanoElJuego();
	}

	public boolean estaPerdido() {
		return this.getEstadoGeneral() == EstadosDelJuego.PERDIDO;
	}

	/**
	 * @see ModeloDeDominio.Juego#estaGanado()
	 */
	public boolean estaGanado() {
		return this.getEstadoGeneral() == EstadosDelJuego.GANADO;
	}

	/**
	 * @see ModeloDeDominio.Juego#seEstaJugando()
	 */
	public boolean seEstaJugando() {
		return (this.getEstadoGeneral() == EstadosDelJuego.PACMAN_PERSIGUE_FANTASMITAS ||
				this.getEstadoGeneral() == EstadosDelJuego.FANTASMITAS_PERSIGUEN_PACMAN ||
				this.getEstadoGeneral() == EstadosDelJuego.ESTA_PASANDO_EL_EFECTO );
	}

	/**
	 * @see ModeloDeDominio.Juego#seComieronAPacman()
	 */
	public void seComieronAPacman() {
		estadoGeneral = EstadosDelJuego.SE_COMIERON_A_PACMAN;
	}

	/**
	 * @see ModeloDeDominio.Juego#seComioUnaPastilla()
	 */
	public void seComioUnaPastilla() {
		this.incrementarPuntajeEn(Constantes.getPuntajePastillaEnNivel(this.getNivel()));
		this.decrementarCantidadDePastillas();
		if ( ! this.quedanPastillas())
			this.seGanoElJuego();
	}

	public Laberinto getLaberinto() {
		return this.laberinto;
	}

	public double getPuntaje() {
		return this.puntaje;
	}

	public int getNivel() {
		return this.nivel;
	}

	/**
	 * @see ModeloDeDominio.Juego#seComioUnaFruta(ModeloDeDominio.ElementosEstaticos.Fruta)
	 */
	public void seComioUnaFruta(Fruta fruta) {
		this.incrementarPuntajeEn(fruta.getPuntaje());
	}

	/**
	 * @see ModeloDeDominio.Juego#juegoPerdido()
	 */
	public void seGanoElJuego() {
		this.setEstadoGeneral(EstadosDelJuego.GANADO);
	}

	/**
	 * @see ModeloDeDominio.Juego#juegoGanado()
	 */
	public void sePerdioElJuego() {
		this.setEstadoGeneral(EstadosDelJuego.PERDIDO);
	}

	/**
	 * @see ModeloDeDominio.Juego#pausarJuego()
	 */
	public void pausarJuego() {
		if (seEstaJugando())
			setEstadoGeneral(EstadosDelJuego.PAUSADO);	 
	}

	/**
	 * @see ModeloDeDominio.Juego#despausarJuego()
	 */
	public void despausarJuego() {
		volverAEstadoAnterior();
	}

	/**
	 * @see ModeloDeDominio.Juego#seComioUnFantasmita()
	 */
	public void seComioUnFantasmita() {
		incrementarCantidaddeFantasmitasComidos();
		incrementarCantidaddeFantasmitasComidos();
		this.incrementarPuntajeEn(Constantes.getPuntajeDeFantasmitaComidoEnNivel(this.getNivel())*cantidadDeFantasmitasComidos);
		setEstadoGeneral(EstadosDelJuego.SE_COMIERON_UN_FANTASMITA);
		
	}

	private void incrementarCantidaddeFantasmitasComidos() {
		setCantidadDeFantasmitasComidos(getCantidadDeFantasmitasComidos() + 1);
	}

	/**
	 * @see ModeloDeDominio.Juego#cargarLaberinto(ModeloDeDominio.Laberinto.Laberinto)
	 */
	public void cargarLaberinto(Laberinto laberinto) {
		this.laberinto = laberinto;
	}

	public Pacman getPacman() {
		return this.getListaDePersonajes().getPacman();
	}

	public void agregarPersonaje(Personaje nuevoPersonaje) {
		this.getListaDePersonajes().add(nuevoPersonaje);
		//TODO agregar limite de personajes???
	}

	@Override
	public boolean pacmanEstaPersiguiendoFantasmitas() {
		return this.getEstado()instanceof PacManPersigueFantasmitas;
	}

	@Override
	public boolean juegoPausado() {
		return this.getEstadoGeneral() == EstadosDelJuego.PAUSADO;
	}

	@Override
	public boolean juegoGanado() {
		return this.getEstadoGeneral() == EstadosDelJuego.GANADO;
	}

	@Override
	public boolean juegoPerdido() {
		return this.getEstadoGeneral() == EstadosDelJuego.PERDIDO;
	}

	public static void limpiar() {
		unicaInstancia = null;		
	}

	public void simular() {
		if ( ! juegoPausado()){
			if (seEstaJugando()){
				actualizarPosiciones();
				resolverPosiblesChoques();
			}

			if (estaGanado()){
				incrementarNivel();
				nuevaPartida();
			}

			if (estaPerdido()){
				
			}

			gestionarSalidaDeFantasmitas();

			gestionarTicsPastillaEspecial();		

			gestionarTicsFruta();

			gestionarTicsFreezeCuandoSeComieronAUnFantasmita();

			gestionarTicsFreezeCuandoSeComieronUnaFruta();

			gestionarTicsFreezeInicio();


			if (getEstadoGeneral() == EstadosDelJuego.SE_COMIERON_A_PACMAN){
				ticsFreezeSeComieronAPacman ++;
				if (ticsFreezeSeComieronAPacman == Constantes.TICS_FREEZE_SE_COMIERON_A_PACMAN){
					ticsFreezeSeComieronAPacman = 0;
					decrementarVidas();
					if (quedanVidas()){
						setEstadoGeneral(EstadosDelJuego.INICIANDO);
					}
					else 
						setEstadoGeneral(EstadosDelJuego.PERDIDO);
					setearPosicionesIniciales();
				}
			}
		}
	}



	private void gestionarTicsFreezeInicio() {
		if (getEstadoGeneral() == EstadosDelJuego.INICIANDO){
			ticsIniciandoNivel ++;
			if (ticsIniciandoNivel == Constantes.TICS_FREEZE_INICIANDO){
				this.setEstadoGeneral(EstadosDelJuego.FANTASMITAS_PERSIGUEN_PACMAN);
				ticsIniciandoNivel = 0;
			}
		}

	}

	private void gestionarTicsFreezeCuandoSeComieronUnaFruta() {
		if (getEstadoGeneral() == EstadosDelJuego.SE_COMIERON_UNA_FRUTA){
			ticsSeComieronUnaFruta ++;
			if (ticsSeComieronUnaFruta == Constantes.TICS_FREEZE_FRUTA_COMIDA ){
				volverAEstadoAnterior();
				ticsSeComieronUnaFruta = 0;
			}
		}
	}

	private void gestionarTicsFreezeCuandoSeComieronAUnFantasmita() {
		if (getEstadoGeneral() == EstadosDelJuego.SE_COMIERON_UN_FANTASMITA){
			ticsSeComieronUnFantasmita ++;
			if (ticsSeComieronUnFantasmita == Constantes.TICS_FREEZE_FANTASMITA_COMIDO){
				volverAEstadoAnterior();
				ticsSeComieronUnFantasmita = 0;
			}
		}
	}

	private void gestionarTicsFruta() {
		if (!(getEstadoGeneral() == EstadosDelJuego.PAUSADO)){
			ticsFruta ++;
			if (this.ticsFruta == Constantes.getTiempoEnElQueApareceUnaFruta()){
				unicaInstancia.agregarFruta();
				ticsFruta = 0;
			}

			if (hayFruta){
				this.contadorDuracionDeFruta ++;
				if (this.contadorDuracionDeFruta == Constantes.getTiempoDeEfectoDeUnaFruta()) {
					unicaInstancia.eliminarFruta();
					this.contadorDuracionDeFruta = 0;
				}
			}
		}
	}

	private void gestionarTicsPastillaEspecial() {
		if (getEstadoGeneral() == EstadosDelJuego.ESTA_PASANDO_EL_EFECTO){
			ticsEstaPasandoElEfecto ++;
			if (ticsEstaPasandoElEfecto == Constantes.AVISO_PASTILLA){
				setEstadoGeneral ( EstadosDelJuego.FANTASMITAS_PERSIGUEN_PACMAN );
				ticsEstaPasandoElEfecto = 0 ;
				this.cambiarEstado();
			}				
		}

		if (unicaInstancia.pacmanEstaPersiguiendoFantasmitas()) {
			this.ticsEfectoDePastilla ++;
			if (this.ticsEfectoDePastilla == Constantes.getTiempoDeEfectoPastillaEspecial()) {
				this.setEstadoGeneral(EstadosDelJuego.ESTA_PASANDO_EL_EFECTO);
				this.ticsEfectoDePastilla = 0;
			}
		}

	}

	@Override
	public void vivir() {
		simular();
	}

	public void nuevaPartida(){
		recargarLaberinto();
		this.setCantidadDePastillas(this.getLaberinto().getCantidadDePastillas());
		this.cambiarAPersecucionALosFantasmitas();
		this.setEstadoGeneral(EstadosDelJuego.INICIANDO);
		this.setEstado(new FantasmitasPersiguenPacMan());
		setearPosicionesIniciales();
		this.hayFruta = false;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	private void setCantidadDePastillas(int cantidadDePastillas) {
		this.cantidadDePastillas = cantidadDePastillas;
	}

	private void setEstadoGeneral(EstadosDelJuego estado) {
		estadoAnterior = estadoGeneral;
		estadoGeneral = estado;
	}

	private void volverAEstadoAnterior(){
		estadoGeneral = estadoAnterior;
	}

	private void resolverPosiblesChoquesConElementosEstaticos() {
		Pacman pacman = this.getPacman();
		Posicion posicionDelPacman = pacman.getPosicion();
		Celda casilleroCorrespondienteAlDelPacman = celdaCorrepondienteAlCasillero(posicionDelPacman);
		if (casilleroCorrespondienteAlDelPacman.estaCargada()){
			ElementoEstatico elementoAComer = casilleroCorrespondienteAlDelPacman.getElementoAlmacenado();
			if (elementoAComer.esFruta())
				setEstadoGeneral (EstadosDelJuego.SE_COMIERON_UNA_FRUTA);
			pacman.comerA(elementoAComer);
			casilleroCorrespondienteAlDelPacman.almacenarElementoEstatico(null);
		}
	}

	private Celda celdaCorrepondienteAlCasillero(Posicion posicionDelPacman) {
		return getInstancia().getLaberinto().casilleroEn(posicionDelPacman);
	}

	private void resolverPosiblesChoquesConFantasmita(FantasmitaConcreto esteFantasmita) {
		Pacman pacman = JuegoConcreto.getInstancia().getPacman();
		Posicion posicionPacman = pacman.getPosicion();
		Posicion posicionFantasmita = esteFantasmita.getPosicion();
		if (posicionPacman.estaDentroDelMargenCon(posicionFantasmita,Constantes.getMargenDePersonajes()) && ! esteFantasmita.estaComido())
			this.getEstado().consecuenciaDelChoqueEntre(pacman, esteFantasmita);
	}

	public int getCantidadDePastillas() {
		return this.cantidadDePastillas;
	}

	/*
	 * Cambia el estado del juego entre pacman persigue fantasmitas y fantasmitas persiguen pacman.
	 * Si esta en un estado cambia al otro. 
	 */
	private void cambiarEstado() {
		if (this.fantasmitasEstanPersiguiendoPacman()){
			this.setEstado(new PacManPersigueFantasmitas());
			setEstadoGeneral(EstadosDelJuego.PACMAN_PERSIGUE_FANTASMITAS);
			this.cambiarAEscapeALosFantasmitas();
		}
		else{
			this.setEstado(new FantasmitasPersiguenPacMan());
			setEstadoGeneral(EstadosDelJuego.FANTASMITAS_PERSIGUEN_PACMAN);
			this.cambiarAPersecucionALosFantasmitas();
			setCantidadDeFantasmitasComidos(0);
		}
	}

	private void cambiarAPersecucionALosFantasmitas() {
		Iterator<FantasmitaConcreto> iterador = this.getListaDePersonajes().iteradorFantasmitas();
		while (iterador.hasNext()){
			FantasmitaConcreto actual = iterador.next();
			if (actual.estaEscapando())
				actual.cambiarPersecucionYEscape();
		}
	}

	private void cambiarAEscapeALosFantasmitas() {
		Iterator<FantasmitaConcreto> iterador = this.getListaDePersonajes().iteradorFantasmitas();
		while (iterador.hasNext()){
			FantasmitaConcreto actual = iterador.next();
			if (! actual.estaComido() && ! actual.estaEnCasa())
				actual.cambiarPersecucionYEscape();
		}
	}

	private void setEstado(EstadoDelJuego nuevoEstado) {
		this.estado = nuevoEstado;		
	}

	private EstadoDelJuego getEstado() {
		return this.estado;
	}

	private void decrementarVidas() {
		this.setCantidadDeVidas(this.getCantidadDeVidas()-1);
	}

	public void setCantidadDeVidas(int vidas) {
		this.cantidadDeVidas = vidas;		
	}

	private boolean quedanVidas() {
		return (this.getCantidadDeVidas() > 0);
	}

	public void incrementarVidas() {
		this.setCantidadDeVidas(this.getCantidadDeVidas()+1);	 
	}

	private void setearPosicionesIniciales() {
		Iterator<FantasmitaConcreto> iterador= this.getListaDePersonajes().iteradorFantasmitas();
		while (iterador.hasNext()){
			FantasmitaConcreto estePersonaje = iterador.next();
			estePersonaje.setPosicionInicial();
		}
		this.getListaDePersonajes().getPacman().setPosicionInicial();
	}

	private boolean quedanPastillas() {
		return this.getCantidadDePastillas() > 0;
	}

	private void decrementarCantidadDePastillas() {
		int nuevaCantidadDePastillas = this.getCantidadDePastillas();
		nuevaCantidadDePastillas--;
		this.setCantidadDePastillas(nuevaCantidadDePastillas);
	}

	private void incrementarPuntajeEn(double puntaje) {
		this.setPuntaje(this.getPuntaje() + puntaje);
		if (suficientePuntajeParaIncrementarVidas()){
			this.incrementarVidas();
		}
	}

	private boolean suficientePuntajeParaIncrementarVidas() {
		if (puntajeParaVidas > Constantes.getPuntajeParaNuevaVida()){
			puntajeParaVidas = 0;
			return true;
		}
		else
			return false;
	}

	public void setPuntaje(double nuevoPuntaje) {
		this.puntaje = nuevoPuntaje;		
	}

	private void gestionarSalidaDeFantasmitas() {
		if( seEstaJugando() && hayAlgunFantamitaEnLaCasa()){
			ticsSalidaDeFantasmitas++;
			if (ticsSalidaDeFantasmitas == Constantes.tiempoDeSalidaDeFantasmitasParaNivel(this.getNivel())){
				Iterator<FantasmitaConcreto> iterador = getListaDePersonajes().iteradorFantasmitas();
				boolean salioAlguno = false;
				while (iterador.hasNext() && ! salioAlguno){
					FantasmitaConcreto fantasmita = iterador.next();
					if (fantasmita.estaEnCasa()){
						fantasmita.salirDeCasa();
						ticsSalidaDeFantasmitas = 0;
						salioAlguno = true;					
					}
				}					
			}
		}
	}

	private boolean hayAlgunFantamitaEnLaCasa() {
		Iterator<FantasmitaConcreto> iterador = getListaDePersonajes().iteradorFantasmitas();
		boolean hayAlgunoEnCasa = false;
		while (iterador.hasNext() && ! hayAlgunoEnCasa)
			hayAlgunoEnCasa = iterador.next().estaEnCasa();
		return hayAlgunoEnCasa;
	}

	private void eliminarFruta() {
		this.hayFruta = false;
		Laberinto laberinto = unicaInstancia.getLaberinto();
		if (posicionDondeHayFruta != null){
			laberinto.casilleroEn(posicionDondeHayFruta).removeElementoEstatico();
		}
	}

	private void agregarFruta() {
		this.hayFruta = true;
		Laberinto laberinto = unicaInstancia.getLaberinto();
		//PosicionConcreta posicion = null;
		boolean valido=false;
		while (!valido){
			int posX;
			int posY;
			Random randomHorizontal = new Random();
			Random randomVertical = new Random();
			posX= randomHorizontal.nextInt(laberinto.getAncho()-1);
			posY= randomVertical.nextInt(laberinto.getAlto()-1);
			//posicion = new PosicionConcreta(posX,posY);
			Celda casillero = laberinto.casilleroEn(posX,posY);
			if (!casillero.estaCargada()&&(!(casillero instanceof Pared))&&(casillero.esTransitable())){
				valido = true;
				posicionDondeHayFruta = new PosicionConcreta(posX,posY);
			}
		}
		laberinto.casilleroEn(posicionDondeHayFruta).almacenarElementoEstatico(frutaDeNivel(unicaInstancia.getNivel()));
	}

	private ElementoEstatico frutaDeNivel(int nivel) {
		switch (nivel){
		case 1: {
			return new Cereza();
		}
		case 2: {
			return new Banana();
		}
		case 3: {
			return new Manzana();
		}
		default: 
			return new Melon();
		}
	}

	public void incrementarNivel() {
		int nuevoNivel = this.getNivel()+1;
		this.setNivel(nuevoNivel);
	}

	private void recargarLaberinto(){
		Laberinto nuevo = null ;
		try {
			nuevo = CargadorDeLaberintos.levantarDeTXT(this.pathDelLaberinto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int j=0; j<nuevo.getAlto(); j++)
			for (int i=0; i<nuevo.getAncho(); i++)
				if (nuevo.casilleroEn(i,j).estaCargada()){
					ElementoEstatico almacenado = nuevo.casilleroEn(i,j).getElementoAlmacenado();
					if (almacenado.getClass() == Pastilla.class)
						laberinto.casilleroEn(i,j).almacenarElementoEstatico(new Pastilla());
					else
						laberinto.casilleroEn(i,j).almacenarElementoEstatico(new PastillaEspecial());
				}
	}

	public void setCantidadDeFantasmitasComidos(double cantidadDeFantasmitasComidos) {
		this.cantidadDeFantasmitasComidos = cantidadDeFantasmitasComidos;
	}

	public double getCantidadDeFantasmitasComidos() {
		return cantidadDeFantasmitasComidos;
	}

	private PosicionConcreta posicionDondeHayFruta;
	private String pathDelLaberinto;
	private int ticsEfectoDePastilla = 0;
	private int contadorDuracionDeFruta = 0;
	private boolean hayFruta = false;
	private EstadoDelJuego estado;
	private ListaDePersonajes listaDePersonajes;
	private Laberinto laberinto;
	private int cantidadDeVidas;
	private int nivel;
	private EstadosDelJuego estadoGeneral;
	private double puntaje;
	private int cantidadDePastillas;
	private int puntajeParaVidas;
	private static JuegoConcreto unicaInstancia;
	private int ticsIniciandoNivel=0;
	private int ticsSeComieronUnFantasmita;
	private int ticsEstaPasandoElEfecto;
	private EstadosDelJuego estadoAnterior;
	private int ticsSeComieronUnaFruta;
	private int ticsFreezeSeComieronAPacman;
	private int ticsSalidaDeFantasmitas;
	
}

