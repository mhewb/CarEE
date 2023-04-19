package io.m2i.caree.services;

import io.m2i.caree.dao.CategoryDAO;
import io.m2i.caree.dao.CategoryJdbcDAO;
import io.m2i.caree.dao.VehiclesDAO;
import io.m2i.caree.dao.VehiclesJdbcDAO;
import io.m2i.caree.models.Category;
import io.m2i.caree.models.Vehicle;

import java.util.List;

public class CategoriesService {

    private final CategoryDAO categoryDAO = new CategoryJdbcDAO();

    public List<Category> fetchAllCategories() {return categoryDAO.findAll(); }

    public Category getById(Integer id) { return categoryDAO.getById(id); }

    public void delete(Category category) {categoryDAO.delete(category);}

    public boolean belongsToVehicles(Category category) {
        VehiclesDAO vehiclesDAO = new VehiclesJdbcDAO();

        for (Vehicle vehicle : vehiclesDAO.findAll()) {
            if (vehicle.getCategory().getId() == category.getId()) {
                return true;
            }
        }
        return false;
    }

}
