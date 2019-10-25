/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.interfaces;

import java.sql.SQLException;
import java.util.List;
import mx.gob.ceasonora.tonerManagement.entidades.Usuario;

/**
 *
 * @author kevin
 */
public interface UsuarioInt {
    public boolean Agregar(Usuario usr) throws SQLException;
    public boolean Editar(Usuario usrAnterior, Usuario usrNuevo) throws SQLException;
    public boolean Eliminar(Usuario usr) throws SQLException;
    public List <Usuario> lista_usuarios() throws SQLException;
    public List <Usuario> buscar_correo(String busqueda) throws SQLException;
    public List <Usuario> buscar_nombre(String busqueda) throws SQLException;
    public List <Usuario> buscar_nombreUsuario(String busqueda) throws SQLException;
    public List <Usuario> buscar_id(int busqueda) throws SQLException;
}
