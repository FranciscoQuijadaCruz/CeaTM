/*
 * To change this license header, choose License Headers in Project Propmoties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.interfaces;

import java.sql.SQLException;
import java.util.List;
import mx.gob.ceasonora.tonerManagement.entidades.Prestamo;
import mx.gob.ceasonora.tonerManagement.enumeradores.Estado;

/**
 *
 * @author kevin
 */
public interface PrestamoInt {
    public boolean Agregar(Prestamo pmo) throws SQLException;
    public boolean Editar(Prestamo pmoAnterior, Prestamo pmoNuevo) throws SQLException;
    public boolean Eliminar(Prestamo pmo) throws SQLException;
    public List <Prestamo> lista_prestamos() throws SQLException;
    public List <Prestamo> buscar_estado(Estado estado) throws SQLException;
    public List <Prestamo> buscar_idHerramienta(int busqueda) throws SQLException;
    public List <Prestamo> buscar_idPersonal(int busqueda) throws SQLException;
    public List <Prestamo> buscar_id(int busqueda) throws SQLException;
    public List <Prestamo> noDevueltos_idPersonal(int busqueda) throws SQLException;
}
