package com.sky.boot.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service(value = "userService")
public class UserService {
    // 想获取provider-server提供的票,就需要去注册中心拿到服务
    @Reference
    TicketService ticketService;

    public void getAndUseTheTicket() {
        System.out.println(ticketService.getTicket() + ",并且卖掉了它,赚了20$");
    }
}
