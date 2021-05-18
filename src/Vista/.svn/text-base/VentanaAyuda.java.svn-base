package Vista;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Panel;


import ModeloDeDominio.Juego.JuegoConcreto;

public class VentanaAyuda extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel panel;

	public VentanaAyuda(){
		this.setTitle("AYUDA...| ALGO3MAN | ALGORITMOS Y PROGRAMACION 3 | GRUPO 5 |");
		this.setResizable(false);
		this.setSize(500, 300);
		this.setLocationByPlatform(true);
		panel= new Panel(500, 300, null);
		this.add(panel);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				JuegoConcreto.getInstancia().despausarJuego();
			}
		});
		
		TextArea texto= new TextArea();
		texto.setText("Algo3Man\n" +
				"\n" +
				"El objetivo del juego es comerse todas las pastillas distribuidas \n" +
				"en el laberinto evitando ser comido por los fantasmitas.\n\n" +
				"Si se come una pastilla especial, se puede comer a los fantasmitas\n" +
				" por un período de tiempo\n" +
				"\n" +
				"Use el cursor del teclado para moverse\n" +
				"Use P para pausar y despausar el juego\n" +
				"\n" +
				"http://code.google.com/p/pacman5/");//LEA COMPLETA UN CHAMUYITO PARA LA AYUDA
		texto.setEditable(false);
		
		panel.add(texto);
	}
	
	public SuperficieDeDibujo getSuperficieDeDibujo(){
		return this.panel;
	}
}
