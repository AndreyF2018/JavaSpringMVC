package com.rest.services;

import com.rest.dao.ProfitDao;
import com.rest.models.Profit;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfitsService {

    private ProfitDao profitDao = new ProfitDao();

    public ProfitsService()
    {
    }

    public Profit findById(int id)
    {
        return profitDao.findById(id);
    }


    public void saveProfit(Profit profit) throws Exception {
        profitDao.save(profit);
    }

    public void deleteProfit(Profit profit)
    {
        profitDao.delete(profit);
    }

    public void updateProfit(Profit profit)
    {
        profitDao.update(profit);
    }

    public List<Profit> findAll()
    {
        return profitDao.findAll();
    }

    public Profit getProfitByOrderId (int orderId) { return profitDao.getProfitByOrderId(orderId); }
}

