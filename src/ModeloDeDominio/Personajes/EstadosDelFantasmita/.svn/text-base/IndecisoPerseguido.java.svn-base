package ModeloDeDominio.Personajes.EstadosDelFantasmita;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.Escapar;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;

public class IndecisoPerseguido extends Indeciso {

	public EstadoDelFantasmita cambiarComidoYVivo() {
		return new IndecisoComido();
	}

	public EstadoDelFantasmita digerir() {
		JuegoConcreto.getInstancia().seComioUnFantasmita();
		return new IndecisoComido();
	}

	public EstadoDelFantasmita cambiarPersecucionYEscape() {
		return new Indeciso();
	}

	public Estrategia getEstrategia() {
		return new Escapar();
	}

	public double getVelocidad() {
		return Constantes.getVelocidadDeEscapePAraNivel(JuegoConcreto.getInstancia().getNivel());
	}
	
	public boolean estaEscapando() {
		return true;
	}
}

