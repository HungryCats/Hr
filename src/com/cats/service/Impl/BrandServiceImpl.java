package com.cats.service.Impl;

import com.cats.dao.BrandDao;
import com.cats.dao.Impl.BrandDaoImpl;
import com.cats.pojo.Brand;
import com.cats.service.BrandService;


import java.util.List;

public class BrandServiceImpl implements BrandService {
    private final BrandDao brandDao = new BrandDaoImpl();

    @Override
    public List<Brand> selectAllBrand() {
        return brandDao.selectAllBrand();
    }

    @Override
    public Brand addBrand(String name, String pwd, String money) {
        return brandDao.addBrand(name,pwd,money);
    }

    @Override
    public Brand deleteById(String id) {
        return brandDao.deleteById(id);
    }

    @Override
    public Brand selectById(String id) {
        return brandDao.selectById(id);
    }

    @Override
    public int updateBrand(Brand brand,String id) {
        return brandDao.updateBrand(brand,id);
    }

}
