package com.qrs.admin.pojo.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/16 14:53
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DocumentDTO {
    @ApiModelProperty(value = "属性")
    private Integer attribute;

    @ApiModelProperty(value = "文件id")
    private String document_id;
}
