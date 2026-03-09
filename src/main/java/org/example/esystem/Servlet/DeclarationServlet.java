package org.example.esystem.Servlet;
import org.example.esystem.DAO.EmployeurDAO;
import org.example.esystem.Model.Employeur;
import org.example.esystem.DAO.DeclarationDAO;
import org.example.esystem.Service.DeclarationService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/declarations/*")
public class DeclarationServlet extends HttpServlet{
    DeclarationDAO declarationDAO = new DeclarationDAO();
    EmployeurDAO employeurDAO = new EmployeurDAO();
    DeclarationService declarationService=new DeclarationService();

@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
    String action = req.getPathInfo();
    if(action==null) action="/list";
    switch (action){
        case"/add":
            req.setAttribute("employeurs", employeurDAO.findAll());
            req.getRequestDispatcher("/jsp/declarations/add.jsp").forward(req,res);
            break;
        default:
            req.setAttribute("declarations",
                    declarationDAO.findAll());
            req.getRequestDispatcher("/jsp/declarations/list.jsp")
                    .forward(req, res);
            break;
    }
}
@Override
    protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
    int empId= Integer.parseInt(req.getParameter("employeurId"));
    int mois= Integer.parseInt(req.getParameter("mois"));
    int annee= Integer.parseInt(req.getParameter("annee"));
    Employeur emp = employeurDAO.findById(empId);
    String result=declarationService.creerDeclaration(emp, mois,annee);
    req.setAttribute("message", result);
    req.setAttribute("declarations", declarationDAO.findAll());
    req.getRequestDispatcher("/jsp/declarations/list.jsp").forward(req,res);
}
}

