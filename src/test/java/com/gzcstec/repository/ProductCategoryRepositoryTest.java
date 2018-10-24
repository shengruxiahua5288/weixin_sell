package com.gzcstec.repository;

import com.gzcstec.SellApplication;
import com.gzcstec.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fan on 2017/10/12.
 */
@RunWith(SpringRunner.class)

@SpringBootTest(classes = SellApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    //根据id从数据库查询一条数据
    @Test
    public void findOneTest() {
        System.out.println(productCategoryRepository.findById(1).get());
    }

    @Test
    public void findAllTest() {
        System.out.println(productCategoryRepository.findAll());
    }
    //新增一条数据
    @Test
    @Rollback(value = false)
    @Transactional
    public void saveTest() {
       ProductCategory productCategory = new ProductCategory();
       productCategory.setCategoryName("小孩最爱");
       productCategory.setCategoryType(4);
       productCategoryRepository.save(productCategory);

    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(3);
        productCategory.setCategoryName("男生最爱");
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> categoryType = Arrays.asList(2,4);

        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(categoryType);
        Assert.assertNotEquals(0 , result.size());
    }
}