import org.junit.Test;
import static org.junit.Assert.*;

public class TestCitaMedica {

    @Test
    public void testGeneral() {
        CitaMedica cita = new CitaMedica("Pedro", "Perez",15, 5, 2025, 10, 30);
        assertEquals("Cita confirmada con Dr.Perez para Pedro el 15/Mayo/2025 a las 10:30:00", cita.toTotalString());
    }

    @Test
    public void testFechaCorrecta() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2025);        
        cita.setMes(3);
        cita.setDia(1);
        assertEquals("01/03/2025", cita.toFechaAbreviadaString());
    }


    
    @Test
    public void testDiaFueraDeRangoInferiorAño() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2023);        
        cita.setMes(9);
        cita.setDia(26);
        assertEquals("26/09/2025", cita.toFechaAbreviadaString());
    }

    @Test
    public void testDiaFueraDeRangoSuperiorAño() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2027);        
        cita.setMes(9);
        cita.setDia(26);
        assertEquals("26/09/2025", cita.toFechaAbreviadaString());
    }

    //PRUEBAS 2025

    @Test
    public void testDiaFueraDeRangoInferiorFebrero2025() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2025);        
        cita.setMes(2);
        cita.setDia(24);
        assertEquals("25/02/2025", cita.toFechaAbreviadaString());
    }

    public void testDiaFueraDeRangoSuperiorFebrero2025() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2025);        
        cita.setMes(2);
        cita.setDia(29);
        assertEquals("25/02/2025", cita.toFechaAbreviadaString());
    }


    @Test
    public void testDiaFueraDeRangoInferiorMes2025() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2025);        
        cita.setMes(0);
        cita.setDia(26);
        assertEquals("26/02/2025", cita.toFechaAbreviadaString());
    }

    @Test
    public void testDiaFueraDeRangoSuperiorMes2025() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2025);        
        cita.setMes(13);
        cita.setDia(26);
        assertEquals("26/02/2025", cita.toFechaAbreviadaString());
    }



    //PRUEBAS 2026


    @Test
    public void testDiaFueraDeRangoInferiorMes2026() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2026);        
        cita.setMes(0);
        cita.setDia(26);
        assertEquals("26/01/2026", cita.toFechaAbreviadaString());
    }

    @Test
    public void testDiaFueraDeRangoSuperiorMes2026() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2026);        
        cita.setMes(13);
        cita.setDia(26);
        assertEquals("26/01/2026", cita.toFechaAbreviadaString());
    }

    @Test
    public void testDiaFueraDeRangoInferiorEnero2026() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2026);        
        cita.setMes(1);
        cita.setDia(0);
        assertEquals("01/01/2026", cita.toFechaAbreviadaString());
    }


    @Test
    public void testDiaFueraDeRangoInferiorFebrero2026() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2026);        
        cita.setMes(2);
        cita.setDia(0);
        assertEquals("01/02/2026", cita.toFechaAbreviadaString());
    }






    @Test
    public void testDiaFueraDeRangoSuperiorEnero2026() {
        CitaMedica cita = new CitaMedica();

        cita.setAño(2026);
        cita.setMes(1);
        cita.setDia(32);        
        
        assertEquals("01/01/2026", cita.toFechaAbreviadaString());
    }

    @Test
    public void testDiaFueraDeRangoSuperiorFebrero2026() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2026);        
        cita.setMes(2);
        cita.setDia(29);
        assertEquals("01/02/2026", cita.toFechaAbreviadaString());
    }








    //PRUEBAS HORA


    @Test
    public void testHoraLimiteSuperior() {
        CitaMedica cita = new CitaMedica();
        cita.setAño(2025);        
        cita.setMes(2);
        cita.setDia(26); 

        cita.setHora(8);
        cita.setMinutos(00);    
        
        assertEquals("08:00:00", cita.toHoraString());
    }


    @Test
    public void testHoraLimiteInferior() {
        CitaMedica cita = new CitaMedica();
        cita.setAño(2025);        
        cita.setMes(2);
        cita.setDia(26); 

        cita.setHora(19);
        cita.setMinutos(59);    
        
        assertEquals("19:59:00", cita.toHoraString());
    }

    @Test
    public void testHoraFueraDeRangoInferiorHora() {
        CitaMedica cita = new CitaMedica();
        cita.setAño(2025);        
        cita.setMes(2);
        cita.setDia(26);        

        cita.setHora(7);
        cita.setMinutos(59); 
        
        assertEquals("08:59:00", cita.toHoraString());
    }


    @Test
    public void testHoraFueraDeRangoInferiorMinutos() {
        CitaMedica cita = new CitaMedica();
        cita.setAño(2025);        
        cita.setMes(2);
        cita.setDia(26);         

        cita.setHora(8);
        cita.setMinutos(-1); 
        
        assertEquals("08:00:00", cita.toHoraString());
    }


    @Test
    public void testHoraFueraDeRangoSuperiorHora() {
        CitaMedica cita = new CitaMedica();
        cita.setAño(2025);        
        cita.setMes(2);
        cita.setDia(26);       

        cita.setHora(20);
        cita.setMinutos(59); 
        
        assertEquals("08:59:00", cita.toHoraString());
    }


    @Test
    public void testHoraFueraDeRangoSuperiorMinutos() {
        CitaMedica cita = new CitaMedica();
        cita.setAño(2025);        
        cita.setMes(2);
        cita.setDia(26);    

        cita.setHora(8);
        cita.setMinutos(61); 
        
        assertEquals("08:00:00", cita.toHoraString());
    }


    @Test
    public void testHoraFueraDeRangoInferior25_02_2025() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2025);        
        cita.setMes(2);
        cita.setDia(25);      

        cita.setHora(8);
        cita.setMinutos(35); 
        
        assertEquals("16:35:00", cita.toHoraString());
    }


    @Test
    public void testHoraFueraDeRangoSuperior25_02_2025() {
        CitaMedica cita = new CitaMedica();
        
        cita.setAño(2025);        
        cita.setMes(2);
        cita.setDia(25);      

        cita.setHora(20);
        cita.setMinutos(35); 
        
        assertEquals("16:35:00", cita.toHoraString());
    }

    @Test
    public void testAlNoColocarDoctorniPaciente() {
        CitaMedica cita = new CitaMedica(15, 5, 2025, 10, 30);
        assertEquals("Cita confirmada con Dr.Doctor para Paciente el 15/Mayo/2025 a las 10:30:00", cita.toTotalString());
    }



}
