package com.gzcstec.service.impl;

import com.gzcstec.SellApplication;
import com.gzcstec.dto.OrderDTO;
import com.gzcstec.service.OrderService;
import com.gzcstec.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SellApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1509033666612964484");
        pushMessageService.orderStatus(orderDTO);
    }

}