package ModeloDeDominio.Personajes.EstadosDelFantasmita;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Personajes.Estrategias.Escapar;
import ModeloDeDominio.Personajes.Estrategias.Estrategia;

public class CazadorPerseguido extends Cazador {

	public EstadoDelFantasmita cambiarComidoYVivo() {
		return new CazadorComido();
	}

	public EstadoDelFantasmita digerir() {
		JuegoConcreto.getInstancia().seComioUnFantasmita();
		return new CazadorComido();
	}

	public EstadoDelFantasmita cambiarPersecucionYEscape() {
		return new Cazador(); 
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

