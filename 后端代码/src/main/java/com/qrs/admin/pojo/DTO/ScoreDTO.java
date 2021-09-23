package com.qrs.admin.pojo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/11 17:03
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ScoreDTO {

    @ApiModelProperty(value = "工号")
    private int user_id;

    @ApiModelProperty(value = "文档类型")
    private String attribute_name;

    @ApiModelProperty(value = "文档名称")
    private String document_name;

    @ApiModelProperty(value = "获得的分数")
    private int document_score;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;
}
