package Vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


import ModeloDeDominio.Juego.JuegoConcreto;

public class VentanaAcercaDe extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public VentanaAcercaDe() {
		int ancho=500;
		int alto=500;
		ImageIcon imagen= new ImageIcon("ArchivosNecesarios/Imagenes/acercaDe.jpg");
		if (imagen!=null){
			ancho=imagen.getIconWidth();
			alto=imagen.getIconHeight();
		}
		this.setTitle("ACERCA DE...  | ALGO3MAN | ALGORITMOS Y PROGRAMACION 3 | GRUPO 5 |");
		this.setResizable(false);
		this.setSize(ancho, alto+15);
		this.setLocationByPlatform(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				JuegoConcreto.getInstancia().despausarJuego();
			}
		});
		
		this.getContentPane().add(new JLabel(imagen));
	}
	
}

