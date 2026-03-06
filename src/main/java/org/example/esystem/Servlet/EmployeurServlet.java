package org.example.esystem.Servlet;
import org.example.esystem.DAO.EmployeurDAO;
import org.example.esystem.Model.Employeur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeurs/*")
public class EmployeurServlet extends HttpServlet{
    private EmployeurDAO employeurDAO = new EmployeurDAO();
@Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
    String action = req.getPathInfo();
    if (action == null) action = "/list";
    switch (action) {
        case "/add":
            req.getRequestDispatcher("/WEB-INF/jsp/employeurs/add.jsp").forward(req, res);
            break;
        case "/detail":
            int id = Integer.parseInt(req.getParameter("id"));
            Employeur emp = employeurDAO.findById(id);
            req.setAttribute("employeur", emp);
            req.getRequestDispatcher("/WEB-INF/jsp/employeurs/detail.jsp").forward(req, res);
            break;

        default:
            List<Employeur> list = employeurDAO.findAll();
            req.setAttribute("employeurs", list);
            req.getRequestDispatcher("/WEB-INF/jsp/employeurs/list.jsp").forward(req, res);
            break;

    }
}
@Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        String raisonSociale =req.getParameter("raisonSociale");
        String secteur = req.getParameter("secteurActivite");
        Employeur emp= new Employeur(raisonSociale,secteur);
        employeurDAO.ajouterEmployeur(emp);
        res.sendRedirect(req.getContextPath()+"/employeurs/list");
    }

}
