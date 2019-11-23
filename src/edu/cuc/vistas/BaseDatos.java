/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.vistas;

import java.util.List;

/**
 *
 * @author Jaram
 */
public interface BaseDatos {
    
    public List listar();
    public int agregar(Object[] o);
    public int actualizar(Object[] o);
    public void eliminar(int  id);
    
}
