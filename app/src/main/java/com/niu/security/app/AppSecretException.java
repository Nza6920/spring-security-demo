package com.niu.security.app;

/**
 * App异常
 *
 * @author [nza]
 * @version 1.0 2020/10/6
 * @createTime 2020/10/6
 */
public class AppSecretException extends RuntimeException {


    /**
     *
     */
    private static final long serialVersionUID = -1629364510827838114L;

    public AppSecretException(String msg) {
        super(msg);
    }
}
