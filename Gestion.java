/**
 * Clase que gestiona las operaciones relacionadas con la reserva de asientos en un auditorio.
 * Permite reservar asientos, mostrar la disponibilidad de asientos, cancelar reservas y calcular los ingresos generados por las reservas.
 * 
 * <p>Autor: Luis Angel Girón Arévalo</p>
 * <p>Fecha de creación: 12/09/2024</p>
 * <p>Última modificación: 13/09/2024</p>
 */
public class Gestion {
    private Secciones secciones;

    /**
     * Constructor de la clase {@code Gestion}.
     * Inicializa el objeto {@code Secciones} que gestiona los datos de las secciones de asientos.
     */
    public Gestion() {
        secciones = new Secciones();
    }

    /**
     * Reserva un asiento en una sección específica.
     * 
     * @param seccion Número de la sección (1 para VIP, 2 para Platino, 3 para Oro, 4 para Plata).
     * @param fila Número de la fila del asiento.
     * @param asiento Número del asiento en la fila.
     * @return Un mensaje indicando el resultado de la operación.
     */
    public String reservarAsientos(int seccion, int fila, int asiento) {
        int[][] lista = obtenerListaSeccion(seccion);
        String alerta = "";

        if (lista == null || fila < 1 || fila > lista.length || asiento < 1 || asiento > lista[0].length) {
            alerta = "Datos de asiento incorrectos.\n";
            return alerta;
        }

        if (lista[fila - 1][asiento - 1] == 1) {
            lista[fila - 1][asiento - 1] = 0;
            secciones.guardarDatos();
            alerta = "Asiento reservado exitosamente.\n";
        } else {
            alerta = "El asiento ya esta reservado.\n";
        }
        return alerta;
    }

    /**
     * Muestra la disponibilidad de asientos en una sección específica.
     * 
     * @param seccion Número de la sección (1 para VIP, 2 para Platino, 3 para Oro, 4 para Plata).
     * @return Un mensaje con la disponibilidad de los asientos en la sección.
     */
    public String mostrarDisponibilidad(int seccion) {
        int[][] lista = obtenerListaSeccion(seccion);
        String resultado = "";
        String resultado1 = "";
        String resultado3 = "";
		String[] abecedario = {A, B, C, D, E, F, G, H, I, J, K, L, M, N, Ñ, O, P, Q, R, S, T, U, V, W, X, Y, Z};

        if (lista == null) {
            resultado = "Sección no valida.\n";
            return resultado;
        }

        for (int i = 0; i < lista.length; i++) {
            resultado = "Fila " + (i + 1) + ": \n";
            for (int j = 0; j < lista[i].length; j++) {
                resultado1 = abecedario[j] + "\n" + (lista[i][j] == 1 ? "Disponible" : "Reservado") + " ";
                resultado = resultado + resultado1 + "\n";
            }
            resultado3 = resultado3 + resultado;
        }
        return resultado3;
    }

    /**
     * Cancela una reserva de asiento en una sección específica.
     * 
     * @param seccion Número de la sección (1 para VIP, 2 para Platino, 3 para Oro, 4 para Plata).
     * @param fila Número de la fila del asiento.
     * @param asiento Número del asiento en la fila.
     * @return Un mensaje indicando el resultado de la operación.
     */
    public String cancelarReserva(int seccion, int fila, int asiento) {
        int[][] lista = obtenerListaSeccion(seccion);
        String alerta = "";

        if (lista == null || fila < 1 || fila > lista.length || asiento < 1 || asiento > lista[0].length) {
            alerta = "Datos de asiento incorrectos.\n";
            return alerta;
        }

        if (lista[fila - 1][asiento - 1] == 0) {
            lista[fila - 1][asiento - 1] = 1;
            secciones.guardarDatos();
            alerta = "Reserva cancelada exitosamente.\n";
        } else {
            alerta = "El asiento ya esta disponible.\n";
        }
        return alerta;
    }

    /**
     * Calcula los ingresos generados por las reservas en cada sección.
     * 
     * @return Un mensaje con los ingresos por sección y el total.
     */
    public String calcularIngresos() {
        int[] precios = {150, 100, 75, 50};
        int[] ingresos = new int[4];
        int[][][] listas = new int[][][]{secciones.getVip(), secciones.getPlatino(), secciones.getOro(), secciones.getPlata()};
        String texto = "Ingresos por seccion:\n";
        String ivip = "";
        String iplatino = "";
        String ioro = "";
        String iplata = "";
        String total = "";

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
        total = "Total: $" + (ingresos[0] + ingresos[1] + ingresos[2] + ingresos[3]) + "\n";
        texto = texto + ivip + iplatino + ioro + iplata + total;
        return texto;
    }

    /**
     * Obtiene la matriz de asientos para una sección específica.
     * 
     * @param seccion Número de la sección (1 para VIP, 2 para Platino, 3 para Oro, 4 para Plata).
     * @return La matriz de asientos para la sección especificada, o {@code null} si la sección no es válida.
     */
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