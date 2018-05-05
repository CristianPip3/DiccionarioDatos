/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DOMINIO.DatosConexion;
import DOMINIO.Logica;
import GUI.Inicio;
import GUI.Principal;

/**
 *
 * @author cristian
 */
public class Controlador {
    Logica miLogica;
    DatosConexion datosConexion;
    Principal vtnPrincipal;
    Inicio vtnInicio;
    public DatosConexion getDatosConexion() {
        return datosConexion;
    }
    public void setDatosConexion(DatosConexion datosConexion) {
        this.datosConexion = datosConexion;
    }
    public Inicio getVtnInicio() {
        return vtnInicio;
    }
    public void setVtnInicio(Inicio vtnInicio) {
        this.vtnInicio = vtnInicio;
    }
    

    public Logica getMiLogica() {
        return miLogica;
    }

    public void setMiLogica(Logica miLogica) {
        this.miLogica = miLogica;
    }

    public Principal getVtnPrincipal() {
        return vtnPrincipal;
    }

    public void setVtnPrincipal(Principal vtnPrincipal) {
        this.vtnPrincipal = vtnPrincipal;
    }
    public void registrarConexion(String host, String port1, String user, String pass){
        int port = Integer.parseInt(port1);
        datosConexion = new DatosConexion(host, port, user, pass);
        System.out.println("Controlador");
        miLogica.validarDatosConexion(datosConexion);
        
    }

    
    
    
    
}
