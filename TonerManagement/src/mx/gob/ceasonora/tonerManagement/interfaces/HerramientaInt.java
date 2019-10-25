/*
 * To change this license header, choose License Headers in Project Proherties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.interfaces;

import java.sql.SQLException;
import java.util.List;
import mx.gob.ceasonora.tonerManagement.entidades.Herramienta;

/**
 *
 * @author kevin
 */
public interface HerramientaInt {
    public boolean Agregar(Herramienta her) throws SQLException;
    public boolean Editar(Herramienta herAnterior, Herramienta herNuevo) throws SQLException;
    public boolean Eliminar(Herramienta her) throws SQLException;
    public List <Herramienta> lista_herramientas() throws SQLException;
    public List <Herramienta> buscar_nombre(String busqueda) throws SQLException;
    public List <Herramienta> buscar_codigo(String busqueda) throws SQLException;
    public List <Herramienta> buscar_id(int busqueda) throws SQLException;
}
