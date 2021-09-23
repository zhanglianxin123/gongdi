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
@TableName("t_construction")
@ApiModel(value="Construction对象", description="")
public class Construction implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "工地id")
    private Integer construction_id;

    @ApiModelProperty(value = "工地编号")
    private String construction_number;

    @ApiModelProperty(value = "工地名称")
    private String construction_name;

    @ApiModelProperty(value = "工地经度")
    private Float construction_longitude;

    @ApiModelProperty(value = "工地纬度")
    private Float construction_latitude;

    @ApiModelProperty(value = "负责人名字")
    private String head_name;

    @ApiModelProperty(value = "负责人电话")
    private String head_phone;

    @ApiModelProperty(value = "工地人数")
    private Integer construction_people;

    @ApiModelProperty(value = "工地地址")
    private  String construction_address;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;


}
