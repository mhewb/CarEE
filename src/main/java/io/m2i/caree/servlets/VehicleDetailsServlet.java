package io.m2i.caree.servlets;

import io.m2i.caree.dao.VehiclesDAO;
import io.m2i.caree.dao.VehiclesJdbcDAO;
import io.m2i.caree.models.Vehicle;
import io.m2i.caree.services.VehiclesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = VehicleDetailsServlet.URL)
public class VehicleDetailsServlet extends HttpServlet {

    protected static final String URL = "/vehicle-details";
    private static final String JSP = "/WEB-INF/vehicle-details.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        if (session.getAttribute("username") != null) {
            req.setAttribute("isLogged", true);
        }

        int id = Integer.parseInt(req.getParameter("id"));

        VehiclesDAO vehiclesDAO = new VehiclesJdbcDAO();
        Vehicle vehicle = vehiclesDAO.getById(id);

        req.setAttribute("vehicle", vehicle);

        req.getRequestDispatcher(JSP).forward(req, resp);

    }
}
