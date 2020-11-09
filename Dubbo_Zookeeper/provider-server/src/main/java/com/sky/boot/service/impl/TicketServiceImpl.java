package com.sky.boot.service.impl;

import com.sky.boot.service.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
// 项目一启动就注册到注册中 这就是Dubbo的服务注册与发现
@Service
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "富贵获取了一张票";
    }
}
