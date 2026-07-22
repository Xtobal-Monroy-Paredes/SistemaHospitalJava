package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PacienteDAO {

    public boolean insertar(Paciente paciente) {

        String sql = "INSERT INTO pacientes(id,nombre,edad,dni,enfermedad) VALUES (?,?,?,?,?)";

        try {

            Connection con = Conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, paciente.getId());
            ps.setString(2, paciente.getNombre());
            ps.setInt(3, paciente.getEdad());
            ps.setString(4, paciente.getDni());
            ps.setString(5, paciente.getEnfermedad());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return false;

        }

    }
    
    
    public ArrayList<Paciente> listar() {

    ArrayList<Paciente> lista = new ArrayList<>();

    String sql = "SELECT * FROM pacientes";

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

            lista.add(paciente);

        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return lista;

}
    
    public Paciente buscarPorId(int id) {

    String sql = "SELECT * FROM pacientes WHERE id = ?";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Paciente paciente = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("dni"),
                    rs.getString("enfermedad")
            );

            rs.close();
            ps.close();
            con.close();

            return paciente;

        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return null;

}
    
    public boolean actualizar(Paciente paciente) {

    String sql = "UPDATE pacientes SET nombre=?, edad=?, dni=?, enfermedad=? WHERE id=?";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, paciente.getNombre());
        ps.setInt(2, paciente.getEdad());
        ps.setString(3, paciente.getDni());
        ps.setString(4, paciente.getEnfermedad());
        ps.setInt(5, paciente.getId());

        int filas = ps.executeUpdate();

        ps.close();
        con.close();

        return filas > 0;

    } catch (SQLException e) {

        System.out.println(e.getMessage());

        return false;

    }

}
    
    public boolean eliminar(int id) {

    String sql = "DELETE FROM pacientes WHERE id = ?";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int filas = ps.executeUpdate();

        ps.close();
        con.close();

        return filas > 0;

    } catch (SQLException e) {

        System.out.println(e.getMessage());

        return false;

    }

}

}