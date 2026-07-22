package hospital;


public class Cita {

    private int codigo;
    private Paciente paciente;
    private Doctor doctor;
    private String fecha;

    public Cita(int codigo, Paciente paciente, Doctor doctor, String fecha) {

        this.codigo = codigo;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
// getters
    }

    public int getCodigo() {
        return codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getFecha() {
        return fecha;
    }
    
    public void mostrarCita() {

        System.out.println("--- DETALLE DE CITA ---");
        System.out.println("Fecha: " + fecha);
        System.out.println("Paciente: " + paciente.getNombre() + " (DNI: " + paciente.getDni() + ")");
        System.out.println("Doctor: " + doctor.getNombre() + " (" + doctor.getEspecialidad() + ")");
        System.out.println("---------------------------");

    }
    
    //setters

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

}