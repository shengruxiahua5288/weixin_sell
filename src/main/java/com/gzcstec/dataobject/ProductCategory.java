package com.gzcstec.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * Created by fan on 2017/10/12.
 */
/*
@DynamicUpdate表示动态更新时间
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class ProductCategory {
    //数据库映射成对象
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**类目id**/
    private Integer categoryId;

    /**
     * 类目名称,这个命名规则是把数据库里面对应的栏目category_Name把下划线去掉改成驼峰
     */
    private String categoryName;

    /**
     * 类目类别
     */
    private Integer categoryType;

    /**创建时间**/
//    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**更新时间**/
//    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
}
