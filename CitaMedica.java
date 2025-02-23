import java.text.DecimalFormat;


//Confirmar=1 --Info Correcta
//Hora permitida para cita de 8 a 19:59
// Fecha permitida de 25 de febrero de 2025 hasta el 31 de diciembre de 2026
//Si es la fecha de 25 de febrero de 2025 la cita se puede realizar a partir de las 16:00, antes no


public class CitaMedica {

    private String paciente;
    private String doctor;
    private int dia;
    private int mes;
    private int año;
    private int hora;
    private int minutos;


    public CitaMedica() {
        this.paciente = "Paciente";
        this.doctor = "Doctor";
        dia = 25;
        mes = 2;
        año = 2025;
        hora = 13;
        minutos = 0;       
    }

    public CitaMedica(int d, int m, int a, int h, int min) {
        this.paciente = "Paciente";
        this.doctor = "Doctor";
        dia = d;
        mes = m;
        año = a;
        hora = h;
        minutos = min;       
    }


    public CitaMedica(String paciente, String doctor, int d, int m, int a, int h, int min) {
        this.paciente = paciente;
        this.doctor = doctor;
        dia = d;
        mes = m;
        año = a;
        hora = h;
        minutos = min;       
    }

    public void setPaciente(String paciente) { //Porque se debe de poner esto!!!!!
        this.paciente = paciente;
    }

    public void setDoctor(String doctor) { //Porque se debe de poner esto!!!!!
        this.doctor = doctor;
    }

    public int setHora(int h){ 
        int confirmar;

        if(dia==25 && mes == 2 && año == 2025){
            if (h >= 16 && h < 20) {
                hora = h;
                confirmar = 1;
            } else {
                System.out.println(h + " no es una hora valida");
                hora = 16;  
                confirmar = 0;
            }
        }

        else{
        if (h >= 8 && h < 20) {
            hora = h;
            confirmar = 1;
        } else {
            System.out.println(h + " no es una hora valida");
            hora = 8;  
            confirmar = 0;
        }

    }
        return confirmar;
    }

    public int setMinutos(int min){
        int confirmar;
            if (min >= 0 && min < 60) {
            minutos = min;
            confirmar = 1;
        }
        else {
            System.out.println(min + " no son minutos validos");
            minutos = 0;
            confirmar = 0;
        }
    
        return confirmar;
    }
    


     //definir mis funciones setters
     public int setDia(int d){
        /*La función dia mes regresa el limite de dias del mes
         * Comparamos si el dia es mayor a 0 y menor o igual a los dias del mes
         */
        int diasMes=diasMes(mes, año);
        int confirmar;

        if (año>2025 || mes > 2){
            if (d > 0 && d <= diasMes){
                dia=d;
                confirmar = 1;
            }
            else{
                System.out.println(d+" no es un dia valido");
                dia=1;
                confirmar = 0;
            }            
        }
        else{ 
                if (d > 24 && d <= diasMes){
                    dia=d;
                    confirmar = 1;
                }
                else{
                    System.out.println(d+" no es un dia valido");
                    dia=25;
                    confirmar = 0;
                }
            
        }     
        return confirmar;
    }


 
    public int setMes(int m){ //se pone public int para poder regresar un valor

        int confirmar;

        if (año>2025){
            if (m>0 && m<13){
                mes=m;
                confirmar = 1;
            }
            else{
                System.out.println(m+" no es un mes valido");
                mes=1;
                confirmar = 0;
            }
        }
        else{
            if (m>1 && m<13){
                mes=m;
                confirmar = 1;
            }
            else{
                System.out.println(m+" no es un mes valido");
                mes=2;
                confirmar = 0;
            }            
        }

        setDia(dia);
        return confirmar;
    }
 
    public int setAño(int a){
        int confirmar;

        if (a>2024&&a<2027){
            año=a;
            confirmar = 1;
        }
        else{
            System.out.println(a+" no es un año valido");
            año=2025;
            confirmar = 0;
        }
 
        setDia(dia);
        return confirmar;
    }
   
    //función que identifica los dias del mes
    private int diasMes(int m, int a){
        int diasDelMes []={0,31,28,31,30,31,30,31,31,30,31,30,31};
        if (m==2 && bisiesto(a)){
            return 29;
        }
        return diasDelMes[m];
    }
 
    //función que identifica si un año es bisiesto
    private boolean bisiesto(int a){
        return a%4==0 && (a%100!=0 || a%400==0);
    }


    public String toFechaAbreviadaString(){
        DecimalFormat formateador = new DecimalFormat("00");
        return formateador.format(dia)+"/"+
               formateador.format(mes)+"/"+año;
    }

        public String toFechaAbreviadaStringTexto(){
        DecimalFormat formateador = new DecimalFormat("00");
        return formateador.format(dia)+"/"+
              MesTexto(mes) +"/"+año;
    }


private String MesTexto(int m){
    String MesEnTexto [] = {"Nada", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    return MesEnTexto[m];
}

    public String toHoraString(){
        DecimalFormat twoDigits = new DecimalFormat("00");

		return twoDigits.format(hora) + ":" + twoDigits.format(minutos) + ":00";
    }


    public String toTotalString()
	{
		return "Cita confirmada con Dr." + doctor + " para " + paciente + " el " + toFechaAbreviadaStringTexto() + " a las " + toHoraString();
	}



    public String confirmarCita(int d, int m, int a, int h, int min) {
        int confirmarAño = setAño(a);
        int confirmarMes = setMes(m);
        int confirmarDia = setDia(d);
        int confirmarHora = setHora(h);
        int confirmarMinutos = setMinutos(min);
        
        if (confirmarAño == 1 && confirmarMes == 1 && confirmarDia == 1 && confirmarHora == 1 && confirmarMinutos == 1) {
            return toTotalString(); // Retorna la confirmación de la cita
        } else {
            return "No se puede confirmar su cita debido a que la fecha o la hora son incorrectas.";
        }
    }
    


    public String getPaciente() {
        return paciente;
    }

    public String getDoctor() {
        return doctor;
    }
    public int getDia(){
        return dia;
    }
 
    public int getMes(){
        return mes;
    }
 
    public int getAño(){
        return año;
    }

    public int getHora(){
        return hora;
    }
    
    public int getMinutos(){
        return minutos;
    }


    
}
