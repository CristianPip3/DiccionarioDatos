/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMINIO;

import Conexion.Dba;
import Logica.Controlador;

/**
 *
 * @author cristian
 */
public class Logica {
    
    String errorSqlM;
    Controlador miControlador;

    public Controlador getMiCoordinador() {
        return miControlador;
    }

    public void setMiControlador(Controlador miCoordinador) {
        this.miControlador = miCoordinador;
    }
    public void validarDatosConexion(DatosConexion datosConexion){
        Dba dba = new Dba();
        System.out.println("Logica");
        dba.registroConexion(datosConexion);
        this.almacenarDatosConexion(datosConexion);
        
        
    }
    private void almacenarDatosConexion(DatosConexion conexion){
        //Registrar en un archivo, escribir los datos de conexión
    }

  
    
    
    
    
}
