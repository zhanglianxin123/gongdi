package com.qrs.admin.pojo.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/16 14:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageDTO2 {
    @ApiModelProperty(value = "第几页")
    private int current;

    @ApiModelProperty(value = "每页条数")
    private int size;
    @ApiModelProperty(value = "文档属性")
    private int attribute;
}
