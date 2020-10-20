package com.niu.web.controller;

import com.niu.web.dto.FileInfoDTO;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 描述
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private static final String folder = "D:\\file";

    @PostMapping
    public FileInfoDTO upload(MultipartFile file) throws IOException {

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(folder, System.currentTimeMillis() + ".txt");

        file.transferTo(localFile);

        return new FileInfoDTO(localFile.getAbsolutePath());
    }

    @GetMapping("{id}")
    public void download(@PathVariable("id") String id,
                         HttpServletRequest req,
                         HttpServletResponse resp) {
        try (
                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = resp.getOutputStream()
        ) {
            resp.setContentType("application/x-download");
            resp.addHeader("Content-Disposition", "attachment;filename=test.txt");

            IOUtils.copy(inputStream, outputStream);

            // 刷新内存
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
