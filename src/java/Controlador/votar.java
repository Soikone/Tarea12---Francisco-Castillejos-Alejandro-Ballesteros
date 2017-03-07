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
@WebServlet(name = "votar", urlPatterns = {"/votar"})
public class votar extends HttpServlet {
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
            throws ServletException, IOException {
        

        operaciones o = new operaciones();
        HttpSession session = request.getSession(true);
        String voto = request.getParameter("radioVoto");
        votante v = (votante)session.getAttribute("votante");
        int resul1=1;
        int resul2=1;
        
        if(voto == null){
            //Voto en blanco
            /* hago una transacción en el Servlet */
            try{
                Conexion.setAutoCommit(false);
                /* registro el voto */
                resul1=o.votar(v,Conexion);
                /* no cuento el voto */
                Conexion.commit();
            }catch(SQLException SQLE1){
                if(Conexion!=null){
                    try{
                        Conexion.rollback();
                    }catch(SQLException SQLE2){
                    }
                }
            }
        }else{
            /* hago una transacción en el Servlet */
            try{
                Conexion.setAutoCommit(false);
                /* registro el voto */
                resul1=o.votar(v,Conexion);
                /* cuento el voto */
                resul2=o.registrarVoto(voto, Conexion);
                Conexion.commit();
            }catch(SQLException SQLE1){
                if(Conexion!=null){
                    try{
                        Conexion.rollback();
                    }catch(SQLException SQLE2){
                    }
                }
            }
        }
        
        if(resul1==0 || resul2==0){
            session.setAttribute("error", "Error. Algo ha salido mal.");
                response.sendRedirect("Vista/error.jsp"); 
        }else{
            if(voto == null){
                session.setAttribute("aux", "Gracias por votar. Has votado en blanco.");
                response.sendRedirect("Vista/ok.jsp");
            }else{
                session.setAttribute("aux", "Gracias por votar. Has votado a " + voto + ".");
                response.sendRedirect("Vista/ok.jsp");
            }           
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
