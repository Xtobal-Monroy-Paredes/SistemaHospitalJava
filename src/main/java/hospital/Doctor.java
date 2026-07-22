/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
package hospital;

public class Doctor {

    private int codigo;
    private String nombre;
    private String especialidad;

    public Doctor(int codigo, String nombre, String especialidad) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void mostrarDoctor() {

        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);

        System.out.println("---------------------------");
    }
    
    @Override
    public String toString() {

    return nombre;

}
}
