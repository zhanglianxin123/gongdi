package com.qrs.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_environment")
@ApiModel(value="Environment对象", description="")
public class Environment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "数据编号")
    private Integer environment_number;

    @ApiModelProperty(value = "粉尘1")
    private Float dust_one;

    @ApiModelProperty(value = "粉尘2")
    private Float dust_two;

    @ApiModelProperty(value = "噪音")
    private Float noise;

    @ApiModelProperty(value = "风速")
    private Float speed;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;


}
