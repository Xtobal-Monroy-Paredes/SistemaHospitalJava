package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorDAO {

    public boolean insertar(Doctor doctor) {

        String sql = "INSERT INTO doctores(codigo,nombre,especialidad) VALUES (?,?,?)";

        try {

            Connection con = Conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, doctor.getCodigo());
            ps.setString(2, doctor.getNombre());
            ps.setString(3, doctor.getEspecialidad());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return false;

        }

    }
    
    
    public ArrayList<Doctor> listar() {

    ArrayList<Doctor> lista = new ArrayList<>();

    String sql = "SELECT * FROM doctores";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Doctor doctor = new Doctor(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("especialidad")
            );

            lista.add(doctor);

        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return lista;

}
    
    public Doctor buscarPorCodigo(int codigo) {

    String sql = "SELECT * FROM doctores WHERE codigo=?";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, codigo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Doctor doctor = new Doctor(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("especialidad")
            );

            rs.close();
            ps.close();
            con.close();

            return doctor;

        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return null;

}
    
    public boolean actualizar(Doctor doctor) {

    String sql = "UPDATE doctores SET nombre=?, especialidad=? WHERE codigo=?";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, doctor.getNombre());
        ps.setString(2, doctor.getEspecialidad());
        ps.setInt(3, doctor.getCodigo());

        ps.executeUpdate();

        ps.close();
        con.close();

        return true;

    } catch (SQLException e) {

        System.out.println(e.getMessage());

        return false;

    }

}
    
    public boolean eliminar(int codigo) {

    String sql = "DELETE FROM doctores WHERE codigo=?";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, codigo);

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