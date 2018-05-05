/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author cristian 
 */
public class Conexion 
{
    private String cadenaConexion;
    private Connection con;
    
    public Conexion()
    {
       
    }   
    
    public boolean inicializarConexion(String usuario, String host, int port, String pass)
    {
        try
        {
            cadenaConexion = String.format("jdbc:oracle:thin:@%s:%s:xe",host, port);
            con = DriverManager.getConnection(cadenaConexion, usuario, pass);      
            return true;
        }
        catch(Exception ex)
        {  
            return false;
        }    
    } 
    
    public ResultSet ejecutarSELECT(String consulta)
    {
        ResultSet rs;// rs sera desplazable, no mostrara cambios realizados por otros y sera actualizable
        try
        {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(consulta); 
            return rs;        
        }
        catch(Exception ex)
        {
          System.out.println("Error al ejecutar DML -> " + ex.getMessage());
          return null;
        }
    }
    
    public int ejecutarDML(String comando)
    {
        int filasAfectadas = 0;
        try
        {
            Statement stmt = con.createStatement();
            filasAfectadas = stmt.executeUpdate(comando);
            return filasAfectadas; 
        }
        catch(Exception ex)
        { 
            return 0;
        }
     }
    
    public void cerrarConexion() throws SQLException
    {
        con.close();
    }
}
