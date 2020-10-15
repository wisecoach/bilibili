package com.wisecoach.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 类型
 *      类型分三级
 *      | tid   | name  | parent|
 *      | 0     | all   | null  |
 *      | x     | parent| 0     |
 *      | y     | child | x     |
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type implements Serializable {
    /*类型id*/
    @TableId(type = IdType.INPUT)
    private Long tid;
    /*类型名*/
    private String name;
    /*类型text*/
    private String text;
    /*介绍*/
    private String intro;
    /*注意*/
    private String notice;
    /*父类型*/
    private Long parent;
    /*该类型计数*/
    private Integer count;
    /*创建时间*/
    @TableField(fill = FieldFill.INSERT)
    private Date ctime;

    /*子类型*/
    private List<Type> childs;
}
