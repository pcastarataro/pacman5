package ModeloDeDominio.Personajes.EstadosDelFantasmita;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;
import ModeloDeDominio.Personajes.Estrategias.QuedarseEnCasa;

public class IndecisoEnCasa extends Cazador{

	public EstadoDelFantasmita cambiarComidoYVivo() {
		return new Indeciso();
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

	public Estrategia getEstrategia() {
		return new QuedarseEnCasa();
	}
}
