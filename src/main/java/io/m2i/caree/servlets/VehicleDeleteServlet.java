package io.m2i.caree.servlets;

import io.m2i.caree.dao.VehiclesDAO;
import io.m2i.caree.dao.VehiclesJdbcDAO;
import io.m2i.caree.models.Vehicle;
import io.m2i.caree.services.CategoriesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = VehicleDeleteServlet.URL)
public class VehicleDeleteServlet extends HttpServlet {

    protected static final String URL = "/delete-vehicle";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        VehiclesDAO vehiclesDAO = new VehiclesJdbcDAO();
        Vehicle vehicle = vehiclesDAO.getById(id);

        vehiclesDAO.delete(vehicle);

        CategoriesService categoriesService = new CategoriesService();

        req.getRequestDispatcher(VehiclesGalleryServlet.URL).forward(req, resp);

    }

}
