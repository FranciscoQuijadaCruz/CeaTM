/*
 * To change this license header, choose License Headers in Project Prosalties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.interfaces;

import java.sql.SQLException;
import java.util.List;
import mx.gob.ceasonora.tonerManagement.entidades.Salida;
import mx.gob.ceasonora.tonerManagement.enumeradores.Estado;

/**
 *
 * @author kevin
 */
public interface SalidaInt {
    public boolean Agregar(Salida sal) throws SQLException;
    public boolean Editar(Salida salAnterior, Salida salNuevo) throws SQLException;
    public boolean Eliminar(Salida sal) throws SQLException;
    public List <Salida> lista_salidas() throws SQLException;
    public List <Salida> buscar_idConsumible(int busqueda) throws SQLException;
    public List <Salida> buscar_idPersonal(int busqueda) throws SQLException;
    public List <Salida> buscar_id(int busqueda) throws SQLException;
}
