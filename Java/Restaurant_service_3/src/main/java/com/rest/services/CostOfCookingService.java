package com.rest.services;

import com.rest.dao.CostOfCookingDao;
import com.rest.models.CostOfCooking;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CostOfCookingService {

    private CostOfCookingDao costOfCookingDao = new CostOfCookingDao();

    public CostOfCookingService()
    {
    }

    public CostOfCooking findById(int id)
    {
        return costOfCookingDao.findById(id);
    }


    public void saveCost(CostOfCooking costOfCooking) {
        costOfCookingDao.save(costOfCooking);
    }

    public void deleteCost(CostOfCooking costOfCooking)
    {
        costOfCookingDao.delete(costOfCooking);
    }

    public void updateCost(CostOfCooking costOfCooking)
    {
        costOfCookingDao.update(costOfCooking);
    }

    public List<CostOfCooking> findAll()
    {
        return costOfCookingDao.findAll();
    }

    public CostOfCooking getCookingCostByDishId(int dishId) { return costOfCookingDao.getCookingCostByDishId(dishId); }
}
