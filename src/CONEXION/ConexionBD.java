/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import DOMINIO.DatosConexion;
import GUI.Inicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class ConexionBD {
   private Connection con;
   private static String cadenaConexion ="";
   private static String host = "";
   private static int port = 0;
   private static String login = "";
   private static String password = "";
   private static String errorSql = "";
   private static int codSql = 0;
   
    public ConexionBD(DatosConexion datos){
        ConexionBD.host = datos.getHost();
        ConexionBD.port = datos.getPuerto();
        ConexionBD.login = datos.getUsuario();
        ConexionBD.password = datos.getPassword();        
        try {
            cadenaConexion = String.format("jdbc:oracle:thin:@%s:%s:xe",host, port);
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            con = DriverManager.getConnection(cadenaConexion, login, password);
            System.out.println("Conectado " );
          
        } catch (SQLException ex) {
            // Mantener el control sobre el tipo de error
            //System.out.println("SQLException: " + ex.getMessage());
            errorSql = ex.getMessage();
            codSql = ex.getErrorCode();
            con = null;

        }
    }

    public static int getCodsql() {
        return codSql;
    }

    public static String getErrorSql() {
        return errorSql;
    }
    
    public Connection getConexioBD() {
        return con;
    }
    public void desconectar(){
      con = null;
   }
    
}
