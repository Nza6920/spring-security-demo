package com.niu.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
@Data
@Accessors(chain = true)
public class FileInfoDTO {

    public FileInfoDTO(String path) {
        this.path = path;
    }

    /**
     * 文件路径
     */
    private String path;
}
