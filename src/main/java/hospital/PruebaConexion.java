package hospital;

import java.sql.Connection;

public class PruebaConexion {

    public static void main(String[] args) {

        Connection con = Conexion.conectar();

        if (con != null) {

            System.out.println("La conexión funciona correctamente.");

        } else {

            System.out.println("No se pudo conectar.");

        }

    }

}