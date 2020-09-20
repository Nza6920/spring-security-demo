package com.niu.web.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 描述
 *
 * @author [nza]
 * @version 1.0 2020/9/19
 * @createTime 2020/9/19
 */
public class UserControllerTest extends BaseController {

    @Test
    public void whenQuerySuccess() throws Exception {

        String res = mockMvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("username", "niu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(res);
    }

    @Test
    public void whenGetInfoSuccess() throws Exception {
        String res = mockMvc.perform(get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("tom"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(res);
    }

    @Test
    public void whenGetInfoFail() throws Exception {
        mockMvc.perform(get("/user/a")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void whenCreateSuccess() throws Exception {

        String content = "{\"username\":\"tom\",\"password\": null}";
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void whenUpdateSuccess() throws Exception {

        String content = "{\"id\":\"1\",\"username\":\"tom\",\"password\": null}";
        mockMvc.perform(put("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void whenDeleteSuccess() throws Exception {
        mockMvc.perform(delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void whenUploadSuccess() throws Exception {
        String res = mockMvc.perform(fileUpload("/file")
                .file(new MockMultipartFile("file",
                        "text.txt",
                        "multipart/form-data",
                        "hello upload".getBytes(StandardCharsets.UTF_8))))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(res);
    }
}
