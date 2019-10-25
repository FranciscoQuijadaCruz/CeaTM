/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.interfaces;

import java.sql.SQLException;
import java.util.List;
import mx.gob.ceasonora.tonerManagement.entidades.Personal;

/**
 *
 * @author kevin
 */
public interface PersonalInt {
    public boolean Agregar(Personal per) throws SQLException;
    public boolean Editar(Personal perAnterior, Personal perNuevo) throws SQLException;
    public boolean Eliminar(Personal per) throws SQLException;
    public List <Personal> lista_personal() throws SQLException;
    public List <Personal> buscar_nombre(String busqueda) throws SQLException;
    public List <Personal> buscar_id(int busqueda) throws SQLException;
}
