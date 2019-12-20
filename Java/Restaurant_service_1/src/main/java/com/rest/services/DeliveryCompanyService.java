package com.rest.services;

import com.rest.dao.DeliveryCompanyDao;
import com.rest.models.DeliveryCompany;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryCompanyService {

    private DeliveryCompanyDao companyDao = new DeliveryCompanyDao();
    public DeliveryCompanyService()
    {
    }

    public DeliveryCompany findById(int id)
    {
        return companyDao.findById(id);
    }


    public void saveCompany(DeliveryCompany company)
    {
        companyDao.save(company);
    }

    public void deleteCompany(DeliveryCompany company)
    {
        companyDao.delete(company);
    }

    public void updateCompany(DeliveryCompany company)
    {
        companyDao.update(company);
    }

    public List<DeliveryCompany> findAll()
    {
        return companyDao.findAll();
    }

    public DeliveryCompany MinPrice () { return companyDao.MinPrice(); }
}
