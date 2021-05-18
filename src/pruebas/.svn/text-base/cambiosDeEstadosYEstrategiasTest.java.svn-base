package pruebas;

import ModeloDeDominio.Personajes.FabricaDeFantasmitas;
import ModeloDeDominio.Personajes.FabricaDeFantasmitasConcreta;
import ModeloDeDominio.Personajes.FantasmitaConcreto;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.Cazador;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.CazadorComido;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.CazadorPerseguido;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.Emboscador;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.EmboscadorComido;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.EmboscadorPerseguido;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.Indeciso;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.IndecisoComido;
import ModeloDeDominio.Personajes.EstadosDelFantasmita.IndecisoPerseguido;
import junit.framework.TestCase;

public class cambiosDeEstadosYEstrategiasTest extends TestCase {

	private FantasmitaConcreto cazador;
	private FantasmitaConcreto emboscador;
	private FantasmitaConcreto indeciso;
	private FabricaDeFantasmitas fabrica;

	protected void setUp() throws Exception {
		super.setUp();
		fabrica = new FabricaDeFantasmitasConcreta();
		cazador = fabrica.fabricarFantasmitaCazador();
		emboscador = fabrica.fabricarFantasmitaEmboscador();
		indeciso = fabrica.fabricarIndeciso();
	}

	public void testPersecucionEscapeCazador(){
		assertEquals(cazador.getEstado().getClass(), Cazador.class);
		cazador.cambiarPersecucionYEscape();
		assertEquals(cazador.getEstado().getClass(), CazadorPerseguido.class);
		cazador.cambiarPersecucionYEscape();
		assertEquals(cazador.getEstado().getClass(), Cazador.class);
		cazador.cambiarComidoYNormal();
		assertEquals(cazador.getEstado().getClass(), Cazador.class);
	}

	public void testPersecucionEscapeIndeciso() {
		assertEquals(indeciso.getEstado().getClass(), Indeciso.class);
		indeciso.cambiarPersecucionYEscape();
		assertEquals(indeciso.getEstado().getClass(), IndecisoPerseguido.class);
		indeciso.cambiarPersecucionYEscape();
		assertEquals(indeciso.getEstado().getClass(), Indeciso.class);	
		indeciso.cambiarComidoYNormal();
		assertEquals(indeciso.getEstado().getClass(), Indeciso.class);
	}

	public void testPesecucioEscapeEmboscador() {
		assertEquals(emboscador.getEstado().getClass(), Emboscador.class);
		emboscador.cambiarPersecucionYEscape();
		assertEquals(emboscador.getEstado().getClass(), EmboscadorPerseguido.class);
		emboscador.cambiarPersecucionYEscape();
		assertEquals(emboscador.getEstado().getClass(), Emboscador.class);
		emboscador.cambiarComidoYNormal();
		assertEquals(emboscador.getEstado().getClass(), Emboscador.class);
	}

	public void testCambioComidoAVivoCazador(){
		assertEquals(cazador.getEstado().getClass(), Cazador.class);
		cazador.cambiarPersecucionYEscape();
		assertEquals(cazador.getEstado().getClass(), CazadorPerseguido.class);
		cazador.cambiarComidoYNormal();
		assertEquals(cazador.getEstado().getClass(), CazadorComido.class);
		cazador.cambiarPersecucionYEscape();
		assertEquals(cazador.getEstado().getClass(), CazadorComido.class);
	}		

	public void testComidoVivoIndeciso() {
		assertEquals(indeciso.getEstado().getClass(), Indeciso.class);
		indeciso.cambiarPersecucionYEscape();
		assertEquals(indeciso.getEstado().getClass(), IndecisoPerseguido.class);
		indeciso.cambiarComidoYNormal();
		assertEquals(indeciso.getEstado().getClass(), IndecisoComido.class);
		indeciso.cambiarPersecucionYEscape();
		assertEquals(indeciso.getEstado().getClass(), IndecisoComido.class);
	}

	public void testCambioComidoVivoEmboscador() {
		assertEquals(emboscador.getEstado().getClass(), Emboscador.class);
		emboscador.cambiarPersecucionYEscape();
		assertEquals(emboscador.getEstado().getClass(), EmboscadorPerseguido.class);
		emboscador.cambiarComidoYNormal();
		assertEquals(emboscador.getEstado().getClass(), EmboscadorComido.class);
		emboscador.cambiarPersecucionYEscape();
		assertEquals(emboscador.getEstado().getClass(), EmboscadorComido.class);
	}
}
