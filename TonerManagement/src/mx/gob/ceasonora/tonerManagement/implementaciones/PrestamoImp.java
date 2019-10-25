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
import mx.gob.ceasonora.tonerManagement.entidades.Prestamo;
import mx.gob.ceasonora.tonerManagement.enumeradores.Estado;
import mx.gob.ceasonora.tonerManagement.instancias.InstanciaConexion;
import mx.gob.ceasonora.tonerManagement.interfaces.HerramientaInt;
import mx.gob.ceasonora.tonerManagement.interfaces.PersonalInt;
import mx.gob.ceasonora.tonerManagement.interfaces.PrestamoInt;
import mx.gob.ceasonora.tonerManagement.interfaces.UsuarioInt;

/**
 *
 * @author kevin
 */
public class PrestamoImp implements PrestamoInt{
    private static InstanciaConexion conexion = InstanciaConexion.getInstanciaConexion();

    @Override
    public boolean Agregar(Prestamo pmo) throws SQLException {
        boolean exito = false;
        
        try {
            String agregarSQL = "INSERT INTO prestamo (fechaPrestamo, fechaRegreso, estado, idHerramienta, idUsuario, idPersonal) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = conexion.conexion().prepareStatement(agregarSQL);
            pst.setDate(1, new Date(pmo.getFechaPrestamo().getTime()));
            pst.setDate(2, new Date(pmo.getFechaRegreso().getTime()));
            pst.setString(3, pmo.getEstado().name());
            pst.setInt(4, pmo.getHerramienta().getId());
            pst.setInt(5, pmo.getUsuario().getId());
            pst.setInt(6, pmo.getPersonal().getId());
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
    public boolean Editar(Prestamo pmoAnterior, Prestamo pmoNuevo) throws SQLException {
        boolean exito = false;
        
        try {
            String editarSQL = "UPDATE prestamo SET fechaPrestamo=?, fechaRegreso=?, estado=?, idHerramienta=?, idUsuario=?, idPersonal=? "
                    + "WHERE id= "+pmoAnterior.getId();
            PreparedStatement pst = conexion.conexion().prepareStatement(editarSQL);
            pst.setDate(1, new Date(pmoNuevo.getFechaPrestamo().getTime()));
            pst.setDate(2, new Date(pmoNuevo.getFechaRegreso().getTime()));
            pst.setString(3, pmoNuevo.getEstado().name());
            pst.setInt(4, pmoNuevo.getHerramienta().getId());
            pst.setInt(5, pmoNuevo.getUsuario().getId());
            pst.setInt(6, pmoNuevo.getPersonal().getId());
            pst.executeUpdate();
            exito = true;
        } catch (Exception e) {
            System.out.println("Error al actualizar los datos: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return exito;
    }

    @Override
    public boolean Eliminar(Prestamo pmo) throws SQLException {
        boolean exito = false;
        
        try {
            String eliminarSQL = "DELETE FROM prestamo WHERE id= "+pmo.getId();
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
    public List<Prestamo> lista_prestamos() throws SQLException {
        List<Prestamo> lista = null;
        HerramientaInt her = new HerramientaImp();
        UsuarioInt usr = new UsuarioImp();
        PersonalInt per = new PersonalImp();
        
        try {
            String listaSQL = "SELECT * FROM prestamo";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Prestamo pmo = new Prestamo();
                pmo.setId(rs.getInt("id"));
                pmo.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                pmo.setFechaRegreso(rs.getDate("fechaRegreso"));
                pmo.setEstado(Estado.valueOf(rs.getString("estado")));
                pmo.setHerramienta(her.buscar_id(rs.getInt("idHerramienta")).get(0));
                pmo.setUsuario(usr.buscar_id(rs.getInt("idUsuario")).get(0));
                pmo.setPersonal(per.buscar_id(rs.getInt("idPersonal")).get(0));
                lista.add(pmo);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Prestamo> buscar_estado(Estado estado) throws SQLException {
        List<Prestamo> lista = null;
        HerramientaInt her = new HerramientaImp();
        UsuarioInt usr = new UsuarioImp();
        PersonalInt per = new PersonalImp();
        
        try {
            String listaSQL = "SELECT * FROM prestamo WHERE estado= '"+estado.name()+"'";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Prestamo pmo = new Prestamo();
                pmo.setId(rs.getInt("id"));
                pmo.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                pmo.setFechaRegreso(rs.getDate("fechaRegreso"));
                pmo.setEstado(Estado.valueOf(rs.getString("estado")));
                pmo.setHerramienta(her.buscar_id(rs.getInt("idHerramienta")).get(0));
                pmo.setUsuario(usr.buscar_id(rs.getInt("idUsuario")).get(0));
                pmo.setPersonal(per.buscar_id(rs.getInt("idPersonal")).get(0));
                lista.add(pmo);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Prestamo> buscar_idHerramienta(int busqueda) throws SQLException {
        List<Prestamo> lista = null;
        HerramientaInt her = new HerramientaImp();
        UsuarioInt usr = new UsuarioImp();
        PersonalInt per = new PersonalImp();
        
        try {
            String listaSQL = "SELECT * FROM prestamo WHERE idHerramienta= "+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Prestamo pmo = new Prestamo();
                pmo.setId(rs.getInt("id"));
                pmo.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                pmo.setFechaRegreso(rs.getDate("fechaRegreso"));
                pmo.setEstado(Estado.valueOf(rs.getString("estado")));
                pmo.setHerramienta(her.buscar_id(rs.getInt("idHerramienta")).get(0));
                pmo.setUsuario(usr.buscar_id(rs.getInt("idUsuario")).get(0));
                pmo.setPersonal(per.buscar_id(rs.getInt("idPersonal")).get(0));
                lista.add(pmo);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Prestamo> buscar_id(int busqueda) throws SQLException {
        List<Prestamo> lista = null;
        HerramientaInt her = new HerramientaImp();
        UsuarioInt usr = new UsuarioImp();
        PersonalInt per = new PersonalImp();
        
        try {
            String listaSQL = "SELECT * FROM prestamo WHERE id= "+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Prestamo pmo = new Prestamo();
                pmo.setId(rs.getInt("id"));
                pmo.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                pmo.setFechaRegreso(rs.getDate("fechaRegreso"));
                pmo.setEstado(Estado.valueOf(rs.getString("estado")));
                pmo.setHerramienta(her.buscar_id(rs.getInt("idHerramienta")).get(0));
                pmo.setUsuario(usr.buscar_id(rs.getInt("idUsuario")).get(0));
                pmo.setPersonal(per.buscar_id(rs.getInt("idPersonal")).get(0));
                lista.add(pmo);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Prestamo> buscar_idPersonal(int busqueda) throws SQLException {
        List<Prestamo> lista = null;
        HerramientaInt her = new HerramientaImp();
        UsuarioInt usr = new UsuarioImp();
        PersonalInt per = new PersonalImp();
        
        try {
            String listaSQL = "SELECT * FROM prestamo WHERE idPersonal= "+busqueda;
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Prestamo pmo = new Prestamo();
                pmo.setId(rs.getInt("id"));
                pmo.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                pmo.setFechaRegreso(rs.getDate("fechaRegreso"));
                pmo.setEstado(Estado.valueOf(rs.getString("estado")));
                pmo.setHerramienta(her.buscar_id(rs.getInt("idHerramienta")).get(0));
                pmo.setUsuario(usr.buscar_id(rs.getInt("idUsuario")).get(0));
                pmo.setPersonal(per.buscar_id(rs.getInt("idPersonal")).get(0));
                lista.add(pmo);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;
    }

    @Override
    public List<Prestamo> noDevueltos_idPersonal(int busqueda) throws SQLException {
List<Prestamo> lista = null;
        HerramientaInt her = new HerramientaImp();
        UsuarioInt usr = new UsuarioImp();
        PersonalInt per = new PersonalImp();
        
        try {
            String listaSQL = "SELECT * FROM prestamo WHERE idPersonal= "+busqueda+" AND (estado='PENDIENTE' OR estado='ATRASADO')";
            PreparedStatement pst = conexion.conexion().prepareStatement(listaSQL);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Prestamo pmo = new Prestamo();
                pmo.setId(rs.getInt("id"));
                pmo.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                pmo.setFechaRegreso(rs.getDate("fechaRegreso"));
                pmo.setEstado(Estado.valueOf(rs.getString("estado")));
                pmo.setHerramienta(her.buscar_id(rs.getInt("idHerramienta")).get(0));
                pmo.setUsuario(usr.buscar_id(rs.getInt("idUsuario")).get(0));
                pmo.setPersonal(per.buscar_id(rs.getInt("idPersonal")).get(0));
                lista.add(pmo);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer la tabla: "+e.getMessage());
        }finally{
            conexion.cerrar();
        }
        return lista;    }
    
}
