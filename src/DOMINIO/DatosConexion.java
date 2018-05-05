/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMINIO;

/**
 *
 * @author cristian
 */
public class DatosConexion {
    private String usuario;
    private String host;
    private int puerto;
    private String password;

    public DatosConexion() {
        
    }

    public DatosConexion( String Host, int Puerto,String usuario, String password) {
        this.usuario = usuario;
        this.host = Host;
        this.puerto = Puerto;
        this.password = password;
    }
    
    

     public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getHost() {
        return host;
    }

    public void setHost(String Host) {
        this.host = Host;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int Puerto) {
        this.puerto = Puerto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
}
