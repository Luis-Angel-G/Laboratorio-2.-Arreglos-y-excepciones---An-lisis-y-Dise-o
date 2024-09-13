import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Secciones {
    private int[][] vip = new int[5][10];
    private int[][] platino = new int[8][12];
    private int[][] oro = new int[10][15];
    private int[][] plata = new int[12][20];

    public Secciones() {
        inicializarSecciones();
        cargarDatos();
    }

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

    public int[][] getVip() {
        return vip;
    }

    public int[][] getPlatino() {
        return platino;
    }

    public int[][] getOro() {
        return oro;
    }

    public int[][] getPlata() {
        return plata;
    }

    private void cargarDatos() {
        cargarSeccion("vip.csv", vip);
        cargarSeccion("platino.csv", platino);
        cargarSeccion("oro.csv", oro);
        cargarSeccion("plata.csv", plata);
    }

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

    public void guardarDatos() {
        guardarSeccion("vip.csv", vip);
        guardarSeccion("platino.csv", platino);
        guardarSeccion("oro.csv", oro);
        guardarSeccion("plata.csv", plata);
    }

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