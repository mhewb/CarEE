package io.m2i.caree.servlets;

import io.m2i.caree.dao.CategoryDAO;
import io.m2i.caree.dao.CategoryJdbcDAO;
import io.m2i.caree.models.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = CategoryEditServlet.URL)
public class CategoryEditServlet extends HttpServlet {

    protected static final String URL = "/edit-category";
    private static final String JSP = "/WEB-INF/category-form.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        if (session.getAttribute("username") != null) {
            req.setAttribute("isLogged", true);
        }

        int id = Integer.parseInt(req.getParameter("id"));

        CategoryDAO categoryDAO = new CategoryJdbcDAO();
        Category category = categoryDAO.getById(id);

        req.setAttribute("isEdit", true);


        req.setAttribute("id", category.getId());
        req.setAttribute("name", category.getName());

        req.getRequestDispatcher(JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        CategoryDAO categoryDAO = new CategoryJdbcDAO();
        Category category = categoryDAO.getById(id);

        category.setName(req.getParameter("name"));

        categoryDAO.update(category);

        resp.sendRedirect(CategoriesGalleryServlet.URL);

    }
}
