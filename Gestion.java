public class Gestion {
    private Secciones secciones;

    public Gestion() {
        secciones = new Secciones();
    }

    public String reservarAsientos(int seccion, int fila, int asiento) {
        int[][] lista = obtenerListaSeccion(seccion);
		String alerta = "";
        
        if (lista == null || fila < 1 || fila > lista.length || asiento < 1 || asiento > lista[0].length) {
            alerta = "Datos de asiento incorrectos.\n";
			return alerta;
        }

        if (lista[fila - 1][asiento - 1] == 1) {
            lista[fila - 1][asiento - 1] = 0;
            alerta = "Asiento reservado exitosamente.\n";
        } else {
            alerta = "El asiento ya está reservado.\n";
        }
		return alerta;
    }

    public String mostrarDisponibilidad(int seccion) {
        int[][] lista = obtenerListaSeccion(seccion);
		String resultado = "";
		String resultado1 = "";
		String resultado3 = "";

        if (lista == null) {
            resultado = "Seccion no valida.\n";
			return resultado;
        }

        for (int i = 0; i < lista.length; i++) {
            resultado = "Fila " + (i + 1) + ": \n";
            for (int j = 0; j < lista[i].length; j++) {
                resultado1 = (lista[i][j] == 1 ? "Disponible" : "Reservado") + " ";
				resultado = resultado + resultado1 + "\n";
            }
			resultado3 = resultado3 + resultado;
        }
		return resultado3;
    }

    public String cancelarReserva(int seccion, int fila, int asiento) {
        int[][] lista = obtenerListaSeccion(seccion);
		String alerta = "";
        
        if (lista == null || fila < 1 || fila > lista.length || asiento < 1 || asiento > lista[0].length) {
            alerta = "Datos de asiento incorrectos.\n";
			return alerta;
        }

        if (lista[fila - 1][asiento - 1] == 0) {
            lista[fila - 1][asiento - 1] = 1;
            alerta = "Reserva cancelada exitosamente.\n";
        } else {
            alerta = "El asiento ya está disponible.\n";
        }
		return alerta;
    }

    public String calcularIngresos() {
        int[] precios = {150, 100, 75, 50};
        int[] ingresos = new int[4];
        int[][][] listas = new int[][][]{secciones.getVip(), secciones.getPlatino(), secciones.getOro(), secciones.getPlata()};
		String texto = "Ingresos por seccion:\n";
		String ivip = "";
		String iplatino = "";
		String ioro = "";
		String iplata = "";
		

        for (int i = 0; i < listas.length; i++) {
            for (int j = 0; j < listas[i].length; j++) {
                for (int k = 0; k < listas[i][j].length; k++) {
                    if (listas[i][j][k] == 0) ingresos[i] += precios[i];
                }
            }
        }

		ivip = "VIP: $" + ingresos[0] + "\n";
        iplatino = "Platino: $" + ingresos[1] + "\n";
        ioro = "Oro: $" + ingresos[2] + "\n";
        iplata = "Plata: $" + ingresos[3] + "\n";
		texto = texto + ivip + iplatino + ioro + iplata;
		return texto;
    }

    private int[][] obtenerListaSeccion(int seccion) {
        switch (seccion) {
            case 1: return secciones.getVip();
            case 2: return secciones.getPlatino();
            case 3: return secciones.getOro();
            case 4: return secciones.getPlata();
            default: return null;
        }
    }
}