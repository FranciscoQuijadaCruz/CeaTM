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
import mx.gob.ceasonora.tonerManagement.entidades.Consumible;
import mx.gob.ceasonora.tonerManagement.instancias.InstanciaConexion;
import mx.gob.ceasonora.tonerManagement.interfaces.ConsumibleInt;
import mx.gob.ceasonora.tonerManagement.interfaces.ProveedorInt;

/**
 *
 * @author kevin
 */
public class ConsumibleImp implements ConsumibleInt{
    private static InstanciaConexion conexion = InstanciaConexion.getInstanciaConexion();

    @Override
    public boolean Agregar(Consumible con) throws SQLException {
        boolean exito = false;
        try {
            String agregarSQL = "INSERT INTO consumible (cantidad, nombre, descripcion, precioUnitario, idProveedor, codigoProducto) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = conexion.conexion().prepareStatement(agregarSQL);
            pst.setInt(1, con.getCantidad());
            pst.setString(2, con.getNombre());
            pst.setString(3, con.getDescripcion());
            pst.setDouble(4, con.getPrecioUnitario());
            pst.setInt(5, con.getProveedor().getId());
            pst.setString(6, con.getCodigoProducto());
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
    public boolean Editar(Consumible conAnterior, Consumible conNuevo) throws SQLException {
        boolean exito = false;
        
        try {
            String editarSQL = "UPDATE consumible SET cantidad=?, nombre=?, descripcion=?, precioUnitario=?, idProveedor=?, codigoProducto=? "
                    + "WHERE id= "+conAnterior.getId();
            PreparedStatement pst = conexion.conexion().prepareStatement(editarSQL);
            pst.setInt(1, conNuevo.getCantidad());
            pst.setString(2, conNuevo.getNombre());
            pst.setString(3, conNuevo.getDescripcion());
            pst.setDouble(4, conNuevo.getPrecioUnitario());
            pst.setInt(5, conNuevo.getProveedor().getId());
            pst.setString(6, conNuevo.getCodigoProducto());
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
    public boolean Eliminar(Consumible con) throws SQLException {
        boolean exito = false;
        
        try {
            String eliminarSQL = "DELETE FROM consumible WHERE id= "+con.getId();
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
    public List<Consumible> lista_consumibles() throws SQLException {
        List<Consumible> lista = null;
        ProveedorInt pvd = new ProveedorImp();
        
        try{
            String listaSQL = "SELECT * FROM consumible";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Consumible con = new Consumible();
                con.setId(rs.getInt("id"));
                con.setCantidad(rs.getInt("cantidad"));
                con.setNombre(rs.getString("nombre"));
                con.setDescripcion(rs.getString("descripcion"));
                con.setPrecioUnitario(rs.getDouble("precioUnitario"));
                con.setProveedor(pvd.buscar_id(rs.getInt("idProveedor")).get(0));
                con.setCodigoProducto(rs.getString("codigoProducto"));
                lista.add(con);
                
            }
        }catch(SQLException e){
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Consumible> buscar_nombre(String busqueda) throws SQLException {
        List<Consumible> lista = null;
        ProveedorInt pvd = new ProveedorImp();
        
        try{
            String listaSQL = "SELECT * FROM consumible WHERE nombre LIKE '%"+busqueda+"%'";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Consumible con = new Consumible();
                con.setId(rs.getInt("id"));
                con.setCantidad(rs.getInt("cantidad"));
                con.setNombre(rs.getString("nombre"));
                con.setDescripcion(rs.getString("descripcion"));
                con.setPrecioUnitario(rs.getDouble("precioUnitario"));
                con.setProveedor(pvd.buscar_id(rs.getInt("idProveedor")).get(0));
                con.setCodigoProducto(rs.getString("codigoProducto"));
                lista.add(con);
                
            }
        }catch(SQLException e){
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Consumible> buscar_codigo(String busqueda) throws SQLException {
        List<Consumible> lista = null;
        ProveedorInt pvd = new ProveedorImp();
        
        try{
            String listaSQL = "SELECT * FROM consumible WHERE codigoProducto LIKE '%"+busqueda+"%'";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Consumible con = new Consumible();
                con.setId(rs.getInt("id"));
                con.setCantidad(rs.getInt("cantidad"));
                con.setNombre(rs.getString("nombre"));
                con.setDescripcion(rs.getString("descripcion"));
                con.setPrecioUnitario(rs.getDouble("precioUnitario"));
                con.setProveedor(pvd.buscar_id(rs.getInt("idProveedor")).get(0));
                con.setCodigoProducto(rs.getString("codigoProducto"));
                lista.add(con);
                
            }
        }catch(SQLException e){
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Consumible> buscar_id(int busqueda) throws SQLException {
        List<Consumible> lista = null;
        ProveedorInt pvd = new ProveedorImp();
        
        try{
            String listaSQL = "SELECT * FROM consumible WHERE id= "+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Consumible con = new Consumible();
                con.setId(rs.getInt("id"));
                con.setCantidad(rs.getInt("cantidad"));
                con.setNombre(rs.getString("nombre"));
                con.setDescripcion(rs.getString("descripcion"));
                con.setPrecioUnitario(rs.getDouble("precioUnitario"));
                con.setProveedor(pvd.buscar_id(rs.getInt("idProveedor")).get(0));
                con.setCodigoProducto(rs.getString("codigoProducto"));
                lista.add(con);
                
            }
        }catch(SQLException e){
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Consumible> lista_escasos() throws SQLException {
        ProveedorInt pvd = new ProveedorImp();
        List<Consumible> lista = null;
        
        try {
            String escasosSQL = "SELECT * FROM consumible WHERE cantidad <= 2 AND cantidad > 0";
            PreparedStatement pst = conexion.conexion().prepareStatement(escasosSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Consumible con = new Consumible();
                con.setId(rs.getInt("id"));
                con.setCantidad(rs.getInt("cantidad"));
                con.setNombre(rs.getString("nombre"));
                con.setDescripcion(rs.getString("descripcion"));
                con.setPrecioUnitario(rs.getDouble("precioUnitario"));
                con.setProveedor(pvd.buscar_id(rs.getInt("idProveedor")).get(0));
                con.setCodigoProducto(rs.getString("codigoProducto"));
                lista.add(con);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Consumible> lista_faltantes() throws SQLException {
        ProveedorInt pvd = new ProveedorImp();
        List<Consumible> lista = null;
        
        try {
            String escasosSQL = "SELECT * FROM consumible WHERE cantidad <= 0";
            PreparedStatement pst = conexion.conexion().prepareStatement(escasosSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Consumible con = new Consumible();
                con.setId(rs.getInt("id"));
                con.setCantidad(rs.getInt("cantidad"));
                con.setNombre(rs.getString("nombre"));
                con.setDescripcion(rs.getString("descripcion"));
                con.setPrecioUnitario(rs.getDouble("precioUnitario"));
                con.setProveedor(pvd.buscar_id(rs.getInt("idProveedor")).get(0));
                con.setCodigoProducto(rs.getString("codigoProducto"));
                lista.add(con);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }
    
}
