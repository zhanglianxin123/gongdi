package com.qrs.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_limit")
@ApiModel(value="Limit对象", description="")
public class Limit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "设备id")
    private Integer device_id;

    @ApiModelProperty(value = "设备编号")
    private String device_number;

    @ApiModelProperty(value = "设备名")
    private String device_name;

    @ApiModelProperty(value = "最小值")
    private Float min_value;

    @ApiModelProperty(value = "最大值")
    private Float max_value;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "精度")
    private Integer accuracy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;


}
