package Principal;

import java.io.FileNotFoundException;
import java.io.IOException;

import Audio.SonidoJuego;
import ModeloDeDominio.Juego.*;
import ModeloDeDominio.Laberinto.Laberinto;
import ModeloDeDominio.Laberinto.Excepciones.LaberintoInvalidoException;
import ModeloDeDominio.Personajes.*;
import Vista.*;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class Principal {
	
	public static void main(String[] args) {

		/*
		 * Primero se instancia el modelo
		 */		 
		
		try {
			FabricaDeJuegos.fabricarJuegoEnLaberinto("ArchivosNecesarios/Laberintos/laberintoPosta");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (LaberintoInvalidoException e) {
			e.printStackTrace();
		}
		
		JuegoConcreto juego = JuegoConcreto.getInstancia();
		Laberinto laberinto = juego.getLaberinto();
				
		FabricaDeFantasmitas fabrica = new FabricaDeFantasmitasConcreta();
		Personaje cazador = fabrica.fabricarFantasmitaCazador();
		
		Personaje chicho = fabrica.fabricarFantasmitaEmboscador();
		Personaje buba = fabrica.fabricarIndeciso();
		Personaje otroIndeciso = fabrica.fabricarIndeciso();
		
		juego.agregarPersonaje(cazador);
		juego.agregarPersonaje(buba);
		juego.agregarPersonaje(chicho);		
		juego.agregarPersonaje(otroIndeciso);

		/*
		 * Luego se instancian los objetos
		 */		
		ControladorJuego controlador = new ControladorJuego();
		
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		
		ajustarVentanaALaberinto(laberinto, ventana);
		ventana.setVisible(true);
		
		Skin skin= new SkinClasico();
		VistaJuego vistaJuego= new VistaJuego(juego,skin);
		vistaJuego.setPosicionable(new PosicionadorFijo(10,10));
				
		/*
		 * Se agrega cada personaje del juego y el juego quien es el encargado de verificar los choques
		 * 
		 */
		controlador.agregarObjetoVivo(juego); 
				
		/*
		 * Se agregan los objetos que actuan como vista a la lista de dibujables del controlador
		 * para que sean repintados al final de cada gameloop. TODOS LOS FANTASMAS Y EL PACMAN
		 */
		
		controlador.agregarDibujable(vistaJuego);
		
		/*
		 * Finalmente se establece el intervalo de sleep dentro del gameloop
		 * y se comienza a ejecutar
		 */
		controlador.setIntervaloSimulacion(30);
		
		/*
		 * inicio la reproduccion del audio
		 */
		
		SonidoJuego sonido= new SonidoJuego(juego);
		sonido.start();
		
		controlador.comenzarJuego();	
	}

	private static void ajustarVentanaALaberinto(Laberinto laberinto,
			VentanaPrincipal ventana) {
		ventana.setSize((int)(laberinto.getAncho()* ConstantesVista.AJUSTE_LABERINTO_ANCHO),(int)(laberinto.getAlto()*ConstantesVista.AJUSTE_LABERINTO_ALTO));
	}

}
