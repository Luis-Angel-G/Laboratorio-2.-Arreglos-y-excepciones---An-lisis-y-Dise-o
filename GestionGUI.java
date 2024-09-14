import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que proporciona una interfaz gráfica para la gestión de reservas de asientos en el auditorio.
 * Permite realizar operaciones como reservar asientos, mostrar disponibilidad, cancelar reservas y calcular ingresos
 * mediante una interfaz gráfica de usuario.
 * 
 * <p>Autor: Luis Angel Girón Arévalo</p>
 * <p>Fecha de creación: 13/09/2024</p>
 * <p>Última modificación: 13/09/2024</p>
 */
public class GestionGUI extends JFrame {
    private Gestion gestion;
    private JTextArea textArea;

    /**
     * Constructor de la clase GestionGUI.
     * Configura la interfaz gráfica e inicializa los botones para las operaciones.
     */
    public GestionGUI() {
        gestion = new Gestion();
        setTitle("Gestión de Reservas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 5));

        JButton btnReservar = new JButton("Reservar Asiento");
        JButton btnMostrar = new JButton("Mostrar Disponibilidad");
        JButton btnCancelar = new JButton("Cancelar Reserva");
        JButton btnCalcular = new JButton("Calcular Ingresos");
        JButton btnSalir = new JButton("Salir");

        panelBotones.add(btnReservar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnCancelar);
        panelBotones.add(btnCalcular);
        panelBotones.add(btnSalir);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(panelBotones, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        btnReservar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reservarAsiento();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDisponibilidad();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarReserva();
            }
        });

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularIngresos();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * Método para reservar un asiento.
     * Muestra un diálogo para que el usuario ingrese la sección, fila y asiento, y luego procesa la reserva.
     */
    private void reservarAsiento() {
        try {
            int seccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese sección (1: VIP, 2: Platino, 3: Oro, 4: Plata):"));
            int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila:"));
            int asiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese asiento:"));
            String resultado = gestion.reservarAsientos(seccion, fila, asiento);
            textArea.append(resultado + "\n");
        } catch (NumberFormatException e) {
            textArea.append("Entrada no válida. Por favor, ingrese números.\n");
        }
    }

    /**
     * Método para mostrar la disponibilidad de asientos en una sección.
     * Muestra un diálogo para que el usuario ingrese la sección y luego muestra la disponibilidad en el área de texto.
     */
    private void mostrarDisponibilidad() {
        try {
            int seccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese sección para mostrar disponibilidad (1: VIP, 2: Platino, 3: Oro, 4: Plata):"));
            String resultado = gestion.mostrarDisponibilidad(seccion);
            textArea.append(resultado + "\n");
        } catch (NumberFormatException e) {
            textArea.append("Entrada no válida. Por favor, ingrese números.\n");
        }
    }

    /**
     * Método para cancelar una reserva de asiento.
     * Muestra un diálogo para que el usuario ingrese la sección, fila y asiento, y luego procesa la cancelación de la reserva.
     */
    private void cancelarReserva() {
        try {
            int seccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese sección (1: VIP, 2: Platino, 3: Oro, 4: Plata):"));
            int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila:"));
            int asiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese asiento:"));
            String resultado = gestion.cancelarReserva(seccion, fila, asiento);
            textArea.append(resultado + "\n");
        } catch (NumberFormatException e) {
            textArea.append("Entrada no válida. Por favor, ingrese números.\n");
        }
    }

    /**
     * Método para calcular los ingresos totales por sección.
     * Calcula y muestra los ingresos generados por las reservas en cada sección.
     */
    private void calcularIngresos() {
        String resultado = gestion.calcularIngresos();
        textArea.append(resultado + "\n");
    }

    /**
     * Método principal que inicia la interfaz gráfica.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GestionGUI().setVisible(true);
            }
        });
    }
}