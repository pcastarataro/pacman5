package Vista;

import java.awt.Color;

import ModeloDeDominio.Juego.JuegoConcreto;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Texto;

public class VistaNivel extends Texto {
	
	public VistaNivel(){
		super();
		setColor(Color.GREEN);
		setTamanio(20);
	}
	public void dibujar(SuperficieDeDibujo superfice) {
		super.dibujar(superfice);
		super.setTexto("NIVEL:  "+ (int)JuegoConcreto.getInstancia().getNivel());
	}
}
