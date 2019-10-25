/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.gob.ceasonora.tonerManagement.entidades.Personal;
import mx.gob.ceasonora.tonerManagement.instancias.InstanciaConexion;
import mx.gob.ceasonora.tonerManagement.interfaces.PersonalInt;

/**
 *
 * @author kevin
 */
public class PersonalImp implements PersonalInt{
    private static InstanciaConexion conexion = InstanciaConexion.getInstanciaConexion();

    @Override
    public boolean Agregar(Personal per) throws SQLException {
        boolean exito = false;
        try {
            String agregarSQL = "INSERT INTO personal (nombre, telefono, correo, area, puesto) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = conexion.conexion().prepareStatement(agregarSQL);
            pst.setString(1, per.getNombre());
            pst.setString(2, per.getTelefono());
            pst.setString(3, per.getCorreo());
            pst.setString(4, per.getArea());
            pst.setString(5, per.getPuesto());
            pst.executeUpdate();
            exito=true;
        } catch (SQLException e) {
            System.out.println("Error al agregar datos a la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return exito;
    }

    @Override
    public boolean Editar(Personal perAnterior, Personal perNuevo) throws SQLException {
        boolean exito = false;
        
        try {
            String editarSQL = "UPDATE personal SET nombre=?, telefono=?, correo=?, area=?, puesto=? "
                    + "WHERE id= "+perAnterior.getId();
            PreparedStatement pst = conexion.conexion().prepareStatement(editarSQL);
            pst.setString(1, perNuevo.getNombre());
            pst.setString(2, perNuevo.getTelefono());
            pst.setString(3, perNuevo.getCorreo());
            pst.setString(4, perNuevo.getArea());
            pst.setString(5, perNuevo.getPuesto());
            pst.executeUpdate();
            exito=true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return exito;

    }

    @Override
    public boolean Eliminar(Personal per) throws SQLException {
        boolean exito = false;
        
        try {
            String eliminarSQL = "DELETE FROM personal WHERE id= "+per.getId();
            PreparedStatement pst = conexion.conexion().prepareStatement(eliminarSQL);
            pst.executeUpdate();
            exito = true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return exito;
    }

    @Override
    public List<Personal> lista_personal() throws SQLException {
        List<Personal> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM personal";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Personal per = new Personal();
                per.setId(rs.getInt("id"));
                per.setNombre(rs.getString("nombre"));
                per.setTelefono(rs.getString("telefono"));
                per.setCorreo(rs.getString("correo"));
                per.setArea(rs.getString("area"));
                per.setPuesto(rs.getString("puesto"));
                lista.add(per);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Personal> buscar_nombre(String busqueda) throws SQLException {
        List<Personal> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM personal WHERE nombre LIKE '%"+busqueda+"%'";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Personal per = new Personal();
                per.setId(rs.getInt("id"));
                per.setNombre(rs.getString("nombre"));
                per.setTelefono(rs.getString("telefono"));
                per.setCorreo(rs.getString("correo"));
                per.setArea(rs.getString("area"));
                per.setPuesto(rs.getString("puesto"));
                lista.add(per);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Personal> buscar_id(int busqueda) throws SQLException {
        List<Personal> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM personal WHERE id= "+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Personal per = new Personal();
                per.setId(rs.getInt("id"));
                per.setNombre(rs.getString("nombre"));
                per.setTelefono(rs.getString("telefono"));
                per.setCorreo(rs.getString("correo"));
                per.setArea(rs.getString("area"));
                per.setPuesto(rs.getString("puesto"));
                lista.add(per);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }
    
}
