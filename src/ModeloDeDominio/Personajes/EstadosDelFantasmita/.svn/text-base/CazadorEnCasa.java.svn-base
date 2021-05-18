package ModeloDeDominio.Personajes.EstadosDelFantasmita;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;
import ModeloDeDominio.Personajes.Estrategias.QuedarseEnCasa;

public class CazadorEnCasa extends Cazador{

	public EstadoDelFantasmita cambiarComidoYVivo() {
		return new Cazador();
	}
	
	public double getVelocidad() {
		return Constantes.getVelocidadVueltaACasaParaNivel(JuegoConcreto.getInstancia().getNivel());
	}

	public EstadoDelFantasmita cambiarPersecucionYEscape() {
		return this;
	}
	
	public EstadoDelFantasmita digerir() {
		return this;
	}

	@Override
	public Estrategia getEstrategia() {
		return new QuedarseEnCasa();
	}
}
