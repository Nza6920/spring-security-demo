package com.niu.security.core.validate.code.image;

import com.niu.security.core.validate.code.ValidateCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 图形验证码
 *
 * @author [nza]
 * @version 1.0 2020/9/21
 * @createTime 2020/9/21
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ImageCode extends ValidateCode {

    public ImageCode(BufferedImage image, String code, int expireTime) {
        super(code, expireTime);
        this.image = image;

    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;

    }

    /**
     * 图片
     */
    private BufferedImage image;
}
