/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.instancias;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import mx.gob.ceasonora.tonerManagement.gui.*;
import mx.gob.ceasonora.tonerManagement.gui.administrar.*;
import mx.gob.ceasonora.tonerManagement.gui.administrar.nuevo.*;
import mx.gob.ceasonora.tonerManagement.gui.administrar.ver.*;

/**
 *
 * @author kevin
 */
public class InstanciaVentana {
    private static JFrame MenuPrincipal;
    private static JInternalFrame AdministrarConsumibles, AdministrarHerramientas,
            AdministrarPersonal, AdministrarPrestamos, AdministrarProveedores, 
            AdministrarSalidas, AdministrarUsuarios, NuevoConsumible, NuevoUsuario,
            NuevoProveedor, VerProveedor;
    
    private InstanciaVentana(){
        
    }
    
    public static JFrame getMenuPrincipal(){
        if(MenuPrincipal == null){
            MenuPrincipal = new MenuPrincipal();
        }
        return MenuPrincipal;
    }
    
    public static JInternalFrame getAdministrarConsumibles(){
        if(AdministrarConsumibles == null){
            AdministrarConsumibles = new AdministrarConsumibles();
        }
        return AdministrarConsumibles;
    }
    
    public static JInternalFrame getAdministrarHerramientas(){
        if(AdministrarHerramientas == null){
            AdministrarHerramientas = new AdministrarHerramientas();
        }
        return AdministrarHerramientas;
    }
    
    public static JInternalFrame getAdministrarPersonal(){
        if(AdministrarPersonal == null){
            AdministrarPersonal = new AdministrarPersonal();
        }
        return AdministrarPersonal;
    }
    
    public static JInternalFrame getAdministrarPrestamos(){
        if(AdministrarPrestamos == null){
            AdministrarPrestamos = new AdministrarPrestamos();
        }
        return AdministrarPrestamos;
    }
    
    public static JInternalFrame getAdministrarProveedores(){
        if(AdministrarProveedores == null){
            AdministrarProveedores = new AdministrarProveedores();
        }
        return AdministrarProveedores;
    }
    
    public static JInternalFrame getAdministrarSalidas(){
        if(AdministrarSalidas == null){
            AdministrarSalidas = new AdministrarSalidas();
        }
        return AdministrarSalidas;
    }
    
    public static JInternalFrame getAdministrarUsuarios(){
        if(AdministrarUsuarios == null){
            AdministrarUsuarios = new AdministrarUsuarios();
        }
        return AdministrarUsuarios;
    }
    
    public static JInternalFrame getNuevoConsumible(){
        if(NuevoConsumible == null){
            NuevoConsumible = new NuevoConsumible();
        }
        return NuevoConsumible;
    }
    
    public static JInternalFrame getNuevoUsuario(){
        if(NuevoUsuario == null){
            NuevoUsuario = new NuevoUsuario();
        }
        return NuevoUsuario;
    }
    
    public static JInternalFrame getNuevoProveedor(){
        if(NuevoProveedor == null){
            NuevoProveedor = new NuevoProveedor();
        }
        return NuevoProveedor;
    }
    
    public static JInternalFrame getVerProveedor(){
        if(VerProveedor == null){
            VerProveedor = new VerProveedor();
        }
        return VerProveedor;
    }
    
    
}


