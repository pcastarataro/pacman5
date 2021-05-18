package ModeloDeDominio.Personajes;

import ModeloDeDominio.Personajes.EstadosDelFantasmita.Cazador;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.Emboscador;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.Indeciso;

public class FabricaDeFantasmitasConcreta implements FabricaDeFantasmitas {

	@Override
	public FantasmitaConcreto fabricarFantasmitaCazador() {
		return new FantasmitaConcreto(new Cazador());
	}

	@Override
	public FantasmitaConcreto fabricarFantasmitaEmboscador() {
		return new FantasmitaConcreto(new Emboscador());
	}

	@Override
	public FantasmitaConcreto fabricarIndeciso() {
		return new FantasmitaConcreto(new Indeciso());
	}

}
