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
import mx.gob.ceasonora.tonerManagement.entidades.Herramienta;
import mx.gob.ceasonora.tonerManagement.instancias.InstanciaConexion;
import mx.gob.ceasonora.tonerManagement.interfaces.HerramientaInt;

/**
 *
 * @author kevin
 */
public class HerramientaImp implements HerramientaInt{
    private static InstanciaConexion conexion = InstanciaConexion.getInstanciaConexion();

    @Override
    public boolean Agregar(Herramienta her) throws SQLException {
        boolean exito = false;
        try {
            String agregarSQL = "INSERT INTO herramienta (cantidadTotal, cantidadDisponible, nombre, precioUnitario, descripcion, codigoProducto) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = conexion.conexion().prepareStatement(agregarSQL);
            pst.setInt(1, her.getCantidadTotal());
            pst.setInt(2, her.getCantidadDisponible());
            pst.setString(3, her.getNombre());
            pst.setDouble(4, her.getPrecioUnitario());
            pst.setString(5, her.getDescripcion());
            pst.setString(6, her.getCodigoProducto());
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
    public boolean Editar(Herramienta herAnterior, Herramienta herNuevo) throws SQLException {
        boolean exito = false;
        
        try {
            String editarSQL = "UPDATE herramienta SET cantidadTotal=?, cantidadDisponible=?, nombre=?, precioUnitario=?, descripcion=?, codigoProducto=? "
                    + "WHERE id= "+herAnterior.getId();
            PreparedStatement pst = conexion.conexion().prepareStatement(editarSQL);
            pst.setInt(1, herNuevo.getCantidadTotal());
            pst.setInt(2, herNuevo.getCantidadDisponible());
            pst.setString(3, herNuevo.getNombre());
            pst.setDouble(4, herNuevo.getPrecioUnitario());
            pst.setString(5, herNuevo.getDescripcion());
            pst.setString(6, herNuevo.getCodigoProducto());
            pst.executeUpdate();
            exito = true;
        } catch (SQLException e) {
        }finally{
            conexion.cerrar();
        }
        return exito;
    }

    @Override
    public boolean Eliminar(Herramienta her) throws SQLException {
        boolean exito = false;
        
        try {
            String eliminarSQL = "DELETE FROM herramienta WHERE id= "+her.getId();
            PreparedStatement pst = conexion.conexion().prepareStatement(eliminarSQL);
            pst.executeUpdate();
            exito=true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return exito;
    }

    @Override
    public List<Herramienta> lista_herramientas() throws SQLException {
        List<Herramienta> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM herramienta";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Herramienta her = new Herramienta();
                her.setId(rs.getInt("id"));
                her.setCantidadTotal(rs.getInt("cantidadTotal"));
                her.setCantidadDisponible(rs.getInt("cantidadDisponible"));
                her.setNombre(rs.getString("nombre"));
                her.setPrecioUnitario(rs.getDouble("precioUnitario"));
                her.setDescripcion(rs.getString("descripcion"));
                her.setCodigoProducto(rs.getString("codigoProducto"));
                lista.add(her);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Herramienta> buscar_nombre(String busqueda) throws SQLException {
        List<Herramienta> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM herramienta WHERE nombre LIKE '%"+busqueda+"%'";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Herramienta her = new Herramienta();
                her.setId(rs.getInt("id"));
                her.setCantidadTotal(rs.getInt("cantidadTotal"));
                her.setCantidadDisponible(rs.getInt("cantidadDisponible"));
                her.setNombre(rs.getString("nombre"));
                her.setPrecioUnitario(rs.getDouble("precioUnitario"));
                her.setDescripcion(rs.getString("descripcion"));
                her.setCodigoProducto(rs.getString("codigoProducto"));
                lista.add(her);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Herramienta> buscar_codigo(String busqueda) throws SQLException {
        List<Herramienta> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM herramienta WHERE codigoProducto LIKE '%"+busqueda+"%'";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Herramienta her = new Herramienta();
                her.setId(rs.getInt("id"));
                her.setCantidadTotal(rs.getInt("cantidadTotal"));
                her.setCantidadDisponible(rs.getInt("cantidadDisponible"));
                her.setNombre(rs.getString("nombre"));
                her.setPrecioUnitario(rs.getDouble("precioUnitario"));
                her.setDescripcion(rs.getString("descripcion"));
                her.setCodigoProducto(rs.getString("codigoProducto"));
                lista.add(her);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Herramienta> buscar_id(int busqueda) throws SQLException {
        List<Herramienta> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM herramienta WHERE id= "+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Herramienta her = new Herramienta();
                her.setId(rs.getInt("id"));
                her.setCantidadTotal(rs.getInt("cantidadTotal"));
                her.setCantidadDisponible(rs.getInt("cantidadDisponible"));
                her.setNombre(rs.getString("nombre"));
                her.setPrecioUnitario(rs.getDouble("precioUnitario"));
                her.setDescripcion(rs.getString("descripcion"));
                her.setCodigoProducto(rs.getString("codigoProducto"));
                lista.add(her);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }
    
}
