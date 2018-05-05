/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.ConexionBD;
import DOMINIO.Logica;
import GUI.Inicio;
import GUI.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cristian
 */
public class DiccionarioDeDatos {
     static String cadenaConexion ="";
    public static void main(String[] args) throws SQLException {
        
        
        Logica miLogica = new Logica();
        Controlador controlador= new Controlador();
        Principal vtnPrincipal = new Principal();
        Inicio vtnInicio = new Inicio();
        
        
        miLogica.setMiControlador(controlador);

        vtnPrincipal.setCoordinador(controlador);
        vtnInicio.setMiControlador(controlador);
        

       
        
        controlador.setMiLogica(miLogica);
        controlador.setVtnPrincipal(vtnPrincipal);
        controlador.setVtnInicio(vtnInicio);
  
        vtnInicio.setVisible(true);
        //controlador.mostrar();
    
       
    }
    
}
