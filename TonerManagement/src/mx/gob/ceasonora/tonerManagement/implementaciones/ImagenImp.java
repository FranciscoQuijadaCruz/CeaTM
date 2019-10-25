/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.gob.ceasonora.tonerManagement.instancias.InstanciaConexion;
import mx.gob.ceasonora.tonerManagement.interfaces.ImagenInt;

/**
 *
 * @author kevin
 */
public class ImagenImp implements ImagenInt{
    private static InstanciaConexion conexion = InstanciaConexion.getInstanciaConexion();

    @Override
    public boolean Actualizar(String ruta) throws SQLException {
        boolean exito = false;
        
        try {
            String actualizarSQL= "UPDATE configuracion SET logoReportes=? ";
            PreparedStatement pst = conexion.conexion().prepareStatement(actualizarSQL);
            pst.setString(1, ruta);
            pst.executeUpdate();
            exito = true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos"+e.getSQLState());
        }finally{
            conexion.cerrar();
        }
        return exito;
        
    }

    @Override
    public String Obtener() throws SQLException {

        String ruta = null;
        
        try {
            String obtenerSQL = "SELECT * FROM configuracion";
            PreparedStatement pst = conexion.conexion().prepareStatement(obtenerSQL);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                ruta = rs.getString("logoReportes");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la imagen"+e.getSQLState());
        }finally{
            conexion.cerrar();
        }
        return ruta;
        
    }
    
}
