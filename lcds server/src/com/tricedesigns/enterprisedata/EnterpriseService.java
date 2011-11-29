package com.tricedesigns.enterprisedata;

import java.util.List;

import com.tricedesigns.enterprisedata.model.SharedVehicleModel;
import com.tricedesigns.enterprisedata.model.Vehicle;


public class EnterpriseService {
	

	public List<Vehicle> getVehicles() {

		return SharedVehicleModel.getVehicles();
	}
}