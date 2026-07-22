package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
        "jdbc:mysql://127.0.0.1:3306/hospital?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=America/Lima";

    private static final String USUARIO = "root";

    private static final String PASSWORD = "12345";

    public static Connection conectar() {

        try {

            Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);

            System.out.println("Conexión exitosa a MySQL.");

            return con;

        } catch (SQLException e) {

            System.out.println("Error al conectar: " + e.getMessage());

            return null;

        }

    }

}