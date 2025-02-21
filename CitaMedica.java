import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CitaMedica {
    private String paciente;
    private String doctor;
    private LocalDate fecha;
    private LocalTime hora;

    // Formatos para validaciones
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");

    // Constructor
    public CitaMedica(String paciente, String doctor, String fecha, String hora) {
        this.paciente = paciente;
        this.doctor = doctor;
        setFecha(fecha);
        setHora(hora);
    }

    // Validar y establecer fecha
    public void setFecha(String fechaStr) {
        try {
            LocalDate fechaIngresada = LocalDate.parse(fechaStr, FORMATO_FECHA);
            if (!fechaIngresada.isBefore(LocalDate.now())) {
                this.fecha = fechaIngresada;
            } else {
                throw new IllegalArgumentException("La fecha no puede ser en el pasado.");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Usa dd/MM/yyyy");
        }
    }

    // Validar y establecer hora
    public void setHora(String horaStr) {
        try {
            LocalTime horaIngresada = LocalTime.parse(horaStr, FORMATO_HORA);
            if (horaIngresada.isAfter(LocalTime.of(7, 59)) && horaIngresada.isBefore(LocalTime.of(18, 1))) {
                this.hora = horaIngresada;
            } else {
                throw new IllegalArgumentException("La hora debe estar entre 08:00 y 18:00.");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de hora inválido. Usa HH:mm");
        }
    }

    public String getPaciente() {
        return paciente;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getFecha() {
        return fecha.format(FORMATO_FECHA);
    }

    public String getHora() {
        return hora.format(FORMATO_HORA);
    }

    // Representación en String
    @Override
    public String toString() {
        return "Cita con " + doctor + " para " + paciente + " el " + getFecha() + " a las " + getHora();
    }
}
