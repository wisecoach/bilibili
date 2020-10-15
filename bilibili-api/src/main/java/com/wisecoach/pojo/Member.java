package com.wisecoach.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
    /*用户id*/
    @TableId
    private Long mid;
    /*用户名*/
    private String name;
    /*性别: 男 女 保密*/
    private String sex;
    /*个性签名*/
    private String sign;
    /*生日 'MM-dd'*/
    private String birthday;
    /*加入时间*/
    private Date joinTime;
    /*等级*/
    private Integer level;
    /*经验*/
    private Integer exp;
    /*关注数*/
    private Integer following;
    /*被关注数*/
    private Integer follower;
    /*投稿数*/
    private Integer aCount;
    /*播放数*/
    private Integer aView;
    /*点赞数*/
    private Integer aLike;
    /*动态数*/
    private Integer dyCount;
    /*硬币数*/
    private Integer coin;
    /*是否邮箱认证*/
    private Boolean verifiedEmail;
    /*是否电话认证*/
    private Boolean verifiedTel;
    /*是否身份认证*/
    private Boolean verifiedId;
    /*密码*/
    private String password;
    /*邮箱*/
    private String email;
    /*电话*/
    private String tel;
    /*身份证号*/
    private String identity;
    /*封面*/
    private String face;
    /*是否登录*/
    private Boolean isLogin;
}
