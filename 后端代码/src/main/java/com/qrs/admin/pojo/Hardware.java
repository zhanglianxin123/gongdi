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
@TableName("t_hardware")
@ApiModel(value="Hardware对象", description="")
public class Hardware implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "数据编号")
    private Integer tardward_id;

    @ApiModelProperty(value = "吊塔震动")
    private Float vibration_one;

    @ApiModelProperty(value = "吊塔三轴加速度x")
    private Float acceleration_x_one;

    @ApiModelProperty(value = "吊塔三轴加速度y")
    private Float acceleration_y_one;

    @ApiModelProperty(value = "吊塔三轴加速度z")
    private Float acceleration_z_one;

    @ApiModelProperty(value = "高支模震动")
    private Float vibration_two;

    @ApiModelProperty(value = "高支模三轴加速度x")
    private Float acceleration_x_two;

    @ApiModelProperty(value = "高支模三轴加速度y")
    private Float acceleration_y_two;

    @ApiModelProperty(value = "高支模三轴加速度z")
    private Float acceleration_z_two;

    @ApiModelProperty(value = "人体检测1")
    private Integer detection_one;

    @ApiModelProperty(value = "人体检测2")
    private Integer detection_two;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;


}
