package examples;

import es.uji.belfern.generador.GeneradorDatosINE;

public final class Principal {
	private Principal() {
		super();
	}

	private void ejecuta() {
		
		GeneradorDatosINE ine = new GeneradorDatosINE();
		System.out.println("Hombre: " + ine.getNombreHombre());
		System.out.println("Mujer: " + ine.getNombreMujer());
		System.out.println("Nombre: " + ine.getNombre());
		String provincia = ine.getProvincia();
		System.out.println("Provincia: " + provincia);
		System.out.println("Poblacion: " + ine.getPoblacion(provincia));
		System.out.println("DNI: " + ine.getNIF());
	}

	public static void main(String[] args) {
		new Principal().ejecuta();
	}
}
