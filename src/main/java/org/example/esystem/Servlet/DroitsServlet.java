package org.example.esystem.Servlet;
import org.example.esystem.DAO.AssureDAO;
import org.example.esystem.Model.Assure;
import org.example.esystem.Service.DroitsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Map;
@WebServlet("/droits")
public class DroitsServlet extends HttpServlet {
    private DroitsService droitsService = new DroitsService();
    private AssureDAO assureDAO = new AssureDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id= req.getParameter("assureId");
        if(id!=null){
            long assureId = Long.parseLong(id);
            Assure assure= assureDAO.findById(assureId);
            Map<String,Object> droits = droitsService.consulterDroits(assureId);
            req.setAttribute("assure", assure);
            req.setAttribute("droits", droits);
        }
        req.setAttribute("assures", assureDAO.findAll());
        req.getRequestDispatcher("/jsp/droits/consulter.jsp")
                .forward(req, resp);
    }
}
