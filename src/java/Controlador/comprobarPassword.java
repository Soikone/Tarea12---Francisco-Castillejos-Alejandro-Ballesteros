/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ConexionBBDD;
import DAO.operaciones;
import Modelo.partido;
import Modelo.votante;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author franciscocr
 */
@WebServlet(name = "comprobarPassword", urlPatterns = {"/comprobarPassword"})
public class comprobarPassword extends HttpServlet {
    private votante v;
    private Connection Conexion;
    ArrayList<partido> partidos;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        String dni = request.getParameter("dni");
        String password = request.getParameter("password");
        int num=0;
        String voto="";
        
        v = new votante(dni, "", password);
        session.setAttribute("votante", v);
        operaciones o = new operaciones();
        try {
            num=o.comprobarLogin(v, Conexion);
        } catch (SQLException ex) {
            Logger.getLogger(registraUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(num >= 1){
            try {
                voto=o.comprobarVoto(v, Conexion);
            } catch (SQLException ex) {
                Logger.getLogger(registraUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(voto.equals("no")){
                try {
                    partidos = o.getPartido(Conexion);
                    session.setAttribute("partidos", partidos);
                } catch (SQLException ex) {
                    Logger.getLogger(registraUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                response.sendRedirect("Vista/votar.jsp"); 
            }else{
                session.setAttribute("error", "El usuario ya ha votado");
                response.sendRedirect("Vista/error.jsp"); 
            }
            
             
        }else{
            session.setAttribute("error", "Datos erroneos");
            response.sendRedirect("Vista/error.jsp");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
     @Override
    public void init() throws ServletException {
     /* Establecemos la conexión, si no existe */
    try{
        ConexionBBDD ConexBD=ConexionBBDD.GetConexion();
        Conexion=ConexBD.GetCon();
    }catch(ClassNotFoundException cnfe){
    }
    catch(SQLException sqle){
    }
    }

}
