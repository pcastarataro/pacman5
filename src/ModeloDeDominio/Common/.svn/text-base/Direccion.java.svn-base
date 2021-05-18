package ModeloDeDominio.Common;

public enum Direccion {
	ARRIBA,DERECHA,ABAJO,IZQUIERDA, NULA;

	public Direccion direccionContraria() {
		switch (this) {
		case ARRIBA:
			return ABAJO;
		case ABAJO:
			return ARRIBA;
		case DERECHA:
			return IZQUIERDA;
		case IZQUIERDA:
			return DERECHA;
		default:
			return NULA;
		}
	}
}

