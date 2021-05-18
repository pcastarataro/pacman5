package ModeloDeDominio.Personajes.EstadosDelFantasmita;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.Escapar;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;

public class EmboscadorPerseguido extends Emboscador {
	
	public EstadoDelFantasmita cambiarComidoYVivo() {
		return new EmboscadorComido();
	}

	public EstadoDelFantasmita digerir() {
		JuegoConcreto.getInstancia().seComioUnFantasmita();
		return new EmboscadorComido();
	}

	public EstadoDelFantasmita cambiarPersecucionYEscape() {
		return new Emboscador(); 
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

