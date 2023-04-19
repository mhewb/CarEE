package io.m2i.caree.servlets;

import io.m2i.caree.dao.CategoryDAO;
import io.m2i.caree.dao.CategoryJdbcDAO;
import io.m2i.caree.models.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = CategoryCreateServlet.URL)
public class CategoryCreateServlet extends HttpServlet {

    protected static final String URL = "/create-category";
    private static final String JSP = "/WEB-INF/category-form.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryDAO categoryDAO = new CategoryJdbcDAO();

        String name = req.getParameter("name");

        Category category = new Category(name);

        categoryDAO.create(category);

        resp.sendRedirect(CategoriesGalleryServlet.URL);

    }
}
