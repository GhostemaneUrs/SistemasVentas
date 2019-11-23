/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jaram
 */
public class ventasDatos {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    
    public String NroSerieVentas(){
        String serie="";
        String sql="select max(NumeroSerie) from ventas";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                serie=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return serie;
    }
    
    public String IdVentas(){
        String idv="";
        String sql="select max(IdVentas) from ventas";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                idv=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idv;
    }
    public int GuardarVentas(ventas v){       
        String sql="insert into Ventas(IdCliente, IdVendedor,NumeroSerie,FechaVentas,Monto,Estado)values(?,?,?,?,?,?)";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdVendedor());
            ps.setString(3, v.getSerie());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getMonto());
            ps.setString(6, v.getEstado());
            r=ps.executeUpdate();
        } catch (Exception e) {
        }
        
        return r;
    }
    public int GuardarDetalleVentas(detalleVenta dv){
        String sql="insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta)values(?,?,?,?)";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, dv.getIdVentas());
            ps.setInt(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPreVenta());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
}
