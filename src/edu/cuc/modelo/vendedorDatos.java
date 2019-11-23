/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.modelo;


import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaram
 */
public class vendedorDatos {
    PreparedStatement ps;
    ResultSet rs;
    
    conexion con = new conexion();
    Connection acceder;
    
    public entidadVendedor Validar(String dni,String user){
        entidadVendedor vd = new entidadVendedor();
        String sql = "Select * from vendedor where Dni =? and User=?";
        try {
            acceder = con.conectar();
            ps = (PreparedStatement) acceder.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs = ps.executeQuery();
            while (rs.next()) {                
                vd.setId(rs.getInt(1));
                vd.setDni(rs.getString(2));
                vd.setNom(rs.getString(3));
                vd.setTel(rs.getString(4));
                vd.setEstado(rs.getString(5));
                vd.setUser(rs.getString(6));
                
            }
        } catch (Exception e) {
        }
        return vd;
    }
    
    public vendedor listarVendedorId(String dni) {
        vendedor vd =new vendedor();
        String sql = "select * from vendedor where Dni=" + dni;
        try {
            acceder = con.conectar();
            ps = (PreparedStatement) acceder.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vd.setIdVendedor(rs.getInt(1));
                vd.setDni(rs.getString(2));
                vd.setNombre(rs.getString(3));
                vd.setTelefono(rs.getString(4));
                vd.setEstado(rs.getString(5));
                vd.setUsuario(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return vd;
    }
    //********CRUD - Principal**************

    public List listarVendedor() {
        String sql = "select * from vendedor";
        List<vendedor> listaVendedor = new ArrayList<>();
        try {
            acceder = con.conectar();
            ps = (PreparedStatement) acceder.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vendedor ven = new vendedor();
                ven.setIdVendedor(rs.getInt(1));
                ven.setDni(rs.getString(2));
                ven.setNombre(rs.getString(3));
                ven.setTelefono(rs.getString(4));
                ven.setEstado(rs.getString(5));
                ven.setUsuario(rs.getString(6));
                listaVendedor.add(ven);
            }
        } catch (Exception e) {
        }
        return listaVendedor;
    }

    public int agregarVendedor(vendedor v) {
        int r=0;
        String sql = "insert into vendedor(Dni,Nombres,Telefono,Estado,User)values(?,?,?,?,?)";
        try {
            acceder = con.conectar();
            ps = (PreparedStatement) acceder.prepareStatement(sql);
            ps.setString(1, v.getDni());
            ps.setString(2, v.getNombre());
            ps.setString(3, v.getTelefono());
            ps.setString(4, v.getEstado());
            ps.setString(5, v.getUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int actualizarVendedor(vendedor v) {
        int r=0;
        String sql = "update vendedor set Dni=?, Nombres=?,Telefono=?,Estado=? Where IdVendedor=?";
        try {
            acceder = con.conectar();
            ps = (PreparedStatement) acceder.prepareStatement(sql);
            ps.setString(1, v.getDni());
            ps.setString(2, v.getNombre());
            ps.setString(3, v.getTelefono());
            ps.setString(4, v.getEstado());
            ps.setInt(5, v.getIdVendedor());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.err.println("" + e);
        }
        return r;
    }

    public int eliminarVendedor(int id) {
        int r=0;
        String sql = "delete from vendedor where IdVendedor=?";
        try {
            acceder = con.conectar();
            ps = (PreparedStatement) acceder.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
