package com.cats.dao;

import com.cats.pojo.Brand;

import java.util.List;

public interface BrandDao {
    List<Brand> selectAllBrand();

    Brand addBrand(String name, String pwd, String money);

    Brand deleteById(String id);

    Brand selectById(String id);

    int updateBrand(Brand brand,String id);
}
