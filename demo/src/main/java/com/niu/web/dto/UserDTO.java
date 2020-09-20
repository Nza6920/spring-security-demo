package com.niu.web.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.niu.web.validator.MyConstraint;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 用户
 *
 * @author [nza]
 * @version 1.0 2020/9/19
 * @createTime 2020/9/19
 */
@Data
@Accessors(chain = true)
public class UserDTO {

    /**
     * 简单视图
     */
    public interface UserSimpleView {

    }

    /**
     * 复杂视图
     */
    public interface UserDetailView extends UserSimpleView {

    }

    /**
     * 用户ID
     */
    @JsonView({UserDetailView.class})
    private String id;

    /**
     * 用户名
     */
    @JsonView({UserSimpleView.class})
    @MyConstraint()
    private String username;

    /**
     * 密码
     */
    @JsonView({UserDetailView.class})
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 生日
     */
    @JsonView({UserSimpleView.class})
    @Past(message = "日期必须是过去的时间")
    private Date birthDay;
}
