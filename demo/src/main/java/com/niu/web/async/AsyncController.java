package com.niu.web.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * 异步控制器
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @GetMapping("/order")
    public Callable<String> order1() {
        log.info("主线程开始");

        Callable<String> res = () -> {
            log.info("副线程开始");
            Thread.sleep(1000);
            log.info("副线程返回");
            return "success";
        };

        log.info("主线程返回");

        return res;
    }

    @GetMapping("/order2")
    public DeferredResult order2() throws InterruptedException {
        log.info("主线程开始");

        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> res = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, res);

        log.info("主线程返回");

        return res;
    }
}
