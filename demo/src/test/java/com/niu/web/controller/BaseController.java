package com.niu.web.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 基础测试控制器
 *
 * @author [nza]
 * @version 1.0 2020/9/19
 * @createTime 2020/9/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseController {

    @Autowired
    private WebApplicationContext ctx;

    protected MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }
}
