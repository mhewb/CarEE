package io.m2i.caree.servlets;

import io.m2i.caree.dao.VehiclesDAO;
import io.m2i.caree.dao.VehiclesJdbcDAO;
import io.m2i.caree.models.Category;
import io.m2i.caree.models.Vehicle;

import io.m2i.caree.services.CategoriesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = VehicleEditServlet.URL)
public class VehicleEditServlet extends HttpServlet {

    protected static final String URL = "/edit-vehicle";
    private static final String JSP = "/WEB-INF/vehicle-form.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        VehiclesDAO vehiclesDAO = new VehiclesJdbcDAO();
        Vehicle vehicle = vehiclesDAO.getById(id);

        CategoriesService categoriesService = new CategoriesService();

        req.setAttribute("isEdit", true);

        req.setAttribute("id", vehicle.getId());
        req.setAttribute("name", vehicle.getName());
        req.setAttribute("price", vehicle.getPrice());
        req.setAttribute("description", vehicle.getDescription());
        req.setAttribute("imgUrl", vehicle.getImgUrl());
        req.setAttribute("currentCategory", vehicle.getCategory());
        req.setAttribute("categories", categoriesService.fetchAllCategories());


        req.getRequestDispatcher(JSP).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoriesService categoriesService = new CategoriesService();

        int id = Integer.parseInt(req.getParameter("id"));

        VehiclesDAO vehiclesDAO = new VehiclesJdbcDAO();
        Vehicle vehicle = vehiclesDAO.getById(id);

        vehicle.setName(req.getParameter("name"));
        vehicle.setPrice(Float.parseFloat(req.getParameter("price")));
        vehicle.setDescription(req.getParameter("description"));
        vehicle.setImgUrl(req.getParameter("imgUrl"));
        vehicle.setCategory(categoriesService.getById(Integer.valueOf(req.getParameter("category"))));

        vehiclesDAO.update(vehicle);

        resp.sendRedirect(VehicleDetailsServlet.URL + "/?id=" + id);

    }
}
