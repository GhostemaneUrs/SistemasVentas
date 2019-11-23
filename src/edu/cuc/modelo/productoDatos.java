/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaram
 */
public class productoDatos {
    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    conexion acceso = new conexion();
    producto pro = new producto();
    
    
    public int actualizarStock(int cant, int idp){
       String sql="update producto set Stock=? where idProducto=?";
       try {
           con=acceso.conectar();
           ps=con.prepareStatement(sql);
           ps.setInt(1, cant);
           ps.setInt(2, idp);
           ps.executeUpdate();
       } catch (Exception e) {
       }
       return r;
   }
    public producto listarID(int id){
        producto p=new producto();
        String sql="select * from producto where IdProducto=?";
        try {
            con=acceso.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
   
    public List listarProducto() {
        String sql = "select * from producto";
        List<producto> listaprod = new ArrayList<>();
        try {
            con = acceso.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto p = new producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                listaprod.add(p);
            }
        } catch (Exception e) {
        }
        return listaprod;
    }

    public int agregar(producto p) {
        int contador = 0;
        String sql = "insert into producto(Nombres,Precio,Stock,Estado)values(?,?,?,?)";
        try {
            con = acceso.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int actualizar(producto p) {
        String sql = "update producto set Nombres=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
        try {
            con = acceso.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int delete(int id) {
        String sql = "delete from producto where IdProducto=?";
        try {
            con = acceso.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
