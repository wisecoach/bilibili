package com.wisecoach.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat implements Serializable {
    /*视频id*/
    @TableId
    private Long cid;
    /*投稿id*/
    private Long aid;
    /*序号*/
    private Integer page;
    /*视频名*/
    private String part;
    /*时长*/
    private Integer duration;
    /*发布时间*/
    private Date ctime;
    /*视频地址*/
    private String url;
}
