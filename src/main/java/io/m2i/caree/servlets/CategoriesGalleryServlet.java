package io.m2i.caree.servlets;
import io.m2i.caree.models.Category;
import io.m2i.caree.services.CategoriesService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = CategoriesGalleryServlet.URL)
public class CategoriesGalleryServlet extends HttpServlet {

    public static final String URL = "/categories-list";
    public static final String JSP = "/WEB-INF/categories-gallery.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoriesService categoriesService = new CategoriesService();
        List<Category> categoryList = categoriesService.fetchAllCategories();

        req.setAttribute("categories", categoryList);

        req.getRequestDispatcher(JSP).forward(req, resp);
    }
}
