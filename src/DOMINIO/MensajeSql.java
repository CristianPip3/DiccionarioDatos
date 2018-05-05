/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMINIO;

/**
 *
 * @author Andres
 */
public class MensajeSql {
    private String mensajeSql;
    private int codeSql;
    private boolean bandera;

    public MensajeSql() {
    }

    public MensajeSql(String mensajeSql, int codeSql, boolean bandera) {
        this.mensajeSql = mensajeSql;
        this.codeSql = codeSql;
        this.bandera = bandera;
    }

    public String getMensajeSql() {
        return mensajeSql;
    }

    public void setMensajeSql(String mensajeSql) {
        this.mensajeSql = mensajeSql;
    }

    public int getCodeSql() {
        return codeSql;
    }

    public void setCodeSql(int codeSql) {
        this.codeSql = codeSql;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    
    
}
