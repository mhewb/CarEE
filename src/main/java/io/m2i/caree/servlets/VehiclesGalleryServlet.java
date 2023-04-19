package io.m2i.caree.servlets;

import io.m2i.caree.models.Category;
import io.m2i.caree.models.Vehicle;
import io.m2i.caree.services.VehiclesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = VehiclesGalleryServlet.URL)
public class VehiclesGalleryServlet extends HttpServlet {

    public static final String URL = "/";
    public static final String JSP = "/WEB-INF/vehicles-gallery.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        if (session.getAttribute("username") != null) {
            req.setAttribute("isLogged", true);
        }

        VehiclesService vehiclesService = new VehiclesService();
        List<Vehicle> vehicleList = vehiclesService.fetchAllVehicles();
        req.setAttribute("vehicles", vehicleList);

        req.getRequestDispatcher(JSP).forward(req, resp);
    }
}
