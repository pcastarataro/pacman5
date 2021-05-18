package ModeloDeDominio.Personajes.EstadosDelFantasmita;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;
import ModeloDeDominio.Personajes.Estrategias.VolverACasa;

public class EmboscadorComido extends Emboscador {
	
	public EstadoDelFantasmita cambiarComidoYVivo() {
		return new Emboscador();
	}

	public EstadoDelFantasmita cambiarPersecucionYEscape() {
		return this;
	}

	public EstadoDelFantasmita digerir() {
		return this;	
	}

	public Estrategia getEstrategia() {
		return new VolverACasa();
	}

	public double getVelocidad() {
		return Constantes.getVelocidadVueltaACasaParaNivel(JuegoConcreto.getInstancia().getNivel());
	}
	
	public boolean estaComido() {
		return true;
	}
}

