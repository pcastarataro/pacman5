package ModeloDeDominio.Personajes;

import ModeloDeDominio.Common.Posicion;
//import ModeloDeDominio.Common.PosicionConcreta;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.EstadoDelFantasmita;
import ModeloDeDominio.Personajes.Estrategias.QuedarseEnCasa;
import ModeloDeDominio.Personajes.Estrategias.SalirDeCasa;

public class FantasmitaConcreto extends Personaje implements Fantasmita {
	
	public FantasmitaConcreto(EstadoDelFantasmita nuevo) {
		super();
		this.setEstado(nuevo);
		this.setEstrategia(new QuedarseEnCasa());
		//this.estadoGeneral=EstadoGeneralDelFantasmita.EN_CASA;
	}

	@Override
	public void digerir() {
		//estadoGeneral=EstadoGeneralDelFantasmita.COMIDO;
		this.setEstado(this.getEstado().digerir());
	}

	/**
	 * @return 
	 * @see ModeloDeDominio.Personajes.Fantasmita#cambiarPersecucionYEscape()
	 */
	public void cambiarPersecucionYEscape() {
		this.setEstado(this.getEstado().cambiarPersecucionYEscape());
		
	}

	public void cambiarComidoYNormal(){
		this.setEstado(this.getEstado().cambiarComidoYVivo());
	}

	private void setEstado(EstadoDelFantasmita estadoNuevo) {
		estado = estadoNuevo;	
		this.setEstrategia(estadoNuevo.getEstrategia());
	}

	public EstadoDelFantasmita getEstado() {
		return estado;
	}

	@Override
	protected Posicion posicionInicial() {
		return JuegoConcreto.getInstancia().getLaberinto().getPosicionInicialDeLosFantasmas();
	}

	void actualizarVelocidad(){
		this.setModuloDeLaVelocidad(this.getEstado().getVelocidad());
		this.setDireccionDeLaVelocidad(this.getEstrategia().haciaDondeIrDesdePosicionConDireccionActual(this.getPosicion(), this.getVelocidad().getDireccion()));
	}
	
	public void mover() {
		super.mover();
		if ( estaComido() && estaEnLaCasa() ){
			cambiarComidoYNormal();
			this.setEstrategia(new QuedarseEnCasa());
		}
		if (estaEnLaPuertaDeLaCasa() && estaSaliendo())
			this.setEstrategia(this.getEstado().getEstrategia());
	}

	private boolean estaSaliendo() {
		return this.getEstrategia().getClass() == SalirDeCasa.class;
	}

	private boolean estaEnLaPuertaDeLaCasa() {
		return (this.getPosicion().equals(JuegoConcreto.getInstancia().getLaberinto().getPuertaDeLaCasaDeLosFantasmitas()));
	}

	public boolean estaComido() {
		return getEstado().estaComido();
	}
	
	private boolean estaEnLaCasa() {
		return (this.getPosicion().equals(JuegoConcreto.getInstancia().getLaberinto().getPosicionInicialDeLosFantasmas()));
	}

	public void salirDeCasa() {
		this.setEstrategia(new SalirDeCasa());
	}
	
	public boolean estaEscapando(){
		return getEstado().estaEscapando();
	}
	
	private EstadoDelFantasmita estado;

	public boolean estaEnCasa() {
		return getEstrategia().getClass() == QuedarseEnCasa.class;
	}
}

