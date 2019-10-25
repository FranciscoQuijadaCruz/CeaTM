/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.interfaces;

import java.sql.SQLException;
import java.util.List;
import mx.gob.ceasonora.tonerManagement.entidades.Proveedor;

/**
 *
 * @author kevin
 */
public interface ProveedorInt {
    public boolean Agregar(Proveedor pvd) throws SQLException;
    public boolean Editar(Proveedor pvdAnterior, Proveedor pvdNuevo) throws SQLException;
    public boolean Eliminar(Proveedor pvd) throws SQLException;
    public List <Proveedor> lista_proveedores() throws SQLException;
    public List <Proveedor> buscar_nombre(String busqueda) throws SQLException;
    public List <Proveedor> buscar_id(int busqueda) throws SQLException;
}
