package com.wisecoach.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 动态
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dynamic implements Serializable {
    /*动态id*/
    @TableId
    private Long dyid;
    /*成员id*/
    private Long mid;
    /*动态类型
     * 1:转发型动态
     * 2:纯文本动态
     * 4:图片动态
     * 8:投稿发布动态
     */
    private Integer type;
    /*发布时间*/
    private Date ctime;
    /*内容*/
    private String message;
    /*投稿发布动态的投稿id*/
    private Long aid;
    /*转发动态的动态id*/
    private Long preDyId;
    /*图片动态图片数*/
    private Integer dyPicture;
    /*动态点赞数*/
    private Integer dyLike;
    /*动态评论数*/
    private Integer dyReply;

    /*发布成员*/
    private Member member;
    /*动态描述对象*/
    private Object object;
}
