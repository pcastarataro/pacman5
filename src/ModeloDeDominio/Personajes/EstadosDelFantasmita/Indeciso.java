package ModeloDeDominio.Personajes.EstadosDelFantasmita;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.AndarPorAhi;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;

public class Indeciso implements EstadoDelFantasmita {

	public EstadoDelFantasmita cambiarPersecucionYEscape() {
		return new IndecisoPerseguido();
	}

	public Estrategia getEstrategia() {
		return new AndarPorAhi();
	}

	public EstadoDelFantasmita cambiarComidoYVivo() {
		return this;
	}

	public double getVelocidad() {
		return Constantes.getVelocidadIndecisoParaNivel(JuegoConcreto.getInstancia().getNivel());
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

