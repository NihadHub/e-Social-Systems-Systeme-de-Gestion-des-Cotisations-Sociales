package org.example.esystem.Servlet;
import org.example.esystem.DAO.AssureDAO;
import org.example.esystem.DAO.EmployeurDAO;
import org.example.esystem.Model.Assure;
import org.example.esystem.Model.Employeur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
@WebServlet("/assures/*")
public class AssureServlet extends HttpServlet{
    AssureDAO assureDAO= new AssureDAO();
    private EmployeurDAO employeurDAO = new EmployeurDAO();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        String action= req.getPathInfo();
        if(action==null)action="/list";
        switch (action){
            case"/add":
                List<Employeur>emps = employeurDAO.findAll();
                req.setAttribute("employeurs",emps);
                req.getRequestDispatcher("/jsp/assures/add.jsp").forward(req,res);
                break;

            case"/edit":
                int id=Integer.parseInt(req.getParameter("id"));
                Assure assure = assureDAO.findById(id);
                req.setAttribute("assure",assure);
                req.getRequestDispatcher("/jsp/assures/edit.jsp").forward(req,res);
                break;
            case"/byEmployeur":
                int empId=Integer.parseInt(req.getParameter("employeurId"));
                List<Assure> assures=assureDAO.findEmployeur(empId);
                req.setAttribute("assures",assures);
                req.getRequestDispatcher("/jsp/assures/list.jsp").forward(req,res);
                break;

            default:
                List<Assure> all= assureDAO.findAll();
                req.setAttribute("assures",all);
                req.getRequestDispatcher("/jsp/assures/list.jsp").forward(req,res);
                break;
        }
    }
@Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        req.setCharacterEncoding("UTF-8");
        String action = req.getPathInfo();
    if ("/updateSalaire".equals(action)) {
        int id = Integer.parseInt(req.getParameter("id"));
        double newSalaire =
                Double.parseDouble(req.getParameter("salaire"));
        assureDAO.UpdateSalary(id, newSalaire);
    } else {
        String nom = req.getParameter("nom");
        double salaire =
                Double.parseDouble(req.getParameter("salaire"));
        int empId =
                Integer.parseInt(req.getParameter("employeurId"));

        Employeur emp = employeurDAO.findById(empId);
        Assure assure = new Assure(nom, salaire, emp);
        assureDAO.ajouterAssure(assure);
    }
    res.sendRedirect(req.getContextPath() + "/assures/list");
}
}
