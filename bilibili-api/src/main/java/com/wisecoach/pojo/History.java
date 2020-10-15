package com.wisecoach.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 历史记录
 * @ 1
 *      以{@link Chat}为基础的历史记录
 *      其 cid，mid 为主键，用于给每个Chat定位
 *      对应 history 表
 * @ 2
 *      以{@link Archive}为基础的历史记录
 *      其 aid，mid 为主键，用于给每个Archive定位，用于各种计算，视频默认地址
 *      对应 history_archive 表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class History implements Serializable {
    /*投稿id*/
    private Long aid;
    /*用户id*/
    private Long mid;
    /*视频id*/
    private Long cid;
    /*观看时间点*/
    private Date viewAt;
    /*观看进度*/
    private Integer duration;
}
