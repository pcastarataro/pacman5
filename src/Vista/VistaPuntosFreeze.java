package Vista;

import java.awt.Color;

import ModeloDeDominio.Common.Constantes;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Juego.JuegoConcreto.EstadosDelJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Texto;

public class VistaPuntosFreeze extends Texto {



	public VistaPuntosFreeze() {
		super();
		setColor(Color.green);
		setTamanio(12);
	}

	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		if (JuegoConcreto.getInstancia().getEstadoGeneral() == EstadosDelJuego.SE_COMIERON_UN_FANTASMITA){
			super.setTexto((int)Constantes.getPuntajeDeFantasmitaComidoEnNivel(JuegoConcreto.getInstancia().getNivel())*(int)JuegoConcreto.getInstancia().getCantidadDeFantasmitasComidos());		
			setPosicionable(JuegoConcreto.getInstancia().getPacman());
		}
		else 
			if (JuegoConcreto.getInstancia().getEstadoGeneral() == EstadosDelJuego.SE_COMIERON_UNA_FRUTA){
				super.setTexto((int)Constantes.getPuntajeDeCereza());
				setPosicionable(JuegoConcreto.getInstancia().getPacman());
			}
			else 
				if (JuegoConcreto.getInstancia().getEstadoGeneral() == EstadosDelJuego.INICIANDO){
					super.setTexto("GO GO GO!");
					setPosicionable(JuegoConcreto.getInstancia().getPacman());
				}
				else 
					super.setTexto("");
		
		super.dibujar(superfice);
	}

}
