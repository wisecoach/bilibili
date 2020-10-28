package com.wisecoach.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /*用户id*/
    @TableId
    private Long mid;
    /*密码*/
    private String password;
    /*邮箱*/
    private String email;
    /*电话*/
    private String tel;
    /*身份证号*/
    private String identity;
    /*是否登录*/
    private Boolean isLogin;
}
