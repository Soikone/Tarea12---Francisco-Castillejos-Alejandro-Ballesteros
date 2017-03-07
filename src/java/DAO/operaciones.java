/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.partido;
import Modelo.votante;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franciscocr
 */
public class operaciones {
    
    public void insertarVotante(votante v, Connection con) throws SQLException{
        Statement s;
        
        try {
            s = con.createStatement();
            String sql = "INSERT INTO votante (id, dni, nombre, pass, voto) VALUES (null, '" + v.getDni() + "', '" + v.getNombre() + "', AES_ENCRYPT('"+ v.getContraseña() +"','chirimoya'), 'no')";
            s.executeUpdate(sql) ;

        } catch (SQLException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        
        
    }
    
    public int comprobarLogin(votante v, Connection con) throws SQLException{
        Statement s = con.createStatement();
        ResultSet rs;
        int numUsu=0;
        
        try {
            s = con.createStatement();
            String sql = "SELECT count(*) as total FROM votante WHERE dni='"+v.getDni()+"' and pass=AES_ENCRYPT('"+v.getContraseña()+"','chirimoya')";
            rs=s.executeQuery(sql);
            
            while (rs.next()){
                numUsu = rs.getInt("total");
            }
            

        }catch (SQLException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return numUsu;
        
    }
    
    public String comprobarVoto(votante v, Connection con) throws SQLException{
        Statement s = con.createStatement();
        ResultSet rs;
        String voto="";
        
        try {
            s = con.createStatement();
            String sql = "SELECT * FROM votante WHERE dni='"+v.getDni()+"'";
            rs=s.executeQuery(sql);
            
            while (rs.next()){
                voto = rs.getString("voto");
            }
            

        }catch (SQLException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return voto;
        
    }
    
    public ArrayList<partido> getPartido(Connection con) throws SQLException{
        Statement s = con.createStatement();
        ResultSet rs;
        String acronimo="";
        String nombre="";
        String imagen="";
        int numVotos=0;
        ArrayList<partido> partidos = new ArrayList<partido>();
        
        try {
            s = con.createStatement();
            String sql = "SELECT * FROM partido_politico";
            rs=s.executeQuery(sql);
            
            while (rs.next()){
                acronimo = rs.getString("acronimo");
                nombre = rs.getString("nombre");
                imagen = rs.getString("logo");
                numVotos = 0;
                
                partido p = new partido(acronimo, nombre, imagen, numVotos);
                
                partidos.add(p);
            }
            

        }catch (SQLException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return partidos;
        
    }
    
    public int votar(votante v, Connection con) throws SQLException{
        Statement s = con.createStatement();
        int resultado;
        try{
            s = con.createStatement();
            resultado=s.executeUpdate ("UPDATE votante SET voto='si' WHERE dni='"+ v.getDni() +"'");
        } catch(SQLException SQLE){
            throw new SQLException(SQLE);
        }
        if (resultado==0)throw new SQLException();
        return resultado;
    }
    
    public int registrarVoto(String voto, Connection con) throws SQLException{
        int resultado;
        try{
            Statement s = con.createStatement();
            resultado=s.executeUpdate ("UPDATE partido_politico SET num_votos=num_votos+1 WHERE nombre='"+ voto +"'");
        } catch(SQLException SQLE){
            throw new SQLException(SQLE);
        }
        if (resultado==0)throw new SQLException();
        return resultado;
    }
    
    public ArrayList<votante> censo(Connection con) throws SQLException{
        Statement s = con.createStatement();
        ResultSet rs;
        String dni="";
        String nombre="";
        String voto="";
        votante v;
        ArrayList<votante> votantes = new ArrayList<votante>();
        
        try {
            s = con.createStatement();
            String sql = "SELECT * FROM votante";
            rs=s.executeQuery(sql);
            
            while (rs.next()){
                dni = rs.getString("dni");
                nombre = rs.getString("nombre");
                voto = rs.getString("voto");
                
                if(voto.equals("si")){
                    v = new votante(dni, nombre, true);                
                }else{
                    v = new votante(dni, nombre, false);                
                }
                
                votantes.add(v);
            }
            

        }catch (SQLException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return votantes;
        
    }
    
    public int borrarVotante(votante v, Connection con) throws SQLException{
        // Preparamos la consulta y la ejecutamos
        Statement s = con.createStatement();
        int resultado = s.executeUpdate( "DELETE FROM votante WHERE dni='"+ v.getDni() +"' " );
        
        return resultado;
    }
    
    public ArrayList<partido> guardarVotos(Connection con) throws SQLException{
        ArrayList<partido> backup = new ArrayList();
        try {
            Statement s = con.createStatement();
            String sql = "SELECT * FROM partido_politico";
            ResultSet rs=s.executeQuery(sql);
            
            while (rs.next()){
                String nombre = rs.getString("nombre");
                String acronimo = rs.getString("acronimo");
                int votos = rs.getInt("num_votos");
                String imagen = rs.getString("logo");
                
                
                partido p = new partido(acronimo, nombre, imagen, votos);
                
                backup.add(p);
            }
            

        }catch (SQLException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return backup;
    }
    
    public void actualizarBackup(ArrayList<partido> backup, Connection con) throws SQLException{
        int resultado;
        
        Iterator It=backup.iterator();
        while(It.hasNext()){
            partido p = (partido)It.next();
            try{
                Statement s = con.createStatement();
                resultado=s.executeUpdate ("UPDATE backup_partido_politico SET num_votos="+p.getNumVotos()+" WHERE nombre='"+ p.getNombre() +"'");
            } catch(SQLException SQLE){
                throw new SQLException(SQLE);
            }
        }
       
    }
}
