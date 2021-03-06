package com.gzcstec.repository;

import com.gzcstec.SellApplication;
import com.gzcstec.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SellApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
public class OrderMasterRepositoryTest {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    @Rollback(value = false)
    @Transactional
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("范先生");
        orderMaster.setBuyerAddress("东风东路699广东港澳中心403");
        orderMaster.setBuyerPhone("15626131368");
        orderMaster.setBuyerOpenid("123456");
        orderMaster.setOrderAmount(new BigDecimal(100));
        OrderMaster result = orderMasterRepository.save(orderMaster);

        Assert.assertEquals("123456" , result.getBuyerOpenid());
    }

    @Test
    public void findByBuyerOpenidTest() {
    }

    @Test
    public void findByBuyerOpenid() throws Exception {

    }

}