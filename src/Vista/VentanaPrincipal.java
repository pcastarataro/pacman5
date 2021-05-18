package Vista;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import ModeloDeDominio.Juego.JuegoConcreto;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Panel;

public class VentanaPrincipal extends Frame {

	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		this.controladorJuego = unControladorJuego;
		this.setLocationByPlatform(true);
		this.setTitle("| ALGO3MAN | ALGORITMOS Y PROGRAMACION 3 | GRUPO 5 |");
		this.setResizable(false);
		
		ImageIcon imagenIcono=new ImageIcon("ArchivosNecesarios/Imagenes/IconoPrincipal.png"); 
		this.setIconImage(imagenIcono.getImage());
		
		panel = new Panel(700,700,controladorJuego);
		this.add(panel);

		MenuItem juegoNuevo= new MenuItem("Juego Nuevo", new MenuShortcut(KeyEvent.VK_J));
		juegoNuevo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JuegoConcreto juego=JuegoConcreto.getInstancia();
				juego.nuevaPartida();
				juego.setPuntaje(0);
				juego.setCantidadDeVidas(3);
				juego.setNivel(1);
				
			}
		});

		MenuItem salir= new MenuItem("Salir", new MenuShortcut(KeyEvent.VK_S));
		salir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}

		});
		

		Menu juego= new Menu("Juego");
		juego.add(juegoNuevo);
		juego.add(salir);
		
		MenuItem acercaDe= new MenuItem("Acerca de...", new MenuShortcut(KeyEvent.VK_D));
		acercaDe.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JuegoConcreto.getInstancia().pausarJuego();
				VentanaAcercaDe acercaDe = new VentanaAcercaDe();
				acercaDe.setVisible(true);
			}
		});

		MenuItem bayuda= new MenuItem("Ayuda", new MenuShortcut(KeyEvent.VK_F1,false));
		
		bayuda.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JuegoConcreto.getInstancia().pausarJuego();
				VentanaAyuda ventanaAyuda= new VentanaAyuda();
				ventanaAyuda.setVisible(true);
			}

		});
		
		
		Menu ayuda = new Menu("Ayuda");
		ayuda.add(acercaDe);
		ayuda.add(bayuda);

		MenuBar barraDeMenu= new MenuBar();
		barraDeMenu.add(juego);
		barraDeMenu.add(ayuda);
		

		this.setMenuBar(barraDeMenu);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		panel.setFocusable(true);
	}

	private ControladorJuego controladorJuego;
	private static final long serialVersionUID = 1L;
	private Panel panel;

	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return this.panel;
	}
	
}
