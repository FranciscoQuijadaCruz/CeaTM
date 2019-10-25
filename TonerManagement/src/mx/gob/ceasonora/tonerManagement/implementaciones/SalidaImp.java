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
import mx.gob.ceasonora.tonerManagement.entidades.Salida;
import mx.gob.ceasonora.tonerManagement.instancias.InstanciaConexion;
import mx.gob.ceasonora.tonerManagement.interfaces.ConsumibleInt;
import mx.gob.ceasonora.tonerManagement.interfaces.PersonalInt;
import mx.gob.ceasonora.tonerManagement.interfaces.SalidaInt;
import mx.gob.ceasonora.tonerManagement.interfaces.UsuarioInt;

/**
 *
 * @author kevin
 */
public class SalidaImp implements SalidaInt{
    private static InstanciaConexion conexion = InstanciaConexion.getInstanciaConexion();

    @Override
    public boolean Agregar(Salida sal) throws SQLException {
        boolean exito = false;
        
        try {
            String agregarSQL = "INSERT INTO salida (fecha, idConsumible, cantidad, idUsuario, idPersonal) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = conexion.conexion().prepareStatement(agregarSQL);
            pst.setDate(1, new Date(sal.getFecha().getTime()));
            pst.setInt(2, sal.getConsumible().getId());
            pst.setInt(3, sal.getCantidad());
            pst.setInt(4, sal.getUsuario().getId());
            pst.setInt(5, sal.getPersonal().getId());
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
    public boolean Editar(Salida salAnterior, Salida salNuevo) throws SQLException {
        boolean exito = false;
        
        try {
            String editarSQL = "UPDATE salida SET fecha=?, idConsumible=?, cantidad=?, idUsuario=?, idPersonal=? "
                    + "WHERE id= "+salAnterior.getId();
            PreparedStatement pst = conexion.conexion().prepareStatement(editarSQL);
            pst.setDate(1, new Date(salNuevo.getFecha().getTime()));
            pst.setInt(2, salNuevo.getConsumible().getId());
            pst.setInt(3, salNuevo.getCantidad());
            pst.setInt(4, salNuevo.getUsuario().getId());
            pst.setInt(5, salNuevo.getPersonal().getId());
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
    public boolean Eliminar(Salida sal) throws SQLException {
        boolean exito = false;
        
        try {
            String eliminarSQL = "DELETE FROM salida WHERE id= "+sal.getId();
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
    public List<Salida> lista_salidas() throws SQLException {
        List<Salida> lista = null;
        ConsumibleInt con = new ConsumibleImp();
        UsuarioInt usr = new UsuarioImp();
        PersonalInt per = new PersonalImp();
        
        try {
            String listaSQL = "SELECT * FROM salida";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Salida sal = new Salida();
                sal.setId(rs.getInt("id"));
                sal.setFecha(rs.getDate("fecha"));
                sal.setConsumible(con.buscar_id(rs.getInt("idConsumible")).get(0));
                sal.setCantidad(rs.getInt("cantidad"));
                sal.setUsuario(usr.buscar_id(rs.getInt("idUsuario")).get(0));
                sal.setPersonal(per.buscar_id(rs.getInt("idPersonal")).get(0));
                lista.add(sal);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Salida> buscar_idConsumible(int busqueda) throws SQLException {
        List<Salida> lista = null;
        ConsumibleInt con = new ConsumibleImp();
        UsuarioInt usr = new UsuarioImp();
        PersonalInt per = new PersonalImp();
        
        try {
            String listaSQL = "SELECT * FROM salida WHERE idConsumible= "+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Salida sal = new Salida();
                sal.setId(rs.getInt("id"));
                sal.setFecha(rs.getDate("fecha"));
                sal.setConsumible(con.buscar_id(rs.getInt("idConsumible")).get(0));
                sal.setCantidad(rs.getInt("cantidad"));
                sal.setUsuario(usr.buscar_id(rs.getInt("idUsuario")).get(0));
                sal.setPersonal(per.buscar_id(rs.getInt("idPersonal")).get(0));
                lista.add(sal);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Salida> buscar_idPersonal(int busqueda) throws SQLException {
        List<Salida> lista = null;
        ConsumibleInt con = new ConsumibleImp();
        UsuarioInt usr = new UsuarioImp();
        PersonalInt per = new PersonalImp();
        
        try {
            String listaSQL = "SELECT * FROM salida WHERE idPersonal= "+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Salida sal = new Salida();
                sal.setId(rs.getInt("id"));
                sal.setFecha(rs.getDate("fecha"));
                sal.setConsumible(con.buscar_id(rs.getInt("idConsumible")).get(0));
                sal.setCantidad(rs.getInt("cantidad"));
                sal.setUsuario(usr.buscar_id(rs.getInt("idUsuario")).get(0));
                sal.setPersonal(per.buscar_id(rs.getInt("idPersonal")).get(0));
                lista.add(sal);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Salida> buscar_id(int busqueda) throws SQLException {
        List<Salida> lista = null;
        ConsumibleInt con = new ConsumibleImp();
        UsuarioInt usr = new UsuarioImp();
        PersonalInt per = new PersonalImp();
        
        try {
            String listaSQL = "SELECT * FROM salida WHERE id= "+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Salida sal = new Salida();
                sal.setId(rs.getInt("id"));
                sal.setFecha(rs.getDate("fecha"));
                sal.setConsumible(con.buscar_id(rs.getInt("idConsumible")).get(0));
                sal.setCantidad(rs.getInt("cantidad"));
                sal.setUsuario(usr.buscar_id(rs.getInt("idUsuario")).get(0));
                sal.setPersonal(per.buscar_id(rs.getInt("idPersonal")).get(0));
                lista.add(sal);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }
    
}
