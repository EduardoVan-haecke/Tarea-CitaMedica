import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CitaMedicaTest {

    @Test
   public void testCitaValida() {
        CitaMedica cita = new CitaMedica("Juan Pérez", "Dr. López", "15/04/2024", "10:30");
        //assert cita.toString().equals("Cita con Dr. López  para Juan Pérez el 15/04/2024 a las 10:30"):"Error";
        assertEquals("Juan Pérez", cita.getPaciente());
        assertEquals("Dr. López", cita.getDoctor());
        assertEquals("15/04/2024", cita.getFecha());
        assertEquals("10:30", cita.getHora());
    }
/* 
    @Test
    void testFechaInvalida() {
        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica("Ana Gómez", "Dr. García", "01/01/2020", "09:00");
        });
        assertEquals("La fecha no puede ser en el pasado.", excepcion.getMessage());
    }

    @Test
    void testHoraInvalida() {
        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica("Carlos Ruiz", "Dra. Fernández", "20/05/2024", "19:00");
        });
        assertEquals("La hora debe estar entre 08:00 y 18:00.", excepcion.getMessage());
    }*/
}
