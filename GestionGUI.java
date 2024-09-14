import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionGUI extends JFrame {
    private Gestion gestion;
    private JTextArea textArea;

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

    private void reservarAsiento() {
        try {
            int seccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese seccion (1: VIP, 2: Platino, 3: Oro, 4: Plata):"));
            int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila:"));
            int asiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese asiento:"));
            String resultado = gestion.reservarAsientos(seccion, fila, asiento);
            textArea.append(resultado + "\n");
        } catch (NumberFormatException e) {
            textArea.append("Entrada no válida. Por favor, ingrese números.\n");
        }
    }

    private void mostrarDisponibilidad() {
        try {
            int seccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese seccion para mostrar disponibilidad (1: VIP, 2: Platino, 3: Oro, 4: Plata):"));
            String resultado = gestion.mostrarDisponibilidad(seccion);
            textArea.append(resultado + "\n");
        } catch (NumberFormatException e) {
            textArea.append("Entrada no válida. Por favor, ingrese números.\n");
        }
    }

    private void cancelarReserva() {
        try {
            int seccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese seccion (1: VIP, 2: Platino, 3: Oro, 4: Plata):"));
            int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila:"));
            int asiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese asiento:"));
            String resultado = gestion.cancelarReserva(seccion, fila, asiento);
            textArea.append(resultado + "\n");
        } catch (NumberFormatException e) {
            textArea.append("Entrada no válida. Por favor, ingrese números.\n");
        }
    }

    private void calcularIngresos() {
        String resultado = gestion.calcularIngresos();
        textArea.append(resultado + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GestionGUI().setVisible(true);
            }
        });
    }
}