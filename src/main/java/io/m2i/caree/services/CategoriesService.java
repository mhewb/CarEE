package io.m2i.caree.services;

import io.m2i.caree.dao.CategoryDAO;
import io.m2i.caree.dao.CategoryJdbcDAO;
import io.m2i.caree.models.Category;

import java.util.List;

public class CategoriesService {

    private final CategoryDAO categoryDAO = new CategoryJdbcDAO();

    public List<Category> fetchAllCategories() {return categoryDAO.findAll(); }
}
