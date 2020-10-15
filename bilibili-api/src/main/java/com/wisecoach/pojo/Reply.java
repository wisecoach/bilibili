package com.wisecoach.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 评论
 *      主要评论对象
 *          {@link Archive}
 *          {@link Dynamic}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply implements Serializable {
    /*评论id*/
    @TableId
    private Long rpid;
    /*评论对象id*/
    private Long oid;
    /*用户id*/
    private Long mid;
    /**
     * 评论类型
     * 1    {@link Archive}
     * 17   {@link Dynamic}
     */
    private Integer type;
    /* 根评论
     * 0 为根评论
     * 其余为 父评论
     */
    private Long root;
    /*内容*/
    private String message;
    /*子评论数*/
    private Integer rpCount;
    /*评论点赞数*/
    private Integer rpLike;
    /*发布时间*/
    private Date ctime;

    /*发布者*/
    private Member member;
    /*评论对象*/
    private Object object;
    /*子评论*/
    private List<Reply> childReplies;
}
