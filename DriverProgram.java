import java.util.Scanner;

public class DriverProgram {
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