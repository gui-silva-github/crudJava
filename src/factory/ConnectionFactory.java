package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    // Name of the user

    private static final String USERNAME = "root";

    // Password of the database

    private static final String PASSWORD = "";

    // Path for using

    private static final String PATH = "jdbc:mysql://localhost:3306/cadastro_crud";

    // Method to connect

    public static Connection createConnectionToMySQL() throws Exception {

        // Path of the Driver 

        Class.forName("com.mysql.cj.jdbc.Driver");

        // Using the DriverManager

        Connection connection = DriverManager.getConnection(PATH, USERNAME, PASSWORD);

        // Returning this connection

        return connection;

    }

    // Test of this connection

    public static void main (String[] args) throws Exception {

        Connection conn = createConnectionToMySQL();

        if (conn != null){
            System.out.println("Conexão obtida com sucesso!");
            conn.close();
        }

    }

}
