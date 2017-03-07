/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ConexionBBDD;
import DAO.operaciones;
import Modelo.votante;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
 * @author Angela
 */
@WebServlet(name = "borrarVotanteConfirmado", urlPatterns = {"/borrarVotanteConfirmado"})
public class borrarVotanteConfirmado extends HttpServlet {
    private Connection Conexion;
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
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession(true);
        
        votante v = (votante)session.getAttribute("votante");
        operaciones o = new operaciones();
        int resultado = o.borrarVotante(v, Conexion);
        
        if(resultado >= 1){
            session.setAttribute("aux", "Usuario borrado correctamente.");
            response.sendRedirect("Vista/ok.jsp");
        }else{
            session.setAttribute("error", "Ha ocurrido un error inesperado.");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(borrarVotanteConfirmado.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(borrarVotanteConfirmado.class.getName()).log(Level.SEVERE, null, ex);
        }
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
