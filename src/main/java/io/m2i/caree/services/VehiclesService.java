package io.m2i.caree.services;

import io.m2i.caree.dao.VehiclesDAO;
import io.m2i.caree.dao.VehiclesJdbcDAO;
import io.m2i.caree.models.Vehicle;

import java.util.List;

public class VehiclesService {

    private final VehiclesDAO vehicleDAO = new VehiclesJdbcDAO();

    public List<Vehicle> fetchAllVehicles() {return vehicleDAO.findAll();}

}
