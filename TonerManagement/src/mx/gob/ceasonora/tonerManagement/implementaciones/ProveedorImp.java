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
import mx.gob.ceasonora.tonerManagement.entidades.Proveedor;
import mx.gob.ceasonora.tonerManagement.instancias.InstanciaConexion;
import mx.gob.ceasonora.tonerManagement.interfaces.ProveedorInt;

/**
 *
 * @author kevin
 */
public class ProveedorImp implements ProveedorInt{
    private static InstanciaConexion conexion = InstanciaConexion.getInstanciaConexion();

    @Override
    public boolean Agregar(Proveedor pvd) throws SQLException {
        boolean exito = false;
        try {
            String agregarSQL = "INSERT INTO proveedor (nombre, telefono, correo, direccion, ciudad, estado, pais) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = conexion.conexion().prepareStatement(agregarSQL);
            pst.setString(1, pvd.getNombre());
            pst.setString(2, pvd.getTelefono());
            pst.setString(3, pvd.getCorreo());
            pst.setString(4, pvd.getDireccion());
            pst.setString(5, pvd.getCiudad());
            pst.setString(6, pvd.getEstado());
            pst.setString(7, pvd.getPais());
            pst.executeUpdate();
            exito = true;
        } catch (SQLException e) {
            System.out.println("Error al agregar a la base de datos: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return exito;
    }

    @Override
    public boolean Editar(Proveedor pvdAnterior, Proveedor pvdNuevo) throws SQLException {
        boolean exito = false;
        
        try {
            String editarSQL = "UPDATE proveedor SET nombre=?, telefono=?, correo=?, direccion=?, ciudad=?, estado=?, pais=? "
                    + "WHERE id= "+pvdAnterior.getId();
            PreparedStatement pst = conexion.conexion().prepareStatement(editarSQL);
            pst.setString(1, pvdNuevo.getNombre());
            pst.setString(2, pvdNuevo.getTelefono());
            pst.setString(3, pvdNuevo.getCorreo());
            pst.setString(4, pvdNuevo.getDireccion());
            pst.setString(5, pvdNuevo.getCiudad());
            pst.setString(6, pvdNuevo.getEstado());
            pst.setString(7, pvdNuevo.getPais());
            pst.executeUpdate();
            exito = true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return exito;
    }

    @Override
    public boolean Eliminar(Proveedor pvd) throws SQLException {
        boolean exito = false;
        
        try {
            String eliminarSQL = "DELETE FROM proveedor WHERE id= "+pvd.getId();
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
    public List<Proveedor> lista_proveedores() throws SQLException {
        List<Proveedor> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM proveedor";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Proveedor pvd = new Proveedor();
                pvd.setId(rs.getInt("id"));
                pvd.setNombre(rs.getString("nombre"));
                pvd.setTelefono(rs.getString("telefono"));
                pvd.setCorreo(rs.getString("correo"));
                pvd.setDireccion(rs.getString("direccion"));
                pvd.setCiudad(rs.getString("ciudad"));
                pvd.setEstado(rs.getString("estado"));
                pvd.setPais(rs.getString("pais"));
                lista.add(pvd);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Proveedor> buscar_nombre(String busqueda) throws SQLException {
        List<Proveedor> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM proveedor WHERE nombre LIKE '%"+busqueda+"%'";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Proveedor pvd = new Proveedor();
                pvd.setId(rs.getInt("id"));
                pvd.setNombre(rs.getString("nombre"));
                pvd.setTelefono(rs.getString("telefono"));
                pvd.setCorreo(rs.getString("correo"));
                pvd.setDireccion(rs.getString("direccion"));
                pvd.setCiudad(rs.getString("ciudad"));
                pvd.setEstado(rs.getString("estado"));
                pvd.setPais(rs.getString("pais"));
                lista.add(pvd);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }
    

    @Override
    public List<Proveedor> buscar_id(int busqueda) throws SQLException {
        List<Proveedor> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM proveedor WHERE id= "+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Proveedor pvd = new Proveedor();
                pvd.setId(rs.getInt("id"));
                pvd.setNombre(rs.getString("nombre"));
                pvd.setTelefono(rs.getString("telefono"));
                pvd.setCorreo(rs.getString("correo"));
                pvd.setDireccion(rs.getString("direccion"));
                pvd.setCiudad(rs.getString("ciudad"));
                pvd.setEstado(rs.getString("estado"));
                pvd.setPais(rs.getString("pais"));
                lista.add(pvd);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }
    
    
}
