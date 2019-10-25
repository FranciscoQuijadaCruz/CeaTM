/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.instancias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexion usando el patrón Singleton.
 * @author kevin
 */
public class InstanciaConexion {
    public Connection con = null;
    private static InstanciaConexion UnicaInstancia;
    
    private InstanciaConexion(){
        
    }
    
    public static synchronized InstanciaConexion getInstanciaConexion(){
        if(UnicaInstancia==null){
            UnicaInstancia = new InstanciaConexion();
            System.out.println("Instancia de conexion establecida");
        }else{
            System.out.println("Instancia de conexion previamente establecida, no se puede volver a instanciar");
        }
        return UnicaInstancia;
    }
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tonermanagement?user=root&password=asdfmovie");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar la Base de Datos: "+e.getLocalizedMessage());
        } catch (SQLException x){
            System.out.println("Error en la tabla de la Base de Datos: "+x.getMessage());
        }
        return con;
    }
    
    public void cerrar() throws SQLException{
        if(con != null){
            if(!con.isClosed()){
                con.close();
                UnicaInstancia = null;
            }
        }
    }
}
