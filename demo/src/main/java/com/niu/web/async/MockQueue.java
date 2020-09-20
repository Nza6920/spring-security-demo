package com.niu.web.async;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 描述
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
@Data
@Accessors(chain = true)
@Slf4j
@Component
public class MockQueue {

    /**
     * 下单消息
     */
    private String placeOrder;

    /**
     * 订单完成消息
     */
    private String completeOrder;

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(() -> {
            log.info("接到下单请求");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            log.info("接到下单请求处理完毕: {}", placeOrder);
        }).start();
    }
}
