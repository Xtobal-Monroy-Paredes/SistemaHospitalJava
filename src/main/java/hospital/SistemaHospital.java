/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
package hospital;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;


public class SistemaHospital {
    private ArrayList<Paciente> pacientes;
    private ArrayList<Doctor> doctores;
    private HashSet<String> especialidades;
    private ArrayList<Cita> citas;
    private ArrayList<Usuario> usuarios;
    private Scanner sc;
    private SistemaHospital sistema;
    
    public ArrayList<Paciente> getPacientes() {

    PacienteDAO dao = new PacienteDAO();

    return dao.listar();

}

   public SistemaHospital() {

    pacientes = new ArrayList<>();
    doctores = new ArrayList<>();
    citas = new ArrayList<>();
    usuarios = new ArrayList<>();
    
    especialidades = new HashSet<>();

    sc = new Scanner(System.in);
    }
   

    public void registrarPaciente() {

        System.out.println("\n=== REGISTRO DE PACIENTE ===");

        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese DNI: ");
        String dni = sc.nextLine();

        System.out.print("Ingrese enfermedad: ");
        String enfermedad = sc.nextLine();

        Paciente nuevoPaciente = new Paciente(
                id,
                nombre,
                edad,
                dni,
                enfermedad
        );

        pacientes.add(nuevoPaciente);

        System.out.println("Paciente registrado correctamente.");
    }

    public void mostrarPacientes() {
        
       
        System.out.println("\n=== LISTA DE PACIENTES ===");

        if (pacientes.isEmpty()) {

            System.out.println("No hay pacientes registrados.");

        } else {

            for (Paciente p : pacientes) {
                p.mostrarDatos();
            }
        }
    }
    
    
    public void registrar(Paciente paciente) {

    PacienteDAO dao = new PacienteDAO();

    if (dao.insertar(paciente)) {

        System.out.println("Paciente registrado correctamente en MySQL.");

    } else {

        System.out.println("No se pudo registrar el paciente.");

    }

}

    
    public void mostrar() {

    mostrarPacientes();

}

    public void buscarPaciente() {

        System.out.print("\nIngrese DNI del paciente: ");

        String dniBuscar = sc.nextLine();

        boolean encontrado = false;

        for (Paciente p : pacientes) {

            if (p.getDni().equals(dniBuscar)) {

                System.out.println("\nPaciente encontrado:");
                p.mostrarDatos();

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Paciente no encontrado.");
        }
    }

    public void registrarDoctor() {

        System.out.println("\n=== REGISTRO DE DOCTOR ===");

        System.out.print("Ingrese código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese especialidad: ");
        String especialidad = sc.nextLine();

        Doctor nuevoDoctor = new Doctor(
                codigo,
                nombre,
                especialidad
        );

        doctores.add(nuevoDoctor);
        
        especialidades.add(especialidad);

        System.out.println("Doctor registrado correctamente.");
    }

    public void mostrarDoctores() {

        System.out.println("\n=== LISTA DE DOCTORES ===");

        if (doctores.isEmpty()) {

            System.out.println("No hay doctores registrados.");

        } else {

            for (Doctor d : doctores) {
                d.mostrarDoctor();
            }
        }
    }
    
    public void mostrarEspecialidades() {

    System.out.println("\n=== ESPECIALIDADES REGISTRADAS ===");

    if (especialidades.isEmpty()) {

        System.out.println("No hay especialidades registradas.");

    } else {

        for (String especialidad : especialidades) {

            System.out.println("- " + especialidad);

        }
    }
}

    private Paciente buscarPacientePorDni(String dni) {

        for (Paciente p : pacientes) {

            if (p.getDni().equals(dni)) {

                return p;
            }
        }

        return null;
    }



    public Doctor buscarDoctorPorCodigo(int codigo) {

    DoctorDAO dao = new DoctorDAO();

    return dao.buscarPorCodigo(codigo);

}


    public void menu() {

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println("      SISTEMA HOSPITALARIO");
            System.out.println("=================================");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Mostrar pacientes");
            System.out.println("3. Buscar paciente");
            System.out.println("4. Registrar doctor");
            System.out.println("5. Mostrar doctores");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarPaciente();
                    break;

                case 2:
                    mostrarPacientes();
                    break;

                case 3:
                    buscarPaciente();
                    break;

                case 4:
                    registrarDoctor();
                    break;

                case 5:
                    mostrarDoctores();
                    break;

                case 6:
                    System.out.println("\nSaliendo del sistema...");
                    break;

                default:
                    System.out.println("\nOpción inválida.");
            }

        
        } while (opcion != 6);
    } 
    public boolean validarUsuario(String usuario, String contraseña) {

    UsuarioDAO dao = new UsuarioDAO();

    return dao.validar(usuario, contraseña);

}
    
    public Paciente buscarPacientePorId(int id) {

    PacienteDAO dao = new PacienteDAO();

    return dao.buscarPorId(id);

}
    
    public boolean actualizarPaciente(int id,
        String nombre,
        int edad,
        String dni,
        String enfermedad) {

    PacienteDAO dao = new PacienteDAO();

    Paciente paciente = new Paciente(
            id,
            nombre,
            edad,
            dni,
            enfermedad
    );

    return dao.actualizar(paciente);

}
    
    public boolean eliminarPaciente(int id) {

    PacienteDAO dao = new PacienteDAO();

    return dao.eliminar(id);

}

// ===================== DOCTORES =====================

public void registrarDoctor(Doctor doctor) {

    DoctorDAO dao = new DoctorDAO();

    if (dao.insertar(doctor)) {

        System.out.println("Doctor registrado correctamente en MySQL.");

    } else {

        System.out.println("No se pudo registrar el doctor.");

    }

}

public ArrayList<Doctor> getDoctores() {

    DoctorDAO dao = new DoctorDAO();

    return dao.listar();

}

public boolean actualizarDoctor(int codigo,
        String nombre,
        String especialidad) {

    DoctorDAO dao = new DoctorDAO();

    Doctor doctor = new Doctor(
            codigo,
            nombre,
            especialidad
    );

    return dao.actualizar(doctor);

}

public boolean eliminarDoctor(int codigo) {

    DoctorDAO dao = new DoctorDAO();

    return dao.eliminar(codigo);

}
    
    public void registrarCita(Cita cita) {

    CitaDAO dao = new CitaDAO();

    dao.insertar(cita);

}
    
    public ArrayList<Cita> getCitas() {

    CitaDAO dao = new CitaDAO();

    return dao.listar();

}
    
    
    
} 