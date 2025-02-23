import java.awt.*;
import javax.swing.*;

public class CitaMedicaFrame {

    private CitaMedica cita;
    private JTextField dayField, monthField, yearField, hourField, minuteField, pacienteField, doctorField;
    private JLabel displayLabel;

    public CitaMedicaFrame() {
        cita = new CitaMedica();

        JFrame frame = new JFrame("GUI - Registro Cita Médica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(3, 3, 5, 5));





        pacienteField = createField(frame, "Paciente:");
        doctorField = createField(frame, "Doctor:");
        yearField = createField(frame, "Año:");
        monthField = createField(frame, "Mes:");        
        dayField = createField(frame, "Día:");
        hourField = createField(frame, "Hora:");
        minuteField = createField(frame, "Minutos:");

        displayLabel = new JLabel(getCitaMedicaString(), SwingConstants.CENTER);
        frame.add(displayLabel);

        JButton confirmationButton = new JButton("Confirmar Cita");
        frame.add(confirmationButton);

        pacienteField.addActionListener(e -> updatePaciente());
        doctorField.addActionListener(e -> updateDoctor());
        yearField.addActionListener(e -> updateYear());       
        monthField.addActionListener(e -> updateMonth());
        dayField.addActionListener(e -> updateDay());
        hourField.addActionListener(e -> updateHour());
        minuteField.addActionListener(e -> updateMinute());
        confirmationButton.addActionListener(e -> Confirmation());

        frame.setVisible(true);
    }

    private JTextField createField(JFrame frame, String labelText) {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel(labelText));
        JTextField field = new JTextField(5);
        panel.add(field);
        frame.add(panel);
        return field;
    }

    private void updatePaciente() {
        cita.setPaciente(pacienteField.getText());
        updateDisplay();
    }

    private void updateDoctor() {
        cita.setDoctor(doctorField.getText());
        updateDisplay();
    }

    private void updateYear() {
        cita.setAño(Integer.parseInt(yearField.getText()));
        updateDisplay();
    }

    private void updateMonth() {
        cita.setMes(Integer.parseInt(monthField.getText()));
        updateDisplay();
    }


    private void updateDay() {
        cita.setDia(Integer.parseInt(dayField.getText()));
        updateDisplay();
    }

    private void updateHour() {
        cita.setHora(Integer.parseInt(hourField.getText()));
        updateDisplay();
    }

    private void updateMinute() {
        cita.setMinutos(Integer.parseInt(minuteField.getText()));
        updateDisplay();
    }

    private void Confirmation() {
        int d = Integer.parseInt(dayField.getText());
        int m = Integer.parseInt(monthField.getText());
        int a = Integer.parseInt(yearField.getText());
        int h = Integer.parseInt(hourField.getText());
        int min = Integer.parseInt(minuteField.getText());

        // Mostrar resultado de la confirmación en la etiqueta
        String confirmacion = cita.confirmarCita(d, m, a, h, min);
        displayLabel.setText(confirmacion);
    }

    private void updateDisplay() {
        displayLabel.setText(getCitaMedicaString());
    }

    private String getCitaMedicaString() {
        return "Paciente: " + cita.getPaciente() + 
               " Doctor: " + cita.getDoctor() + "\n" + 
               " Fecha: " + cita.toFechaAbreviadaString() + "  |  " + cita.toFechaAbreviadaStringTexto() + "\n" + 
               "Hora: " + cita.toHoraString();
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CitaMedicaFrame::new);
    }
}
