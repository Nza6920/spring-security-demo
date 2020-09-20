package com.niu.web.exception;

/**
 * 自定义异常
 *
 * @author [nza]
 * @version 1.0 2020/9/20
 * @createTime 2020/9/20
 */
public class UserNotExistException extends RuntimeException {
    private static final long serialVersionUID = -5902593988485617408L;

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
