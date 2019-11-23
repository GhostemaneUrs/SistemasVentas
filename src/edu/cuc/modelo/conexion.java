/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jaram
 */
public class conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String usuario = "root";
    String contraseña = "fenriz123";
    
    public Connection conectar(){
        try {
        Class.forName("com.mysql.jdbc.Driver"); 
        con=DriverManager.getConnection(url,usuario,contraseña);
        } catch (Exception e) {
        }
        return con;
    }

    Connection Conectar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }   
