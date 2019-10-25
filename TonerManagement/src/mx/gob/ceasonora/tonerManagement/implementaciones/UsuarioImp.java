/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.implementaciones;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.gob.ceasonora.tonerManagement.entidades.Usuario;
import mx.gob.ceasonora.tonerManagement.instancias.InstanciaConexion;
import mx.gob.ceasonora.tonerManagement.interfaces.UsuarioInt;

/**
 *
 * @author kevin
 */
public class UsuarioImp implements UsuarioInt{
    private static InstanciaConexion conexion = InstanciaConexion.getInstanciaConexion();

    @Override
    public boolean Agregar(Usuario usr) throws SQLException {
        boolean exito = false;
        try {
            String agregarSQL = "INSERT INTO usuario (nombreUsuario, contrasena, nombre, area, puesto, correo, telefono, fechaRegistro) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conexion.conexion().prepareStatement(agregarSQL);
            pst.setString(1, usr.getNombreUsuario());
            pst.setString(2, usr.getContrasena());
            pst.setString(3, usr.getNombre());
            pst.setString(4, usr.getArea());
            pst.setString(5, usr.getPuesto());
            pst.setString(6, usr.getCorreo());
            pst.setString(7, usr.getTelefono());
            pst.setDate(8, new Date(usr.getFechaRegistro().getTime()));
            pst.executeUpdate();
            exito = true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            conexion.cerrar();
        }
        return exito;
        
    }

    @Override
    public List<Usuario> lista_usuarios() throws SQLException {
        List<Usuario> lista = null;
        
        try{
            String listaSQL = "SELECT * FROM usuario";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Usuario usr = new Usuario();
                usr.setId(rs.getInt("id"));
                usr.setNombreUsuario(rs.getString("nombreUsuario"));
                usr.setContrasena(rs.getString("contrasena"));
                usr.setNombre(rs.getString("nombre"));
                usr.setArea(rs.getString("area"));
                usr.setPuesto(rs.getString("puesto"));
                usr.setCorreo(rs.getString("correo"));
                usr.setTelefono(rs.getString("telefono"));
                usr.setFechaRegistro(rs.getDate("fechaRegistro"));
                lista.add(usr);
            }
        }catch(SQLException e){
            System.out.println("Error al leer la tabla: "+e.getMessage());
        } finally{
            conexion.cerrar();
        }
        return lista;

    }

    @Override
    public List<Usuario> buscar_nombre(String busqueda) throws SQLException {
        List<Usuario> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM usuario WHERE nombre LIKE '%"+busqueda+"%'";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Usuario usr = new Usuario();
                usr.setId(rs.getInt("id"));
                usr.setNombreUsuario(rs.getString("nombreUsuario"));
                usr.setContrasena(rs.getString("contrasena"));
                usr.setNombre(rs.getString("nombre"));
                usr.setArea(rs.getString("area"));
                usr.setPuesto(rs.getString("puesto"));
                usr.setCorreo(rs.getString("correo"));
                usr.setTelefono(rs.getString("telefono"));
                usr.setFechaRegistro(rs.getDate("fechaRegistro"));
                lista.add(usr);
            }
        }catch(SQLException e){
            System.out.println("Error al leer la tabla: "+e.getMessage());
        } finally{
            conexion.cerrar();
        }
        return lista;
    }
    
    @Override
    public List<Usuario> buscar_correo(String busqueda) throws SQLException {
        List<Usuario> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM usuario WHERE correo LIKE '%"+busqueda+"%'";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Usuario usr = new Usuario();
                usr.setId(rs.getInt("id"));
                usr.setNombreUsuario(rs.getString("nombreUsuario"));
                usr.setContrasena(rs.getString("contrasena"));
                usr.setNombre(rs.getString("nombre"));
                usr.setArea(rs.getString("area"));
                usr.setPuesto(rs.getString("puesto"));
                usr.setCorreo(rs.getString("correo"));
                usr.setTelefono(rs.getString("telefono"));
                usr.setFechaRegistro(rs.getDate("fechaRegistro"));
                lista.add(usr);
            }
        }catch(SQLException e){
            System.out.println("Error al leer la tabla: "+e.getMessage());
        } finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Usuario> buscar_id(int busqueda) throws SQLException {
        List<Usuario> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM usuario WHERE id="+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Usuario usr = new Usuario();
                usr.setId(rs.getInt("id"));
                usr.setNombreUsuario(rs.getString("nombreUsuario"));
                usr.setContrasena(rs.getString("contrasena"));
                usr.setNombre(rs.getString("nombre"));
                usr.setArea(rs.getString("area"));
                usr.setPuesto(rs.getString("puesto"));
                usr.setCorreo(rs.getString("correo"));
                usr.setTelefono(rs.getString("telefono"));
                usr.setFechaRegistro(rs.getDate("fechaRegistro"));
                lista.add(usr);
            }
        }catch(SQLException e){
            System.out.println("Error al leer la tabla: "+e.getMessage());
        } finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public boolean Editar(Usuario usrAnterior, Usuario usrNuevo) throws SQLException {
        boolean exito = false;
        
        try {
            String editarSQL = "UPDATE usuario SET nombreUsuario= ?, contrasena= ?, nombre= ?,"
                    + "area= ?, puesto= ?, correo= ?, telefono= ? "
                    + "WHERE id= "+usrAnterior.getId();
            PreparedStatement pst = conexion.conexion().prepareStatement(editarSQL);
            pst.setString(1, usrNuevo.getNombreUsuario());
            pst.setString(2, usrNuevo.getContrasena());
            pst.setString(3, usrNuevo.getNombre());
            pst.setString(4, usrNuevo.getArea());
            pst.setString(5, usrNuevo.getPuesto());
            pst.setString(6, usrNuevo.getCorreo());
            pst.setString(7, usrNuevo.getTelefono());
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
    public boolean Eliminar(Usuario usr) throws SQLException {
        boolean exito = false;
        
        try {
            String eliminarSQL = "DELETE FROM usuario WHERE id= "+usr.getId();
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
    public List<Usuario> buscar_nombreUsuario(String busqueda) throws SQLException {

        List<Usuario> lista = null;
        
        try {
            String listaSQL = "SELECT * FROM usuario WHERE nombreUsuario= '"+busqueda+"'";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Usuario usr = new Usuario();
                usr.setId(rs.getInt("id"));
                usr.setNombreUsuario(rs.getString("nombreUsuario"));
                usr.setContrasena(rs.getString("contrasena"));
                usr.setNombre(rs.getString("nombre"));
                usr.setArea(rs.getString("area"));
                usr.setPuesto(rs.getString("puesto"));
                usr.setCorreo(rs.getString("correo"));
                usr.setTelefono(rs.getString("telefono"));
                usr.setFechaRegistro(rs.getDate("fechaRegistro"));
                lista.add(usr);
            }
        }catch(SQLException e){
            System.out.println("Error al leer la tabla: "+e.getMessage());
        } finally{
            conexion.cerrar();
        }
        return lista;
    }

    
    
}
