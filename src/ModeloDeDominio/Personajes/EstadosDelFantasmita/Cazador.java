package ModeloDeDominio.Personajes.EstadosDelFantasmita;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.Cazar;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;

public class Cazador implements EstadoDelFantasmita {

	public EstadoDelFantasmita cambiarPersecucionYEscape() {
		return new CazadorPerseguido();
	}

	public Estrategia getEstrategia() {
		return new Cazar();
	}

	public EstadoDelFantasmita cambiarComidoYVivo() {
		return this;
	}

	public double getVelocidad() {
		return Constantes.getVelocidadCazadorParaNivel(JuegoConcreto.getInstancia().getNivel());
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

