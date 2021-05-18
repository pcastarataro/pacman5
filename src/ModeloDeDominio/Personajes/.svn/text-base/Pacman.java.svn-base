package ModeloDeDominio.Personajes;


import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Common.Posicion;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.ControladoPorElUsuario;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;


public class Pacman extends Personaje implements Perseguible {

	private Estrategia estrategia;

	@Override
	public void digerir() {
		JuegoConcreto.getInstancia().seComieronAPacman();
	}

	public Pacman() {
		super();
		this.getVelocidad().setDireccion(Direccion.NULA);
		this.setEstrategia(new ControladoPorElUsuario());
	}

	/**
	 * @see ModeloDeDominio.Personajes.Perseguible#dondeEsta()
	 */
	public Posicion dondeEsta() {
		return this.getPosicion();
	}

	/**
	 * @see ModeloDeDominio.Personajes.Perseguible#haciaDondeVa()
	 */
	public Direccion haciaDondeVa() {
		return this.getVelocidad().getDireccion();
	}

	public void setEstrategia(ControladoPorElUsuario controlador) {
		this.estrategia=controlador;		
	}

	@Override
	protected Posicion posicionInicial() {
		return JuegoConcreto.getInstancia().getLaberinto().getPosicionInicialDePacman();
	}

	@Override
	void actualizarVelocidad() {
		this.setModuloDeLaVelocidad(Constantes.getVelocidadPacmanParaNivel(JuegoConcreto.getInstancia().getNivel()));
		this.setDireccionDeLaVelocidad(this.getEstrategia().haciaDondeIrDesdePosicionConDireccionActual(this.getPosicion(), this.getVelocidad().getDireccion()));
	}

	public Estrategia getEstrategia(){
		return this.estrategia;
	}
	
	public void mover(){
		super.mover();
		if (estuvoCentradoEnLaCelda && ! JuegoConcreto.getInstancia().getLaberinto().sePuedeAvanzarEnDireccionDesde(this.getVelocidad().getDireccion(), this.getPosicion()))
			this.setDireccionDeLaVelocidad(Direccion.NULA);
	}
}

