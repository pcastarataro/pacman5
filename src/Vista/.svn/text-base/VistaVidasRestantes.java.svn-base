package Vista;

import java.awt.Color;

import ModeloDeDominio.Juego.JuegoConcreto;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Texto;

public class VistaVidasRestantes extends Texto{

	public VistaVidasRestantes(){
		super();
		setColor(Color.GREEN);
		setTamanio(20);
	}
	public void dibujar(SuperficieDeDibujo superfice) {
		super.dibujar(superfice);
		super.setTexto("VIDAS:  "+ JuegoConcreto.getInstancia().getCantidadDeVidas());
	}
}
