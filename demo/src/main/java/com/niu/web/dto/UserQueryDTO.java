package com.niu.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述
 *
 * @author [nza]
 * @version 1.0 2020/9/19
 * @createTime 2020/9/19
 */
@Data
@Accessors(chain = true)
public class UserQueryDTO {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "用户年龄")
    private Integer age;
}
