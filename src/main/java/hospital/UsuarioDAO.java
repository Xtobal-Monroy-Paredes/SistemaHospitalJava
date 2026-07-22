package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean validar(String usuario, String contraseña) {

        String sql =
                "SELECT * FROM usuarios WHERE usuario=? AND contraseña=?";

        try {

            Connection con = Conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();

            boolean existe = rs.next();

            rs.close();
            ps.close();
            con.close();

            return existe;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

}