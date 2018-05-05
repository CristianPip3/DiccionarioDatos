/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import DOMINIO.DatosConexion;
import DOMINIO.MensajeSql;
import java.sql.ResultSet;


/**
 *
 * @author cristian
 */
public class Dba {
   
    private String consulta;
    private DatosConexion datosConexion;
    private MensajeSql mensajeSql;
    
    
    public void registroConexion(DatosConexion datosConexion) {
        ConexionBD con;
        con = new ConexionBD(datosConexion);
        
        
        con.desconectar();
    }
   

    
    
    
}
