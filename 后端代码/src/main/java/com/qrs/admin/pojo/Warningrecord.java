package com.qrs.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_warningrecord")
@ApiModel(value="Warningrecord对象", description="")
public class Warningrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "警告id")
    private Integer warning_id;

    @ApiModelProperty(value = "警告编号")
    private String warning_number;

    @ApiModelProperty(value = "警告名称")
    private String warning_name;

    @ApiModelProperty(value = "警告原因")
    private String warning_why;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    @ApiModelProperty(value = "警告时间")
    private String warning_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    @ApiModelProperty(value = "关闭时间")
    private String shutdown_time;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;


}
