package Vista;

import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Juego.JuegoConcreto.EstadosDelJuego;
import ModeloDeDominio.Personajes.FantasmitaConcreto;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.Cazador;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.CazadorComido;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.CazadorPerseguido;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.Emboscador;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.EmboscadorComido;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.EmboscadorPerseguido;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.EstadoDelFantasmita;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.Indeciso;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.IndecisoComido;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.IndecisoPerseguido;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaFantasma extends Imagen{
	private Skin skin;
	private boolean titila;
	private int contador;
	
	public VistaFantasma(Skin skin){
		super();
		this.skin= skin;
		titila=true;
		contador = 0;
	}
	

	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		setearImagenSegunTipo();
		super.dibujar(superficeDeDibujo);
	}

	private void setearImagenSegunTipo() {
		EstadoDelFantasmita tipoDeFantasmita = ((FantasmitaConcreto) this.getPosicionable()).getEstado();
		String rutaImagen = null;
		if (fantasmitaEstaEscapando(tipoDeFantasmita)){
			rutaImagen= skin.getFantasmasPerseguidos();
			if (JuegoConcreto.getInstancia().getEstadoGeneral() == EstadosDelJuego.ESTA_PASANDO_EL_EFECTO){
				contador ++;
				if (titila){
					rutaImagen= skin.getFantasmasPerseguidos();
				}
				else
				{
					rutaImagen = skin.getFantasmasPerseguidosTitila();
				}		
				if (contador == ConstantesVista.CICLOS_TITILA_AVISO_CAMBIO_DE_ESTADO){
					if (titila)
						titila = false;
					else 
						titila = true;
					contador = 0;
				}
			}
		}			
		else
			if (fantasmitaFueComido(tipoDeFantasmita))
				rutaImagen = skin.getFantasmasComidos();
			else
				if (esFantasmitaCazador(tipoDeFantasmita))
					rutaImagen = skin.getFantasmaCazador();
				else
					if (esFantasmitaEmbozcador(tipoDeFantasmita))
						rutaImagen = skin.getFantasmaEmbozcador();
					else
						if (esFantasmitaIndeciso(tipoDeFantasmita))
							rutaImagen = skin.getFantasmaIndeciso();
		this.setNombreArchivoImagen(rutaImagen);		
	}

	private boolean fantasmitaFueComido(EstadoDelFantasmita tipoDeFantasmita) {
		return (tipoDeFantasmita instanceof IndecisoComido || 
				tipoDeFantasmita instanceof CazadorComido || 
				tipoDeFantasmita instanceof EmboscadorComido );
	}

	private boolean esFantasmitaCazador(EstadoDelFantasmita tipoDeFantasmita) {
		return tipoDeFantasmita instanceof Cazador;
	}

	private boolean esFantasmitaEmbozcador(EstadoDelFantasmita tipoDeFantasmita) {
		return tipoDeFantasmita instanceof Emboscador;
	}

	private boolean esFantasmitaIndeciso(EstadoDelFantasmita tipoDeFantasmita) {
		return tipoDeFantasmita instanceof Indeciso;
	}

	private boolean fantasmitaEstaEscapando(EstadoDelFantasmita tipoDeFantasmita) {
		return (tipoDeFantasmita instanceof IndecisoPerseguido || 
				tipoDeFantasmita instanceof CazadorPerseguido || 
				tipoDeFantasmita instanceof EmboscadorPerseguido );
	}
}
