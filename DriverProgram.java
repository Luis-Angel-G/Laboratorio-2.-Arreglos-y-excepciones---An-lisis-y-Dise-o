import java.util.Scanner;

/**
 * Programa principal que proporciona un menú interactivo para gestionar reservas de asientos en un auditorio.
 * Permite al usuario realizar operaciones como reservar asientos, mostrar la disponibilidad de asientos, 
 * cancelar reservas y calcular ingresos mediante una interfaz de línea de comandos.
 * 
 * <p>Autor: Luis Angel Girón Arévalo</p>
 * <p>Fecha de creación: 12/09/2024</p>
 * <p>Última modificación: 13/09/2024</p>
 */
public class DriverProgram {
    /**
     * Método principal que ejecuta el programa.
     * Proporciona un menú para que el usuario seleccione una opción y realiza la operación correspondiente.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Reservar Asiento");
            System.out.println("2. Mostrar Disponibilidad");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Calcular Ingresos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese seccion (1: VIP, 2: Platino, 3: Oro, 4: Plata): ");
                    int seccion = teclado.nextInt();
                    System.out.print("Ingrese fila: ");
                    int fila = teclado.nextInt();
                    System.out.print("Ingrese asiento: ");
                    int asiento = teclado.nextInt();
                    System.out.print(gestion.reservarAsientos(seccion, fila, asiento));
                    break;
                case 2:
                    System.out.print("Ingrese seccion para mostrar disponibilidad (1: VIP, 2: Platino, 3: Oro, 4: Plata): ");
                    seccion = teclado.nextInt();
                    System.out.print(gestion.mostrarDisponibilidad(seccion));
                    break;
                case 3:
                    System.out.print("Ingrese seccion (1: VIP, 2: Platino, 3: Oro, 4: Plata): ");
                    seccion = teclado.nextInt();
                    System.out.print("Ingrese fila: ");
                    fila = teclado.nextInt();
                    System.out.print("Ingrese asiento: ");
                    asiento = teclado.nextInt();
                    System.out.print(gestion.cancelarReserva(seccion, fila, asiento));
                    break;
                case 4:
                    System.out.print(gestion.calcularIngresos());
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 5);
        
        teclado.close();
    }
}