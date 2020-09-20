package com.niu.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.Lists;
import com.niu.web.dto.UserDTO;
import com.niu.web.dto.UserQueryDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * User 控制器
 *
 * @author [nza]
 * @version 1.0 2020/9/19
 * @createTime 2020/9/19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {

        System.out.println(user);
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @DeleteMapping("{id:\\d+}")
    @JsonView({UserDTO.UserDetailView.class})
    public void delete(@PathVariable("id") String id) {

    }

    @PutMapping("{id:\\d+}")
    @JsonView({UserDTO.UserDetailView.class})
    public UserDTO update(@PathVariable("id") String id,
                          @RequestBody @Valid UserDTO user,
                          BindingResult errors) {

        if (errors.hasErrors()) {
            List<ObjectError> allErrors = errors.getAllErrors();
        }

        user.setId(id);
        user.setBirthDay(new Date());

        return user;
    }

    @PostMapping()
    @JsonView({UserDTO.UserDetailView.class})
    public UserDTO create(@RequestBody @Valid UserDTO user, BindingResult errors) {

        if (errors.hasErrors()) {
            List<ObjectError> allErrors = errors.getAllErrors();
        }

        user.setId("1");
        user.setBirthDay(new Date());

        return user;
    }

    @GetMapping()
    @JsonView({UserDTO.UserSimpleView.class})
    @ApiOperation(value = "用户查询")
    public List<UserDTO> query(UserQueryDTO query,
                               @PageableDefault Pageable pageable) {
        List<UserDTO> res = Lists.newArrayList();
        res.add(new UserDTO());
        res.add(new UserDTO());
        res.add(new UserDTO());

        return res;
    }

    @GetMapping("{id:\\d+}")
    @JsonView({UserDTO.UserDetailView.class})
    @ApiOperation(value = "用户详情")
    public UserDTO getInfo(@ApiParam(value = "用户ID") @PathVariable String id) {

//        throw new UserNotExistException(id);
        UserDTO user = new UserDTO();
        user.setUsername("tom");

        return user;
    }
}
