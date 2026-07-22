/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
package hospital;

public class Paciente {

    private int id;
    private String nombre;
    private int edad;
    private String dni;
    private String enfermedad;

    public Paciente(int id, String nombre, int edad, String dni, String enfermedad) {

        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.enfermedad = enfermedad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public void mostrarDatos() {

        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("DNI: " + dni);
        System.out.println("Enfermedad: " + enfermedad);

        System.out.println("---------------------------");
    }
    
    @Override
    public String toString() {

    return nombre;

}
}

