/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.interfaces;

import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public interface ImagenInt {
    public boolean Actualizar(String ruta)throws SQLException;
    public String Obtener()throws SQLException;
}
