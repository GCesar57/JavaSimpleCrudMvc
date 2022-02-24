package model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.sql.DriverManager;

/**
 *
 * @author phoenix055
 */
public class Conexion {
    //jdbc:mysql://localhost/javacrudoop
    //MySQL (com.mysql.jdbc.Driver)
    private final String base = "javacrudoop";
    private final String user = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection conn = null; //Para obtener la conexion para luego retornarla...
    //
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Controlador para la conexion
            conn = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (SQLException e) {
            e.getMessage();
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }//
}
