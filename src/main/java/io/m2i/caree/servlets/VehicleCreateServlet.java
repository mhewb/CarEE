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

@WebServlet(urlPatterns = VehicleCreateServlet.URL)
public class VehicleCreateServlet extends HttpServlet {
    protected static final String URL = "/create-vehicle";
    private static final String JSP = "/WEB-INF/vehicle-form.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        if (session.getAttribute("username") != null) {
            req.setAttribute("isLogged", true);
        }

        CategoriesService categoriesService = new CategoriesService();

        req.setAttribute("categories", categoriesService.fetchAllCategories());

        req.getRequestDispatcher(JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoriesService categoriesService = new CategoriesService();

        VehiclesDAO vehiclesDAO = new VehiclesJdbcDAO();

        String name = req.getParameter("name");
        Float price = Float.parseFloat(req.getParameter("price"));
        String description = req.getParameter("description");
        String imgUrl =req.getParameter("imgUrl");
        Category category = categoriesService.getById(Integer.valueOf(req.getParameter("category")));

        Vehicle vehicle = new Vehicle(name, category, price, description, imgUrl);

        vehiclesDAO.create(vehicle);

        resp.sendRedirect(VehiclesGalleryServlet.URL);

    }
}
