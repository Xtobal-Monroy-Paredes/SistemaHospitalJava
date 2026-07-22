
package hospital;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            Login login = new Login();

            login.setLocationRelativeTo(null);

            login.setVisible(true);

        });

    }

}