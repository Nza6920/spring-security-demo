package com.niu.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.Lists;
import com.niu.security.core.properties.SecurityProperties;
import com.niu.web.dto.UserDTO;
import com.niu.web.dto.UserQueryDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
@Slf4j
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

//    @Autowired
//    private AppSignUpUtils appSignUpUtils;

    @Autowired
    private SecurityProperties securityProperties;

    @GetMapping("jwt/me")
    public Object getCurrentUser(Authentication user, HttpServletRequest request) {

        // 解析jwt
        String header = request.getHeader("Authorization");
        String token = StringUtils.substringAfter(header, "bearer ");
        Claims claims = Jwts.parser().setSigningKey(securityProperties.getOauth2().getJwtSigningKey().getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token).getBody();
        String company = (String) claims.get("company");

        log.info("company: {}", company);

        log.info("user: {}", user);

        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("session/me")
    public Object getCurrentUser(Authentication user) {

        return user;
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

    @PostMapping("/register")
    public void register(UserDTO user, HttpServletRequest request) {

        log.info("用户注册");

        // 拿到用户唯一标识
        String username = user.getUsername();
        // 将注册后的用户回传给spring social
//        providerSignInUtils.doPostSignUp(username, new ServletWebRequest(request));

        // app 注册
//        appSignUpUtils.doPostSignUp(new ServletWebRequest(request), username);
    }
}
