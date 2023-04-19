package io.m2i.caree.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoggedFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        if (
        // All the pages a non-connected user can access
                request.getRequestURI().equals(request.getContextPath() + "/")
                        || request.getRequestURI().equals(request.getContextPath() + "/login")
                        || request.getRequestURI().equals(request.getContextPath() + "/categories-list")
                        || request.getRequestURI().equals(request.getContextPath() + "/vehicle-details")

        ) {
            chain.doFilter(req, resp);
        } else {
            if (session.getAttribute("username") == null) {

                response.sendRedirect(request.getContextPath() + "/login");
            } else {
                chain.doFilter(req, resp);
            }
        }



    }
}