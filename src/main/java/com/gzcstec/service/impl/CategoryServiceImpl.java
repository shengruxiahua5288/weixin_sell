package com.gzcstec.service.impl;

import com.gzcstec.dataobject.ProductCategory;
import com.gzcstec.repository.ProductCategoryRepository;
import com.gzcstec.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public ProductCategory findOne(Integer id) {
        //这个是spring-boot 1.5版本上不会出错
      //  return categoryRepository.findOne(id);
        //spring-boot 2.0的版本
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {
        return categoryRepository.findByCategoryTypeIn(categoryTypes);
    }

    @Override
    public ProductCategory save(ProductCategory category) {
        return categoryRepository.save(category);
    }
}
