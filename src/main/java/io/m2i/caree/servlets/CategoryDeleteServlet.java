package io.m2i.caree.servlets;

import io.m2i.caree.dao.CategoryDAO;
import io.m2i.caree.dao.CategoryJdbcDAO;
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
import java.util.List;

@WebServlet(urlPatterns = CategoryDeleteServlet.URL)
public class CategoryDeleteServlet extends HttpServlet {

    protected static final String URL = "/delete-category";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        if (session.getAttribute("username") != null) {
            req.setAttribute("isLogged", true);
        }


        CategoriesService categoriesService = new CategoriesService();
        int id = Integer.parseInt(req.getParameter("id"));

        Category category = categoriesService.getById(id);

        if (!categoriesService.belongsToVehicles(category)) {
            categoriesService.delete(category);
        } else {
            req.setAttribute("err", "Cannot delete a category which is associated to existing Vehicles");
        }

        req.getRequestDispatcher(CategoriesGalleryServlet.URL).forward(req, resp);

    }
}
