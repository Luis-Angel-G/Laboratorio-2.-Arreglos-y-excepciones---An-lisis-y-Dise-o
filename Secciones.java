import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que gestiona las secciones de asientos en un auditorio. Proporciona métodos para
 * inicializar las secciones, cargar datos desde archivos CSV y guardar datos en archivos CSV.
 * 
 * <p>Autor: Luis Angel Girón Arévalo</p>
 * <p>Fecha de creación: 12/09/2024</p>
 * <p>Última modificación: 13/09/2024</p>
 */
public class Secciones {
    private int[][] vip = new int[5][10];
    private int[][] platino = new int[8][12];
    private int[][] oro = new int[10][15];
    private int[][] plata = new int[12][20];

    /**
     * Constructor de la clase {@code Secciones}.
     * Inicializa las secciones y carga los datos desde archivos CSV.
     */
    public Secciones() {
        inicializarSecciones();
        cargarDatos();
    }

    /**
     * Inicializa todas las secciones de asientos con el valor 1 (disponible).
     */
    private void inicializarSecciones() {
        for (int i = 0; i < vip.length; i++)
            for (int j = 0; j < vip[i].length; j++)
                vip[i][j] = 1;

        for (int i = 0; i < platino.length; i++)
            for (int j = 0; j < platino[i].length; j++)
                platino[i][j] = 1;

        for (int i = 0; i < oro.length; i++)
            for (int j = 0; j < oro[i].length; j++)
                oro[i][j] = 1;

        for (int i = 0; i < plata.length; i++)
            for (int j = 0; j < plata[i].length; j++)
                plata[i][j] = 1;
    }

    /**
     * Devuelve la matriz que representa la sección VIP.
     * 
     * @return La matriz de asientos para la sección VIP.
     */
    public int[][] getVip() {
        return vip;
    }

    /**
     * Devuelve la matriz que representa la sección Platino.
     * 
     * @return La matriz de asientos para la sección Platino.
     */
    public int[][] getPlatino() {
        return platino;
    }

    /**
     * Devuelve la matriz que representa la sección Oro.
     * 
     * @return La matriz de asientos para la sección Oro.
     */
    public int[][] getOro() {
        return oro;
    }

    /**
     * Devuelve la matriz que representa la sección Plata.
     * 
     * @return La matriz de asientos para la sección Plata.
     */
    public int[][] getPlata() {
        return plata;
    }

    /**
     * Carga los datos de las secciones desde archivos CSV.
     */
    private void cargarDatos() {
        cargarSeccion("vip.csv", vip);
        cargarSeccion("platino.csv", platino);
        cargarSeccion("oro.csv", oro);
        cargarSeccion("plata.csv", plata);
    }

    /**
     * Carga los datos de una sección desde un archivo CSV.
     * 
     * @param archivo El nombre del archivo CSV.
     * @param seccion La matriz de asientos a cargar.
     */
    private void cargarSeccion(String archivo, int[][] seccion) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int fila = 0;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                for (int i = 0; i < datos.length; i++) {
                    seccion[fila][i] = Integer.parseInt(datos[i]);
                }
                fila++;
            }
        } catch (IOException e) {
            System.out.println("Error al cargar datos de " + archivo + ": " + e.getMessage());
        }
    }

    /**
     * Guarda los datos de las secciones en archivos CSV.
     */
    public void guardarDatos() {
        guardarSeccion("vip.csv", vip);
        guardarSeccion("platino.csv", platino);
        guardarSeccion("oro.csv", oro);
        guardarSeccion("plata.csv", plata);
    }

    /**
     * Guarda los datos de una sección en un archivo CSV.
     * 
     * @param archivo El nombre del archivo CSV.
     * @param seccion La matriz de asientos a guardar.
     */
    private void guardarSeccion(String archivo, int[][] seccion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < seccion.length; i++) {
                for (int j = 0; j < seccion[i].length; j++) {
                    bw.write(seccion[i][j] + (j < seccion[i].length - 1 ? "," : ""));
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar datos en " + archivo + ": " + e.getMessage());
        }
    }
}