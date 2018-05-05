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
    private DatosConexion datosConexion ;
    private MensajeSql mensajeSql;
   
    
    public boolean registroConexion(DatosConexion datosConexion) {
        ConexionBD con;
        boolean bandera;
        mensajeSql = new MensajeSql();
        con = new ConexionBD(datosConexion);
        mensajeSql.setMensajeSql(ConexionBD.getErrorSql());
        mensajeSql.setCodeSql(ConexionBD.getCodsql());
        System.out.println("HAY ALGO"+ mensajeSql.getMensajeSql());
        if(mensajeSql.getMensajeSql().equals("")){
            System.out.println("PRUEBA PASAMOS");
            bandera = true;
            
        }else{
            System.out.println("NO PASAMOS" + mensajeSql.getMensajeSql());
            mensajeSql.setBandera(true);
            bandera = false;
        }
  
       
        
        con.desconectar();
        return bandera;
    }
   

    
    
    
}
