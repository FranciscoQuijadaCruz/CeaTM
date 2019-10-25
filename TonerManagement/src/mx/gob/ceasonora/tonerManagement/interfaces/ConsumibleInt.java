/*
 * To change this license header, choose License Headers in Project Proconties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.interfaces;

import java.sql.SQLException;
import java.util.List;
import mx.gob.ceasonora.tonerManagement.entidades.Consumible;

/**
 *
 * @author kevin
 */
public interface ConsumibleInt {
    public boolean Agregar(Consumible con) throws SQLException;
    public boolean Editar(Consumible conAnterior, Consumible conNuevo) throws SQLException;
    public boolean Eliminar(Consumible con) throws SQLException;
    public List <Consumible> lista_consumibles() throws SQLException;
    public List <Consumible> lista_escasos() throws SQLException;
    public List <Consumible> lista_faltantes() throws SQLException;
    public List <Consumible> buscar_nombre(String busqueda) throws SQLException;
    public List <Consumible> buscar_codigo(String busqueda) throws SQLException;
    public List <Consumible> buscar_id(int busqueda) throws SQLException;
}
