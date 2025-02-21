import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CitaMedicaGUI extends JFrame {
    private JTextField txtPaciente, txtDoctor, txtFecha, txtHora;
    private JLabel lblResultado;
    private JButton btnRegistrar;

    public CitaMedicaGUI() {
        setTitle("Registro de Citas Médicas");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Creación de componentes
        add(new JLabel("Paciente:"));
        txtPaciente = new JTextField();
        add(txtPaciente);

        add(new JLabel("Doctor:"));
        txtDoctor = new JTextField();
        add(txtDoctor);

        add(new JLabel("Fecha (dd/MM/yyyy):"));
        txtFecha = new JTextField();
        add(txtFecha);

        add(new JLabel("Hora (HH:mm):"));
        txtHora = new JTextField();
        add(txtHora);

        btnRegistrar = new JButton("Registrar Cita");
        add(btnRegistrar);

        lblResultado = new JLabel(" ");
        add(lblResultado);

        // Acción del botón
        btnRegistrar.addActionListener((ActionEvent e) -> registrarCita());

        setVisible(true);
    }

    private void registrarCita() {
        try {
            CitaMedica cita = new CitaMedica(txtPaciente.getText(), txtDoctor.getText(), txtFecha.getText(), txtHora.getText());
            lblResultado.setText("Cita registrada: " + cita);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
