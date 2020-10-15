package com.wisecoach.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
 * 投稿
 *      {@link Chat}视频的集合
 *      {@link Member}视频作者
 *      {@link Type}视频类型
 *      aid和bvid两者都可作为主键
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Archive implements Serializable {
    /*投稿id*/
    @TableId(type = IdType.AUTO)
    private Long aid;
    /*投稿bvid*/
    private String bvid;
    /*用户id*/
    private Long mid;
    /*第一个视频id*/
    private Long cid;
    /*类型id*/
    private Long tid;
    /*投稿标题*/
    private String title;
    /*视频总时长*/
    private Integer duration;
    /*发布时间*/
    private Date ctime;
    /*投稿介绍*/
    private String intro;
    /*投稿视频数*/
    private Integer aVideos;
    /*播放数*/
    private Integer aView;
    /*点赞数*/
    private Integer aLike;
    /*评论数*/
    private Integer aReply;
    /*投币数*/
    private Integer aCoin;
    /*收藏数*/
    private Integer aFav;
    /*弹幕数*/
    private Integer aDanmaku;
    /*封面*/
    private String face;
    /*相似计数*/
    private Integer simCount;
}
