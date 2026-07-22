/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class CitaDAO {
    
    public boolean insertar(Cita cita) {

    String sql = "INSERT INTO citas(codigo,paciente_id,doctor_codigo,fecha) VALUES(?,?,?,?)";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, cita.getCodigo());
        ps.setInt(2, cita.getPaciente().getId());
        ps.setInt(3, cita.getDoctor().getCodigo());
        ps.setString(4, cita.getFecha());

        int filas = ps.executeUpdate();

        ps.close();
        con.close();

        return filas > 0;

    } catch (SQLException e) {

        System.out.println(e.getMessage());

        return false;

    }

}
    
    
    public ArrayList<Cita> listar() {

    ArrayList<Cita> lista = new ArrayList<>();

    String sql =
        "SELECT c.codigo, c.fecha, " +
        "p.id, p.nombre, p.edad, p.dni, p.enfermedad, " +
        "d.codigo AS codigoDoctor, d.nombre AS nombreDoctor, d.especialidad " +
        "FROM citas c " +
        "INNER JOIN pacientes p ON c.paciente_id = p.id " +
        "INNER JOIN doctores d ON c.doctor_codigo = d.codigo";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Paciente paciente = new Paciente(

                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("dni"),
                    rs.getString("enfermedad")

            );

            Doctor doctor = new Doctor(

                    rs.getInt("codigoDoctor"),
                    rs.getString("nombreDoctor"),
                    rs.getString("especialidad")

            );

            Cita cita = new Cita(

                    rs.getInt("codigo"),
                    paciente,
                    doctor,
                    rs.getString("fecha")

            );

            lista.add(cita);

        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return lista;

}
    
}
