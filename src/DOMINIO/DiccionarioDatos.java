/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMINIO;

import Conexion.Conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public class DiccionarioDatos {

    private Conexion dba;
    private DatosConexion dc;

    public DiccionarioDatos() {
        dba = new Conexion();
    }

    public boolean conexion(DatosConexion dcs) {
        dc = dcs;
        return dba.inicializarConexion(dc.getUsuario(), dc.getHost(), dc.getPuerto(), dc.getPassword());
    }

    String consulta;

    public ResultSet consultaTablas() {
        consulta = "SELECT DISTINCT ut.TABLE_NAME \"Nombre_tabla\", ut.TABLESPACE_NAME \"Nombre_tablespace\", \n"
                + "COUNT(uc.COLUMN_NAME) \"Numero_columnas\"\n"
                + "FROM USER_TABLES ut INNER JOIN USER_TAB_COLUMNS uc ON ut.TABLE_NAME = uc.TABLE_NAME\n"
                + "GROUP BY ut.TABLE_NAME, ut.TABLESPACE_NAME";
        /*consulta = "SELECT  ut.TABLE_NAME \"Nombre_tabla\", c.OWNER \"Propietario\", ut.TABLESPACE_NAME \"Nombre_tablespace\", \n" 
                 + "COUNT(uc.COLUMN_NAME) \"Numero_columnas\", uc.COLUMN_NAME \"Nombre_columna\", uc.DATA_TYPE \"Tipo_dato\", uc.DATA_LENGTH \"Longitud\", uc.NULLABLE \"Nulo\"\n" 
                 + "FROM USER_TABLES ut INNER JOIN USER_TAB_COLUMNS uc ON ut.TABLE_NAME = uc.TABLE_NAME INNER JOIN USER_CONSTRAINTS c ON ut.TABLE_NAME = c.TABLE_NAME\n"
                 + "GROUP BY ut.TABLE_NAME, c.OWNER, ut.TABLESPACE_NAME, uc.COLUMN_NAME, uc.DATA_TYPE, uc.DATA_LENGTH, uc.NULLABLE";*/
        return dba.ejecutarSELECT(consulta);
    }

    public ResultSet ConsultarTabla(String tabla) {
        //(nombre, tipo de dato, longitud, permite o no nulos)
        //consulta = String.format("describe '%s'" , tabla.toUpperCase());
        consulta = String.format("SELECT COLUMN_NAME , DATA_TYPE , DATA_LENGTH ,nullable FROM USER_tab_Columns where table_name='%s'", tabla.toUpperCase());
        return dba.ejecutarSELECT(consulta);
    }

    public ResultSet consultaTablespaces() {
        consulta = "select NAME \"Nombre\" from V$TABLESPACE";
        return dba.ejecutarSELECT(consulta);
    }

    public ResultSet consultaDatafiles() {
        consulta = "select FILE# \"Número del Archivo\", CREATION_TIME \"Fecha de Creación\","
                + " STATUS \"Estado\", NAME \"Nombre\" from V$DATAFILE ";
        return dba.ejecutarSELECT(consulta);
    }

    public ResultSet consultaBaseDatos() {
        consulta = "select Name \"Nombre\" , created \"Fecha de Creación\" from V$DATABASE";
        return dba.ejecutarSELECT(consulta);
    }

    public ResultSet consultaTipoUsuario(String usuario) {
        consulta = String.format("SELECT ADMIN_OPTION FROM user_role_privs WHERE USERNAME = '%s'", usuario.toUpperCase());
        return dba.ejecutarSELECT(consulta);
    }
    public ResultSet consultarDatosTabla(String nomTab){
        consulta = "Select * from "+nomTab;
        return dba.ejecutarSELECT(consulta);
    }

    public void cerrarConexion() throws SQLException {
        dba.cerrarConexion();
    }
    

    DatosConexion p = new DatosConexion();
    FileReader fr = null;

    public ArrayList cargar() {
        ArrayList<DatosConexion> cargados = new ArrayList();
        FileReader fr = null;
        boolean control = false;

        try {

            File archivo = new File("archivo.txt");
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            int i =0;
            while (linea != null && control == false) {
                linea = br.readLine();
                if (linea == null) {
                    control = true;
                } else {
                    cargados.add(dividir(linea));
                    System.out.println("cargados :" + cargados.get(i));
                    i++;
                }
                
            }
            br.close();

        } catch (IOException e) {
            System.out.println("ERROR FATAL!, COMPRUEBE LA RUTA DEL ARCHIVO");
        }
        return cargados;
    }

    private DatosConexion dividir(String linea) {

        DatosConexion tem = new DatosConexion();
        String vector[];
        vector = linea.split(";");
        tem.setUsuario(vector[0]);
        tem.setHost(vector[1]);
        tem.setPuerto(Integer.parseInt(vector[2]));
        tem.setPassword(vector[2]);

        return tem;
    }

}
