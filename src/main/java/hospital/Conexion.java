package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
        "jdbc:mysql://sakura.proxy.rlwy.net:48417/railway?allowPublicKeyRetrieval=true&useSSL=true&serverTimezone=America/Lima";

    private static final String USUARIO = "root";

    private static final String PASSWORD = "aEqaTaSDCtUAKiCITXllQmllQRdrWtUN";

    public static Connection conectar() {

        try {

            Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);

            System.out.println("Conexión exitosa a Railway.");

            return con;

        } catch (SQLException e) {

            System.out.println("Error al conectar: " + e.getMessage());

            return null;
        }
    }
}