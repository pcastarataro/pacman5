package ModeloDeDominio.Personajes.EstadosDelFantasmita;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.Embozcar;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;

public class Emboscador implements EstadoDelFantasmita {

	public EstadoDelFantasmita cambiarPersecucionYEscape() {
		return new EmboscadorPerseguido();
	}

	public Estrategia getEstrategia() {
		return new Embozcar();
	}

	public EstadoDelFantasmita cambiarComidoYVivo() {
		return this;
	}

	public double getVelocidad() {
		return Constantes.getVelocidadEmbozcadorParaNivel(JuegoConcreto.getInstancia().getNivel());
	}

	public EstadoDelFantasmita digerir() {
		return this;
	}
	
	public boolean estaComido() {
		return false;
	}
	
	public boolean estaEscapando() {
		return false;
	}
}

